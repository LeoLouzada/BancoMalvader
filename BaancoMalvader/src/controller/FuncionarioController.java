package controller;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void cadastrarFuncionario(Funcionario funcionario){
        funcionarioDAO.save(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario){
        funcionarioDAO.update(funcionario);
    }

    public void deletarFuncionario(Funcionario funcionario){
        funcionarioDAO.delete(funcionario.getId());
    }

    public void pesquisarFuncionario(Funcionario funcionario){
        //funcionarioDAO.findById(funcionario.getId());
    }
}
