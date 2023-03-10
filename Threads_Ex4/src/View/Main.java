package View;

import Controller.ThreadCorrida;

public class Main {

	public static void main(String[] args) {
		
		for (int sapo = 1; sapo < 6; sapo++) {
			Thread threadCorrida = new ThreadCorrida(sapo);
			threadCorrida.start();
		}
	}
}
