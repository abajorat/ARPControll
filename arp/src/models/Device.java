package models;

public class Device {
	private String mac;
	private String ip;
	private int state;
	//private int id;
	//private int id_red;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public Device(byte[] mac, byte [] ip){
		Integer [] m = new Integer[6];
		for(int i=0;i<6;i++){
			m[i] = (int)mac[i];
		}
		
		for(int i=0;i<6;i++){
			if((int)m[i]<0){
				m[i] += 256;
			}
		}
		this.mac = Integer.toHexString(m[0]) +":"+
					Integer.toHexString(m[1]) +":"+
					Integer.toHexString(m[2]) +":"+
					Integer.toHexString(m[3]) +":"+
					Integer.toHexString(m[4]) +":"+
					Integer.toHexString(m[5]);
		this.ip = Integer.toHexString(ip[0]) +":"+
					Integer.toHexString(ip[1]) +":"+
					Integer.toHexString(ip[2]) +":"+
					Integer.toHexString(ip[3]);
		this.state = 0; //0 = active
//		if(mask == 3){
//			this.id = ip[3];
//		}
//		if(mask == 2){
//			this.id = ip[2]*255 + ip[3];
//		}
//		if(mask == 1){
//			this.id = ip[1]*255*255+ip[2]*255 + ip[3];
//		}
	}

}
