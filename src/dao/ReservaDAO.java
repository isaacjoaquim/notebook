/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.reservas;
import conexao.Conectar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gelad
 */
public class ReservaDAO {
      public void salvar(reservas reserva) {
        String sql = "INSERT INTO reservas (user_id, user_tipo, material_id, quantidade, data_devolucao) VALUES (?,?,?,?,?)";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Verifica se é funcionário ou aluno
            if (reserva.getFuncionario() != null) {
                stmt.setInt(1, reserva.getFuncionario().getIdFun());
                stmt.setString(2, "F");
            } else if (reserva.getAluno() != null) {
                stmt.setInt(1, reserva.getAluno().getIdAlu());
                stmt.setString(2, "A");
            } else {
                throw new IllegalArgumentException("Reserva sem usuário definido.");
            }

            stmt.setInt(3, reserva.getMaterial().getId());
            stmt.setInt(4, reserva.getQuantidadeReservada());
            stmt.setDate(5, Date.valueOf(reserva.getDataDevolucao()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<reservas> obterTodos() {
        List<reservas> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";

        try (Connection conn = Conectar.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reservas reserva = new reservas();
                reserva.setIdReserva(rs.getInt("id"));
                // Aqui, poderia verificar user_tipo para carregar Funcionario ou Aluno
                // Ex:
                // if ("F".equals(rs.getString("user_tipo"))) {
                //     Funcionario f = new Funcionario();
                //     f.setId(rs.getInt("user_id"));
                //     reserva.setFuncionario(f);
                // } else {
                //     Aluno a = new Aluno();
                //     a.setId(rs.getInt("user_id"));
                //     reserva.setAluno(a);
                // }

                // Carrega o Material (Ex.: poderia usar MaterialDAO para buscar por id)

                reserva.setQuantidadeReservada(rs.getInt("quantidade"));
                reserva.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());

                reservas.add(reserva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }
}
