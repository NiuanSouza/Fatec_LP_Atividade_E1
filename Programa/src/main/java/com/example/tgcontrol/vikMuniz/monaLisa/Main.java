package com.example.tgcontrol.vikMuniz.monaLisa;

public class Main {
    public static void main(String[] args) {
        Material peanutButter = new Material();
        Canva artSurface = new Canva();
        MonaLisa vikMunizArt = new MonaLisa();

        String materialInfo = peanutButter.getMaterial("Manteiga de Amendoim", 500, "Pastosa");
        String canvaInfo = artSurface.getCanva("Mesa de Luz", 120.5, 80.0);

        boolean isArtCreated = vikMunizArt.makeMonaLisa(materialInfo, canvaInfo, "Vik Muniz");

        System.out.println("\nA arte foi criada com sucesso? " + isArtCreated);
    }
}