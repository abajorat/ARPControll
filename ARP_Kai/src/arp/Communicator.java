package arp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.Device;
import models.Model;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Arp;

public class Communicator extends Thread {

	private PcapPacketHandler<String> jpacketHandler;
	private Pcap pcap;
	private final Model model;
	private StringBuilder error;
	private PcapIf device;
	private List<PcapIf> devices;

	public Communicator(final Model model) {

		this.model = model;
		devices = new ArrayList<PcapIf>();
		error = new StringBuilder();
		int control = Pcap.findAllDevs(devices, error);
		model.setDevices(devices);
		if (control == Pcap.NOT_OK || devices.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					error.toString());
			return;
		}

	}

	public void open() {
		// this.device = devices.get(devId);
		this.device = model.getDevice();
		int snaplen = 64 * 1024;
		int flags = Pcap.MODE_PROMISCUOUS;
		int timeout = 1000 * 10;
		pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, error);

		if (pcap == null) {
			System.err.printf("Error while opening device for capture: "
					+ error.toString());
			return;
		}
		jpacketHandler = new PcapPacketHandler<String>() {
			Arp arp = new Arp();
			byte[] mac = new byte[6];
			byte[] ip = new byte[6];
			byte[] all = new byte[6];

			public void nextPacket(PcapPacket packet, String user) {
				if (packet.hasHeader(arp)) {

					all = arp.getByteArray(8, 19);
					for (int i = 0; i < 6; i++) {
						mac[i] = all[i];
						ip[i] = all[i + 6];
					}
					boolean exists = false;
					Device d = new Device(mac, ip, System.currentTimeMillis());
					for (Device dev : model.getDispositivos()) {
						if (dev.getMac().getString()
								.equals(d.getMac().getString())) {
							
							dev.setIp(d.getIp());
							dev.setLastSignal(d.getLastSignal());
							dev.setStatus(0);
							dev.resetFailedMessages();
							exists = true;
							break;
						}

					}
					if(!exists)model.addDevice(d);

				}
			}
		};
	}

	public void setDevice(PcapIf device) {
		this.device = device;
	}

	public List<PcapIf> getDevices() {
		return devices;
	}

	public  LinkedList<Device> getDispositivos() {
		return model.getDispositivos();
	}

	public PcapIf getDevice() {
		return device;
	}

	public PcapPacketHandler<String> getJpacketHandler() {
		return jpacketHandler;
	}

	public Pcap getPcap() {
		return pcap;
	}

	public Model getModel() {
		return model;
	}

}
