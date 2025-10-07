package com.example.programa.Controllers;

import com.example.programa.Classes.desafioSobFogo.Blacksmith;
import com.example.programa.Classes.desafioSobFogo.Knife;
import com.example.programa.Classes.desafioSobFogo.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class desafioSobFogo extends controllerBase {

    @Override
    public String getLogFilePath() {
        return "saida/log_desafio_sob_fogo.csv";
    }

    @Override
    public String[] getLogHeaders() {
        return new String[]{"Autor", "Resultado", "Ação"};
    }

    private Blacksmith currentBlacksmith;
    private Tools currentTool;
    private Knife currentKnife;

    @FXML private TextArea txt_view;

    @FXML private TextField txt_toolName;
    @FXML private TextField txt_toolFunction;
    @FXML private TextField txt_toolDurability;
    @FXML private TextField txt_knifeMaterial;
    @FXML private TextField txt_knifeHandle;
    @FXML private TextField txt_knifeMethod;
    @FXML private TextField txt_bsName;
    @FXML private TextField txt_bsAge;
    @FXML private TextField txt_bsCountry;

    @Override
    protected void inicializarController() {
        if (isFieldEmpty(txt_toolName.getText()) || isFieldEmpty(txt_toolFunction.getText()) || isFieldEmpty(txt_toolDurability.getText())) {
            exibirMensagem("Preencha todos os dados da ferramenta.");
            txt_view.appendText("\nErro: Dados da ferramenta incompletos.");
            return;
        }

        try {
            double initialDurability = Double.parseDouble(txt_toolDurability.getText());
            currentTool = new Tools(txt_toolName.getText(), txt_toolFunction.getText(), initialDurability);
            exibirMensagem("Ferramenta carregada: " + currentTool.getName());
            txt_view.appendText("\nFerramenta inicializada com sucesso.");
        } catch (NumberFormatException e) {
            currentTool = new Tools(txt_toolName.getText(), txt_toolFunction.getText(), 100.0);
            txt_toolDurability.setText("100.0");
            exibirMensagem("Durabilidade inválida. Usando 100%.");
            txt_view.appendText("\nDurabilidade inválida. Usando 100%.");
        }
    }

    @FXML
    void useTool(ActionEvent event) {
        if (currentTool == null) {
            exibirMensagem("Ferramenta não inicializada.");
            return;
        }

        String useStatus = currentTool.use();
        txt_view.appendText("\n" + useStatus);

        double newDurability = currentTool.getDurability();
        txt_toolDurability.setText(String.format("%.1f", newDurability));

        exibirMensagem("Ferramenta usada: " + currentTool.getName());
        logarEvento(currentTool.getName(), String.format("%.1f", newDurability), "Uso de Ferramenta");
    }

    @FXML
    void knifeCut(ActionEvent event) {
        if (isFieldEmpty(txt_bsName.getText()) || isFieldEmpty(txt_bsAge.getText()) || isFieldEmpty(txt_bsCountry.getText())) {
            exibirMensagem("Preencha todos os dados do ferreiro.");
            return;
        }
        if (isFieldEmpty(txt_knifeMaterial.getText()) || isFieldEmpty(txt_knifeHandle.getText()) || isFieldEmpty(txt_knifeMethod.getText())) {
            exibirMensagem("Preencha todos os dados da faca.");
            return;
        }

        try {
            currentBlacksmith = new Blacksmith(txt_bsName.getText(), safeParseInt(txt_bsAge.getText(), 40), txt_bsCountry.getText());
            currentKnife = new Knife(txt_knifeMaterial.getText(), txt_knifeHandle.getText(), txt_knifeMethod.getText());

            txt_view.appendText("\n--- TESTE DE CORTE ---");
            txt_view.appendText("\n" + currentBlacksmith.forge("Faca de Teste"));
            txt_view.appendText("\n" + currentKnife.cut());

            exibirMensagem("Faca forjada e testada com sucesso.");
            logarEvento(currentBlacksmith.getName(), currentKnife.getMaterial(), "Teste de Corte");

        } catch (IllegalArgumentException e) {
            exibirMensagem("Erro ao criar faca: " + e.getMessage());
        }
    }

    @FXML
    void bsIntroduce(ActionEvent event) {
        if (isFieldEmpty(txt_bsName.getText()) || isFieldEmpty(txt_bsAge.getText()) || isFieldEmpty(txt_bsCountry.getText())) {
            exibirMensagem("Preencha todos os dados do ferreiro.");
            return;
        }

        currentBlacksmith = new Blacksmith(txt_bsName.getText(), safeParseInt(txt_bsAge.getText(), 40), txt_bsCountry.getText());

        txt_view.appendText("\n--- APRESENTAÇÃO ---");
        txt_view.appendText("\n" + currentBlacksmith.introduce());
        exibirMensagem("Ferreiro apresentado.");
        logarEvento(currentBlacksmith.getName(), String.valueOf(currentBlacksmith.getAge()), "Apresentação");
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
}