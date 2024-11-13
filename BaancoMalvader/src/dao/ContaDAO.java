package dao;

import model.Cliente;
import model.Conta;
import java.sql.*;

public class ContaDAO {

    public void save(Conta conta) {
        String sql = "INSERT INTO conta (numero, agencia, saldo, cliente_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta.getNumero());
            stmt.setString(2, conta.getAgencia());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setInt(4, conta.getCliente().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Conta conta) {
        String sql = "UPDATE conta SET agencia = ?, saldo = ?, cliente_id = ? WHERE numero = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta.getNumero());
            stmt.setString(2, conta.getAgencia());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setInt(4, conta.getCliente().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int numero) {
        String sql = "DELETE FROM conta WHERE numero = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*&public Conta findById(int numero) {
        String sql = "SELECT * FROM conta WHERE numero = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Conta conta = new Conta() {};
                    conta.setNumero(rs.getInt("numero"));
                    conta.setAgencia(rs.getString("agencia"));
                    conta.setSaldo(rs.getDouble("saldo"));

                    ClienteDAO clienteDAO = new ClienteDAO();
                    Cliente cliente = clienteDAO.findById(rs.getInt("cliente_id"));
                    conta.setCliente(cliente);

                    return conta;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
