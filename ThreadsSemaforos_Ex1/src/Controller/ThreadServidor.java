package Controller;

import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread {

	public ThreadServidor() {
		super();
	}

	private int idThread;
	private Semaphore semaforo;

	public ThreadServidor(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		int i = 0;
		while (i <= 1) {
			if (idThread % 3 == 1) {
				transacao1();
			} else if (idThread % 3 == 2) {
				transacao2();
			} else if (idThread % 3 == 0) {
				transacao3();
			}
			try {
				semaforo.acquire();
				bancoDeDados();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			i++;
		}
	}

	private void transacao1() {
		System.out.println("Thread #" + idThread + ": calculando.");
		int tempo = (int) ((Math.random() * 801) + 200);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void transacao2() {
		System.out.println("Thread #" + idThread + ": calculando.");
		int tempo = (int) ((Math.random() * 1001) + 500);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void transacao3() {
		System.out.println("Thread #" + idThread + ": calculando.");
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void bancoDeDados() {
		System.out.println("Thread #" + idThread + ": transacao com banco de dados.");
		if (idThread % 3 == 1) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
