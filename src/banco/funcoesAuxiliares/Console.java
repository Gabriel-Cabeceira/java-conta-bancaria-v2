package banco.funcoesAuxiliares;

public class Console {


    public static void clear() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Comando para limpar o terminal no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar o terminal em Unix/Linux/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar o terminal: " + e.getMessage());
        }
    }
}
