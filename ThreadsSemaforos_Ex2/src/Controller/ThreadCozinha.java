package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {

	public ThreadCozinha() {
		super();
	}

	private int idPrato;
	private Semaphore semaforo;

	public ThreadCozinha(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		if (idPrato % 2 == 0) {
			lasanhaBolonhesa();
		} else {
			sopaCebola();
		}
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void lasanhaBolonhesa() {
		int percentual = 0;
		System.out.println("Iniciado o preparo do prato #" + idPrato + " de Lasanha a Bolonhesa.");
		int tempo = (int) ((Math.random() * 601) + 600);
		while (percentual < 100) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			percentual += tempo / 100;
			if (percentual > 100) {
				percentual = 100;
			}
			System.out.println("Percentual do cozimento do prato #" + idPrato + ": " + percentual);
		}
		System.out.println("Prato #" + idPrato + " concluido.");
	}

	private void sopaCebola() {
		int percentual = 0;
		System.out.println("Iniciado o preparo do prato #" + idPrato + " de Sopa de Cebola.");
		int tempo = (int) ((Math.random() * 301) + 500);
		while (percentual < 100) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			percentual += tempo / 100;
			if (percentual > 100) {
				percentual = 100;
			}
			System.out.println("Percentual do cozimento do prato #" + idPrato + ": " + percentual);
		}
		System.out.println("Prato #" + idPrato + " concluido.");
	}

	private void entrega() {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Prato #" + idPrato + " entregue.");
	}
}
