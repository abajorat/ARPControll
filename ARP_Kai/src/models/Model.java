package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import org.jnetpcap.PcapIf;

public class Model extends Observable implements Serializable {
	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 4890954930089081055L;
	private int pendent;
	private int inactive;
	private int timeout;
	private LinkedList<Device> dispositivos;
	private ByteArray senderIp;
	private ByteArray senderMac;
	private ByteArray mask;
	private ByteArray network;
	private int maskValue;
	private double hosts;
	private PcapIf device;
	private List<PcapIf> devices;

	public PcapIf getDevice() {
		return device;
	}

	public void setDevice(PcapIf device) {
		this.device = device;
		setChanged();
		notifyObservers();
	}

	public List<PcapIf> getDevices() {
		return devices;
	}

	public void setDevices(List<PcapIf> devices) {
		this.devices = devices;
	}

	public Model() {
		setPendent(10);
		setInactive(20);
		setTimeout(100);
		this.dispositivos = new LinkedList<Device>();
		ByteArray b = new ByteArray("0.0.0.0", false);
		setSenderIp(b);
		setNetwork(b);
		b = new ByteArray("00:00:00:00:00:00", true);
		setSenderMac(b);
		b = new ByteArray("255.255.255.254", false);
		setMask(b);
		this.maskValue = computeMaskValue(mask.getInts());
		this.hosts = Math.pow(2, 32 - maskValue);
	}

	public void setTimeout(int i) {
		this.timeout = i;
		setChanged();
		notifyObservers();
		
	}
	public int getTimeout(){
		return timeout;
	}

	public void addDevice(Device d) {
		if (!dispositivos.contains(d)) {
			dispositivos.add(d);
			setChanged();
			notifyObservers("Device");
		}
	

	}

	public void deleteDevice(ByteArray mac) {

		for (Device d : dispositivos) {
			if (d.getMac().getString().equals(mac.getString())) {
				dispositivos.remove(d);
				setChanged();
				notifyObservers("Device");
				break;

			}
		}


	}

	public int getMaskValue() {
		return maskValue;
	}

	public int getPendent() {
		return pendent;
	}

	public void setPendent(int pendent) {
		this.pendent = pendent;
		setChanged();
		notifyObservers();
	}

	public int getInactive() {
		return inactive;
	}

	public void setInactive(int inactive) {
		this.inactive = inactive;
		setChanged();
		notifyObservers();
	}

	public ByteArray getSenderIp() {
		return senderIp;
	}

	public void setSenderIp(ByteArray senderIp) {
		this.senderIp = senderIp;
		setChanged();
		notifyObservers();
	}

	public ByteArray getSenderMac() {
		return senderMac;
	}

	public void setSenderMac(ByteArray senderMac) {
		this.senderMac = senderMac;
		setChanged();
		notifyObservers();
	}

	public ByteArray getMask() {
		return mask;
	}

	public void setMask(ByteArray mask) {
		this.mask = mask;
		setChanged();
		notifyObservers();
	}

	public ByteArray getNetwork() {
		return network;
	}

	public void setNetwork(ByteArray network) {
		this.network = network;
		setChanged();
		notifyObservers();
	}

	public LinkedList<Device> getDispositivos() {
		return dispositivos;
	}

	public double getHosts() {
		return hosts;
	}

	private static int computeMaskValue(Integer[] ints) {
		int cnt = 8;
		for (int i = 1; i < 4; i++) {
			switch (ints[i]) {
			case 255:
				cnt += 8;
				break;
			case 254:
				cnt += 7;
				break;
			case 252:
				cnt += 6;
				break;
			case 248:
				cnt += 5;
				break;
			case 240:
				cnt += 4;
				break;
			case 224:
				cnt += 3;
				break;
			case 192:
				cnt += 2;
				break;
			case 128:
				cnt += 1;
				break;

			}
		}
		return cnt;
	}

}
