import java.util.Scanner;

import banco.funcoesAuxiliares.Console;
import banco.menu.Menu;
import user.User;

public class App {
    public static void main(String[] args) {
        
        boolean exit = false;

        Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

        while (!exit) {

            int escolha = Menu.menuPrincipal(scanner);

            switch (escolha) {

                // Login - Menu principal
                case 1:
                    User usuario = Menu.menuRealizarLogin(scanner);

                    if(usuario != null) {

                        Console.clear();

                        // Usuário logado
                        System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario.getNome() + "!");

                        boolean loggedIn = true;

                        while (loggedIn) {

                            int escolhaLogado = Menu.menuContaUsuario(scanner);

                            // menu usuário Logado
                            switch (escolhaLogado) {

                                // Menu usuário logado - Depositar
                                case 1:
                                    Menu.menuDepositar(scanner, usuario);
                                    break;
                                
                                // menu usuário Logado - Sacar
                                case 2:
                                    Menu.menuSacar(scanner, usuario);
                                    break;

                                // menu usuário Logado - Transferir
                                case 3:
                                    
                                    Menu.menuTransferir(scanner, usuario);

                                    break;

                                // menu usuário Logado - Criar conta
                                case 4:
                                    Menu.menuCriarConta(scanner, usuario);
                                    break;

                                // menu usuário Logado - Logout
                                case 5:
                                    loggedIn = false; // sair do menu logado
                                    Console.clear();
                                    System.out.println("Logout realizado com sucesso!");
                                    break;
                            
                                default:
                                    Console.clear();
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }
                        }

                    } else {
                        System.out.println("Usuário ou senha inválidos");
                    }

                    break;

                // Criar usuário - Menu principal
                case 2:
                    Console.clear();
                    Menu.menuCriarUsuario(scanner);
                    Console.clear();
                    break;

                // Sair - Menu principal
                case 3:
                    exit = true;
                    Console.clear();
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    Console.clear();
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
