package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadCorredor;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		for (int pessoa = 1; pessoa<= 4; pessoa++) {
			Thread t = new ThreadCorredor(pessoa, semaforo);
			t.start();
		}
	}
}
