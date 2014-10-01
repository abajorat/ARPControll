package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import models.ByteArray;
import models.Model;

public class OptionsView extends JPanel {
;
    private final JTextField bytes1;
    private final JTextField bytes2;
    private final JTextField bytes3;
    private final JTextField bytes4;
    private final JTextField bytes5;
    private final JTextField bytes6;
    private final JTextField bytes7;
    private final JTextField bytes8;
    private final JTextField sec1;
    private final JTextField sec2;
    private JLabel label;
    private JButton button;

     private final Model model;

    public OptionsView(final Model m){

	this.model = m;
	this.setLayout(new BorderLayout());//new FlowLayout(FlowLayout.LEADING, 5, 1));

	JPanel left = new JPanel();
	left.setLayout(new GridLayout(8, 1));
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	panel.add(label);
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	label = new JLabel("Network: ");
	panel.add(label);
	JPanel panel2 = new JPanel();
	panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));
	bytes1 = new JTextField("      ");
	panel2.add(bytes1);
	label = new JLabel(".");
	panel2.add(label);
	bytes2 = new JTextField("      ");
	panel2.add(bytes2);
	label = new JLabel(".");
	panel2.add(label);
	bytes3 = new JTextField("      ");
	panel2.add(bytes3);
	label = new JLabel(".");
	panel2.add(label);
	bytes4 = new JTextField("      ");
	panel2.add(bytes4);
	panel.add(panel2);
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	label = new JLabel("Mask:      ");
	panel.add(label);
	panel2 = new JPanel();
	panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));
	bytes5 = new JTextField("      ");
	panel2.add(bytes5);
	label = new JLabel(".");
	panel2.add(label);
	bytes6 = new JTextField("      ");
	panel2.add(bytes6);
	label = new JLabel(".");
	panel2.add(label);
	bytes7 = new JTextField("      ");
	panel2.add(bytes7);
	label = new JLabel(".");
	panel2.add(label);
	bytes8 = new JTextField("      ");
	panel2.add(bytes8);
	panel.add(panel2);
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 1));
	label = new JLabel("Time pendent: ");
	sec1 = new JTextField("      ");
	panel.add(label);
	panel.add(sec1);
	label = new JLabel("sec");
	panel.add(label);
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 1));
	label = new JLabel("Time inactive:  ");
	sec2 = new JTextField("      ");
	panel.add(label);
	panel.add(sec2);
	label = new JLabel("sec");
	panel.add(label);
	left.add(panel);
	
	left.add(new JPanel());
	button = new JButton("Apply");
	button.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		model.setPendentTime(Integer.parseInt(sec1.getText().replaceAll(" ","")));
		model.setInactiveTime(Integer.parseInt(sec2.getText().replaceAll(" ","")));
		try {

		    String bytes = bytes1.getText().replaceAll(" ", "");
		    bytes += "." + bytes2.getText().replaceAll(" ", "") + "."
			    + bytes3.getText().replaceAll(" ", "") + "."
			    + bytes4.getText().replaceAll(" ", "");
		    model.setNetwork(new ByteArray(bytes,false));
		    bytes = bytes5.getText().replaceAll(" ", "");
		    bytes += "." + bytes6.getText().replaceAll(" ", "") + "."
			    + bytes7.getText().replaceAll(" ", "") + "."
			    + bytes8.getText().replaceAll(" ", "");
		    model.setMask(new ByteArray(bytes,false));
		    System.out.println(bytes);
		} catch (Exception e1) {

		}
	    }
	});
	left.add(button);

	BufferedImage pic = null;
	try {
	    pic = ImageIO.read(new File("resources/logoARP.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	label = new JLabel(new ImageIcon(pic), JLabel.CENTER);
	label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	panel = new JPanel();
	panel.add(left);
	panel.add(new JPanel());
	this.add(panel,BorderLayout.WEST);
	left = new JPanel();
	panel = new DescriptionView(model);
	left.add(panel);
	left.add(label);
	this.add(left,BorderLayout.CENTER);
	//this.add(label,BorderLayout.EAST);
	
	
    }
}
