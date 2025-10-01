package com.example.programa.scenes;

import com.example.programa.MusicClass.Honour;
import com.example.programa.MusicClass.Power;
import com.example.programa.MusicClass.Valour;
import com.example.programa.EscreveCSV; // Importa a classe de log
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class romeAnthen {

    private long eventCounter = 0;

    @FXML
    public TextField txt_emotion;
    @FXML
    public TextField txt_action;
    @FXML
    public TextField txt_destination;

    @FXML
    public Label lbl_liftSouls;


    @FXML
    public TextField txt_virtude;
    @FXML
    public TextField txt_expressao;
    @FXML
    public TextField txt_mensagem;

    @FXML
    public Label lbl_singPraise;


    @FXML
    public TextField txt_power;
    @FXML
    public TextField txt_identity;
    @FXML
    public TextField txt_symbol;

    @FXML
    public Label lbl_declareLineage;


    private void logEvent(String eventType, String entityName, String entityValue) {
        String csvData = String.format("%s,%s,%s",
                entityName,
                entityValue,
                eventType
        );

        try {
            EscreveCSV.escreverLinha(csvData);
        } catch (IOException e) {
            System.err.println("ERRO CSV: Não foi possível salvar o log. " + e.getMessage());
        }
    }


    @FXML
    public void lift(ActionEvent actionEvent)
    {
        String emotion = txt_emotion.getText();
        String action = txt_action.getText();
        String destination = txt_destination.getText();

        Valour valour = new Valour(emotion, action, destination);

        String resultsouls = valour.liftSouls();

        lbl_liftSouls.setText(resultsouls);

        logEvent("Lift Souls (Valour)", emotion, destination + " via " + action);
    }

    @FXML
    public void sing(ActionEvent actionEvent)
    {
        String virtude = txt_virtude.getText();
        String expressao = txt_expressao.getText();
        String mensagem = txt_mensagem.getText();

        Honour honour = new Honour(virtude, expressao, mensagem);

        String resultPraise = honour.singPraise();

        lbl_singPraise.setText(resultPraise);

        logEvent("Sing Praise (Honour)", virtude, expressao + " | " + mensagem);
    }

    @FXML
    public void declare(ActionEvent actionEvent)
    {
        String strength = txt_power.getText();
        String identity = txt_identity.getText();
        String symbol = txt_symbol.getText();

        Power power = new Power(strength, identity, symbol);

        String resultLineage = power.declareLineage();

        lbl_declareLineage.setText(resultLineage);

        logEvent("Declare Lineage (Power)", identity, strength + " | " + symbol);
    }
}
