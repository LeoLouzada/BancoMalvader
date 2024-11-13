package view;

import javax.swing.*;
import java.awt.*;
import controller.LoginController;

public class LoginView extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton btnFuncionario, btnCliente;
    private LoginController loginController;

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        usuarioField = new JTextField();
        senhaField = new JPasswordField();
        btnFuncionario = new JButton("Funcionário");
        btnCliente = new JButton("Cliente");

        loginController = new LoginController(this);

        add(new JLabel("Usuário:"));
        add(usuarioField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(btnFuncionario);
        add(btnCliente);

        btnFuncionario.addActionListener(e -> loginController.autenticar("funcionario"));
        btnCliente.addActionListener(e -> loginController.autenticar("cliente"));

        setLocationRelativeTo(null);
    }

    public String getUsuario() {
        return usuarioField.getText();
    }

    public String getSenha() {
        return new String(senhaField.getPassword());
    }
}
