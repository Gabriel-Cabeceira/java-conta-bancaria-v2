package banco;

import java.util.HashMap;
import java.util.Map;

import user.User;

public class Banco {
    
    public static Map<String, User> users = new HashMap<>();

    public static void criarUsuario(String nome, String login, String senha) {

        if(users.containsKey(login)) {
            System.out.println("Este nome de usuário já está sendo utilizado, tente outro nome");
        } else {

            User novoUsuario = new User(nome, login, senha);

            users.put(login, novoUsuario);

        }
    }
}
