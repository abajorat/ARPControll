package arp;

import models.Device;

public class Receiver extends Thread {

	private int timeout;
	private Communicator com;

	public Receiver(int time, Communicator com) {
		super();
		this.timeout = time;
		this.com = com;

	}

	@Override
	public void run() {
		System.out.println("vamos");
		com.getPcap().loop(timeout, com.getJpacketHandler(), "jNetPcap rocks!");
		
		for (Device d : com.getDispositivos()) {
			System.out.println("Name: " + d.getName() + "   Mac: "+ d.getMac().getString() + "   Ip: " + d.getIp().getString()
					+ "   Last Signal in ms: " + d.getLastSignal() + "   State: " + d.getStatus());
		}
		System.out.println("acabamos");

	}

}
