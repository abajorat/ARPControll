import models.Model;
import arp.Communicator;
import arp.Transmitter;

public class Operator extends Thread {

	private final Communicator com;
	private final Model model;
	private Thread thread;
	private int op;

	public Operator(final Communicator com, final Model model, int op) {
		this.model = model;
		this.com = com;
		this.op = op; //0 = FrequentBroadcast 1= BroadcastOnce 2= Receiver

	}

	public void sendBroadcastOnce() {
		for (int i = 0; i < (int) model.getHosts() - 1; i++) {
			Transmitter t = new Transmitter(i + 1, model.getSenderIp(),
					model.getSenderMac(), model.getNetwork(),
					model.getMaskValue(), com);
			t.start();
		}
	}

	@SuppressWarnings("static-access")
	public void sendBroadcastFrequent() {
		while (true) {
			thread = new Thread() {

				public void run() {

					for (int i = 0; i < (int) model.getHosts() - 1; i++) {
						Transmitter t = new Transmitter(i + 1,
								model.getSenderIp(), model.getSenderMac(),
								model.getNetwork(), model.getMaskValue(), com);
						t.start();
					}
				}
			};


			thread.start();
			try {
				thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public void run(){
		switch(op){
		case 0: sendBroadcastFrequent();break;
		case 1: sendBroadcastOnce();break;
		
		}
		
	}
}
