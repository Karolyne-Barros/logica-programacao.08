package CampoMinado;

import java.util.Random;

public class CampoMinado {

    static final int LINHAS = 10;
    static final int COLUNAS = 15;
    static final char OCULTO = '-';
    static final char BOMBA = '*';
    static final char VAZIO = ' ';

    char[][] visivel = new char[LINHAS][COLUNAS];
    char[][] real = new char[LINHAS][COLUNAS];
    boolean[][] revelado = new boolean[LINHAS][COLUNAS];

    public CampoMinado() {
        inicializarTabuleiros();
        posicionarBombas();
    }

    void inicializarTabuleiros() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                visivel[i][j] = OCULTO;
                real[i][j] = OCULTO;
                revelado[i][j] = false;
            }
        }
    }

    void posicionarBombas() {
        Random rand = new Random();
        int numBombas = rand.nextInt(11) + 15; // entre 15 e 25 bombas
        int colocadas = 0;

        while (colocadas < numBombas) {
            int linha = rand.nextInt(LINHAS);
            int coluna = rand.nextInt(COLUNAS);

            if (real[linha][coluna] != BOMBA) {
                real[linha][coluna] = BOMBA;
                colocadas++;
            }
        }

        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (real[i][j] != BOMBA) {
                    int bombas = contarBombasAoRedor(i, j);
                    real[i][j] = bombas > 0 ? (char) ('0' + bombas) : VAZIO;
                }
            }
        }
    }

    int contarBombasAoRedor(int x, int y) {
        int cont = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < LINHAS && j >= 0 && j < COLUNAS) {
                    if (real[i][j] == BOMBA) cont++;
                }
            }
        }
        return cont;
    }

    void mostrarTabuleiro() {
        System.out.print("\n    ");
        for (int j = 0; j < COLUNAS; j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();

        for (int i = 0; i < LINHAS; i++) {
            System.out.printf("%c  ", 'A' + i);
            for (int j = 0; j < COLUNAS; j++) {
                System.out.printf("%2c ", visivel[i][j]);
            }
            System.out.println();
        }
    }

    void mostrarTabuleiroReal() {
        System.out.print("\n    ");
        for (int j = 0; j < COLUNAS; j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();

        for (int i = 0; i < LINHAS; i++) {
            System.out.printf("%c  ", 'A' + i);
            for (int j = 0; j < COLUNAS; j++) {
                System.out.printf("%2c ", real[i][j]);
            }
            System.out.println();
        }
    }

    void revelarCelula(int x, int y) {
        if (x < 0 || x >= LINHAS || y < 0 || y >= COLUNAS || revelado[x][y]) return;

        visivel[x][y] = real[x][y];
        revelado[x][y] = true;

        if (real[x][y] == VAZIO) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    revelarCelula(i, j);
                }
            }
        }
    }

    boolean verificarVitoria() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (real[i][j] != BOMBA && !revelado[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static int letraParaIndice(String letra) {
        if (letra.length() != 1) return -1;
        char c = letra.charAt(0);
        if (c >= 'A' && c < 'A' + LINHAS) {
            return c - 'A';
        }
        return -1;
    }
}
