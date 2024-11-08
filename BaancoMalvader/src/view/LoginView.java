package view;

import controller.BancoController;

import javax.swing.*;

public class LoginView extends JFrame {

    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton btnFuncionario;
    private JButton btnCliente;

    public LoginView() {
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        usuarioField = new JTextField();
        senhaField = new JPasswordField();
        btnFuncionario = new JButton("Acesso Funcionário");
        btnCliente = new JButton("Acesso Cliente");

        usuarioField.setBounds(80, 30, 150, 20);
        senhaField.setBounds(80, 60, 150, 20);
        btnFuncionario.setBounds(50, 100, 180, 25);
        btnCliente.setBounds(50, 130, 180, 25);

        add(new JLabel("Usuário:")).setBounds(20, 30, 50, 20);
        add(usuarioField);
        add(new JLabel("Senha:")).setBounds(20, 60, 50, 20);
        add(senhaField);
        add(btnFuncionario);
        add(btnCliente);

        btnFuncionario.addActionListener(e -> autenticar("funcionario"));
        btnCliente.addActionListener(e -> autenticar("cliente"));
    }

    public LoginView(BancoController bancoController) {
    }

    private void autenticar(String tipoUsuario) {
        // Lógica de autenticação
        if (tipoUsuario.equals("funcionario")) {
            new MenuPrincipalView(tipoUsuario).setVisible(true);
        } else {
            new MenuPrincipalView(tipoUsuario).setVisible(true);
        }
        dispose(); // Fecha a tela de login
    }
}
