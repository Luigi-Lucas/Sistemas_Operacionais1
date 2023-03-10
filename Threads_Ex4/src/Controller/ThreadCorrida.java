package Controller;

import java.util.Random;

public class ThreadCorrida extends Thread {

	private int sapo;
	private static int posicao;

	public ThreadCorrida(int sapo) {
		this.sapo = sapo;
	}

	@Override
	public void run() {
		corrida();
	}

	private void corrida() {

		Random r = new Random();
		int distanciaTotal = 0;

		while (distanciaTotal < 10) { // Distância máxima de 10 metros.
			int salto = r.nextInt(4); // Distância máxima de 3 metros para cada pulo.
			distanciaTotal += salto;
			System.out.println("O sapo " + sapo + " saltou " + salto + " metros.");
			if (distanciaTotal > 10) {
				distanciaTotal = 10;
			}
			System.out.println("O sapo " + sapo + " percorreu " + distanciaTotal + " metros.");
		}
		posicao++;
		System.out.println("O sapo " + sapo + " chegou em " + posicao + " lugar.");
	}
}
