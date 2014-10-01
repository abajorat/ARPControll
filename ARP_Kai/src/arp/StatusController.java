package arp;

import models.Device;

public class StatusController extends Thread {
	private Communicator com;
	private int inactiveTime;
	private int downTime;

	public StatusController(Communicator com, int inactiveTime, int downTime) {
		this.com = com;
		this.inactiveTime = inactiveTime;
		this.downTime = downTime;
	}

	public void run() {
		while (true) {
			for (Device d : com.getDispositivos()) {
				long timePassed = System.currentTimeMillis() - d.getLastSignal();
				timePassed /= 1000;
				//System.out.println(timePassed);
				if(timePassed > inactiveTime){
					d.setStatus(1);
				}
				if(timePassed > downTime){
					d.setStatus(2);
				}
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
