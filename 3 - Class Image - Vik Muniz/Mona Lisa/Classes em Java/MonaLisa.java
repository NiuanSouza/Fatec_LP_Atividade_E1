package monaLisa;

public class MonaLisa {
    public String material;
    public String canva;
    public String artist;

    public boolean makeMonaLisa(String material, String canva, String artist) {
        this.material = material;
        this.canva = canva;
        this.artist = artist;
        System.out.println(this.artist + " está criando a Mona Lisa.");
        System.out.println("Usando " + this.material);
        System.out.println("Sobre " + this.canva);
        System.out.println("Criação concluída!");
        return true;
    }
}