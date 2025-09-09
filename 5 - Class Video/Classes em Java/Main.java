package desafioSobFogo;

public class Main {

	public static void main(String[] args) {
		
        Blacksmith ferreiro = new Blacksmith("Benjamin", 45, "Brasil");
        ferreiro.introduce();
        ferreiro.forge("Espada Longa");
        ferreiro.repair("Martelo de Forja");

        Knife facaDeCombate = new Knife("Aço Damasco", "Micarta", "Caldeamento");
        facaDeCombate.displayInfo();
        facaDeCombate.sharpen();
        facaDeCombate.cut();

        Tools martelo = new Tools("Martelo de Forja", "Modelar metal quente", 100.0);
        martelo.describeFunction();
        martelo.checkDurability();
        martelo.use();
        martelo.use();
        martelo.use();
        
        martelo.checkDurability();
	}

}
