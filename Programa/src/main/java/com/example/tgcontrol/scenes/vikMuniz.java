package com.example.tgcontrol.scenes;

import com.example.tgcontrol.vikMuniz.monaLisa.Canva;
import com.example.tgcontrol.vikMuniz.monaLisa.Material;
import com.example.tgcontrol.vikMuniz.monaLisa.MonaLisa;
import com.example.tgcontrol.vikMuniz.trackBrawl.Fight;
import com.example.tgcontrol.vikMuniz.trackBrawl.Fighter;
import com.example.tgcontrol.vikMuniz.trackBrawl.Local;
import com.example.tgcontrol.EscreveCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class vikMuniz {

    private long eventCounter = 0;

    // --- Instâncias de Estado ---
    private Local currentLocal;
    private Fighter fighterOne;
    private Fighter fighterTwo;

    // --- Mona Lisa Components ---
    @FXML public TextField txt_materialName;
    @FXML public TextField txt_materialAmount;
    @FXML public TextField txt_materialConsistency;
    @FXML public Label lbl_material;

    @FXML public TextField txt_canvaBackground;
    @FXML public TextField txt_canvaHeight;
    @FXML public TextField tzt_canvaWidth;
    @FXML public Label lbl_canva;

    @FXML public TextField txt_artist;
    @FXML public Label lbl_monaLisa;

    // --- Track Brawl Components ---
    @FXML public TextField txt_fighterName1;
    @FXML public TextField txt_fighterAge1;
    @FXML public TextField txt_fighterWeight1;

    @FXML public TextField txt_fighterName2;
    @FXML public TextField txt_fighterAge2;
    @FXML public TextField txt_fighterWeight2;

    @FXML public TextField txt_latitude;
    @FXML public TextField txt_longitude;
    @FXML public TextField txt_altitude;

    @FXML public Label lbl_local;
    @FXML public TextArea txt_view;

    private void logEvent(String eventType, String entityName, String entityValue) {
        eventCounter++;
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        // Mapeando dados para a estrutura CSV (id, name, salary, start_date, dept)
        String csvData = String.format("%d,%s,%s,%s,%s",
                eventCounter,           // id: Contador sequencial
                entityName,             // name: Nome da Entidade (ex: "MonaLisa", "Lutador 1")
                entityValue,            // salary: Valor principal (ex: Altura do canvas, Peso do lutador)
                timestamp,              // start_date: Timestamp da consulta
                eventType               // dept: Tipo de evento (Categoria: Monalisa, Luta, Local)
        );

        try {
            EscreveCSV.escreverLinha(csvData);
        } catch (IOException e) {
            System.err.println("ERRO CSV: Não foi possível salvar o log. " + e.getMessage());
        }
    }

    @FXML
    public void btn_Monalisa(ActionEvent actionEvent) {
        try {
            String materialName = txt_materialName.getText();
            int materialAmount = Integer.parseInt(txt_materialAmount.getText());
            String materialConsistency = txt_materialConsistency.getText();
            Material vikMaterial = new Material(materialName, materialAmount, materialConsistency);
            lbl_material.setText(vikMaterial.getInfo());

            String canvaBackground = txt_canvaBackground.getText();
            double canvaHeight = Double.parseDouble(txt_canvaHeight.getText());
            double canvaWidth = Double.parseDouble(tzt_canvaWidth.getText());
            Canva artSurface = new Canva(canvaBackground, canvaHeight, canvaWidth);
            lbl_canva.setText(artSurface.getInfo());

            String artist = txt_artist.getText();
            MonaLisa vikMunizArt = new MonaLisa(artist);

            boolean isArtCreated = vikMunizArt.makeMonaLisa(vikMaterial, artSurface);

            if(isArtCreated) {
                lbl_monaLisa.setText(vikMunizArt.getCreationStatus());
                // LOG: Criação bem-sucedida da Mona Lisa
                String details = String.format("Material: %s (x%d), Canvas: %.1fx%.1f",
                        materialName, materialAmount, canvaWidth, canvaHeight);
                logEvent("MonaLisa (Sucesso)", artist, details);
            } else {
                lbl_monaLisa.setText("ERRO ao criar a arte. Verifique os dados.");
                logEvent("MonaLisa (Erro)", artist, "Criação falhou na lógica interna.");
            }


        } catch (NumberFormatException e) {
            lbl_monaLisa.setText("ERRO: Quantidade, Altura e Largura devem ser números válidos!");
            logEvent("MonaLisa (Erro)", "Dados de Entrada", "Numérico Inválido");
        }
    }


    @FXML
    public void btn_local(ActionEvent actionEvent) {
        try {
            int latitude = Integer.parseInt(txt_latitude.getText());
            int longitude = Integer.parseInt(txt_longitude.getText());
            int altitude = Integer.parseInt(txt_altitude.getText());

            currentLocal = new Local(latitude, longitude, altitude);

            lbl_local.setText(currentLocal.getInfo());
            txt_view.appendText("\n--- Local Definido ---");
            txt_view.appendText("\n" + currentLocal.getInfo());

            // LOG: Definição do Local
            String coords = String.format("Lat: %d, Lon: %d", latitude, longitude);
            logEvent("Track Brawl - Local", "Coordenadas", coords);

        } catch (NumberFormatException e) {
            lbl_local.setText("ERRO: Latitude, Longitude e Altitude devem ser números inteiros válidos.");
            logEvent("Track Brawl - Local (Erro)", "Coordenadas", "Numérico Inválido");
        }
    }

    @FXML
    public void btn_fighter(ActionEvent actionEvent) {
        try {
            String name1 = txt_fighterName1.getText();
            int age1 = Integer.parseInt(txt_fighterAge1.getText());
            double weight1 = Double.parseDouble(txt_fighterWeight1.getText());

            Fighter tempFighterOne = new Fighter(name1, age1, weight1);

            String name2 = txt_fighterName2.getText();
            int age2 = Integer.parseInt(txt_fighterAge2.getText());
            double weight2 = Double.parseDouble(txt_fighterWeight2.getText());

            Fighter tempFighterTwo = new Fighter(name2, age2, weight2);

            fighterOne = tempFighterOne;
            fighterTwo = tempFighterTwo;

            txt_view.appendText("\n--- Lutadores Definidos ---");
            txt_view.appendText("\n" + fighterOne.apresetention());
            txt_view.appendText("\n" + fighterTwo.apresetention());

            String details = String.format("%s (%d kg) vs %s (%d kg)", name1, (int)weight1, name2, (int)weight2);
            logEvent("Track Brawl - Lutadores", "Definidos", details);

        } catch (NumberFormatException e) {
            txt_view.appendText("\nERRO: Idade e Peso dos lutadores devem ser números válidos.");
            logEvent("Track Brawl - Lutadores (Erro)", "Definição", "Numérico Inválido");
        }
    }

    @FXML
    public void btn_fight(ActionEvent actionEvent) {
        if (fighterOne == null || fighterTwo == null || currentLocal == null) {
            txt_view.appendText("\nERRO: Defina os Lutadores e o Local antes de iniciar a luta!");
            logEvent("Track Brawl - Luta (Erro)", "Início da Luta", "Faltando dados de lutadores/local");
            return;
        }

        Fight mainEvent = new Fight(fighterOne, fighterTwo, currentLocal);
        mainEvent.setTime(new Date());

        txt_view.appendText("\n" + mainEvent.getDetails());


        String event = String.format("Luta: %s vs %s", fighterOne.apresetention(), fighterTwo.apresetention());
        logEvent("Track Brawl - Luta", event, currentLocal.getInfo());
    }
}
