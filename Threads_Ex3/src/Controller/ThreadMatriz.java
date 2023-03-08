package Controller;

public class ThreadMatriz extends Thread {

	private int[][] matriz;
	private int i;

	public ThreadMatriz(int[][] matriz, int i) {
		this.matriz = matriz;
		this.i = i;
	}

	@Override
	public void run() {
		matriz();
	}

	private void matriz() {
		int soma = 0;
		for (int j = 0; j < 5; j++) {
			soma = soma + matriz[i][j];
		}
		System.out.println("Linha " + i + " = " + soma);
	}
}
