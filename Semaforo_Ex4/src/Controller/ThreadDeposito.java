package Controller;

import java.util.concurrent.Semaphore;

public class ThreadDeposito extends Thread {

	private int codigoConta;
	private int saldo;
	private int valor;
	private Semaphore semaforo1;

	public ThreadDeposito(int codigoConta, int saldo, int valor, Semaphore semaforo1) {
		this.codigoConta = codigoConta;
		this.saldo = saldo;
		this.valor = valor;
		this.semaforo1 = semaforo1;
	}

	@Override
	public void run() {
		try {
			semaforo1.acquire();
			deposito();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo1.release();
		}
	}

	private void deposito() {
		System.out.println(
				"Codigo da conta: #" + codigoConta + ", saldo atual: R$" + saldo + ", valor do deposito: R$" + valor);
		saldo += valor;
		System.out.println("Saldo final: R$" + saldo);
	}
}
