package view;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import javax.swing.*;

public class MenuFuncionarioView extends JFrame {

    private JButton btnAberturaConta, btnEncerramentoConta, btnConsultaDados, btnAlteracaoDados;
    private JButton btnCadastroFuncionario, btnGerarRelatorios, btnSair;

    public MenuFuncionarioView() {
        setTitle("Menu Funcionário");
        setSize(400, 300);
        setLayout(null);

        btnAberturaConta = new JButton("Abertura de Conta");
        btnAberturaConta.addActionListener(e -> {
            ComboBoxModel<Object> tipoContaComoBox = null;
            String tipoConta = (String) tipoContaComoBox.getSelectedItem();
            String nome = nomeTextField.getText();
            String cpf = cpfTextField.getText();

            Cliente cliente = new Cliente(nome, cpf);
            Conta novaConta = tipoConta.equals("Corrente") ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);

            bancoController.abrirConta(novaConta);
            bancoController.salvarDados();
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
        });

        btnEncerramentoConta = new JButton("Encerramento de Conta");
        btnConsultaDados = new JButton("Consulta de Dados");
        btnAlteracaoDados = new JButton("Alteração de Dados");
        btnCadastroFuncionario = new JButton("Cadastro de Funcionário");
        btnGerarRelatorios = new JButton("Geração de Relatórios");
        btnSair = new JButton("Sair");

        btnAberturaConta.setBounds(50, 30, 300, 25);
        btnEncerramentoConta.setBounds(50, 60, 300, 25);
        btnConsultaDados.setBounds(50, 90, 300, 25);
        btnAlteracaoDados.setBounds(50, 120, 300, 25);
        btnCadastroFuncionario.setBounds(50, 150, 300, 25);
        btnGerarRelatorios.setBounds(50, 180, 300, 25);
        btnSair.setBounds(50, 210, 300, 25);

        add(btnAberturaConta);
        add(btnEncerramentoConta);
        add(btnConsultaDados);
        add(btnAlteracaoDados);
        add(btnCadastroFuncionario);
        add(btnGerarRelatorios);
        add(btnSair);

        btnSair.addActionListener(e -> dispose());
    }
}
