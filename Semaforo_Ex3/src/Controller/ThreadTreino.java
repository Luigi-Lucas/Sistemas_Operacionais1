package Controller;

import java.util.concurrent.Semaphore;

public class ThreadTreino extends Thread {

	private int escuderia;
	private Semaphore semaforoEscuderia;
	private Semaphore semaforoCarros;

	public ThreadTreino(int escuderia, Semaphore semaforoEscuderia, Semaphore semaforoCarros) {
		this.escuderia = escuderia;
		this.semaforoEscuderia = semaforoEscuderia;
		this.semaforoCarros = semaforoCarros;
	}

	@Override
	public void run() {
		try {
			semaforoCarros.acquire();
			for (int i = 1; i < 3; i++) {
				largada(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoCarros.release();
		}
	}

	private void largada(int carro) {
		System.out.println("O carro " + carro + " da escuderia " + escuderia + " entrou na pista.");
		int melhorTempo = 0;
		for (int i = 1; i < 4; i++) {
			int tempo = (int) ((Math.random() * 3001) + 5000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carro: " + carro + ", Escuderia: " + escuderia + ", Volta: " + i
					+ ", Tempo de percurso: " + (tempo / 1000) + " segundos.");
			melhorTempo = tempo;
			if (melhorTempo > tempo) {
				melhorTempo = tempo;
			}
		}
		System.out.println("Carro: " + carro + ", Escuderia: " + escuderia + ", melhor tempo: " + (melhorTempo / 1000) + " segundos.");
		gridLargada(melhorTempo, carro);
	}

	private void gridLargada(int tempo, int carro) {
	
	}
}
