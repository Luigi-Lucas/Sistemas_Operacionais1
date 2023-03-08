package View;

import Controller.ThreadId;

public class Principal {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Thread threadId = new ThreadId();
			threadId.start();
		}
	}
}
