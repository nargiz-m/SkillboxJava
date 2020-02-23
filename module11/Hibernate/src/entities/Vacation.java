package entities;

import java.time.LocalDate;

public class Vacation {
    private Integer id;
    private Employee employee;
    private LocalDate vacationBeginning;
    private LocalDate vacationEnding;

    public Vacation() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getVacationBeginning() {
        return vacationBeginning;
    }

    public void setVacationBeginning(LocalDate vacationBeginning) {
        this.vacationBeginning = vacationBeginning;
    }

    public LocalDate getVacationEnding() {
        return vacationEnding;
    }

    public void setVacationEnding(LocalDate vacationEnding) {
        this.vacationEnding = vacationEnding;
    }
}
