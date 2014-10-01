package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import models.Device;

public class MainView extends JPanel implements Observer {

    private JButton arp;
    private JLabel device;
    private JLabel network;
    private JLabel mask;
    private JLabel timePendent;
    private JLabel timeInactive;
    private IconView left;
//    private Model model;

    public MainView(){//Model m) {
	
//	this.model = m;
//	this.model.addObserver(this);
	this.setLayout(new GridLayout(1, 2));
	byte[] a = { 1, 2, 3, 2, 1, 3 };
	LinkedList<Device> list = new LinkedList<Device>();
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	list.add(new Device(a, a));
	left = new IconView(list);//model.getDevices());
	this.add(left);
	JPanel right = new JPanel();
	right.setLayout(new GridLayout(4, 1));

	JPanel panel = new DescriptionView();
	right.add(panel);

	panel = new JPanel();
	right.add(panel);
	panel = new JPanel();
	right.add(panel);

	panel = new JPanel();
	panel.setLayout(new GridLayout(2, 1));
	arp = new JButton("Sent ARP");
	panel.add(new JPanel());
	panel.add(arp);
	right.add(panel);

	this.add(right);

    }

    @Override
    public void update(Observable o, Object arg) {
	
	

    }

}
