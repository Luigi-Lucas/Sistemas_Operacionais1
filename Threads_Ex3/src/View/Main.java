package View;

import java.util.Random;

import Controller.ThreadMatriz;

public class Main {

	public static void main(String[] args) {

		Random r = new Random();
		int[][] matriz = new int[3][5];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = r.nextInt((100 - 1) + 1) + 1;
			}
		}

		for (int l = 0; l < matriz.length; l++) {
			for (int c = 0; c < matriz[0].length; c++) {
				System.out.print(matriz[l][c] + " ");
			}
			System.out.println(" ");
		}

		for (int i = 0; i < 3; i++) {
			Thread threadMatriz = new ThreadMatriz(matriz, i);
			threadMatriz.start();
		}
	}
}
