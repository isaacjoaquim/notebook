/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Aluno;
import conexao.Conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public void salvar(Aluno a) {
        String sql = "INSERT INTO alunos (matricula, nome, sobrenome, cpf, rg, sexo, data_nascimento, email, telefone1, telefone2) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getMatricula());
            stmt.setString(2, a.getNomeAlu());
            stmt.setString(3, a.getSobrenomeAlu());
            stmt.setString(4, a.getCpfAlu());
            stmt.setString(5, a.getRgAlu());
            stmt.setString(6, a.getSexoAlu());
            stmt.setDate(7, Date.valueOf(a.getDataNascAlu()));
            stmt.setString(8, a.getEmailAlu());
            stmt.setString(9, a.getTelefone1Alu());
            stmt.setString(10, a.getTelefone2Alu());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno(a.getNomeAlu(), a.getSobrenomeAlu(), a.getCpfAlu(), a.getRgAlu(), a.getSexoAlu(), a.getDataNascAlu(), a.getEmailAlu(), a.getTelefone1Alu(), a.getTelefone2Alu(), a.getMatricula());
                a.setIdAlu(rs.getInt("id"));
                a.setMatricula(rs.getString("matricula"));
                a.setNomeAlu(rs.getString("nome"));
                a.setSobrenomeAlu(rs.getString("sobrenome"));
                a.setCpfAlu(rs.getString("cpf"));
                a.setRgAlu(rs.getString("rg"));
                a.setSexoAlu(rs.getString("sexo"));
                a.setDataNascAlu(rs.getString("data_nascimento"));
                a.setEmailAlu(rs.getString("email"));
                a.setTelefone1Alu(rs.getString("telefone1"));
                a.setTelefone2Alu(rs.getString("telefone2"));

                alunos.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }
}
