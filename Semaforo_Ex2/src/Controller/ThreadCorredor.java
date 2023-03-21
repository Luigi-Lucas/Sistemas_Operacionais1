package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {

	private int pessoa;
	private Semaphore semaforo;

	public ThreadCorredor(int pessoa, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			pessoaSaindo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void pessoaAndando() {
		int distanciaCorredor = 200;
		int velocidadePessoa = (int) (Math.random() * (6 - 4 + 1) + 4);
		int distanciaInicial = 0;
		while (distanciaInicial < distanciaCorredor) {
			distanciaInicial += velocidadePessoa;
			System.out.println("A pessoa " + pessoa + " andou " + distanciaInicial + " metros");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("A pessoa " + pessoa + " chegou na porta.");
	}

	private void pessoaSaindo() {
		try {
			sleep((int) ((Math.random() * 1001) + 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A pessoa " + pessoa + " atravessou a porta");
	}
}
