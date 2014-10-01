package arp;

import models.Device;
import models.Model;

public class StatusController extends Thread {
	private Communicator com;
	private int inactive;
	private int timeout;
	private int pendent;
	private Model model;

	public StatusController(Communicator com, int pendent,int inactive, int timeout, Model model) {
		this.com = com;
		this.model = model;
		this.inactive = inactive;
		this.pendent = pendent;
		this.timeout = timeout;
	}

	public void run() {
		while (true) {
			for (Device d : com.getDispositivos()) {
				long timePassed = System.currentTimeMillis() - d.getLastSignal();
				timePassed /= 1000;
				//System.out.println(timePassed);
				if(timePassed > timeout){
					model.deleteDevice(d.getMac());
				}
				
			}
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
