package com.example.programa.vikMuniz.monaLisa;

public class MonaLisa {
    private Material usedMaterial;
    private Canva surface;
    private String artist;
    private boolean created = false;

    public MonaLisa(String artist) {
        this.artist = artist;
    }

    public boolean makeMonaLisa(Material material, Canva canva) {
        if (material != null && canva != null) {
            this.usedMaterial = material;
            this.surface = canva;
            this.created = true;
            return true;
        }
        return false;
    }

    public String getCreationStatus() {
        if (created) {
            return "A arte foi criada com sucesso pelo artista " + this.artist + "!";
        }
        return "A obra ainda não foi criada. Verifique o material e o quadro.";
    }
}