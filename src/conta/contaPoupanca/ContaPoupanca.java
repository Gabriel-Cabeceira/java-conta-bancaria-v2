package conta.contaPoupanca;

import conta.Conta;

public class ContaPoupanca extends Conta {

    
    public ContaPoupanca(String numeroConta) {
        super(numeroConta);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }
}
