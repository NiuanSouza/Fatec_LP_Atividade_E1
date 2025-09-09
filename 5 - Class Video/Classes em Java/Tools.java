package desafioSobFogo;

public class Tools {
	
    private String name;
    private String function;
    private double durability; 

    public Tools(String name, String function, double durability) {
        this.name = name;
        this.function = function;
        this.durability = durability;
    }

    public void use() {
        if (durability > 0) {
            System.out.println("Usando a ferramenta: " + name + ".");
            this.durability -= 5.5;
            if (this.durability < 0) {
                this.durability = 0;
            }
        } else {
            System.out.println("A ferramenta " + name + " quebrou e não pode mais ser usada.");
        }
    }

    public void checkDurability() {
        System.out.println("Durabilidade de '" + name + "': " + String.format("%.1f", durability) + "%");
    }

    public void describeFunction() {
        System.out.println("A função de '" + name + "' é: " + function + ".");
    }
}
