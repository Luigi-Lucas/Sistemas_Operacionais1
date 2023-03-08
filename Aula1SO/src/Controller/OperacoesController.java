package Controller;

public class OperacoesController {

	public OperacoesController() {
		super();
	}

	public void percorreVetor() {
		int[] VT = new int[10000];
		int lenght = VT.length;
		for (int i = 0; i < lenght; i++) {
			VT[i] = 0;
		}
		double tempoInicial = System.nanoTime();
		for (int i = 0; i < lenght; i++) {
			System.out.println(VT[i]);
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("Tempo: " + tempoTotal + "s.");
	}

	public void concatenaStrings() {
		String cadeia = "";
		double tempoInicial = System.nanoTime();
		for (int i = 0; i < 32768; i++) {
			cadeia = cadeia + "a";
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("String: " + tempoTotal + "s.");
	}

	public void concatenaBuffer() {
		StringBuffer buffer = new StringBuffer();
		double tempoInicial = System.nanoTime();
		for (int i = 0; i < 32768; i++) {
			buffer.append("a");
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("Buffer: " + tempoTotal + "s.");
	}
}
