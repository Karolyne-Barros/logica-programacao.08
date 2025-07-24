package QuebraCabeca;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class QuebraCabeca {

    static int[][] tabuleiro = new int[3][3];
    static int vazioX, vazioY; // posição do espaço vazio (representado por 0)

    public static void main(String[] args) {
        embaralhar();
        Scanner sc = new Scanner(System.in);

        while (!verificaSeGanhou()) {
            exibirTabuleiro();
            System.out.print("Digite o número que deseja mover: ");
            int numero = sc.nextInt();
            mover(numero);
        }

        exibirTabuleiro();
        System.out.println("Parabéns! Você venceu!");
    }

    static void embaralhar() {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            numeros.add(i); // 0 representa o espaço vazio
        }
        Collections.shuffle(numeros);

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = numeros.get(index);
                if (tabuleiro[i][j] == 0) {
                    vazioX = i;
                    vazioY = j;
                }
                index++;
            }
        }
    }

    static void exibirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%2d ", tabuleiro[i][j]);
                }
            }
            System.out.println();
        }
    }

    static void mover(int numero) {
        // Localiza o número
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == numero) {
                    // Verifica se está ao lado do espaço vazio
                    if ((Math.abs(vazioX - i) + Math.abs(vazioY - j)) == 1) {
                        tabuleiro[vazioX][vazioY] = numero;
                        tabuleiro[i][j] = 0;
                        vazioX = i;
                        vazioY = j;
                        return;
                    }
                }
            }
        }
        System.out.println("Movimento inválido.");
    }

    static boolean verificaSeGanhou() {
        int valorEsperado = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    return tabuleiro[i][j] == 0;
                }
                if (tabuleiro[i][j] != valorEsperado++) {
                    return false;
                }
            }
        }
        return true;
    }
}
