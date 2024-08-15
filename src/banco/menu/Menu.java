package banco.menu;

import java.util.Map;
import java.util.Scanner;

import banco.Banco;
import conta.contaCorrente.ContaCorrente;
import conta.contaPoupanca.ContaPoupanca;
import user.User;

public class Menu {

    public static int menuPrincipal(Scanner scanner) {
        System.out.println("Seja bem-vindo ao Banco Nacional");
        System.out.println("");
        System.out.println("1 - Login");
        System.out.println("2 - Criar usuário");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        return escolha;
    }

    public static User menuRealizarLogin(Scanner scanner) {
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        User usuario = Banco.users.get(login);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            return null;
        }
    }

    public static void menuCriarUsuario(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite um login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Banco.criarUsuario(nome, login, senha);
    }

    public static int menuContaUsuario(Scanner scanner) {
        System.out.println("1 - Depósito");
        System.out.println("2 - Saque");
        System.out.println("3 - Transferência");
        System.out.println("4 - Criar Conta");
        System.out.println("5 - Logout");
        System.out.print("Escolha uma opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        return escolha;
    }

    public static void menuDepositar(Scanner scanner, User usuario) {
        System.out.println("Digite o valor que deseja depositar: ");
        double valorDeposito = scanner.nextDouble();
        System.out.println("Digite o número da conta em que deseja depositar:");
        scanner.nextLine(); // Consumir a nova linha
        String numeroContaDeposito = scanner.nextLine();

        if (numeroContaDeposito.endsWith("01")) {
            Map<String, ContaCorrente> contasCorrentes = usuario.getContasCorrentes();
            ContaCorrente conta = contasCorrentes.get(numeroContaDeposito);

            if (conta != null) {
                conta.depositar(valorDeposito);
                System.out.println("Depósito realizado com sucesso");
                conta.getSaldo();
            } else {
                System.out.println("Conta corrente não encontrada.");
            }

        } else if (numeroContaDeposito.endsWith("13")) {
            Map<String, ContaPoupanca> contasPoupancas = usuario.getContasPoupancas();
            ContaPoupanca conta = contasPoupancas.get(numeroContaDeposito);

            if (conta != null) {
                conta.depositar(valorDeposito);
                System.out.println("Depósito realizado com sucesso");
                conta.getSaldo();
            } else {
                System.out.println("Conta poupança não encontrada.");
            }
        } else {
            System.out.println("Número da conta inválido.");
        }
    }

    public static void menuSacar(Scanner scanner, User usuario) {
        System.out.println("Digite o valor que deseja sacar: ");
        double valorSaque = scanner.nextDouble();
        System.out.println("Digite o número da conta em que deseja realizar o saque:");
        scanner.nextLine(); // Consumir a nova linha
        String numeroContaSaque = scanner.nextLine();

        if (numeroContaSaque.endsWith("01")) {
            Map<String, ContaCorrente> contasCorrentes = usuario.getContasCorrentes();
            ContaCorrente conta = contasCorrentes.get(numeroContaSaque);

            if (conta != null) {
                conta.sacar(valorSaque);
            } else {
                System.out.println("Conta corrente não encontrada.");
            }

        } else if (numeroContaSaque.endsWith("13")) {
            Map<String, ContaPoupanca> contasPoupancas = usuario.getContasPoupancas();
            ContaPoupanca conta = contasPoupancas.get(numeroContaSaque);

            if (conta != null) {
                conta.sacar(valorSaque);
            } else {
                System.out.println("Conta poupança não encontrada.");
            }
        } else {
            System.out.println("Número da conta inválido.");
        }
    }

    public static void menuTransferir(Scanner scanner, User usuario) {
        System.out.println("Digite o valor que deseja transferir");
        double valorTransferencia = scanner.nextDouble();
        System.out.println("Digite o número da sua conta");
        scanner.nextLine();
        String numeroContaRealizaTransferencia = scanner.nextLine();
        System.out.println("Digite o número da conta para onde fará a transferência");
        String numeroContaRecebeTransferencia = scanner.nextLine();

        if (numeroContaRealizaTransferencia.endsWith("01")) {
            Map<String, ContaCorrente> contasCorrentes = usuario.getContasCorrentes();
            ContaCorrente conta = contasCorrentes.get(numeroContaRealizaTransferencia);

            if (conta != null) {
                conta.transferir(numeroContaRecebeTransferencia, valorTransferencia);
            } else {
                System.out.println("Conta corrente não encontrada.");
            }

        } else if (numeroContaRealizaTransferencia.endsWith("13")) {
            Map<String, ContaPoupanca> contasPoupancas = usuario.getContasPoupancas();
            ContaPoupanca conta = contasPoupancas.get(numeroContaRealizaTransferencia);

            if (conta != null) {
                conta.transferir(numeroContaRecebeTransferencia, valorTransferencia);
            } else {
                System.out.println("Conta poupança não encontrada.");
            }
        } else {
            System.out.println("Número da conta inválido.");
        }
    }

    public static void menuCriarConta(Scanner scanner, User usuario) {
        System.out.println("Escolha o tipo de conta que deseja criar: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipoConta = scanner.nextInt();

        switch (tipoConta) {
            case 1:  
                usuario.criarContaCorrente();
                System.out.println("Conta Corrente criada com sucesso!");
                break;

            case 2:
                usuario.criarContaPoupanca();
                System.out.println("Conta Poupança criada com sucesso!");
                break;
        
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
