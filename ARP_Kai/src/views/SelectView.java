package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jnetpcap.PcapIf;

import models.Model;

public class SelectView extends JPanel {
    
    private JLabel label;
    private JComboBox box;
    private Model model;
    public SelectView(Model m){
	
	model = m;
	label = new JLabel("Select the transmitting Device");
	final Object[] dev = m.getDevices().toArray();
	String[] items = new String[dev.length];
	int i = 0;
	for(Object o : dev){
	    items[i++] = ((PcapIf)o).getName();
	}
	box = new JComboBox(items);
	box.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		
		model.setDevice((PcapIf)dev[box.getSelectedIndex()]);
		
	    }
	});
	this.add(label);
	this.add(box);
    }
}
