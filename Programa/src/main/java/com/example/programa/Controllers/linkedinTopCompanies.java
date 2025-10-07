package com.example.programa.Controllers;

import com.example.programa.Classes.Doddle.Companies;
import com.example.programa.Classes.Doddle.Employee;
import com.example.programa.Classes.Doddle.Vanancy;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class linkedinTopCompanies extends controllerBase {

    private Companies company;
    private Employee employee;
    private Vanancy vacancy;

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

    @Override
    public String getLogFilePath() {
        return "saida/log_linkedin_companies.csv";
    }

    @Override
    public String[] getLogHeaders() {
        return new String[]{"Entidade", "Valor", "Ação"};
    }

    @Override
    protected void inicializarController() {
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
            lbl_companyResult.setText("ERRO: Certifique-se de que os campos numéricos são válidos.");
            logarEvento("App", "0", "Inicializacao (Erro)");
        }
    }

    @FXML
    void hire() {
        String status = company.hire(1);
        lbl_companyResult.setText(status);
        txt_companyEmploysNumber.setText(String.valueOf(company.getEmployeesNumber()));
        logarEvento(company.getName(), String.valueOf(company.getEmployeesNumber()), "Contratacao");
    }

    @FXML
    void dismiss() {
        String status = company.dismiss(1);
        lbl_companyResult.setText(status);
        txt_companyEmploysNumber.setText(String.valueOf(company.getEmployeesNumber()));
        logarEvento(company.getName(), String.valueOf(company.getEmployeesNumber()), "Demissao");
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
            logarEvento(vacancy.getPosition(), String.format("%.2f", vacancy.getSalary()), "Anunciar Vaga");
        } catch (NumberFormatException e) {
            lbl_vanancyResult.setText("ERRO: Salário da Vaga deve ser um número válido.");
            logarEvento("Vaga", "0.00", "Anunciar Vaga (Erro)");
        }
    }

    @FXML
    void work() {
        String status = employee.work();
        lbl_employeeResult.setText(status);
        logarEvento(employee.getName(), String.format("%.2f", employee.getSalary()), "Trabalho");
    }

    @FXML
    void receivePayment() {
        String status = employee.receivePayment();
        lbl_employeeResult.setText(status);
        logarEvento(employee.getName(), String.format("%.2f", employee.getSalary()), "Pagamento");
    }

    @FXML
    void salaryAdjustment() {
        try {
            Double amount = Double.parseDouble(txt_EmployeeSalaryAdjust.getText());
            String status = employee.salaryAdjustment(amount);
            lbl_employeeResult.setText(status);
            txt_EmployerSalary.setText(String.format("%.2f", employee.getSalary()));
            logarEvento(employee.getName(), String.format("%.2f", employee.getSalary()), "Ajuste Salarial");
        } catch (NumberFormatException e) {
            lbl_employeeResult.setText("ERRO: Ajuste salarial deve ser um número válido.");
            logarEvento(employee.getName(), "0.00", "Ajuste Salarial (Erro)");
        }
    }
}