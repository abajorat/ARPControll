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

import arp.Communicator;
import arp.Operator;

import models.Device;
import models.Model;

public class MainView extends JPanel {

    private JButton arp;
    private JLabel device;
    private JLabel network;
    private JLabel mask;
    private JLabel timePendent;
    private JLabel timeInactive;
    private IconView left;
    private Model model;
    private Communicator com;
    
    public MainView(Model m, Communicator c) {

	this.model = m;
	this.com = c;
	this.setLayout(new GridLayout(1, 2));
	left = new IconView(model);
	this.add(left);
	JPanel right = new JPanel();
	right.setLayout(new GridLayout(4, 1));

	JPanel panel = new DescriptionView(model);
	right.add(panel);

	panel = new JPanel();
	right.add(panel);
	panel = new JPanel();
	right.add(panel);

	panel = new JPanel();
	panel.setLayout(new GridLayout(2, 1));
	arp = new JButton("Sent ARP");
	
	arp.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		Operator op;
		if(model.isFrequent()) {
		    op = new Operator(com,model,0);
		}
		else{
		    op = new Operator(com,model,1);
		}
		op.start();
	    }
	});
	panel.add(new JPanel());
	panel.add(arp);
	right.add(panel);

	this.add(right);

    }

}
