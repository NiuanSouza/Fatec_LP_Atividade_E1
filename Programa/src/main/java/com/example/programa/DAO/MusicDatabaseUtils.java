package com.example.programa.DAO;

import com.example.programa.Classes.MusicClass.Valour;
import com.example.programa.Classes.MusicClass.Honour;
import com.example.programa.Classes.MusicClass.Power;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilitário: Classe principal para consultas CRUD das classes de Música no banco de dados.
 */
public class MusicDatabaseUtils {

    private static final Logger LOGGER = Logger.getLogger(MusicDatabaseUtils.class.getName());

    // =================================================================
    // MAPPING HELPERS
    // =================================================================

    private static Valour mapResultSetToValour(ResultSet rs) throws SQLException {
        return new Valour(
                rs.getInt("id"),
                rs.getString("emotion"),
                rs.getString("action"),
                rs.getString("destination")
        );
    }

    private static Honour mapResultSetToHonour(ResultSet rs) throws SQLException {
        return new Honour(
                rs.getInt("id"),
                rs.getString("virtue"),
                rs.getString("expression"),
                rs.getString("message")
        );
    }

    private static Power mapResultSetToPower(ResultSet rs) throws SQLException {
        return new Power(
                rs.getInt("id"),
                rs.getString("strength"),
                rs.getString("identity"),
                rs.getString("symbol")
        );
    }

    // =================================================================
    // VALOUR - CRUD METHODS
    // =================================================================

    /**
     * Função: Insere um novo registro de Valour no banco de dados. (CREATE)
     * @param valour Objeto Valour a ser inserido.
     * @return O objeto Valour com o ID gerado, ou null em caso de falha.
     */
    public static Valour createValour(Valour valour) {
        String sql = "INSERT INTO Valour (emotion, action, destination) VALUES (?, ?, ?)";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, valour.getEmotion());
            pstmt.setString(2, valour.getAction());
            pstmt.setString(3, valour.getDestination());

            if (pstmt.executeUpdate() > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        valour.setId(generatedKeys.getInt(1));
                        return valour;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (createValour): Falha ao inserir Valour.", e);
        }
        return null;
    }

    /**
     * Função: Retorna todos os registros de Valour. (READ ALL)
     * @return Uma lista de objetos Valour.
     */
    public static List<Valour> readAllValour() {
        List<Valour> list = new ArrayList<>();
        String sql = "SELECT id, emotion, action, destination FROM Valour";
        try (Connection conn = MusicDBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToValour(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (readAllValour): Falha ao buscar todos os Valour.", e);
        }
        return list;
    }

    /**
     * Função: Busca um registro de Valour pelo ID. (READ)
     * @param id ID do registro a ser buscado.
     * @return Objeto Valour encontrado, ou null se não existir.
     */
    public static Valour readValour(int id) {
        String sql = "SELECT id, emotion, action, destination FROM Valour WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToValour(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (readValour): Falha ao buscar Valour pelo ID.", e);
        }
        return null;
    }

    /**
     * Função: Atualiza um registro de Valour existente. (UPDATE)
     * @param valour Objeto Valour com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public static boolean updateValour(Valour valour) {
        String sql = "UPDATE Valour SET emotion = ?, action = ?, destination = ? WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, valour.getEmotion());
            pstmt.setString(2, valour.getAction());
            pstmt.setString(3, valour.getDestination());
            pstmt.setInt(4, valour.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (updateValour): Falha ao atualizar Valour.", e);
            return false;
        }
    }

    /**
     * Função: Exclui um registro de Valour pelo ID. (DELETE)
     * @param id ID do registro a ser excluído.
     * @return true se a exclusão foi bem-sucedida, false caso contrário.
     */
    public static boolean deleteValour(int id) {
        String sql = "DELETE FROM Valour WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (deleteValour): Falha ao deletar Valour.", e);
            return false;
        }
    }

    // =================================================================
    // HONOUR - CRUD METHODS
    // =================================================================

    /**
     * Função: Insere um novo registro de Honour no banco de dados. (CREATE)
     * @param honour Objeto Honour a ser inserido.
     * @return O objeto Honour com o ID gerado, ou null em caso de falha.
     */
    public static Honour createHonour(Honour honour) {
        String sql = "INSERT INTO Honour (virtue, expression, message) VALUES (?, ?, ?)";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, honour.getVirtue());
            pstmt.setString(2, honour.getExpression());
            pstmt.setString(3, honour.getMessage());

            if (pstmt.executeUpdate() > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        honour.setId(generatedKeys.getInt(1));
                        return honour;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (createHonour): Falha ao inserir Honour.", e);
        }
        return null;
    }

    /**
     * Função: Retorna todos os registros de Honour. (READ ALL)
     * @return Uma lista de objetos Honour.
     */
    public static List<Honour> readAllHonour() {
        List<Honour> list = new ArrayList<>();
        String sql = "SELECT id, virtue, expression, message FROM Honour";
        try (Connection conn = MusicDBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToHonour(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (readAllHonour): Falha ao buscar todos os Honour.", e);
        }
        return list;
    }


    /**
     * Função: Busca um registro de Honour pelo ID. (READ)
     * @param id ID do registro a ser buscado.
     * @return Objeto Honour encontrado, ou null se não existir.
     */
    public static Honour readHonour(int id) {
        String sql = "SELECT id, virtue, expression, message FROM Honour WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToHonour(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (readHonour): Falha ao buscar Honour pelo ID.", e);
        }
        return null;
    }

    /**
     * Função: Atualiza um registro de Honour existente. (UPDATE)
     * @param honour Objeto Honour com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public static boolean updateHonour(Honour honour) {
        String sql = "UPDATE Honour SET virtue = ?, expression = ?, message = ? WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, honour.getVirtue());
            pstmt.setString(2, honour.getExpression());
            pstmt.setString(3, honour.getMessage());
            pstmt.setInt(4, honour.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (updateHonour): Falha ao atualizar Honour.", e);
            return false;
        }
    }

    /**
     * Função: Exclui um registro de Honour pelo ID. (DELETE)
     * @param id ID do registro a ser excluído.
     * @return true se a exclusão foi bem-sucedida, false caso contrário.
     */
    public static boolean deleteHonour(int id) {
        String sql = "DELETE FROM Honour WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (deleteHonour): Falha ao deletar Honour.", e);
            return false;
        }
    }

    // =================================================================
    // POWER - CRUD METHODS
    // =================================================================

    /**
     * Função: Insere um novo registro de Power no banco de dados. (CREATE)
     * @param power Objeto Power a ser inserido.
     * @return O objeto Power com o ID gerado, ou null em caso de falha.
     */
    public static Power createPower(Power power) {
        String sql = "INSERT INTO Power (strength, identity, symbol) VALUES (?, ?, ?)";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, power.getStrength());
            pstmt.setString(2, power.getIdentity());
            pstmt.setString(3, power.getSymbol());

            if (pstmt.executeUpdate() > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        power.setId(generatedKeys.getInt(1));
                        return power;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (createPower): Falha ao inserir Power.", e);
        }
        return null;
    }

    /**
     * Função: Retorna todos os registros de Power. (READ ALL)
     * @return Uma lista de objetos Power.
     */
    public static List<Power> readAllPower() {
        List<Power> list = new ArrayList<>();
        String sql = "SELECT id, strength, identity, symbol FROM Power";
        try (Connection conn = MusicDBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToPower(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (readAllPower): Falha ao buscar todos os Power.", e);
        }
        return list;
    }

    /**
     * Função: Busca um registro de Power pelo ID. (READ)
     * @param id ID do registro a ser buscado.
     * @return Objeto Power encontrado, ou null se não existir.
     */
    public static Power readPower(int id) {
        String sql = "SELECT id, strength, identity, symbol FROM Power WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPower(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (readPower): Falha ao buscar Power pelo ID.", e);
        }
        return null;
    }

    /**
     * Função: Atualiza um registro de Power existente. (UPDATE)
     * @param power Objeto Power com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public static boolean updatePower(Power power) {
        String sql = "UPDATE Power SET strength = ?, identity = ?, symbol = ? WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, power.getStrength());
            pstmt.setString(2, power.getIdentity());
            pstmt.setString(3, power.getSymbol());
            pstmt.setInt(4, power.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (updatePower): Falha ao atualizar Power.", e);
            return false;
        }
    }

    /**
     * Função: Exclui um registro de Power pelo ID. (DELETE)
     * @param id ID do registro a ser excluído.
     * @return true se a exclusão foi bem-sucedida, false caso contrário.
     */
    public static boolean deletePower(int id) {
        String sql = "DELETE FROM Power WHERE id = ?";
        try (Connection conn = MusicDBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DB FALHA (deletePower): Falha ao deletar Power.", e);
            return false;
        }
    }
}