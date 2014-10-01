import models.ByteArray;
import models.Model;
import arp.Communicator;
import arp.Transmitter;

public class Operator {

    private final Communicator com;
    private final Model model;
    private Thread thread;

    public Operator(final Communicator com, final Model model) {
	this.model = model;
	this.com = com;

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
    public void sendBroadcastFrequent(int sleep) {
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
		thread.sleep(1000 * sleep);
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

}
