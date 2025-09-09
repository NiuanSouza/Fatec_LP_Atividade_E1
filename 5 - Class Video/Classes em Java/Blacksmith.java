package desafioSobFogo;

public class Blacksmith {

    private String name;
    private int age;
    private String country;

    public Blacksmith(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public void forge(String itemName) {
        System.out.println(name + " está forjando um(a) " + itemName + " na bigorna com o calor da fornalha.");
    }

    public void repair(String tool) {
        System.out.println("O ferreiro está consertando o(a) " + tool + ". Parece novo em folha!");
    }

    public void introduce() {
        System.out.println("Olá! Meu nome é " + name + ", tenho " + age + " anos e venho de " + country + ".");
    }
}
