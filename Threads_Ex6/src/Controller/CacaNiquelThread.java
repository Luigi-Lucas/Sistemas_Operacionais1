package Controller;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CacaNiquelThread extends Thread{
	
	private JTextField textField;
	private JButton btnJogar;
	public static int threadsFinalizadas = 0;
	
	public CacaNiquelThread(JTextField textField, JButton btnJogar) {
		this.textField = textField;
		this.btnJogar = btnJogar;
	}
	
	@Override
	public void run() {
		iniciaJogo();
	}

	private void iniciaJogo() {
		Random r = new Random();
		int giro = 1;
		while (giro < r.nextInt(150) + 1) {
			String numero = Integer.toString(r.nextInt(7) + 1);
			textField.setText(numero);
			giro++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		threadsFinalizadas++;
		if (threadsFinalizadas == 3) {
			btnJogar.setVisible(true);
			threadsFinalizadas = 0;
		}
	}
}
