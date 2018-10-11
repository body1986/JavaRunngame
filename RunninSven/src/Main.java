import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		Main mymain = new Main();
		mymain.start();

	}

	private void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Limewand sws = new Limewand(1400,800,100,40);		
					sws.setVisible(true);		
					System.out.println("start");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
