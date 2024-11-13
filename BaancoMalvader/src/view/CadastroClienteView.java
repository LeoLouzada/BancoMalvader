package view;

import javax.swing.*;
import java.awt.*;

public class CadastroClienteView extends JFrame {
    private JTextField nomeField, cpfField, telefoneField, enderecoField;
    private JButton btnSalvar, btnCancelar;

    public CadastroClienteView() {
        setTitle("Cadastro Cliente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        nomeField = new JTextField();
        cpfField = new JTextField();
        telefoneField = new JTextField();
        enderecoField = new JTextField();

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
        add(btnSalvar);
        add(btnCancelar);

        setLocationRelativeTo(null);
    }
}
