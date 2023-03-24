package Controller;

import java.util.concurrent.Semaphore;

public class ThreadPista extends Thread {

	private Semaphore semaforoSul;
	private Semaphore semaforoNorte;
	private int aviao;
	private int pista = (int) ((Math.random() * 2) + 1);

	public ThreadPista(Semaphore semaforoSul, Semaphore semaforoNorte, int aviao) {
		this.semaforoSul = semaforoSul;
		this.semaforoNorte = semaforoNorte;
		this.aviao = aviao;
	}

	@Override
	public void run() {
		if (pista == 1) {
			try {
				semaforoSul.acquire();
				decolarSul();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				semaforoSul.release();
			}
		} else {
			try {
				semaforoNorte.acquire();
				decolarNorte();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoNorte.release();
			}
		}
	}

	private void decolarSul() {
		System.out.println("O aviao " + aviao + " iniciou a decolagem na pista sul.");
		manobrar();
		taxiar();
		decolar();
		afastar();
		System.out.println("O aviao " + aviao + " decolou.");
	}

	private void decolarNorte() {
		System.out.println("O aviao " + aviao + " iniciou a decolagem na pista norte.");
		manobrar();
		taxiar();
		decolar();
		afastar();
		System.out.println("O aviao " + aviao + " decolou.");
	}

	private void manobrar() {
		System.out.println("O aviao " + aviao + " esta manobrando.");
		int tempo = (int) ((Math.random() * 5000) + 3000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void taxiar() {
		System.out.println("O aviao " + aviao + " esta taxiando.");
		int tempo = (int) ((Math.random() * 6000) + 5000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void decolar() {
		System.out.println("O aviao " + aviao + " esta decolando.");
		int tempo = (int) ((Math.random() * 4000) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void afastar() {
		System.out.println("O aviao " + aviao + " esta se afastando.");
		int tempo = (int) ((Math.random() * 6000) + 3000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
