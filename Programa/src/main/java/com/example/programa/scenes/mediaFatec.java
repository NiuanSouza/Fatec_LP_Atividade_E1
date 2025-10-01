package com.example.programa.scenes;
import javafx.scene.control.Label;

import com.example.programa.Media.MediaFatec;
import com.example.programa.EscreveCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class mediaFatec {

    private long eventCounter = 0;

    @FXML
    private TextField txt_p1;
    @FXML
    private TextField txt_e1;
    @FXML
    private TextField txt_e2;
    @FXML
    private TextField txt_x;
    @FXML
    private TextField txt_sub;
    @FXML
    private TextField txt_api;
    @FXML
    private Label resposta;

    private void logEvent(String eventType, String entityName, String entityValue) {
        eventCounter++;
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

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
    public void calcularMedia(ActionEvent actionEvent)
    {
        double p1 = txt_p1.getText().isEmpty() ? 0 : Double.parseDouble(txt_p1.getText());
        double e1 = txt_e1.getText().isEmpty() ? 0 : Double.parseDouble(txt_e1.getText());
        double e2 = txt_e2.getText().isEmpty() ? 0 : Double.parseDouble(txt_e2.getText());
        double x = txt_x.getText().isEmpty() ? 0 : Double.parseDouble(txt_x.getText());
        double sub = txt_sub.getText().isEmpty() ? 0 : Double.parseDouble(txt_sub.getText());
        double api = txt_api.getText().isEmpty() ? 0 : Double.parseDouble(txt_api.getText());

        MediaFatec aluno = new MediaFatec(p1, e1, e2, x, sub, api);

        double mediaFinal = aluno.calMedia();

        resposta.setText(String.format("Resposta: %.2f", mediaFinal));

        try {
            logEvent("Entrada P1", "Nota P1", String.valueOf(p1));
            logEvent("Entrada E1", "Nota E1", String.valueOf(e1));
            logEvent("Entrada E2", "Nota E2", String.valueOf(e2));
            logEvent("Entrada X", "Nota X", String.valueOf(x));
            logEvent("Entrada SUB", "Nota SUB", String.valueOf(sub));
            logEvent("Entrada API", "Nota API", String.valueOf(api));

            logEvent("Calculo Final", "Media Final", String.format("%.2f", mediaFinal));

        } catch (Exception e) {
            System.err.println("Erro durante o log de dados: " + e.getMessage());
        }
    }
}