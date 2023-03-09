package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.CorridaThread;

public class Corrida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Vencedor;
	private JTextField Perdedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Corrida frame = new Corrida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Corrida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCarro1.setForeground(new Color(255, 140, 0));
		lblCarro1.setBounds(20, 80, 71, 34);
		contentPane.add(lblCarro1);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 125, 831, 2);
		contentPane.add(separator);

		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(Color.BLUE);
		lblCarro2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCarro2.setBounds(20, 138, 71, 34);
		contentPane.add(lblCarro2);

		JLabel lblNewLabel_1 = new JLabel("Vencedor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(339, 278, 62, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Perdedor");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(339, 324, 52, 14);
		contentPane.add(lblNewLabel_1_1);

		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(38, 425, 89, 23);
		contentPane.add(btnCorrer);

		Vencedor = new JTextField();
		Vencedor.setHorizontalAlignment(SwingConstants.CENTER);
		Vencedor.setBackground(new Color(255, 255, 255));
		Vencedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		Vencedor.setForeground(new Color(0, 255, 0));
		Vencedor.setEditable(false);
		Vencedor.setBounds(401, 275, 86, 20);
		contentPane.add(Vencedor);
		Vencedor.setColumns(10);

		Perdedor = new JTextField();
		Perdedor.setHorizontalAlignment(SwingConstants.CENTER);
		Perdedor.setBackground(new Color(255, 255, 255));
		Perdedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		Perdedor.setForeground(new Color(255, 0, 0));
		Perdedor.setEditable(false);
		Perdedor.setBounds(401, 321, 86, 20);
		contentPane.add(Perdedor);
		Perdedor.setColumns(10);

		ActionListener inicia = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCorrer.setEnabled(false);
				Thread tCarro1 = new CorridaThread(lblCarro1, Vencedor, Perdedor);
				Thread tCarro2 = new CorridaThread(lblCarro2, Vencedor, Perdedor);
				tCarro1.start();
				tCarro2.start();
			}
		};
		
		btnCorrer.addActionListener(inicia);
		
	}
}
