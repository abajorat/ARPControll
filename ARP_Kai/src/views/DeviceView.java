package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Device;

public class DeviceView extends JPanel {
    
    private Device device;
    private JLabel label;
    private JLabel type;
    private JLabel ip;
    private JLabel mac;
    private JLabel status;
    private JComboBox typebox;
    
    public DeviceView(Device d){
    	this.device = d;
    	this.setLayout(new GridLayout(1,2));
    	
    	BufferedImage pic = null;
		try {
			pic = ImageIO.read(new File(device.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		label = new JLabel(new ImageIcon(pic),JLabel.CENTER);
		
		this.add(label);
		
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(5,1));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		type = new JLabel("Type: ");
		String[] items = {"PC","Laptop","Printer","Router"};
		typebox = new JComboBox(items);
		typebox.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
			
			device.setType(typebox.getSelectedItem().toString());
			
		    }
		});
		panel.add(type);
		panel.add(typebox);
		right.add(panel);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		ip = new JLabel("IP: " + device.getIp());
		panel.add(ip);
		right.add(panel);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		mac = new JLabel("MAC: " + device.getMac());
		panel.add(mac);
		right.add(panel);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		status = new JLabel("Status: " + device.getStatus());
		panel.add(status);
		right.add(panel);
		
		this.add(right);
    }
}
