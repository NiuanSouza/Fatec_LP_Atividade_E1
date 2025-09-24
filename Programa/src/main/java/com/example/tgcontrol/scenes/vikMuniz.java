package com.example.tgcontrol.scenes;

import com.example.tgcontrol.vikMuniz.monaLisa.Canva;
import com.example.tgcontrol.vikMuniz.monaLisa.Material;
import com.example.tgcontrol.vikMuniz.monaLisa.MonaLisa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class vikMuniz {

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
}
