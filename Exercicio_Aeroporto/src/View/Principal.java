package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadPista;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforoSul = new Semaphore(1);
		Semaphore semaforoNorte = new Semaphore(1);
		for (int aviao = 1; aviao < 13; aviao++) {
			Thread t = new ThreadPista(semaforoSul, semaforoNorte, aviao);
			t.start();
		}
	}
}
