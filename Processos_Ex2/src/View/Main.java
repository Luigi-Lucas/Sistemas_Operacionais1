package View;

import javax.swing.JOptionPane;

import Controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController Kc = new KillController();

		int opc = 0;
		while (opc != 9) {
			opc = Integer
					.parseInt(JOptionPane.showInputDialog(" 1 - Verificar lista de processos \n 2 - Matar processo com pid \n 3 - Matar processo com o nome \n 9 - Finalizar"));
			switch (opc) {
			case 1:
				Kc.listaProcessos();
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do pid que deseja matar"));
				Kc.mataPid(pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Digite o nome do processo que deseja matar");
				Kc.mataNome(nome);
				break;
			case 9:
				System.out.println("Programa finalizado.");
				System.exit(0);
			default:
				System.out.println("Opção inválida");
			}
		}
	}
}
