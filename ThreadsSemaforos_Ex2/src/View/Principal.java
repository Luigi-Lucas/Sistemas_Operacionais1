package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadCozinha;

public class Principal {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for (int idPrato = 1; idPrato < 6; idPrato++) {
			Thread threadCozinha = new ThreadCozinha(idPrato, semaforo);
			threadCozinha.start();
		}
	}
}
