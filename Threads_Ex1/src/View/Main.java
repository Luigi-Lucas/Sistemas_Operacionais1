package View;

import java.util.Random;

import Controller.ThreadVetor;

public class Main {

	public static void main(String[] args) {

		Random r = new Random();
		int[] VT = new int[1000];
		int a = 1;
		int b = 2;
		int lenght = VT.length;
		
		for (int i = 0; i < lenght; i++) {
			VT[i] = r.nextInt((100 - 1) + 1) + 1;
		}

		Thread threadVetor = new ThreadVetor(VT, a);
		threadVetor.start();

		threadVetor = new ThreadVetor(VT, b);
		threadVetor.start();
	}
}
