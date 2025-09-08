package linkedinTopCompanies2021;

public class Employee {
	
	private String name;
	private Double salary;
	private Double tenurePerYears;

	public Employee(String name, Double salary, Double tenurePerYears) {
		this.name = name; 
		this.salary = salary;
		this.tenurePerYears = tenurePerYears;
	}
	
	public void work() {
		System.out.println(this.name + " está trabalhando duro em suas tarefas.");
	}

	public Double receivePayment() {
		System.out.println(this.name + " recebeu o pagamento de R$ " + this.salary);
		return this.salary;
	}

	public void salaryAdjustment(Double amount) {
		this.salary += amount;
		System.out.println("O salário de " + this.name + " foi ajustado para R$ " + this.salary);
	}

}
