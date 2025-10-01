package com.example.programa.scenes;

import com.example.programa.Doddle.Companies;
import com.example.programa.Doddle.Employee;
import com.example.programa.Doddle.Vanancy;
import com.example.programa.EscreveCSV;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class linkedinTopCompanies {

    private Companies company;
    private Employee employee;
    private Vanancy vacancy;
    private long eventCounter = 0;

    @FXML private TextField txt_companyName;
    @FXML private TextField txt_companyEmploysNumber;
    @FXML private TextField txt_companyMoney;

    @FXML private TextField txt_EmployeeName;
    @FXML private TextField txt_EmployerSalary;
    @FXML private TextField txt_EmployeetenurePerYears;
    @FXML private TextField txt_EmployeeSalaryAdjust;

    @FXML private TextField txt_vanancyPosition;
    @FXML private TextField txt_vanancySalary;
    @FXML private TextField txt_symbol;

    @FXML private Label lbl_companyResult;
    @FXML private Label lbl_employeeResult;
    @FXML private Label lbl_vanancyResult;

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
            lbl_companyResult.setText("ERRO: Falha ao salvar log de evento no CSV.");
        }
    }

    @FXML
    public void initialize() {
        try {
            company = new Companies(
                    txt_companyName.getText(),
                    Integer.parseInt(txt_companyEmploysNumber.getText()),
                    Double.parseDouble(txt_companyMoney.getText())
            );

            employee = new Employee(
                    txt_EmployeeName.getText(),
                    Double.parseDouble(txt_EmployerSalary.getText()),
                    Double.parseDouble(txt_EmployeetenurePerYears.getText())
            );

            vacancy = new Vanancy(
                    txt_vanancyPosition.getText(),
                    Double.parseDouble(txt_vanancySalary.getText()),
                    txt_symbol.getText()
            );

            lbl_companyResult.setText("Sistema de Empresas e Empregados pronto!");

        } catch (NumberFormatException e) {
            lbl_companyResult.setText("ERRO: Certifique-se de que os campos numéricos têm valores válidos na inicialização.");
            logEvent("Inicializacao (Erro)", "App", "0");
        }
    }

    @FXML
    void hire() {
        int numberToHire = 1;

        String status = company.hire(numberToHire);

        lbl_companyResult.setText(status);
        txt_companyEmploysNumber.setText(String.valueOf(company.getEmployeesNumber()));

        logEvent("Contratacao", company.getName(), String.valueOf(company.getEmployeesNumber()));
    }

    @FXML
    void dismiss() {
        int numberToDismiss = 1;

        String status = company.dismiss(numberToDismiss);

        lbl_companyResult.setText(status);
        txt_companyEmploysNumber.setText(String.valueOf(company.getEmployeesNumber()));

        logEvent("Demissao", company.getName(), String.valueOf(company.getEmployeesNumber()));
    }

    @FXML
    void advertiseVacancy() {

        vacancy.setPosition(txt_vanancyPosition.getText());

        try {
            Double salary = Double.parseDouble(txt_vanancySalary.getText());
            vacancy.setSalary(salary);
            vacancy.setRequirements(txt_symbol.getText());

            String result = vacancy.advertiseVacancy();

            lbl_vanancyResult.setText(result.replace("\n", " | "));
            lbl_companyResult.setText(company.advertiseVacancy());

            logEvent("Anunciar Vaga", vacancy.getPosition(), String.format("%.2f", vacancy.getSalary()));

        } catch (NumberFormatException e) {
            lbl_vanancyResult.setText("ERRO: Salário da Vaga (Vanancy Salary) deve ser um número válido.");
            logEvent("Anunciar Vaga (Erro)", "Vaga", "0.00");
        }
    }

    @FXML
    void work() {
        String status = employee.work();

        lbl_employeeResult.setText(status);

        logEvent("Trabalho", employee.getName(), String.format("%.2f", employee.getSalary()));
    }

    @FXML
    void receivePayment() {
        String status = employee.receivePayment();

        lbl_employeeResult.setText(status);

        logEvent("Pagamento", employee.getName(), String.format("%.2f", employee.getSalary()));
    }

    @FXML
    void salaryAdjustment() {
        try {
            Double amount = Double.parseDouble(txt_EmployeeSalaryAdjust.getText());

            String status = employee.salaryAdjustment(amount);

            lbl_employeeResult.setText(status);

            txt_EmployerSalary.setText(String.format("%.2f", employee.getSalary()));

            logEvent("Ajuste Salarial", employee.getName(), String.format("%.2f", employee.getSalary()));

        } catch (NumberFormatException e) {
            lbl_employeeResult.setText("ERRO: Ajuste salarial deve ser um número válido (ex: 500.00).");
            logEvent("Ajuste Salarial (Erro)", employee.getName(), "0.00");
        }
    }

}
