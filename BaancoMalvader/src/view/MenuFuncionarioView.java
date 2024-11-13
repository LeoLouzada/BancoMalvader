package view;

import javax.swing.*;
import java.awt.*;

public class MenuFuncionarioView extends JFrame {
    private JButton btnCadastrarFuncionario, btnCadastrarCliente, btnCadastrarConta, btnConsultarConta;

    public MenuFuncionarioView() {
        setTitle("Menu Funcionário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarConta = new JButton("Cadastrar Conta");
        btnConsultarConta = new JButton("Consultar Conta");

        add(btnCadastrarFuncionario);
        add(btnCadastrarCliente);
        add(btnCadastrarConta);
        add(btnConsultarConta);

        setLocationRelativeTo(null);
    }
}
