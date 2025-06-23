package controller;
import dao.AlunoDAO;
import model.Aluno;

import java.time.LocalDate;
import java.util.List;

public class AlunoControl {
    private AlunoDAO alunoDAO;

    public AlunoControl() {
        this.alunoDAO = new AlunoDAO();
    }

    public void salvar(String matricula, String nome, String sobrenome, String cpf, String rg,
                       String sexo, String dataNascimento, String email, String telefone1, String telefone2) {
        
        Aluno a = new Aluno(nome,sobrenome, cpf, rg, sexo, dataNascimento, email, telefone1, telefone2, matricula);
        alunoDAO.salvar(a);
        
    }

    public List<Aluno> listarTodos() {
        return alunoDAO.obterTodos();
    }
}
