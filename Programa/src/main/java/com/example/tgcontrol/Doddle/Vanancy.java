package com.example.tgcontrol.Doddle;

public class Vanancy {

    private String position;
    private Double salary;
    private String requirements;

    public Vanancy(String position, Double salary, String requirements) {
        this.position = position;
        this.salary = salary;
        this.requirements = requirements;
    }

    public String advertiseVacancy() {
        return "--- VAGA DISPONÍVEL ---\n" +
		"Cargo: " + this.position + "\n" +
		"Salário: R$ " + this.salary + "\n" +
		"Requisitos: " + this.requirements + "\n" +
		"-----------------------";
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // Getters
    public String getPosition() {
        return position;
    }

    public Double getSalary() {
        return salary;
    }

    public String getRequirements() {
        return requirements;
    }

}