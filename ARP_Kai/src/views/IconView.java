package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import models.Device;
import models.Model;

public class IconView extends JPanel implements Observer {

    private JScrollPane pane;
    private JPanel panel;
    private LinkedList<Device> devices;
    private Model model;

    public IconView(Model m) {

	this.model = m;
	model.addObserver(this);
	this.devices = model.getDispositivos();
	this.setLayout(new BorderLayout());
	panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setLayout(new GridLayout(0, 3));
	pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	this.add(pane, BorderLayout.CENTER);

	for (Device d : this.devices) {
	    this.addIcon(d);
	}
    }

    public void addIcon(Device d) {

	Icon picLabel = new Icon(d);
	this.panel.add(picLabel);

    }

    @Override
    public void update(Observable o, Object arg) {

	if (((String)arg).equals("Device")) {
	    this.removeAll();
	    for (Device d : this.devices) {
		this.addIcon(d);
	    }
	    this.updateUI();
	}
    }

}
