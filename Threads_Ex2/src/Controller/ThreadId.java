package Controller;

public class ThreadId extends Thread {

	@Override
	public void run() {
		int id = (int) getId();
		System.out.println(id);
	}
}
