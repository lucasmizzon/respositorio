package senha;
//Lucas Renato Mizzon de Moraes

//Questão 02

import java.util.Objects;
import java.util.Scanner;

public class Senha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean senhaForte = false;
        String usuario = "User";
        String senha = "";
        try {
            System.out.print("Olá " + usuario + " vamos criar uma senha!\nA mesma deve ter os seguintes requisitos:");
            System.out.println("\nTamanho: 6 Caracteres\nConter:\n1 - Digito Numerico\n1 - Letra Minuscula\n1 - Letra Maiuscula\n1 -Caracter especial");
            while (!senhaForte) {
                System.out.println("Digite uma senha:");
                senha = entrada.nextLine();
                senhaForte = retornaSeASenhaEhForte(senha);
                if (!senhaForte) {
                    System.out.println("Voce inseriu uma senha fraca, vamos tentar novamente (Senha:" + senha + ")");
                }
            }
            System.out.println("Parabéns " + usuario + " você conseguiu atribuir uma senha forte! (Senha: " + senha + ")");
        } catch (IllegalArgumentException exception) {
            System.err.println("Caractere ou expressão inválida!");
        } finally {
            entrada.close();
        }
    }

    private static boolean retornaSeASenhaEhForte(String senha) {
        String digitosEspeciais = "!@#$%^&()-+";
// Verificando tamanho
        if (senha.length() < 6) {
            return false;
        }
// instanciando as boolean sobre consiçoes a serem atendidas
        boolean localizouDigito = false;
        boolean localizouMaiuscula = false;
        boolean localizouMinuscula = false;
        boolean localizouCaracterEspecial = false;
        for (int i = 0; i < senha.length(); i++) {
            Character posicaoAnalisada = senha.charAt(i);
            if (posicaoAnalisada.toString().matches("^[0-9]")) {
                localizouDigito = true;
            }

            if (posicaoAnalisada.toString().toUpperCase().matches("[A-Z]*")) {

                if (posicaoAnalisada.toString().matches("[A-Z]*")) {
                    localizouMaiuscula = true;
                } else {
                    localizouMinuscula = true;
                }
            }
// Verifico se o caracter que esta sendo analisado contem nos especiais
            for (int j = 0; j < digitosEspeciais.length(); j++) {

                Character digitoEspecial = digitosEspeciais.charAt(j);
                if (Objects.equals(posicaoAnalisada, digitoEspecial)) {
                    localizouCaracterEspecial = true;
                }
            }
//Verificacao a cada laço, pois se todos os requisitos forem atendidos, evitando o processamento desnecessario
            if (localizouDigito && localizouMaiuscula
                    && localizouMinuscula && localizouCaracterEspecial) {
                return true;
            }
        }
        return false;
    }
}
