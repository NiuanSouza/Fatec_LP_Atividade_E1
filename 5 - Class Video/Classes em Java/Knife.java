package desafioSobFogo;

public class Knife {


    private String material;
    private String handle; 
    private String forgingMethod; 


    public Knife(String material, String handle, String forgingMethod) {
        this.material = material;
        this.handle = handle;
        this.forgingMethod = forgingMethod;
    }

    public void cut() {
        System.out.println("A faca de " + material + " está cortando com precisão.");
    }


    public void sharpen() {
        System.out.println("Afiando a lâmina... A faca está pronta para o uso!");
    }

    public void displayInfo() {
        System.out.println("--- Detalhes da Faca ---");
        System.out.println("Material da Lâmina: " + material);
        System.out.println("Material do Cabo: " + handle);
        System.out.println("Método de Forja: " + forgingMethod);
        System.out.println("-------------------------");
    }
}
