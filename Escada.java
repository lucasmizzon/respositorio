package escada;
//Lucas Renato Mizzon de Moraes

//Questão 01

import java.util.Scanner;

public class Escada {

    public static void main(String args[]) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Tamanho da escada: ");
        int n = ler.nextInt();
        int t = n;
        String multiplicador = " ";
        String asterisco = "";
        for (int i = 1; i <= n; i++) {
            asterisco += "*";
            if (i == n) {
                System.out.print(asterisco);
                System.exit(0);
            }
            for (int j = t; j >= 3; j--) {
                multiplicador += " ";
            }
            t -= 1;
            System.out.println(multiplicador + asterisco);
            multiplicador = " ";
        }
    }
}
