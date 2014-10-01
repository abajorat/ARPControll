package models;

import java.io.Serializable;
import java.util.Observable;

public class Device extends Observable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1873933206644039295L;
	private ByteArray mac;
	private ByteArray ip;
	private int status;
	private long lastSignal;
	private String name;
	private String type;
	private int failedMessages;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ByteArray getMac() {
		return this.mac;
	}
	public void setMac(ByteArray mac) {
		this.mac = mac;
	}
	public ByteArray getIp() {
		return this.ip;
	}
	public void setIp(ByteArray ip) {
		this.ip = ip;
	}

	public Device(byte[] mac, byte [] ip, long lastSignal){
		this.mac = new ByteArray(mac, true); 
		this.ip = new ByteArray(ip, false);
		this.status = 0; //0 = active
		this.lastSignal = lastSignal;
		this.name = "new";
		this.failedMessages = 0;
	}
	
	public int getFailedMessages(){
		return failedMessages;
	}
	public long getLastSignal() {
		return lastSignal;
	}
	public void setLastSignal(long lastSignal) {
		this.lastSignal = lastSignal;
	}
	public String getPath() {
		return "/home/kai/Pictures/images.png";
	}
	public String getStatus() {
		if (status == 0) return "active";
		if (status == 1) return "inactive";
		if (status == 2) return "down";
		return null;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void resetFailedMessages() {
		this.failedMessages = 0;
	}
	
	public void increaseFailedMessage(){
		failedMessages++;
	}

}
