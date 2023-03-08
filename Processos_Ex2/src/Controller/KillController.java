package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private static String os() {

		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos() {
		String os = Controller.KillController.os();
		String process = " ";
		if (os.contains("Windows")) {
			process = "TASKLIST /FO TABLE";
		} else {
			process = "ps -ef";
		}
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mataPid(int parametro) {
		int pid = parametro;
		String os = Controller.KillController.os();
		if (os.contains("Windows")) {
			String comando = "TASKKILL /PID " + pid;
			try {
				Runtime.getRuntime().exec(comando);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String comando = " kill -9 " + pid;
			try {
				Runtime.getRuntime().exec(comando);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void mataNome(String parametro) {
		String nome = parametro;
		String os = Controller.KillController.os();
		if (os.contains("Windows")) {
			String comando = "TASKKILL /IM " + nome;
			try {
				Runtime.getRuntime().exec(comando);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String comando = "pkill -f " + nome;
			try {
				Runtime.getRuntime().exec(comando);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
