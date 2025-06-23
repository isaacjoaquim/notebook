/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Materiais;
import conexao.Conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gelad
 */
public class MaterialDAO {
     public List<Materiais> obterTodos() {
        List<Materiais> materiais = new ArrayList<>();
        String sql = "SELECT * FROM materiais";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Materiais m = new Materiais();
                m.setId(rs.getInt("id"));
                m.setNomeMat(rs.getString("nome"));
                m.setQuantidade(rs.getInt("quantidade"));
                materiais.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiais;
    }

    public void salvar(Materiais m) {
        String sql = "INSERT INTO materiais (nome, quantidade) VALUES (?,?)";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getNomeMat());
            stmt.setInt(2, m.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
