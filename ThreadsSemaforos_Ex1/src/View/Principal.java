package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadServidor;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int idThread = 1; idThread <= 21; idThread++) {
			Thread threadServidor = new ThreadServidor(idThread, semaforo);
			threadServidor.start();
		}

	}

}
