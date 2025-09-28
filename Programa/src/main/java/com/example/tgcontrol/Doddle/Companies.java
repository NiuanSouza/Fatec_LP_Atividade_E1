package com.example.tgcontrol.Doddle;

public class Companies {

    private String name;
    private int employeesNumber;
    private Double money;

    public Companies(String name, int employeesNumber, Double money) {
        this.name = name;
        this.employeesNumber = employeesNumber;
        this.money = money;
    }

    public String hire(int number){
        this.employeesNumber += number;
        return this.name + " contratou " + number + " novo(s) funcionário(s). Total: " + this.employeesNumber;
    }

    public String dismiss(int number) {
        String status;
        if (this.employeesNumber >= number) {
            this.employeesNumber -= number;
            status = this.name + " demitiu " + number + " funcionário(s). Restam: " + this.employeesNumber;
        } else {
            status = "ERRO: Não é possível demitir " + number + " funcionário(s). A empresa só tem " + this.employeesNumber + ".";
        }
        return status;
    }
    public String advertiseVacancy(){
        return "A empresa " + this.name + " está com novas vagas abertas!";
    }

    public String getName() { return name; }
    public int getEmployeesNumber() { return employeesNumber; }
    public Double getMoney() { return money; }

    public void setMoney(Double money) { this.money = money; }
}