package linkedinTopCompanies2021;

public class Main {

	public static void main(String[] args) {
		
		Companies itau = new Companies("Itaú Unibanco", 96100, 50000000.00);
		itau.hire(5);
		itau.dismiss(2);
		System.out.println(itau.advertiseVacancy());
		
		Employee ana = new Employee("Ana Silva", 7500.00, 2.5);
		ana.work();
		ana.salaryAdjustment(500.00); 
		ana.receivePayment();

		Vanancy devVaga = new Vanancy("Desenvolvedor(a) Java Sênior", 12000.00, "5+ anos de experiência com Java e Spring Boot.");

		System.out.println(devVaga.advertiseVacancy());
	}

}
