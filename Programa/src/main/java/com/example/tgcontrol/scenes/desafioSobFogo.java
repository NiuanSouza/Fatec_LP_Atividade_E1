package com.example.tgcontrol.scenes;

import com.example.tgcontrol.desafioSobFogo.Blacksmith;
import com.example.tgcontrol.desafioSobFogo.Knife;
import com.example.tgcontrol.desafioSobFogo.Tools;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class desafioSobFogo {

    // --- Instâncias de Estado ---
    private Blacksmith currentBlacksmith;
    private Tools currentTool;
    private Knife currentKnife;

    // --- FXML UI Components ---
    @FXML private TextArea txt_view;
    @FXML private Label lbl_status;

    // Tool
    @FXML private TextField txt_toolName;
    @FXML private TextField txt_toolFunction;
    @FXML private TextField txt_toolDurability; // Durability

    // Knife
    @FXML private TextField txt_knifeMaterial;
    @FXML private TextField txt_knifeHandle;
    @FXML private TextField txt_knifeMethod;

    // Blacksmith
    @FXML private TextField txt_bsName;
    @FXML private TextField txt_bsAge;
    @FXML private TextField txt_bsCountry;


    @FXML
    public void initialize() {
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

        try {
            double initialDurability = Double.parseDouble(txt_toolDurability.getText());
            currentTool = new Tools(txt_toolName.getText(), txt_toolFunction.getText(), initialDurability);
            txt_view.appendText(">> SISTEMA: Ferreiro e Tool principal carregados.");
            lbl_status.setText("Pronto para forjar com " + currentTool.getName() + ".");
        } catch (NumberFormatException e) {
            currentTool = new Tools(txt_toolName.getText(), txt_toolFunction.getText(), 100.0);
            txt_toolDurability.setText("100.0");
            lbl_status.setText("ERRO: Durabilidade inválida. Usando 100%.");
            txt_view.appendText("\n>> ERRO: Durabilidade inválida. Usando 100%.");
        }
    }

    private int safeParseInt(String text, int defaultValue) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @FXML
    void useTool(ActionEvent event) {

        String useStatus = currentTool.use();
        txt_view.appendText("\n>> TOOL: " + useStatus);

        txt_toolDurability.setText(String.format("%.1f", currentTool.getDurability()));

        lbl_status.setText("A ferramenta " + currentTool.getName() + " foi usada.");
    }

    @FXML
    void knifeCut(ActionEvent event) {

        String forgeStatus = currentBlacksmith.forge("Espada Curta");
        txt_view.appendText("\n>> BSMITH: " + forgeStatus);

        String cutStatus = currentKnife.cut();
        txt_view.appendText("\n>> KNIFE: " + cutStatus);

        lbl_status.setText("Teste de corte da faca concluído.");
    }

    @FXML
    void bsIntroduce(ActionEvent event) {

        currentBlacksmith = new Blacksmith(
                txt_bsName.getText(),
                safeParseInt(txt_bsAge.getText(), 40),
                txt_bsCountry.getText()
        );

        String introStatus = currentBlacksmith.introduce();

        txt_view.appendText("\n--- APRESENTAÇÃO ---");
        txt_view.appendText("\n>> BSMITH: " + introStatus);
        lbl_status.setText("Ferreiro apresentado.");
    }
}