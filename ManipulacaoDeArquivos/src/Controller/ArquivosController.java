package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController {

	public ArquivosController() {
		super();
	}

	public void lerFrutas(String path, String nome) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Fruits")) {
						String[] info = linha.split(",");
						tabulacao(info);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	private void tabulacao(String[] info) {
		String nomeFruta = info[0];
		String nomeCientifico = info[1];

		if (nomeFruta.length() <= 7 && nomeCientifico.length() <= 14) {
			System.out.println(info[0] + "\t\t\t" + info[1] + "\t\t\t" + info[3]);
		} else if (nomeFruta.length() <= 7) {
			System.out.println(info[0] + "\t\t\t" + info[1] + "\t\t" + info[3]);
		} else if (nomeCientifico.length() <= 5) {
			System.out.println(info[0] + "\t\t" + info[1] + "\t\t\t\t" + info[3]);
		} else if (nomeCientifico.length() <= 14) {
			System.out.println(info[0] + "\t\t" + info[1] + "\t\t\t" + info[3]);
		} else if (nomeFruta.length() >= 16) {
			System.out.println(info[0] + "\t" + info[1] + "\t\t" + info[3]);
		} else {
			System.out.println(info[0] + "\t\t" + info[1] + "\t\t" + info[3]);
		}
	}
}
