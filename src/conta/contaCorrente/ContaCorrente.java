package conta.contaCorrente;

import conta.Conta;

public class ContaCorrente extends Conta {

    private double taxaManutencao = 10.0;
    
    public ContaCorrente(String numeroConta) {
        super(numeroConta);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor - this.taxaManutencao;
    }
}
