package anagramas;
//Lucas Renato Mizzon de Moraes

//Questão 03

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Anagramas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Digite uma palavra e pressione [ENTER]:");
            String palavra = entrada.nextLine();
            palavra.split("\n");
            System.out.println("Voce digitou " + palavra);
            if (palavra.length() == 0) {
                throw new IllegalArgumentException();
            } else if (palavra.length() == 1) {
                System.out.println("Voce digitou apenas uma letra, há apenas 1 anagrama, ele proprio");
            } else {
                System.out.println("Esta palavra possui " + verificaNumeroDeAnagramas(palavra)
                        + ((verificaNumeroDeAnagramas(palavra) >= 1) ? "anagramas." : " anagrama. "));
            }
        } catch (IllegalArgumentException exception) {
            System.err.println("Palavra ou expressão inválida!");
        } finally {
            entrada.close();
        }
    }

    private static Integer verificaNumeroDeAnagramas(String palavra) {
        Integer numeroDeAnagramas = 0;
        List<String> palavrasGeradas = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] letras = palavra.toCharArray();
        int tamanhoPalavra = palavra.length();

        if (palavra.length() <= 0 || palavra.isEmpty() || palavra.isBlank()) {
            throw new IllegalArgumentException();
        } else if (palavra.length() == 1) {
            return 0;
        } else {

            if (palavra.length() <= 1) {
                System.out.println(palavra);
            } else {
                int auxiliar = palavra.length();
                while (auxiliar > 0) {

                    for (int i = 0; i < palavra.length(); i++) {
                        String atual = palavra.substring(i, i + 1);
                        String apos = palavra.substring(0, i);
                        String antes = palavra.substring(i + 1);
                        palavrasGeradas.add(atual + apos + antes);

                    }
                    auxiliar--;
                    palavra = palavra.substring(0, auxiliar);
                }
                for (int i = 0; i < tamanhoPalavra - 1; i++) {
                    for (int j = 1; j < tamanhoPalavra; j++) {
                        if (letras[i] == letras[j] && i != j) {

                            numeroDeAnagramas++;
                            if (i == j - 1) {

                                numeroDeAnagramas++;

                            }
                        }
                    }
                }
                for (String p : palavrasGeradas) {

                    sb.append(p);

                    sb = sb.reverse();
                    if (palavrasGeradas.contains(sb.toString())) {
                        numeroDeAnagramas++;
                        StringBuilder finalSb = sb;
                        palavrasGeradas = palavrasGeradas
                                .stream()
                                .filter(c -> c.toString()
                                        .equals(finalSb.toString()))
                                .collect(Collectors.toList());
                        numeroDeAnagramas++;
                    }
                }
            }
        }
        return numeroDeAnagramas;
    }
}
