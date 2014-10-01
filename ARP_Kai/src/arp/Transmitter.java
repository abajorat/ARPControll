package arp;

import models.ByteArray;
import models.Model;

import org.jnetpcap.packet.JMemoryPacket;
import org.jnetpcap.packet.JPacket;

public class Transmitter extends Thread {

	private int host;
	private ByteArray senderMac;
	private ByteArray senderIp;
	private int maskValue;
	private ByteArray port;
	private Communicator com;
	private Model model;
	public Transmitter(int host, ByteArray senderIp, ByteArray senderMac,
			ByteArray port, int maskValue, Communicator com) {
		super();
		this.maskValue = maskValue;
		this.host = host;
		this.senderMac = senderMac;
		this.senderIp = senderIp;
		this.port = port;
		this.com = com;

	}

	@Override
	public void run() {
		byte ip1 = 0, ip2 = 0, ip3 = 0;

		ip1 = (byte) (port.getInts()[1] + (host / (256 * 256)));
		ip2 = (byte) (port.getInts()[2] + ((host / 256) % 256));
		ip3 = (byte) (port.getInts()[3] - 1 + (host % (256 * 256)));
		
		model = com.getModel();
		synchronized(model){
			
		}
		

		byte[] a = { (byte) ((int) Integer.parseInt("ff", 16)),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),

				senderMac.getBytes()[0], senderMac.getBytes()[1],
				senderMac.getBytes()[2], senderMac.getBytes()[3],
				senderMac.getBytes()[4], senderMac.getBytes()[5],

				(byte) 8, (byte) 6,

				(byte) 0, (byte) 1,

				(byte) 8, (byte) 0,

				(byte) 6,

				(byte) 4,

				(byte) 0, (byte) 1,

				senderMac.getBytes()[0], senderMac.getBytes()[1],
				senderMac.getBytes()[2], senderMac.getBytes()[3],
				senderMac.getBytes()[4], senderMac.getBytes()[5],

				senderIp.getBytes()[0], senderIp.getBytes()[1],
				senderIp.getBytes()[2], senderIp.getBytes()[3],

				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),

				port.getBytes()[0], ip1, ip2, ip3 };

		JPacket packet = new JMemoryPacket(a);

		com.getPcap().sendPacket(packet);
		System.out.println("gesendet" + (host));

	}
}
