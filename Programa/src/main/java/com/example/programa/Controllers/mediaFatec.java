package com.example.programa.Controllers;

import com.example.programa.Classes.Media.MediaFatec;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mediaFatec extends controllerBase {

    @FXML private TextField txt_p1;
    @FXML private TextField txt_e1;
    @FXML private TextField txt_e2;
    @FXML private TextField txt_x;
    @FXML private TextField txt_sub;
    @FXML private TextField txt_api;
    @FXML private Label resposta;

    @Override
    public String getLogFilePath() {
        return "saida/log_media_fatec.csv";
    }

    @Override
    public String[] getLogHeaders() {
        return new String[]{"Entidade", "Valor", "Ação"};
    }

    @FXML
    public void calcularMedia(ActionEvent actionEvent) {
        double p1 = txt_p1.getText().isEmpty() ? 0 : Double.parseDouble(txt_p1.getText());
        double e1 = txt_e1.getText().isEmpty() ? 0 : Double.parseDouble(txt_e1.getText());
        double e2 = txt_e2.getText().isEmpty() ? 0 : Double.parseDouble(txt_e2.getText());
        double x = txt_x.getText().isEmpty() ? 0 : Double.parseDouble(txt_x.getText());
        double sub = txt_sub.getText().isEmpty() ? 0 : Double.parseDouble(txt_sub.getText());
        double api = txt_api.getText().isEmpty() ? 0 : Double.parseDouble(txt_api.getText());

        MediaFatec aluno = new MediaFatec(p1, e1, e2, x, sub, api);
        double mediaFinal = aluno.calMedia();

        resposta.setText(String.format("Resposta: %.2f", mediaFinal));

        logarEvento("Nota P1", String.valueOf(p1), "Entrada P1");
        logarEvento("Nota E1", String.valueOf(e1), "Entrada E1");
        logarEvento("Nota E2", String.valueOf(e2), "Entrada E2");
        logarEvento("Nota X", String.valueOf(x), "Entrada X");
        logarEvento("Nota SUB", String.valueOf(sub), "Entrada SUB");
        logarEvento("Nota API", String.valueOf(api), "Entrada API");
        logarEvento("Media Final", String.format("%.2f", mediaFinal), "Calculo Final");
    }
}
