package linkedinTopCompanies2021;

public class Vanancy {
	
	private String position;
	private Double salary;
	private String requirements;
	
	public Vanancy(String position, Double salary, String requirements) {
		this.position = position;
		this.salary = salary;
		this.requirements = requirements;
	}
	
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
    
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String advertiseVacancy() {
		return "--- VAGA DISPONÍVEL ---\n" +
		       "Cargo: " + this.position + "\n" +
		       "Salário: R$ " + this.salary + "\n" +
		       "Requisitos: " + this.requirements + "\n" +
		       "-----------------------";
	}

}
