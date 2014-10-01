package arp;

import java.util.LinkedList;

import models.Device;
import models.Model;

public class StatusController extends Thread {
	private Communicator com;
	private int inactive;
	private int time;
	private int pendent;
	private Model model;
	private LinkedList<Device> devices;

	public StatusController(Communicator com, int pendent, int inactive,
			int timeout, Model model) {
		this.com = com;
		this.model = model;
		this.inactive = inactive;
		this.pendent = pendent;
		this.time = time;
	}

	public void run() {
		while (true) {
			synchronized (model) {
				devices = (LinkedList<Device>) model.getDispositivos().clone();
			}
				for (Device d : devices) {

					long timePassed = System.currentTimeMillis()
							- d.getLastSignal();
					timePassed /= 1000;
					// System.out.println(timePassed);
					if (timePassed > time) {
						synchronized (model) {
							model.deleteDevice(d.getMac());
						}
						
					}
					
					if(d.getFailedMessages() > pendent){
						System.out.println("Hallo");
						d.setStatus(1);
					}
					if(d.getFailedMessages() > inactive){
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
