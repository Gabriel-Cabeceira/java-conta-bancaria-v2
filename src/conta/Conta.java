package conta;

import java.util.HashMap;
import java.util.Map;

public abstract class Conta {
    
    protected double saldo = 0.0;
    protected String numeroConta;

    private static Map<String, Conta> bancoDeContas = new HashMap<>();

    public Conta(String numeroConta) {
        this.numeroConta = numeroConta;
        bancoDeContas.put(numeroConta, this);
    }

    // Método abstrato
    public void depositar(double valor){}

    // Método concreto
    public void sacar(double valor){
        if(this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso");
            this.getSaldo();
        } else {
            System.out.println("Saldo insuficiente, tente outro valor");
            this.getSaldo();
        }
    }

    // Método concreto para receber transferência
    public void receberTransferencia(double valor) {
        this.saldo += valor;
    }

    // Método concreto Para transferir
    public void transferir(String numeroContaDestino, double valor) {
        
        Conta contaDestino = bancoDeContas.get(numeroContaDestino);
    
        if (contaDestino == null) {
            System.out.println("Conta destino não encontrada.");
            return;
        }
    
        if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.receberTransferencia(valor);
            System.out.println("Transferência realizada com sucesso");
        } else {
            System.out.println("Saldo insuficiente, tente outro valor");
        }
    }
    

    public void getSaldo() {

        String saldoFormatado = String.format("%.2f", this.saldo);

        System.out.println("Seu saldo é de R$" + saldoFormatado);
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }
}
