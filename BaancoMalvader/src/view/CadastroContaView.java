package view;

import javax.swing.*;
import java.awt.*;

public class CadastroContaView extends JFrame {
    private JTextField numeroField, agenciaField, saldoField;
    private JButton btnSalvar, btnCancelar;

    public CadastroContaView() {
        setTitle("Cadastro Conta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        numeroField = new JTextField();
        agenciaField = new JTextField();
        saldoField = new JTextField();

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        add(new JLabel("Número:"));
        add(numeroField);
        add(new JLabel("Agência:"));
        add(agenciaField);
        add(new JLabel("Saldo:"));
        add(saldoField);
        add(btnSalvar);
        add(btnCancelar);

        setLocationRelativeTo(null);
    }
}
