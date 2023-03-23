package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadTreino;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforoEscuderia = new Semaphore(1);
		Semaphore semaforoCarros = new Semaphore(5);
		
		for (int escuderia = 1; escuderia < 8; escuderia++) {
			Thread t = new ThreadTreino(escuderia, semaforoEscuderia, semaforoCarros);
			t.start();
		}
	}
}
