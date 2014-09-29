 import java.util.ArrayList;  
import java.util.List;  

import org.jnetpcap.Pcap;  
import org.jnetpcap.PcapHeader;
import org.jnetpcap.PcapIf;  
import org.jnetpcap.packet.PcapPacket;  
import org.jnetpcap.packet.PcapPacketHandler;  
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.protocol.network.Ip4;

import arp.Receiver;
      
     
    public class Main {  
      
     
 
		public static void main(String[] args) {  
			Receiver r =new Receiver();
			System.out.println("hallo");
		//	r.start(400);
			r.send();
		}

    }  
