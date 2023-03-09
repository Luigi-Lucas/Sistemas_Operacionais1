package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.CacaNiquelThread;

public class CacaNiquel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CacaNiquel frame = new CacaNiquel();
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
	public CacaNiquel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField1.setEditable(false);
		textField1.setBounds(34, 95, 86, 45);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setBounds(142, 95, 86, 45);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField3.setEditable(false);
		textField3.setColumns(10);
		textField3.setBounds(252, 95, 86, 45);
		contentPane.add(textField3);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(139, 194, 89, 23);
		contentPane.add(btnJogar);
		
		ActionListener inicia = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnJogar.setVisible(false);;
				Thread tTextField1 = new CacaNiquelThread(textField1, btnJogar);
				tTextField1.start();
				Thread tTextField2 = new CacaNiquelThread(textField2, btnJogar);
				tTextField2.start();
				Thread tTextField3 = new CacaNiquelThread(textField3, btnJogar);
				tTextField3.start();
			}		
		};
		
		btnJogar.addActionListener(inicia);
		
	}
}
