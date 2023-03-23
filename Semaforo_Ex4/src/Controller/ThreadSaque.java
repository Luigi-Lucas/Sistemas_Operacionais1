package Controller;

import java.util.concurrent.Semaphore;

public class ThreadSaque extends Thread {


	private int codigoConta;
	private int saldo;
	private int valor;
	private Semaphore semaforo2;

	public ThreadSaque(int codigoConta, int saldo, int valor, Semaphore semaforo2) {
		this.codigoConta = codigoConta;
		this.saldo = saldo;
		this.valor = valor;
		this.semaforo2 = semaforo2;
	}

	@Override
	public void run() {

		try {
			semaforo2.acquire();
			saque();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo2.release();
		}
	}

	private void saque() {
		System.out.println("Codigo da conta: #" + codigoConta + ", saldo atual: R$" + saldo + ", valor do saque: R$" + valor);
		saldo -= valor;
		System.out.println("Saldo final: R$" + saldo);
	}
}
