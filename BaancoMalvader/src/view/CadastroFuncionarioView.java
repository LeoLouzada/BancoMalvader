package view;

import javax.swing.*;
import java.awt.*;

public class CadastroFuncionarioView extends JFrame {
    private JTextField nomeField, cpfField, telefoneField, enderecoField;
    private JPasswordField senhaField;
    private JButton btnSalvar, btnCancelar;

    public CadastroFuncionarioView() {
        setTitle("Cadastro Funcionário");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        nomeField = new JTextField();
        cpfField = new JTextField();
        telefoneField = new JTextField();
        enderecoField = new JTextField();
        senhaField = new JPasswordField();

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("CPF:"));
        add(cpfField);
        add(new JLabel("Telefone:"));
        add(telefoneField);
        add(new JLabel("Endereço:"));
        add(enderecoField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(btnSalvar);
        add(btnCancelar);

        setLocationRelativeTo(null);
    }
}
