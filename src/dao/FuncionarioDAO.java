/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Funcionario;
import conexao.Conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void salvar(Funcionario f) {
        String sql = "INSERT INTO funcionarios (nome, sobrenome, cpf, rg, sexo, data_nascimento, email, telefone1, telefone2) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNomeFun());
            stmt.setString(2, f.getSobrenomeFun());
            stmt.setString(3, f.getCpfFun());
            stmt.setString(4, f.getRgFun());
            stmt.setString(5, f.getSexoFun());
            stmt.setDate(6, Date.valueOf(f.getDataNascFun()));
            stmt.setString(7, f.getEmailFun());
            stmt.setString(8, f.getTelefone1Fun());
            stmt.setString(9, f.getTelefone2Fun());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> obterTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFun(rs.getInt("id"));
                f.setNomeFun(rs.getString("nome"));
                f.setSobrenomeFun(rs.getString("sobrenome"));
                f.setCpfFun(rs.getString("cpf"));
                f.setRgFun(rs.getString("rg"));
                f.setSexoFun(rs.getString("sexo"));
                f.setDataNascFun(rs.getDate("data_nascimento").toLocalDate());
                f.setEmailFun(rs.getString("email"));
                f.setTelefone1Fun(rs.getString("telefone1"));
                f.setTelefone2Fun(rs.getString("telefone2"));
                funcionarios.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}
