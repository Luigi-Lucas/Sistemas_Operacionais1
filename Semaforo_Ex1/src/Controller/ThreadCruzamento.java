package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {

	private int carro;
	private Semaphore semaforo;
	private static int sentido = 1;

	public ThreadCruzamento(int carro, Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			Cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void Cruzamento() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (sentido) {
		case 1:
			System.out.println("O carro " + carro + " esta passando de cima para baixo");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro " + carro + " passou.");
			sentido++;
			break;
		case 2:
			System.out.println("O carro " + carro + " esta passando de baixo para cima");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro " + carro + " passou.");
			sentido++;
			break;
		case 3:
			System.out.println("O carro " + carro + " esta passando da esquerda para a direita");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro " + carro + " passou.");
			sentido++;
			break;
		case 4:
			System.out.println("O carro " + carro + " esta passando da direita para esquerda");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro " + carro + " passou.");
			sentido++;
			break;
		}
	}
}
