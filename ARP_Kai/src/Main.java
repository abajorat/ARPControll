import java.io.FileInputStream;
import java.io.ObjectInputStream;

import models.ByteArray;
import models.Model;
import arp.Communicator;
import arp.Receiver;
import arp.StatusController;
import arp.Transmitter;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		
		try {
			
			FileInputStream filein = new FileInputStream("resources/data.ser");
			ObjectInputStream in = new ObjectInputStream(filein);
			model = (Model) in.readObject();
			in.close();
			filein.close();
			
		} catch (Exception e) {
			
		}
		
		Communicator com = new Communicator(model);
		
		
		Operator op = new Operator(com, model);
		op.sendBroadcastFrequent(3);
		
		

		
	
		
		Receiver r = new Receiver(60, com);
		r.start();
		StatusController statusController = new StatusController(com, 5, 40);
		statusController.start();
		

	}

	

}
