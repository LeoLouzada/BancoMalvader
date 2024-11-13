package controller;

import view.LoginView;
import model.Funcionario;
import model.Cliente;
import dao.FuncionarioDAO;
import dao.ClienteDAO;

import javax.swing.*;

public class LoginController {

    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    public void autenticar(String tipoUsuario) {
        String usuario = loginView.getUsuario();
        String senha = loginView.getSenha();

        if ("funcionario".equals(tipoUsuario)) {
            Funcionario funcionario = FuncionarioDAO.buscarPorUsuario(usuario);
            if (funcionario != null && funcionario.getSenha().equals(senha)) {
                // Redirecionar para o Menu Principal do Funcionário
                // Exemplo de redirecionamento
                System.out.println("Autenticação de Funcionário bem-sucedida.");
                // Ação para abrir o menu do funcionário ou redirecionar
            } else {
                JOptionPane.showMessageDialog(loginView, "Usuário ou senha inválidos para Funcionário.");
            }
        } else if ("cliente".equals(tipoUsuario)) {
            Cliente cliente = ClienteDAO.buscarPorUsuario(usuario);
            if (cliente != null && cliente.getSenha().equals(senha)) {
                // Redirecionar para o Menu Principal do Cliente
                // Exemplo de redirecionamento
                System.out.println("Autenticação de Cliente bem-sucedida.");
                // Ação para abrir o menu do cliente ou redirecionar
            } else {
                JOptionPane.showMessageDialog(loginView, "Usuário ou senha inválidos para Cliente.");
            }
        }
    }
}
