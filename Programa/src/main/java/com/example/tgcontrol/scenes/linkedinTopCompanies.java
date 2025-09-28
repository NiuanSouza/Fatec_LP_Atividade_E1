package com.example.tgcontrol.scenes;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.example.tgcontrol.Doddle.*;

public class linkedinTopCompanies {

    private Companies company;
    private Employee employee;
    private Vanancy vacancy;

    @FXML private TextField txt_companyName;
    @FXML private TextField txt_companyEmploysNumber;
    @FXML private TextField txt_companyMoney;

    @FXML private TextField txt_EmployeeName;
    @FXML private TextField txt_EmployerSalary; // Salário atual do empregado
    @FXML private TextField txt_EmployeetenurePerYears;
    @FXML private TextField txt_EmployeeSalaryAdjust; // Valor do ajuste salarial

    @FXML private TextField txt_vanancyPosition;
    @FXML private TextField txt_vanancySalary;
    @FXML private TextField txt_symbol; // Requisitos da vaga

    @FXML private Label lbl_companyResult;
    @FXML private Label lbl_employeeResult;
    @FXML private Label lbl_vanancyResult;

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
        }
    }

    @FXML
    void hire() {
        int numberToHire = 1;

        String status = company.hire(numberToHire);

        lbl_companyResult.setText(status);
        txt_companyEmploysNumber.setText(String.valueOf(company.getEmployeesNumber()));
    }

    @FXML
    void dismiss() {
        int numberToDismiss = 1;

        String status = company.dismiss(numberToDismiss);

        lbl_companyResult.setText(status);
        txt_companyEmploysNumber.setText(String.valueOf(company.getEmployeesNumber()));
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

        } catch (NumberFormatException e) {
            lbl_vanancyResult.setText("ERRO: Salário da Vaga (Vanancy Salary) deve ser um número válido.");
        }
    }

    @FXML
    void work() {
        String status = employee.work();

        lbl_employeeResult.setText(status);
    }

    @FXML
    void receivePayment() {
        String status = employee.receivePayment();

        lbl_employeeResult.setText(status);
    }

    @FXML
    void salaryAdjustment() {
        try {
            Double amount = Double.parseDouble(txt_EmployeeSalaryAdjust.getText());

            String status = employee.salaryAdjustment(amount);

            lbl_employeeResult.setText(status);

            txt_EmployerSalary.setText(String.format("%.2f", employee.getSalary()));

        } catch (NumberFormatException e) {
            lbl_employeeResult.setText("ERRO: Ajuste salarial deve ser um número válido (ex: 500.00).");
        }
    }
}