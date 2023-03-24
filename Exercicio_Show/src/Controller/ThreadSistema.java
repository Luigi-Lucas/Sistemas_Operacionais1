package Controller;

import java.util.concurrent.Semaphore;

public class ThreadSistema extends Thread {

	private Semaphore semaforo;
	private static int ingressos = 100;
	private int usuario = (int) getId();

	public ThreadSistema(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		login();
	}

	private void login() {
		System.out.println("O usuario #" + usuario + " esta fazendo o login.");
		int tempo = (int) ((Math.random() * 1950) + 51);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo > 1000) {
			System.out.println("O usuario #" + usuario + " levou timeout.");
		} else {
			compra();
		}
	}

	private void compra() {
		System.out.println("O usuario #" + usuario + " esta fazendo a compra.");
		int tempo = (int) ((Math.random() * 3000) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo > 2500) {
			System.out.println("O usuario #" + usuario + " estourou o tempo de sessao.");
		} else {
			if (ingressos > 0) {
				try {
					semaforo.acquire();
					int compra = (int) ((Math.random() * 4) + 1);
					if (compra < ingressos) {
						ingressos -= compra;
						System.out.println("O usuario #" + usuario + " comprou " + compra + " ingressos. Restam " + ingressos + " ingressos disponiveis.");
					} else {
						System.out.println("Mensagem para o usuario #" + usuario + " quantidade de ingressos indisponiveis para essa compra!");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			} else {
				System.out.println("Mensagem para o usuario #" + usuario + " :Ingressos esgotados!");
			}
		}
	}
}