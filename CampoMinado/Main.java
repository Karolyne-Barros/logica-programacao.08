package CampoMinado;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CampoMinado jogo = new CampoMinado();

        boolean jogoAtivo = true;

        while (jogoAtivo) {
            jogo.mostrarTabuleiro();

            System.out.print("Digite a coordenada (ex: B 3): ");
            String linhaLetra = sc.next().toUpperCase();
            int coluna;

            try {
                coluna = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Coluna inválida.");
                sc.nextLine(); // limpa buffer
                continue;
            }

            int linha = CampoMinado.letraParaIndice(linhaLetra);
            if (linha == -1 || coluna < 0 || coluna >= CampoMinado.COLUNAS) {
                System.out.println("Coordenada inválida.");
                continue;
            }

            if (jogo.real[linha][coluna] == CampoMinado.BOMBA) {
                System.out.println("\nVocê clicou em uma BOMBA! Fim de jogo.");
                jogo.mostrarTabuleiroReal();
                jogoAtivo = false;
            } else {
                jogo.revelarCelula(linha, coluna);
                if (jogo.verificarVitoria()) {
                    jogo.mostrarTabuleiroReal();
                    System.out.println("\nParabéns! Você venceu o jogo!");
                    jogoAtivo = false;
                }
            }
        }

        sc.close();
    }
}
