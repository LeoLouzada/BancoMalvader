package controller;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrarFuncionario(Cliente cliente){
        clienteDAO.save(cliente);
    }

    public void atualizarFuncionario(Cliente cliente){
        clienteDAO.update(cliente);
    }

    public void deletarFuncionario(Cliente cliente){
        clienteDAO.delete(cliente.getId());
    }

    public void pesquisarFuncionario(Cliente cliente){
        clienteDAO.findById(cliente.getId());
    }
}
