package controller;

import dao.ContaDAO;
import model.Conta;

public class ContaController {

    private ContaDAO contaDAO = new ContaDAO();

    public void cadastrarConta(Conta conta){
        contaDAO.save(conta);
    }

    public void atualizarConta(Conta conta){
        contaDAO.update(conta);
    }

    public void deletarConta(Conta conta){
        contaDAO.delete(conta.getNumero());
    }

    public void pesquisarConta(Conta conta){
        //contaDAO.findById(conta.getNumero());
    }
}
