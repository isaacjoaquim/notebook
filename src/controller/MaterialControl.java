/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.MaterialDAO;
import model.Materiais;

import java.util.List;

public class MaterialControl {
    
    private MaterialDAO materialDAO;

    public MaterialControl() {
        this.materialDAO = new MaterialDAO();
    }

    public List<Materiais> listarTodos() {
        return materialDAO.obterTodos();
    }

    public void salvar(String nome, int quantidade) {
        Materiais m = new Materiais();
        m.setNomeMat(nome);
        m.setQuantidade(quantidade);
        materialDAO.salvar(m);
    }
}
