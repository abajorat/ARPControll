package views;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import models.Device;


public class MainView extends JPanel {
	
	JButton arp;
	JLabel network;
	JLabel timePendent;
	JLabel timeInactive;
	IconView left;
	
	
	public MainView(){
		
		this.setLayout(new GridLayout(1,2));
		byte[] a = {1,2,3,2,1,3};
		left = new IconView(new Device(a,a),20);
		this.add(left);
		left.addIcon("/home/kai/Pictures/images.png");
		left.addIcon("/home/kai/Pictures/images.png");
		left.addIcon("/home/kai/Pictures/images.png");
		left.addIcon("/home/kai/Pictures/images.png");
		left.addIcon("/home/kai/Pictures/images.png");
		left.addIcon("/home/kai/Pictures/images.png");
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(2,1));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		network = new JLabel("Network: 192.168.0.0");
		timePendent = new JLabel("Time until pendent: 5sec");
		timeInactive = new JLabel("Time until inactive: 10sec");
		panel.add(network);
		panel.add(timePendent);
		panel.add(timeInactive);
		right.add(panel);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		arp = new JButton("Sent ARP");
		panel.add(new JPanel());
	//	panel.add(new JPanel());
		panel.add(arp);
		right.add(panel);
		
		this.add(right);
		
		
	}
	
	
}
