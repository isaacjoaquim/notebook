package controller;
import dao.AlunoDAO;
import model.Aluno;


import java.util.List;

public class AlunoControl {
    private AlunoDAO alunoDAO;

    public AlunoControl() {
        this.alunoDAO = new AlunoDAO();
    }

    public void salvar(String nome, String sobrenome, String cpf, String rg,
                       String sexo, String cargo, String dataNascimento, String email, String telefone1, String telefone2) {
        this.alunoDAO = new AlunoDAO();
        
        Aluno a = new Aluno(nome,sobrenome, cpf, rg, sexo, cargo, dataNascimento, email, telefone1, telefone2);
        alunoDAO.salvar(a);
        
    }
    
    public List<Aluno> listarTodos() {
        return alunoDAO.obterTodos();
    }
}
