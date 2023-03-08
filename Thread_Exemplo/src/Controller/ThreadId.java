package Controller;

public class ThreadId extends Thread{
	
	private int idThread;
	
	public ThreadId(int idThread) {
		this.idThread = idThread; //Recebe um valor como parâmetro e passa este valor para a variável global.
	}

	@Override
	public void run() {
		//Só se executa oque está aqui dentro.
		System.out.println(idThread);
	}
}
