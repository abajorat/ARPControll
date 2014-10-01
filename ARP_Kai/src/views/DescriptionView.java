package views;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Model;

public class DescriptionView extends JPanel implements Observer {

    private JLabel devicelabel;
    private JLabel network;
    private JLabel mask;
    private JLabel timePendent;
    private JLabel timeInactive;
    private Model model;

    public DescriptionView(Model m) {

	this.model = m;
	m.addObserver(this);
	this.setLayout(new GridLayout(5, 1));
	devicelabel = new JLabel("Device: ");
	network = new JLabel("Network: " + model.getNetwork().getString());
	mask = new JLabel("Mask: " + model.getMask().getString());
	timePendent = new JLabel("Packets until pendent: "
		+ model.getPendent());
	timeInactive = new JLabel("Time until inactive: "
		+ model.getInactive());
	this.add(devicelabel);
	this.add(network);
	this.add(mask);
	this.add(timePendent);
	this.add(timeInactive);
    }

    @Override
    public void update(Observable o, Object arg) {

	if (!((String) arg).equals("Device")) {
	    this.removeAll();
	    devicelabel = new JLabel(model.getDevice().getName());
	    network = new JLabel("Network: " + model.getNetwork().getString());
	    mask = new JLabel("Mask: " + model.getMask().getString());
	    timePendent = new JLabel("Packets until pendent: "
		    + model.getPendent());
	    timeInactive = new JLabel("Time until inactive: "
		    + model.getInactive());
	    this.add(devicelabel);
	    this.add(network);
	    this.add(mask);
	    this.add(timePendent);
	    this.add(timeInactive);
	}

    }
}
