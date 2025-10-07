package com.example.programa.Controllers;

import com.example.programa.EscreveCSV;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public abstract class controllerBase {

    private String logFilePath;
    private String[] logHeaders;

    @FXML
    protected Label lblStatus;

    public abstract String getLogFilePath();

    public abstract String[] getLogHeaders();

    @FXML
    public final void initialize() {
        try {
            this.logFilePath = getLogFilePath();
            this.logHeaders = getLogHeaders();

            if (logFilePath == null || logFilePath.trim().isEmpty() || logHeaders == null || logHeaders.length == 0) {
                throw new IllegalStateException("O caminho do arquivo de log e os cabeçalhos devem ser fornecidos pelo controller filho.");
            }

            inicializarController();

        } catch (Exception e) {
            System.err.println("ERRO CRÍTICO na inicialização do controller: " + e.getMessage());
            exibirMensagem("ERRO na inicialização: " + e.getMessage());
        }
    }

    protected void inicializarController() {
    }

    protected void logarEvento(String... dados) {
        try {
            EscreveCSV.escreverLinha(this.logFilePath, this.logHeaders, dados);
        } catch (IOException e) {
            System.err.println("Falha ao registrar evento no log '" + this.logFilePath + "': " + e.getMessage());
            exibirMensagem("ERRO: Falha ao salvar log.");
        }
    }

    protected void exibirMensagem(String mensagem) {
        if (lblStatus != null) {
            lblStatus.setText(mensagem);
        }
    }
}
