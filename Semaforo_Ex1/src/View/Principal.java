package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		for (int carro = 1; carro <= 4; carro++) {
			Thread t = new ThreadCruzamento(carro, semaforo);
			t.start();
		}
	}
}