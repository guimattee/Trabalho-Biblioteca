import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.println("Digite um número válido!");
            sc.next();
            System.out.print(mensagem);
        }
        int valor = sc.nextInt();
        sc.nextLine(); 
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextDouble()) {
            System.out.println("Digite um número válido!");
            sc.next();
            System.out.print(mensagem);
        }
        double valor = sc.nextDouble();
        sc.nextLine(); 
        return valor;
    }
}
