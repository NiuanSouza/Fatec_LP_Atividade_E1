package com.example.tgcontrol.scenes;

import com.example.tgcontrol.vikMuniz.monaLisa.Canva;
import com.example.tgcontrol.vikMuniz.monaLisa.Material;
import com.example.tgcontrol.vikMuniz.monaLisa.MonaLisa;
import com.example.tgcontrol.vikMuniz.trackBrawl.Fight;
import com.example.tgcontrol.vikMuniz.trackBrawl.Fighter;
import com.example.tgcontrol.vikMuniz.trackBrawl.Local;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Date;

public class vikMuniz {

    //Mona Lisa
    @FXML
    public TextField txt_materialName;
    @FXML
    public TextField txt_materialAmount;
    @FXML
    public TextField txt_materialConsistency;
    @FXML
    public Label lbl_material;

    @FXML
    public TextField txt_canvaBackground;
    @FXML
    public TextField txt_canvaHeight;
    @FXML
    public TextField tzt_canvaWidth;
    @FXML
    public Label lbl_canva;

    @FXML
    public TextField txt_artist;
    @FXML
    public Label lbl_monaLisa;


    //Track Brawl

    @FXML
    public TextField txt_fighterName1;
    @FXML
    public TextField txt_fighterAge1;
    @FXML
    public TextField txt_fighterWeight1;

    @FXML
    public TextField txt_fighterName2;
    @FXML
    public TextField txt_fighterAge2;
    @FXML
    public TextField txt_fighterWeight2;

    @FXML
    public TextField txt_latitude;
    @FXML
    public TextField txt_longitude;
    @FXML
    public TextField txt_altitude;

    @FXML
    public Label lbl_local;

    @FXML
    public TextArea txt_view;

    String localInfo;

    @FXML
    public void btn_Monalisa(ActionEvent actionEvent)
    {
        Material vikMaterial = new Material();

        String materialName = txt_materialName.getText();
        int materialAmount = Integer.parseInt(txt_materialAmount.getText());
        String materialConsistency = txt_materialConsistency.getText();

        String materialInfo = vikMaterial.getMaterial(materialName, materialAmount, materialConsistency);

        lbl_material.setText(materialInfo);


        Canva artSurface = new Canva();

        String canvaBackground = txt_canvaBackground.getText();
        double canvaHeight = Double.parseDouble(txt_canvaHeight.getText());
        double canvaWidth = Double.parseDouble(tzt_canvaWidth.getText());

        String canvaInfo = artSurface.getCanva(canvaBackground, canvaHeight, canvaWidth);

        lbl_canva.setText(canvaInfo);

        MonaLisa vikMunizArt = new MonaLisa();

        String artist = txt_artist.getText();

        boolean isArtCreated = vikMunizArt.makeMonaLisa(materialInfo, canvaInfo, artist);

        if(isArtCreated)
        {
            lbl_monaLisa.setText("A arte foi criada com sucesso!");
        }
    }

    @FXML
    public void btn_local(ActionEvent actionEvent)
    {
        int latitude = Integer.parseInt(txt_latitude.getText());
        int longitude = Integer.parseInt(txt_longitude.getText());
        int altitude = Integer.parseInt(txt_altitude.getText());

        Local arena = new Local();
        localInfo = arena.calculateLocal(latitude, longitude, altitude);

        lbl_local.setText(localInfo);
    }

    public void btn_fighter(ActionEvent actionEvent)
    {

        Fighter fighter1 = new Fighter();
        fighter1.fighterName = txt_fighterName1.getText();
        fighter1.age = Integer.parseInt(txt_fighterAge1.getText());
        fighter1.weight = Double.parseDouble(txt_fighterWeight1.getText());

        Fighter fighter2 = new Fighter();
        fighter2.fighterName = txt_fighterName2.getText();
        fighter2.age = Integer.parseInt(txt_fighterAge2.getText());
        fighter2.weight = Double.parseDouble(txt_fighterWeight2.getText());

        String apresentationfighter1 = fighter1.apresetention();
        String apresentationfighter2 = fighter2.apresetention();

        txt_view.appendText("\n"+apresentationfighter1);
        txt_view.appendText("\n"+apresentationfighter2);

    }

    public void btn_fight(ActionEvent actionEvent)
    {
        Fight mainEvent = new Fight();
        mainEvent.participants = "Lutador 1 vs. Lutadora 2";
        mainEvent.local = localInfo;
        mainEvent.time = new Date();

        txt_view.appendText("\n--- Detalhes do Evento ---");
        boolean didFightStart = mainEvent.fightBegin();
        txt_view.appendText("\nA luta começou? " + didFightStart);
    }
}
