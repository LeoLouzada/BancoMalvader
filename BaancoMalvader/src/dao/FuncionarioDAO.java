package dao;

import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {

    public void save(Funcionario funcionario){
        String sql = "INSERT INTO funcionario (id, nome, cpf, dataNascimento, telefone, endereco, codigoFuncionario, " +
                "cargo, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);{
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, String.valueOf(funcionario.getDataNascimento()));
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEndereco().toString());
            stmt.setString(7, funcionario.getCodigoFuncionario());
            stmt.setString(8, funcionario.getCargo());
            stmt.setString(9, funcionario.getSenha());
            stmt.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, endereco = ?, " +
                "codigoFuncionario = ?, cargo = ?, senha = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, String.valueOf(funcionario.getDataNascimento()));
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getEndereco().toString());
            stmt.setString(6, funcionario.getCodigoFuncionario());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getSenha());
            stmt.setInt(9, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public Funcionario findById(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCodigoFuncionario(rs.getString("codigoFuncionario"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSenha(rs.getString("senha"));
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
