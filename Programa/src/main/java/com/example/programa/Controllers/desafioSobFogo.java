package com.example.programa.Controllers;

import com.example.programa.EscreveCSV;
import com.example.programa.Classes.desafioSobFogo.Blacksmith;
import com.example.programa.Classes.desafioSobFogo.Knife;
import com.example.programa.Classes.desafioSobFogo.Tools;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class desafioSobFogo {

    private Blacksmith currentBlacksmith;
    private Tools currentTool;
    private Knife currentKnife;

    @FXML private TextArea txt_view;
    @FXML private Label lbl_status;

    @FXML private TextField txt_toolName;
    @FXML private TextField txt_toolFunction;
    @FXML private TextField txt_toolDurability;

    @FXML private TextField txt_knifeMaterial;
    @FXML private TextField txt_knifeHandle;
    @FXML private TextField txt_knifeMethod;

    @FXML private TextField txt_bsName;
    @FXML private TextField txt_bsAge;
    @FXML private TextField txt_bsCountry;

    private void logEvent(String eventType, String eventName, String eventValue) {
        String csvData = String.format("%s,%s,%s", eventName, eventValue, eventType);
        try {
            EscreveCSV.escreverLinha(csvData);
        } catch (IOException e) {
            lbl_status.setText("ERRO: Falha ao salvar CSV.");
        }
    }

    private int safeParseInt(String text, int defaultValue) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private boolean isFieldEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    @FXML
    public void initialize() {
        if (isFieldEmpty(txt_toolName.getText()) || isFieldEmpty(txt_toolFunction.getText()) || isFieldEmpty(txt_toolDurability.getText())) {
            lbl_status.setText("Preencha todos os dados da ferramenta.");
            txt_view.appendText("\nErro: Dados da ferramenta incompletos.");
            return;
        }

        try {
            double initialDurability = Double.parseDouble(txt_toolDurability.getText());
            currentTool = new Tools(txt_toolName.getText(), txt_toolFunction.getText(), initialDurability);
            lbl_status.setText("Ferramenta carregada: " + currentTool.getName());
            txt_view.appendText("\nFerramenta inicializada com sucesso.");
        } catch (NumberFormatException e) {
            currentTool = new Tools(txt_toolName.getText(), txt_toolFunction.getText(), 100.0);
            txt_toolDurability.setText("100.0");
            lbl_status.setText("Durabilidade inválida. Usando 100%.");
            txt_view.appendText("\nDurabilidade inválida. Usando 100%.");
        }
    }

    @FXML
    void useTool(ActionEvent event) {
        if (currentTool == null) {
            lbl_status.setText("Ferramenta não inicializada.");
            return;
        }

        String useStatus = currentTool.use();
        txt_view.appendText("\n" + useStatus);

        double newDurability = currentTool.getDurability();
        txt_toolDurability.setText(String.format("%.1f", newDurability));

        lbl_status.setText("Ferramenta usada: " + currentTool.getName());
        logEvent("Uso de Ferramenta", currentTool.getName(), String.format("%.1f", newDurability));
    }

    @FXML
    void knifeCut(ActionEvent event) {
        if (isFieldEmpty(txt_bsName.getText()) || isFieldEmpty(txt_bsAge.getText()) || isFieldEmpty(txt_bsCountry.getText())) {
            lbl_status.setText("Preencha todos os dados do ferreiro.");
            return;
        }

        if (isFieldEmpty(txt_knifeMaterial.getText()) || isFieldEmpty(txt_knifeHandle.getText()) || isFieldEmpty(txt_knifeMethod.getText())) {
            lbl_status.setText("Preencha todos os dados da faca.");
            return;
        }

        try {
            currentBlacksmith = new Blacksmith(
                    txt_bsName.getText(),
                    safeParseInt(txt_bsAge.getText(), 40),
                    txt_bsCountry.getText()
            );

            currentKnife = new Knife(
                    txt_knifeMaterial.getText(),
                    txt_knifeHandle.getText(),
                    txt_knifeMethod.getText()
            );

            String forgeStatus = currentBlacksmith.forge("Faca de Teste");
            String cutStatus = currentKnife.cut();

            txt_view.appendText("\n--- TESTE DE CORTE ---");
            txt_view.appendText("\n" + forgeStatus);
            txt_view.appendText("\n" + cutStatus);

            lbl_status.setText("Faca forjada e testada com sucesso.");
            logEvent("Teste de Corte", currentBlacksmith.getName(), currentKnife.getMaterial());

        } catch (IllegalArgumentException e) {
            lbl_status.setText("Erro ao criar faca: " + e.getMessage());
        }
    }

    @FXML
    void bsIntroduce(ActionEvent event) {
        if (isFieldEmpty(txt_bsName.getText()) || isFieldEmpty(txt_bsAge.getText()) || isFieldEmpty(txt_bsCountry.getText())) {
            lbl_status.setText("Preencha todos os dados do ferreiro.");
            return;
        }

        currentBlacksmith = new Blacksmith(
                txt_bsName.getText(),
                safeParseInt(txt_bsAge.getText(), 40),
                txt_bsCountry.getText()
        );

        String introStatus = currentBlacksmith.introduce();

        txt_view.appendText("\n--- APRESENTAÇÃO ---");
        txt_view.appendText("\n" + introStatus);
        lbl_status.setText("Ferreiro apresentado.");
        logEvent("Apresentação", currentBlacksmith.getName(), String.valueOf(currentBlacksmith.getAge()));
    }
}
