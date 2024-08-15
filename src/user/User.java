package user;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import conta.contaCorrente.ContaCorrente;
import conta.contaPoupanca.ContaPoupanca;

public class User {
    
    private String nome;
    private String login;
    private String senha;

    // Banco de contas
    private Map<String, ContaCorrente> contasCorrentes = new HashMap<>();
    private Map<String, ContaPoupanca> contasPoupancas = new HashMap<>();

    // Método para criar número da conta corrente
    private static String criarNumeroContaCorrente() {
        int primeirosDigitos = ThreadLocalRandom.current().nextInt(1000, 10000);
        return primeirosDigitos + "-01";
    }

    // Método para criar número da conta poupança
    private static String criarNumeroContaPoupanca() {
        int primeirosDigitos = ThreadLocalRandom.current().nextInt(1000, 10000);
        return primeirosDigitos + "-13";
    }

    // Método construtor
    public User(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Map<String, ContaCorrente> getContasCorrentes() {
        return contasCorrentes;
    }

    public Map<String, ContaPoupanca> getContasPoupancas() {
        return contasPoupancas;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método que cria contas correntes
    public void criarContaCorrente() {

        String numeroConta = criarNumeroContaCorrente();

        ContaCorrente contaCorrente = new ContaCorrente(numeroConta);

        contasCorrentes.put(numeroConta, contaCorrente);

        System.out.println("Conta corrente " + "N° " + numeroConta + " criada com sucesso");
    }

    public void criarContaPoupanca() {

        String numeroConta = criarNumeroContaPoupanca();

        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta);
        contasPoupancas.put(numeroConta, contaPoupanca);
        System.out.println("Conta poupança " + "N° " + numeroConta + " criada com sucesso");
    }
}
