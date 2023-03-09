package Controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CorridaThread extends Thread {

	private JLabel carro;
	private JTextField vencedor, perdedor;

	public CorridaThread(JLabel carro, JTextField vencedor, JTextField perdedor) {
		this.carro = carro;
		this.vencedor = vencedor;
		this.perdedor = perdedor;
	}

	@Override
	public void run() {
		iniciaCorrida();
	}

	private void iniciaCorrida() {
		Random r = new Random();
		Rectangle posicao = carro.getBounds();
		while (posicao.x < 800) {
			posicao.x += r.nextInt(20);
			carro.setBounds(posicao);
			if (posicao.x > 800) {
				posicao.x = 800;
				carro.setBounds(posicao);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (vencedor.getText().isEmpty()) {
			vencedor.setText(carro.getText());
			if (carro.getText() == "Carro 1") {
				perdedor.setText("Carro 2");
			} else {
				perdedor.setText("Carro 1");
			}
		}
	}
}
