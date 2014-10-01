package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Device;

public class Devices extends JPanel {

    private JPanel pc;
    private JPanel printer;
    private JPanel router;
    private JPanel laptop;
    private Device device;
    
    public Devices(Device d) {
	
	this.device = d;
	this.setLayout(new GridLayout(2, 4));
	BufferedImage pic = null;
	try {
	    pic = ImageIO.read(new File("resources/images.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	JLabel pclabel = new JLabel("PC", new ImageIcon(pic),
		JLabel.CENTER);
	pclabel.setVerticalTextPosition(JLabel.BOTTOM);
	pclabel.setHorizontalTextPosition(JLabel.CENTER);
	
	pc = new JPanel();
	pc.setBackground(Color.white);
	pc.add(pclabel);
	
	try {
	    pic = ImageIO.read(new File("resources/images.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	JLabel printerlabel = new JLabel("Printer", new ImageIcon(pic),
		JLabel.CENTER);
	printerlabel.setVerticalTextPosition(JLabel.BOTTOM);
	printerlabel.setHorizontalTextPosition(JLabel.CENTER);
	
	printer = new JPanel();
	printer.setBackground(Color.white);
	printer.add(printerlabel);
	
	try {
	    pic = ImageIO.read(new File("resources/images.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	JLabel routerlabel = new JLabel("Router", new ImageIcon(pic),
		JLabel.CENTER);
	routerlabel.setVerticalTextPosition(JLabel.BOTTOM);
	routerlabel.setHorizontalTextPosition(JLabel.CENTER);
	
	router = new JPanel();
	router.setBackground(Color.white);
	router.add(routerlabel);
	try {
	    pic = ImageIO.read(new File("resources/images.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	JLabel laptoplabel = new JLabel("Router", new ImageIcon(pic),
		JLabel.CENTER);
	laptoplabel.setVerticalTextPosition(JLabel.BOTTOM);
	laptoplabel.setHorizontalTextPosition(JLabel.CENTER);
	
	laptop = new JPanel();
	laptop.setBackground(Color.white);
	laptop.add(laptoplabel);
	
	this.add(pc);
	this.add(printer);
	this.add(router);
	this.add(laptop);
    }	
}
