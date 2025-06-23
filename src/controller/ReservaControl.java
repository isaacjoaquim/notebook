/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ReservaDAO;
import model.Aluno;
import model.Funcionario;
import model.Materiais;
import model.reservas;

import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author gelad
 */
public class ReservaControl {
    
    private ReservaDAO reservaDAO;

    public ReservaControl() {
        this.reservaDAO = new ReservaDAO();
    }

    public void salvar(Funcionario funcionario, Aluno aluno, Materiais material,
                       int quantidade, LocalDate dataDevolucao) {
        reservas reserva = new reservas();
        reserva.setFuncionario(funcionario);
        reserva.setAluno(aluno);
        reserva.setMaterial(material);
        reserva.setQuantidadeReservada(quantidade);
        reserva.setDataDevolucao(dataDevolucao);

        reservaDAO.salvar(reserva);
    }

    public List<reservas> listarTodos() {
        return reservaDAO.obterTodos();
    }
}
