package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Device;

public class Devices extends JPanel {

    private JPanel pc;
    private JPanel printer;
    private JPanel router;
    private JPanel laptop;
    private Device device;
    private JLabel pclabel;
    private JLabel laptoplabel;
    private JLabel routerlabel;
    private JLabel printerlabel;
    private JFrame frame;
    public Devices(Device d, JFrame f) {

	this.device = d;
	this.frame = f;
	this.setLayout(new GridLayout(2, 4));
	BufferedImage pic = null;
	try {
	    pic = ImageIO.read(new File("resources/images.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	pclabel = new JLabel("Pc", new ImageIcon(pic), JLabel.CENTER);
	pclabel.setVerticalTextPosition(JLabel.BOTTOM);
	pclabel.setHorizontalTextPosition(JLabel.CENTER);

	pc = new JPanel();
	pc.setBackground(Color.white);
	pc.add(pclabel);
	pc.addMouseListener(new MouseAdapter() {

	    public void mouseClicked(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {
		    if (e.getClickCount() == 2) {
			device.setType(pclabel.getText());
			frame.setVisible(false);
			frame.dispose();
		    }
		}

	    }

	    public void mouseEntered(MouseEvent e) {

		pclabel.setBorder(BorderFactory.createLineBorder(Color.yellow,
			5));

	    }

	    public void mouseExited(MouseEvent e) {

		pclabel.setBorder(null);

	    }
	});
	try {
	    pic = ImageIO.read(new File("resources/printer.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	printerlabel = new JLabel("Printer", new ImageIcon(pic), JLabel.CENTER);
	printerlabel.setVerticalTextPosition(JLabel.BOTTOM);
	printerlabel.setHorizontalTextPosition(JLabel.CENTER);

	printer = new JPanel();
	printer.setBackground(Color.white);
	printer.add(printerlabel);
	printer.addMouseListener(new MouseAdapter() {

	    public void mouseClicked(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {
		    if (e.getClickCount() == 2) {
			device.setType(printerlabel.getText());
			frame.setVisible(false);
			frame.dispose();
		    }
		}

	    }

	    public void mouseEntered(MouseEvent e) {

		printerlabel.setBorder(BorderFactory.createLineBorder(Color.yellow,
			5));

	    }

	    public void mouseExited(MouseEvent e) {

		printerlabel.setBorder(null);

	    }
	});
	try {
	    pic = ImageIO.read(new File("resources/router.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	routerlabel = new JLabel("Router", new ImageIcon(pic), JLabel.CENTER);
	routerlabel.setVerticalTextPosition(JLabel.BOTTOM);
	routerlabel.setHorizontalTextPosition(JLabel.CENTER);

	router = new JPanel();
	router.setBackground(Color.white);
	router.add(routerlabel);
	router.addMouseListener(new MouseAdapter() {

	    public void mouseClicked(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {
		    if (e.getClickCount() == 2) {
			device.setType(routerlabel.getText());
			frame.setVisible(false);
			frame.dispose();
		    }
		}

	    }

	    public void mouseEntered(MouseEvent e) {

		routerlabel.setBorder(BorderFactory.createLineBorder(Color.yellow,
			5));

	    }

	    public void mouseExited(MouseEvent e) {

		routerlabel.setBorder(null);

	    }
	});
	try {
	    pic = ImageIO.read(new File("resources/laptop.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	laptoplabel = new JLabel("Router", new ImageIcon(pic), JLabel.CENTER);
	laptoplabel.setVerticalTextPosition(JLabel.BOTTOM);
	laptoplabel.setHorizontalTextPosition(JLabel.CENTER);

	laptop = new JPanel();
	laptop.setBackground(Color.white);
	laptop.add(laptoplabel);
	laptop.addMouseListener(new MouseAdapter() {

	    public void mouseClicked(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {
		    if (e.getClickCount() == 2) {
			device.setType(laptoplabel.getText());
			frame.setVisible(false);
			frame.dispose();
		    }
		}

	    }

	    public void mouseEntered(MouseEvent e) {

		laptoplabel.setBorder(BorderFactory.createLineBorder(Color.yellow,
			5));

	    }

	    public void mouseExited(MouseEvent e) {

		laptoplabel.setBorder(null);

	    }
	});
	this.add(pc);
	this.add(printer);
	this.add(router);
	this.add(laptop);
    }
}
