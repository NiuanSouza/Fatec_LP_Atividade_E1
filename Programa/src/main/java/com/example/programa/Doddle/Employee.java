package com.example.programa.Doddle;

public class Employee {

    private String name;
    private Double salary;
    private Double tenurePerYears;

    public Employee(String name, Double salary, Double tenurePerYears) {
        this.name = name;
        this.salary = salary;
        this.tenurePerYears = tenurePerYears;
    }

    public String work() {
        return this.name + " está trabalhando duro em suas tarefas.";
    }

    public String receivePayment() {
        return this.name + " recebeu o pagamento de R$ " + String.format("%.2f", this.salary);
    }

    public String salaryAdjustment(Double amount) {
        this.salary += amount;
        return "O salário de " + this.name + " foi ajustado em R$ " + String.format("%.2f", amount) + " para R$ " + String.format("%.2f", this.salary);
    }

    public String getName() { return name; }
    public Double getSalary() { return salary; }
    public Double getTenurePerYears() { return tenurePerYears; }

    public void setName(String name) { this.name = name; }
    public void setTenurePerYears(Double tenurePerYears) { this.tenurePerYears = tenurePerYears; }
}