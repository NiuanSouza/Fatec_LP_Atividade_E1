package linkedinTopCompanies2021;

public class Companies {
	
	private String name;
	private int employeesNumber;
	private Double money;

	public Companies(String name, int employeesNumber, Double money) {
		this.name = name;
		this.employeesNumber = employeesNumber;
		this.money = money;
	}
	
	public void hire(int number){
		this.employeesNumber += number;
		System.out.println(this.name + " contratou " + number + " novo(s) funcionário(s). Total: " + this.employeesNumber);
	}

	public void dismiss(int number) {
		if (this.employeesNumber >= number) {
			this.employeesNumber -= number;
			System.out.println(this.name + " demitiu " + number + " funcionário(s). Restam: " + this.employeesNumber);
		} else {
			System.out.println("Não é possível demitir " + number + " funcionário(s). A empresa só tem " + this.employeesNumber + ".");
		}
	}
    
	public String advertiseVacancy(){
		return "A empresa " + this.name + " está com novas vagas abertas!";
	}
}
