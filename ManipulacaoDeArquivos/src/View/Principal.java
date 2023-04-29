package View;

import java.io.IOException;

import Controller.ArquivosController;

public class Principal {

	public static void main(String[] args) {

		ArquivosController aC = new ArquivosController();

		String path = "C:\\temp";
		String nome = "generic_food.csv";

		try {
			aC.lerFrutas(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
