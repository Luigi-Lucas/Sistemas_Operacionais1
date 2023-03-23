package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadDeposito;
import Controller.ThreadSaque;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo1 = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore(1);
		for (int i = 0; i <= 20; i++) {
			int transacao = (int) (Math.random() * 2);
			int codigoConta = (int) (Math.random() * 1000);
			int saldo = (int) (Math.random() * 10001);
			int valor = (int) (Math.random() * 1001);
			if (transacao == 1) {
				Thread t = new ThreadDeposito(codigoConta, saldo, valor, semaforo1);
				t.run();
			} else {
				Thread t = new ThreadSaque(codigoConta, saldo, valor, semaforo2);
				t.run();
			}
		}
	}
}
