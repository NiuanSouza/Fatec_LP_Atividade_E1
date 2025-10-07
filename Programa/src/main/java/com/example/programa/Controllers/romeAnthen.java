package com.example.programa.Controllers;

import com.example.programa.Classes.MusicClass.Honour;
import com.example.programa.Classes.MusicClass.Power;
import com.example.programa.Classes.MusicClass.Valour;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class romeAnthen extends controllerBase {

    @FXML public TextField txt_emotion;
    @FXML public TextField txt_action;
    @FXML public TextField txt_destination;
    @FXML public Label lbl_liftSouls;

    @FXML public TextField txt_virtude;
    @FXML public TextField txt_expressao;
    @FXML public TextField txt_mensagem;
    @FXML public Label lbl_singPraise;

    @FXML public TextField txt_power;
    @FXML public TextField txt_identity;
    @FXML public TextField txt_symbol;
    @FXML public Label lbl_declareLineage;

    @Override
    public String getLogFilePath() {
        return "saida/log_rome_anthen.csv";
    }

    @Override
    public String[] getLogHeaders() {
        return new String[]{"Entidade", "Detalhes", "Ação"};
    }

    @FXML
    public void lift(ActionEvent actionEvent) {
        String emotion = txt_emotion.getText();
        String action = txt_action.getText();
        String destination = txt_destination.getText();

        Valour valour = new Valour(emotion, action, destination);
        String resultsouls = valour.liftSouls();
        lbl_liftSouls.setText(resultsouls);

        logarEvento(emotion, destination + " via " + action, "Lift Souls (Valour)");
    }

    @FXML
    public void sing(ActionEvent actionEvent) {
        String virtude = txt_virtude.getText();
        String expressao = txt_expressao.getText();
        String mensagem = txt_mensagem.getText();

        Honour honour = new Honour(virtude, expressao, mensagem);
        String resultPraise = honour.singPraise();
        lbl_singPraise.setText(resultPraise);

        logarEvento(virtude, expressao + " | " + mensagem, "Sing Praise (Honour)");
    }

    @FXML
    public void declare(ActionEvent actionEvent) {
        String strength = txt_power.getText();
        String identity = txt_identity.getText();
        String symbol = txt_symbol.getText();

        Power power = new Power(strength, identity, symbol);
        String resultLineage = power.declareLineage();
        lbl_declareLineage.setText(resultLineage);

        logarEvento(identity, strength + " | " + symbol, "Declare Lineage (Power)");
    }
}
