
package dao;

import model.Aluno;
import conexao.Conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO {
    public void salvar(Aluno a) {
        String sql = "INSERT INTO usuarios (nome, sobrenome, aniversário, cpf, rg, sexo, cargo, email, celular1, celular2) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNomeAlu());
            stmt.setString(2, a.getSobrenomeAlu());
            stmt.setString(3, a.getDataNascAlu());
            stmt.setString(4, a.getCpfAlu());
            stmt.setString(5, a.getRgAlu());
            stmt.setString(6, a.getSexoAlu());
            stmt.setString(7, a.getCargo());
            stmt.setString(8, a.getEmailAlu());
            stmt.setString(9, a.getTelefone1Alu());
            stmt.setString(10, a.getTelefone2Alu());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean atualiza(Aluno a){
        String sql = "UPDATE alunos SET matricula=?, nome=?, sobrenome=?, cpf=?, rg=? WHERE id=?";
    try (Connection conn = Conectar.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(2, a.getNomeAlu());
        stmt.setString(3, a.getSobrenomeAlu());
        stmt.setString(4, a.getCpfAlu());
        stmt.setString(5, a.getRgAlu());
        stmt.setInt(6, a.getIdAlu());

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno a;
                a = new Aluno(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        rs.getString("sexo"),
                        rs.getString("cargo"),
                        rs.getString("data_nascimento"),
                        rs.getString("email"),
                        rs.getString("telefone1"),
                        rs.getString("telefone2")
                );
                a.setIdAlu(rs.getInt("id"));
                alunos.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }
    
}
