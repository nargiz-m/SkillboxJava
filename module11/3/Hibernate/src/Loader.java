import entities.Department;
import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;
import java.util.List;

/**
 * Created by Danya on 26.10.2015.
 */
public class Loader {
    private static SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        setUp();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Department> departments = (List<Department>) session.createQuery("FROM Department").list();
        System.out.println("Список отделов производства:");
        for (Department department : departments) {
            System.out.println(department.getName());
        }

//        Department dept = new Department("Отдел производства");
//        session.save(dept);
//        System.out.println("Сохранен отдел производства с id = " + dept.getId());

//        Department dept = (Department) session.createQuery("FROM Department WHERE name=:name")
//            .setParameter("name", "Отдел производства").list().get(0);
//        session.delete(dept);

        //Вывести ошибочно привязанных сотрудников, которые работают в одних отделах, а руководят другими;
        List<Employee> employeesWrongDepartment = (List<Employee>) session.createQuery(
                "SELECT e FROM Employee AS e JOIN e.department AS d " +
                        "WHERE e != d.headId AND e IN (SELECT DISTINCT headId FROM Department)").list();
        System.out.println("Employees working for one departments and managing the others");
        for (Employee employee : employeesWrongDepartment) {
            System.out.println(employee.getName());
        }

        //Вывести руководителей отделов, зарплата которых составляет менее 115 000 рублей в месяц;
        List<Employee> employeesSalary = (List<Employee>) session.createQuery(
                "SELECT e FROM Employee AS e JOIN e.department AS d " +
                        "WHERE e.salary < 115000 AND e IN (SELECT DISTINCT headId FROM Department)").list();
        System.out.println("Heads of departments with salaries less than 115 000 rubles a month");
        for (Employee employee : employeesSalary) {
            System.out.println(employee.getName() + "\t" + employee.getSalary());
        }

        //Вывести руководителей отделов, которые вышли на работу до марта.
        List<Employee> employeesHireDate = (List<Employee>) session.createQuery(
                "SELECT e FROM Employee AS e JOIN e.department AS d " +
                        "WHERE e.hireDate < '2010-03-01' AND e IN (SELECT DISTINCT headId FROM Department)").list();
        System.out.println("Heads of departments with salaries less than 115 000 rubles a month");
        for (Employee employee : employeesHireDate) {
            System.out.println(employee.getName() + "\t" + employee.getHireDate());
        }

        session.getTransaction().commit();
        session.close();

        //==================================================================
        if (sessionFactory != null) {
            sessionFactory.close();
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
