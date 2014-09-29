package arp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.Device;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Arp; 

public class Receiver {
	
	PcapIf device;
	PcapPacketHandler<String> jpacketHandler;
	LinkedList<Device> dispositivos = new LinkedList<Device>();
	public Receiver(){
		System.out.println("start");
		List<PcapIf> devices = new ArrayList<PcapIf>(); 
        StringBuilder error = new StringBuilder(); 
        int control = Pcap.findAllDevs(devices, error); 
        if (control == Pcap.NOT_OK || devices.isEmpty()) {  
            System.err.printf("Can't read list of devices, error is %s", error  
                .toString());  
            return;  
        }  
        device = devices.get(2);
        int snaplen = 64 * 1024;           
        int flags = Pcap.MODE_PROMISCUOUS; 
        int timeout = 1000 * 10;     
        Pcap pcap =  
            Pcap.openLive(device.getName(), snaplen, flags, timeout, error);  
  
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
            	if(packet.hasHeader(arp))
                {	
            		
            		all = arp.getByteArray(8, 19);
            		for(int i = 0; i<6 ; i++){
            			mac[i] = all[i];
            			ip[i] = all[i+6];
            		}
            		
            		Device d = new Device(mac, ip);
            		boolean exists = false;
            		for(Device dev: dispositivos){
            			if(dev.getMac().equals(d.getMac())){
            				dev.setIp(d.getIp());
            				exists = true;
            			}
            		}
            		if(!exists) dispositivos.add(d);
            		
            		
                }
            }
        };
        pcap.loop(400, jpacketHandler, "jNetPcap rocks!");  
        pcap.close();
        for(Device d : dispositivos){
        	System.out.println(d.getMac() + "    "+ d.getIp() );
        }
        System.out.println("acabamos");
	}
}
