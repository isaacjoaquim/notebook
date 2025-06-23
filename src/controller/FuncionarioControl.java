/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.FuncionarioDAO;
import model.Funcionario;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioControl {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioControl() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public void salvar(String nome, String sobrenome, String cpf, String rg, String sexo,
                      LocalDate dataNascimento, String email, String telefone1, String telefone2) {
        Funcionario f = new Funcionario();
        f.setNomeFun(nome);
        f.setSobrenomeFun(sobrenome);
        f.setCpfFun(cpf);
        f.setRgFun(rg);
        f.setSexoFun(sexo);
        f.setDataNascFun(dataNascimento);
        f.setEmailFun(email);
        f.setTelefone1Fun(telefone1);
        f.setTelefone2Fun(telefone2);

        funcionarioDAO.salvar(f);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioDAO.obterTodos();
    }
}
