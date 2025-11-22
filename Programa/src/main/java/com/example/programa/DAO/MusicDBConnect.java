package com.example.programa.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MusicDBConnect {

    private static final Logger LOGGER = Logger.getLogger(MusicDBConnect.class.getName());

    // --- CONFIGURE SEUS DADOS AQUI ---
    private static final String DATABASE_NAME = "TGControl";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    // --- FIM DA CONFIGURAÇÃO ---


    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME +
            "?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Erro: Driver JDBC do MySQL não encontrado.", e);
            throw new SQLException("Driver não encontrado", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Cria as tabelas do projeto (Valour, Honour, Power) se elas não existirem.
     */
    public static void createTables() {
        String createValourTable = "CREATE TABLE IF NOT EXISTS Valour (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "emotion VARCHAR(255) NOT NULL," +
                "action VARCHAR(255) NOT NULL," +
                "destination VARCHAR(255) NOT NULL)";

        String createHonourTable = "CREATE TABLE IF NOT EXISTS Honour (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "virtue VARCHAR(255) NOT NULL," +
                "expression VARCHAR(255) NOT NULL," +
                "message VARCHAR(255) NOT NULL)";

        String createPowerTable = "CREATE TABLE IF NOT EXISTS Power (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "strength VARCHAR(255) NOT NULL," +
                "identity VARCHAR(255) NOT NULL," +
                "symbol VARCHAR(255) NOT NULL)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createValourTable);
            stmt.execute(createHonourTable);
            stmt.execute(createPowerTable);
            LOGGER.log(Level.INFO, "Tabelas de Música verificadas/criadas com sucesso no DB!");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao criar tabelas no MySQL.", e);
        }
    }
}