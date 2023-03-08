package Controller;

public class ThreadVetor extends Thread {

	private int[] VT;
	private int num;

	public ThreadVetor(int[] VT, int num) {
		this.VT = VT;
		this.num = num;
	}

	@Override
	public void run() {
		vetor();
	}

	private void vetor() {
		if (num % 2 == 0) {
			double tempoInicial = System.nanoTime();
			for (int i = 0; i < VT.length; i++) {
				System.out.println("TID #" + getId() + " " + VT[i]);
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("Tempo par: " + tempoTotal + "s.");
		} else {
			double tempoInicial = System.nanoTime();
			for (int i : VT) {
				System.out.println("TID #" + getId() + " " + i);
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("Tempo impar: " + tempoTotal + "s.");
		}
	}
}
