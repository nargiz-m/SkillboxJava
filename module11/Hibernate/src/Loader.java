import entities.Department;
import entities.Employee;
import entities.Vacation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Danya on 26.10.2015.
 */
public class Loader {
    private static SessionFactory sessionFactory;

    public static class NameCount {
        public String name;
        public Long count;
    }

    static class VacationComparator implements Comparator<Vacation> {
        @Override
        public int compare(Vacation v1, Vacation v2) {
            LocalDate v1VacationBeginning = v1.getVacationBeginning();
            LocalDate v2VacationBeginning = v2.getVacationBeginning();
            return v1VacationBeginning.isBefore(v2VacationBeginning) ? 0 : 1;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        setUp();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Department> departments = session.createQuery("FROM Department", Department.class).list();
        System.out.println("Список отделов производства:");
        for (Department department : departments) {
            System.out.println(department.getName());
        }

//        Department dept = new Department("Отдел производства");
//        session.save(dept);
//        System.out.println("Сохранен отдел производства с id = " + dept.getId());

//        Department dept = session.createQuery("FROM Department WHERE name=:name", Department.class)
//            .setParameter("name", "Отдел производства").list().get(0);
//        session.delete(dept);

        //Вывести ошибочно привязанных сотрудников, которые работают в одних отделах, а руководят другими;
        List<Employee> employeesWrongDepartment = session.createQuery("SELECT e FROM Employee AS e JOIN e.department AS d " +
                "WHERE e != d.headId AND e IN (SELECT DISTINCT headId FROM Department)", Employee.class).list();
        System.out.println("Employees working for one departments and managing the others:");
        for (Employee employee : employeesWrongDepartment) {
            System.out.println(employee.getName());
        }

        //Вывести руководителей отделов, зарплата которых составляет менее 115 000 рублей в месяц;
        List<Employee> employeesSalary = session.createQuery("SELECT e FROM Employee AS e JOIN e.department AS d " +
                "WHERE e.salary < 115000 AND e IN (SELECT DISTINCT headId FROM Department)", Employee.class).list();
        System.out.println("Heads of departments with salaries less than 115 000 rubles a month:");
        for (Employee employee : employeesSalary) {
            System.out.println(employee.getSalary() + "\t" + employee.getName());
        }

        //Вывести руководителей отделов, которые вышли на работу до марта.
        List<Employee> employeesHireDate = session.createQuery("SELECT e FROM Employee AS e JOIN e.department AS d " +
                "WHERE e.hireDate < '2010-03-01' AND e IN (SELECT DISTINCT headId FROM Department)", Employee.class).list();
        System.out.println("Heads of departments who started working before march:");
        for (Employee employee : employeesHireDate) {
            System.out.println(employee.getHireDate() + "\t" + employee.getName());
        }

        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
        for (Employee employee : employees) {
            createVacation(employee, session);
        }

        for (Department department : departments) {
            departmentVacationsIntersession(department);
        }

        //Вывести список отделов с количеством сотрудников в каждом из них
        Query<NameCount> query = session.createQuery("SELECT d.name AS name, COUNT(e.id) AS count " +
                "FROM Employee AS e JOIN e.department AS d GROUP BY d.id");
        List<NameCount> departmentsWithEmployeeCount = query.setResultTransformer(Transformers.aliasToBean(NameCount.class)).list();
        System.out.println("Number of Employees in each Department:");
        for (NameCount nameCount : departmentsWithEmployeeCount) {
            System.out.println(nameCount.count + " employees in " + nameCount.name);
        }

        //Вывести список отделов, в которых работает менее трех сотрудников
        Query<NameCount> queryFew = session.createQuery("SELECT d.name AS name, COUNT(e.id) AS count " +
                "FROM Employee AS e JOIN e.department AS d GROUP BY d.id HAVING COUNT(e.id) < 3");
        List<NameCount> departmentsWithFewEmployees =  queryFew.setResultTransformer(Transformers.aliasToBean(NameCount.class)).list();
        System.out.println("Number of Employees is less than 3:");
        for (NameCount nameCount : departmentsWithFewEmployees) {
            System.out.println(nameCount.count + " employees in " + nameCount.name);
        }

        session.getTransaction().commit();
        session.close();

        //==================================================================
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    //Создание отпусков: по 3–4 недели отпуска ежегодно в случайное время со дня найма до конца следующего года
    public static void createVacation(Employee employee, Session session) {
        LocalDate hireDate = employee.getHireDate();
        Set<Vacation> vacations = employee.getVacations();

        if (!vacations.isEmpty()) {
            hireDate = hireDate.withYear(getLatestVacation(employee.getVacations()));
            if (hireDate.getYear() == LocalDate.now().getYear()) return;
        }
        Random random = new Random();
        LocalDate vacationBeginning = hireDate.plusDays(random.nextInt(168));
        LocalDate vacationEnding = vacationBeginning.plusWeeks(2);

        Vacation vacation1 = new Vacation();
        vacation1.setVacationBeginning(vacationBeginning);
        vacation1.setVacationEnding(vacationEnding);
        vacation1.setEmployee(employee);
        session.save(vacation1);
        vacations.add(vacation1);

        vacationBeginning = vacationEnding.plusDays(random.nextInt(168));
        vacationEnding = vacationBeginning.plusWeeks(2);

        Vacation vacation2 = new Vacation();
        vacation2.setVacationBeginning(vacationBeginning);
        vacation2.setVacationEnding(vacationEnding);
        vacation2.setEmployee(employee);
        session.save(vacation2);
        vacations.add(vacation2);

        employee.setVacations(vacations);
        session.save(employee);
    }

    public static int getLatestVacation(Set<Vacation> vacations) {
        int year = 0;
        for (Vacation vac : vacations) {
            int vacationYear = vac.getVacationBeginning().getYear();
            if (year < vacationYear) {
                year = vacationYear;
            }
        }
        return year + 1;
    }

    //Пересечения отпусков сотрудников в текущем отделе
    public static void departmentVacationsIntersession(Department department) {
        Set<Employee> employees = department.getEmployees();
        for (Employee emp2 : employees) {
            List<Vacation> vacations2 = new ArrayList<Vacation>(emp2.getVacations());
            Collections.sort(vacations2, new VacationComparator());
            for (Employee emp1 : employees) {
                List<Vacation> vacations1 = new ArrayList<Vacation>(emp1.getVacations());
                Collections.sort(vacations1, new VacationComparator());
                for (Vacation vac1 : vacations1) {
                    for (Vacation vac2 : vacations2) {
                        if (vac1.getVacationBeginning().isBefore(vac2.getVacationBeginning()) &&
                                vac2.getVacationBeginning().isBefore(vac1.getVacationEnding())) {
                            System.out.println(vac1.getEmployee().getName() + " and " + vac2.getEmployee().getName() +
                                    " have vacations on the same time from " + vac2.getVacationBeginning() +
                                    " until " + vac1.getVacationEnding());
                        }
                    }
                }
            }
        }
    }

    //=====================================================================

    private static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(new File("src/config/hibernate.cfg.xml")) // configures settings from hibernate.config.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
    }
}
