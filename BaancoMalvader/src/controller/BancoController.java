package controller;

import model.Cliente;
import model.Conta;
import model.Funcionario;
import util.DataManager;

import java.util.ArrayList;
import java.util.List;

public class BancoController {

    private List<Conta> contas;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;

    public BancoController() {
        contas = new ArrayList<>();
        funcionarios = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void abrirConta(Conta conta){
        if (conta != null && !contas.contains(conta)) {
            contas.add(conta);
            System.out.println("Conta aberta com sucesso!");
        } else {
            System.out.println("Erro ao abrir a conta. Conta já existe ou é inválida.");
        }
    }

    public void encerrarConta(int numeroConta){
        Conta conta = consultarConta(numeroConta);
        if (conta != null) {
            contas.remove(conta);
            System.out.println("Conta encerrada com sucesso!");
        } else {
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    public Conta consultarConta(int numeroConta){
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        System.out.println("Conta com o número " + numeroConta + " não encontrada.");
        return null;
    }

    public void salvarDados(){
        DataManager.salvarContas(contas, "contas.dat");
    }

    public void carregarDados(){
        DataManager.carregarContas("contas.dat");
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
