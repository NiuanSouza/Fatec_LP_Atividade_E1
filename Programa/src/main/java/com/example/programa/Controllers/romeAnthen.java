package com.example.programa.Controllers;

import com.example.programa.Classes.MusicClass.Honour;
import com.example.programa.Classes.MusicClass.Power;
import com.example.programa.Classes.MusicClass.Valour;
import com.example.programa.DAO.MusicDBConnect;
import com.example.programa.DAO.MusicDatabaseUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class romeAnthen extends controllerBase {

    @FXML private TabPane tabPane;

    // --- Valour ---
    @FXML private TextField txt_emotion;
    @FXML private TextField txt_action;
    @FXML private TextField txt_destination;
    @FXML private Label lbl_liftSouls;
    @FXML private TextField txt_valourId;
    @FXML private TableView<Valour> tblValour;
    @FXML private TableColumn<Valour, Integer> colValourId;
    @FXML private TableColumn<Valour, String> colValourEmotion;
    @FXML private TableColumn<Valour, String> colValourAction;
    @FXML private TableColumn<Valour, String> colValourDestination;

    // --- Honour ---
    @FXML private TextField txt_virtude;
    @FXML private TextField txt_expressao;
    @FXML private TextField txt_mensagem;
    @FXML private Label lbl_singPraise;
    @FXML private TextField txt_honourId;
    @FXML private TableView<Honour> tblHonour;
    @FXML private TableColumn<Honour, Integer> colHonourId;
    @FXML private TableColumn<Honour, String> colHonourVirtue;
    @FXML private TableColumn<Honour, String> colHonourExpression;
    @FXML private TableColumn<Honour, String> colHonourMessage;

    // --- Power ---
    @FXML private TextField txt_power;
    @FXML private TextField txt_identity;
    @FXML private TextField txt_symbol;
    @FXML private Label lbl_declareLineage;
    @FXML private TextField txt_powerId;
    @FXML private TableView<Power> tblPower;
    @FXML private TableColumn<Power, Integer> colPowerId;
    @FXML private TableColumn<Power, String> colPowerStrength;
    @FXML private TableColumn<Power, String> colPowerIdentity;
    @FXML private TableColumn<Power, String> colPowerSymbol;


    @Override
    protected void inicializarController() {
        MusicDBConnect.createTables();
        setupTableColumns();
        loadData();
    }

    @Override
    public String getLogFilePath() {
        return "saida/log_rome_anthen_db.csv";
    }

    @Override
    public String[] getLogHeaders() {
        return new String[]{"Entidade", "Detalhes", "Ação"};
    }

    /**
     * Configura a forma como as colunas da tabela serão preenchidas.
     */
    private void setupTableColumns() {
        // Valour Columns
        colValourId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colValourEmotion.setCellValueFactory(new PropertyValueFactory<>("emotion"));
        colValourAction.setCellValueFactory(new PropertyValueFactory<>("action"));
        colValourDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));

        // Honour Columns
        colHonourId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colHonourVirtue.setCellValueFactory(new PropertyValueFactory<>("virtue"));
        colHonourExpression.setCellValueFactory(new PropertyValueFactory<>("expression"));
        colHonourMessage.setCellValueFactory(new PropertyValueFactory<>("message"));

        // Power Columns
        colPowerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPowerStrength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        colPowerIdentity.setCellValueFactory(new PropertyValueFactory<>("identity"));
        colPowerSymbol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
    }

    /**
     * Carrega todos os dados do banco de dados para as TableViews.
     */
    private void loadData() {
        ObservableList<Valour> valourList = FXCollections.observableArrayList(MusicDatabaseUtils.readAllValour());
        tblValour.setItems(valourList);

        ObservableList<Honour> honourList = FXCollections.observableArrayList(MusicDatabaseUtils.readAllHonour());
        tblHonour.setItems(honourList);

        ObservableList<Power> powerList = FXCollections.observableArrayList(MusicDatabaseUtils.readAllPower());
        tblPower.setItems(powerList);

        exibirMensagem("Dados carregados. Total: " + valourList.size() + " Valour, " + honourList.size() + " Honour, " + powerList.size() + " Power.");
    }

    @FXML
    public void refreshTable(ActionEvent event) {
        loadData();
    }

    /**
     * Preenche os campos do formulário ao clicar em uma linha da tabela.
     */
    @FXML
    public void handleRowSelection(MouseEvent event) {
        if (event.getClickCount() > 0) {
            String activeTab = tabPane.getSelectionModel().getSelectedItem().getText();

            if ("Valour".equals(activeTab)) {
                Valour selectedValour = tblValour.getSelectionModel().getSelectedItem();
                if (selectedValour != null) {
                    txt_valourId.setText(String.valueOf(selectedValour.getId()));
                    txt_emotion.setText(selectedValour.getEmotion());
                    txt_action.setText(selectedValour.getAction());
                    txt_destination.setText(selectedValour.getDestination());
                    lbl_liftSouls.setText("Registro Valour selecionado (ID: " + selectedValour.getId() + ")");
                }
            } else if ("Honour".equals(activeTab)) {
                Honour selectedHonour = tblHonour.getSelectionModel().getSelectedItem();
                if (selectedHonour != null) {
                    txt_honourId.setText(String.valueOf(selectedHonour.getId()));
                    txt_virtude.setText(selectedHonour.getVirtue());
                    txt_expressao.setText(selectedHonour.getExpression());
                    txt_mensagem.setText(selectedHonour.getMessage());
                    lbl_singPraise.setText("Registro Honour selecionado (ID: " + selectedHonour.getId() + ")");
                }
            } else if ("Power".equals(activeTab)) {
                Power selectedPower = tblPower.getSelectionModel().getSelectedItem();
                if (selectedPower != null) {
                    txt_powerId.setText(String.valueOf(selectedPower.getId()));
                    txt_power.setText(selectedPower.getStrength());
                    txt_identity.setText(selectedPower.getIdentity());
                    txt_symbol.setText(selectedPower.getSymbol());
                    lbl_declareLineage.setText("Registro Power selecionado (ID: " + selectedPower.getId() + ")");
                }
            }
        }
    }

    // =================================================================
    // MÉTODOS CRUD - VALOUR
    // =================================================================

    @FXML
    public void valourCreate(ActionEvent actionEvent) {
        try {
            Valour newRecord = new Valour(txt_emotion.getText(), txt_action.getText(), txt_destination.getText());
            Valour savedRecord = MusicDatabaseUtils.createValour(newRecord);

            if (savedRecord != null) {
                lbl_liftSouls.setText(savedRecord.liftSouls());
                txt_valourId.setText(String.valueOf(savedRecord.getId()));
                exibirMensagem("Valour ID " + savedRecord.getId() + " SALVO no BD.");
                logarEvento(savedRecord.getEmotion(), savedRecord.getDestination(), "Valour CREATE (DB)");
                loadData();
            } else {
                exibirMensagem("ERRO ao salvar Valour no BD. Verifique a conexão.");
            }
        } catch (Exception e) { exibirMensagem("Erro CREATE Valour: " + e.getMessage()); }
    }

    @FXML
    public void valourRead(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_valourId.getText());
            Valour foundValour = MusicDatabaseUtils.readValour(id);

            if (foundValour != null) {
                txt_emotion.setText(foundValour.getEmotion());
                txt_action.setText(foundValour.getAction());
                txt_destination.setText(foundValour.getDestination());
                lbl_liftSouls.setText("BD: " + foundValour.liftSouls());
                exibirMensagem("Valour ID " + id + " ENCONTRADO e carregado.");
                logarEvento("Valour", String.valueOf(id), "Valour READ (DB)");
            } else {
                exibirMensagem("Valour ID " + id + " NÃO encontrado.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Valour deve ser um número inteiro."); }
    }

    @FXML
    public void valourUpdate(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_valourId.getText());
            Valour updatedValour = new Valour(id, txt_emotion.getText(), txt_action.getText(), txt_destination.getText());

            if (MusicDatabaseUtils.updateValour(updatedValour)) {
                lbl_liftSouls.setText("BD UPDATED: " + updatedValour.liftSouls());
                exibirMensagem("Valour ID " + id + " ATUALIZADO com sucesso.");
                logarEvento("Valour", String.valueOf(id), "Valour UPDATE (DB)");
                loadData();
            } else {
                exibirMensagem("Erro ao atualizar Valour ID " + id + ". Verifique o ID e a conexão.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Valour deve ser um número inteiro."); }
    }

    @FXML
    public void valourDelete(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_valourId.getText());

            if (MusicDatabaseUtils.deleteValour(id)) {
                exibirMensagem("Valour ID " + id + " EXCLUÍDO com sucesso.");
                txt_valourId.clear();
                txt_emotion.clear();
                txt_action.clear();
                txt_destination.clear();
                lbl_liftSouls.setText("Registro DB excluído.");
                logarEvento("Valour", String.valueOf(id), "Valour DELETE (DB)");
                loadData();
            } else {
                exibirMensagem("Erro ao excluir Valour ID " + id + ". Verifique o ID e a conexão.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Valour deve ser um número inteiro."); }
    }


    // =================================================================
    // MÉTODOS CRUD - HONOUR
    // =================================================================

    @FXML
    public void honourCreate(ActionEvent actionEvent) {
        try {
            Honour newRecord = new Honour(txt_virtude.getText(), txt_expressao.getText(), txt_mensagem.getText());
            Honour savedRecord = MusicDatabaseUtils.createHonour(newRecord);

            if (savedRecord != null) {
                lbl_singPraise.setText(savedRecord.singPraise());
                txt_honourId.setText(String.valueOf(savedRecord.getId()));
                exibirMensagem("Honour ID " + savedRecord.getId() + " SALVO no BD.");
                logarEvento(savedRecord.getVirtue(), savedRecord.getMessage(), "Honour CREATE (DB)");
                loadData();
            } else {
                exibirMensagem("ERRO ao salvar Honour no BD. Verifique a conexão.");
            }
        } catch (Exception e) { exibirMensagem("Erro CREATE Honour: " + e.getMessage()); }
    }

    @FXML
    public void honourRead(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_honourId.getText());
            Honour foundHonour = MusicDatabaseUtils.readHonour(id);

            if (foundHonour != null) {
                txt_virtude.setText(foundHonour.getVirtue());
                txt_expressao.setText(foundHonour.getExpression());
                txt_mensagem.setText(foundHonour.getMessage());
                lbl_singPraise.setText("BD: " + foundHonour.singPraise());
                exibirMensagem("Honour ID " + id + " ENCONTRADO e carregado.");
                logarEvento("Honour", String.valueOf(id), "Honour READ (DB)");
            } else {
                exibirMensagem("Honour ID " + id + " NÃO encontrado.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Honour deve ser um número inteiro."); }
    }

    @FXML
    public void honourUpdate(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_honourId.getText());
            Honour updatedHonour = new Honour(id, txt_virtude.getText(), txt_expressao.getText(), txt_mensagem.getText());

            if (MusicDatabaseUtils.updateHonour(updatedHonour)) {
                lbl_singPraise.setText("BD UPDATED: " + updatedHonour.singPraise());
                exibirMensagem("Honour ID " + id + " ATUALIZADO com sucesso.");
                logarEvento("Honour", String.valueOf(id), "Honour UPDATE (DB)");
                loadData();
            } else {
                exibirMensagem("Erro ao atualizar Honour ID " + id + ". Verifique o ID e a conexão.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Honour deve ser um número inteiro."); }
    }

    @FXML
    public void honourDelete(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_honourId.getText());

            if (MusicDatabaseUtils.deleteHonour(id)) {
                exibirMensagem("Honour ID " + id + " EXCLUÍDO com sucesso.");
                txt_honourId.clear();
                txt_virtude.clear();
                txt_expressao.clear();
                txt_mensagem.clear();
                lbl_singPraise.setText("Registro DB excluído.");
                logarEvento("Honour", String.valueOf(id), "Honour DELETE (DB)");
                loadData();
            } else {
                exibirMensagem("Erro ao excluir Honour ID " + id + ". Verifique o ID e a conexão.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Honour deve ser um número inteiro."); }
    }


    // =================================================================
    // MÉTODOS CRUD - POWER
    // =================================================================

    @FXML
    public void powerCreate(ActionEvent actionEvent) {
        try {
            Power newRecord = new Power(txt_power.getText(), txt_identity.getText(), txt_symbol.getText());
            Power savedRecord = MusicDatabaseUtils.createPower(newRecord);

            if (savedRecord != null) {
                lbl_declareLineage.setText(savedRecord.declareLineage());
                txt_powerId.setText(String.valueOf(savedRecord.getId()));
                exibirMensagem("Power ID " + savedRecord.getId() + " SALVO no BD.");
                logarEvento(savedRecord.getIdentity(), savedRecord.getStrength(), "Power CREATE (DB)");
                loadData();
            } else {
                exibirMensagem("ERRO ao salvar Power no BD. Verifique a conexão.");
            }
        } catch (Exception e) { exibirMensagem("Erro CREATE Power: " + e.getMessage()); }
    }

    @FXML
    public void powerRead(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_powerId.getText());
            Power foundPower = MusicDatabaseUtils.readPower(id);

            if (foundPower != null) {
                txt_power.setText(foundPower.getStrength());
                txt_identity.setText(foundPower.getIdentity());
                txt_symbol.setText(foundPower.getSymbol());
                lbl_declareLineage.setText("BD: " + foundPower.declareLineage());
                exibirMensagem("Power ID " + id + " ENCONTRADO e carregado.");
                logarEvento("Power", String.valueOf(id), "Power READ (DB)");
            } else {
                exibirMensagem("Power ID " + id + " NÃO encontrado.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Power deve ser um número inteiro."); }
    }

    @FXML
    public void powerUpdate(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_powerId.getText());
            Power updatedPower = new Power(id, txt_power.getText(), txt_identity.getText(), txt_symbol.getText());

            if (MusicDatabaseUtils.updatePower(updatedPower)) {
                lbl_declareLineage.setText("BD UPDATED: " + updatedPower.declareLineage());
                exibirMensagem("Power ID " + id + " ATUALIZADO com sucesso.");
                logarEvento("Power", String.valueOf(id), "Power UPDATE (DB)");
                loadData();
            } else {
                exibirMensagem("Erro ao atualizar Power ID " + id + ". Verifique o ID e a conexão.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Power deve ser um número inteiro."); }
    }

    @FXML
    public void powerDelete(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txt_powerId.getText());

            if (MusicDatabaseUtils.deletePower(id)) {
                exibirMensagem("Power ID " + id + " EXCLUÍDO com sucesso.");
                txt_powerId.clear();
                txt_power.clear();
                txt_identity.clear();
                txt_symbol.clear();
                lbl_declareLineage.setText("Registro DB excluído.");
                logarEvento("Power", String.valueOf(id), "Power DELETE (DB)");
                loadData();
            } else {
                exibirMensagem("Erro ao excluir Power ID " + id + ". Verifique o ID e a conexão.");
            }
        } catch (NumberFormatException e) { exibirMensagem("Erro: ID de Power deve ser um número inteiro."); }
    }
}