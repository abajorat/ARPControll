package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

    public OptionsView(final Model m) {

	this.model = m;
	this.setLayout(new BorderLayout());

	JPanel left = new JPanel();
	left.setLayout(new GridLayout(7, 1));
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	label = new JLabel("Network: ");
	panel.add(label);
	JPanel panel2 = new JPanel();
	panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));
	bytes1 = new JTextField("      ");
	bytes1.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes1.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes1.getText().equals(""))
		    bytes1.setText("      ");
	    }
	});
	panel2.add(bytes1);
	label = new JLabel(".");
	panel2.add(label);
	bytes2 = new JTextField("      ");
	bytes2.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes2.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes2.getText().equals(""))
		    bytes2.setText("      ");
	    }
	});
	panel2.add(bytes2);
	label = new JLabel(".");
	panel2.add(label);
	bytes3 = new JTextField("      ");
	bytes3.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes3.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes3.getText().equals(""))
		    bytes3.setText("      ");
	    }
	});
	panel2.add(bytes3);
	label = new JLabel(".");
	panel2.add(label);
	bytes4 = new JTextField("      ");
	bytes4.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes4.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes4.getText().equals(""))
		    bytes4.setText("      ");
	    }
	});
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
	bytes5.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes5.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes5.getText().equals(""))
		    bytes5.setText("      ");
	    }
	});
	panel2.add(bytes5);
	label = new JLabel(".");
	panel2.add(label);
	bytes6 = new JTextField("      ");
	bytes6.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes6.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes6.getText().equals(""))
		    bytes6.setText("      ");
	    }
	});
	panel2.add(bytes6);
	label = new JLabel(".");
	panel2.add(label);
	bytes7 = new JTextField("      ");
	bytes7.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes7.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes7.getText().equals(""))
		    bytes7.setText("      ");
	    }
	});
	panel2.add(bytes7);
	label = new JLabel(".");
	panel2.add(label);
	bytes8 = new JTextField("      ");
	bytes8.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		bytes8.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (bytes8.getText().equals(""))
		    bytes8.setText("      ");
	    }
	});
	panel2.add(bytes8);
	panel.add(panel2);
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 1));
	label = new JLabel("Time pendent: ");
	sec1 = new JTextField("      ");
	sec1.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		sec1.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (sec1.getText().equals(""))
		    sec1.setText("      ");
	    }
	});
	panel.add(label);
	panel.add(sec1);
	label = new JLabel("sec");
	panel.add(label);
	left.add(panel);

	panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 1));
	label = new JLabel("Time inactive:  ");
	sec2 = new JTextField("      ");
	sec2.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {

		sec2.setText("");

	    }

	    public void focusLost(FocusEvent e) {
		if (sec2.getText().equals(""))
		    sec2.setText("      ");
	    }
	});
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

		if (!sec1.getText().replaceAll(" ", "").equals(""))
		    model.setPendent(Integer.parseInt(sec1.getText()));
		if (!sec2.getText().replaceAll(" ", "").equals(""))
		    model.setInactive(Integer.parseInt(sec2.getText()));
		String bytes = null;
		try {

		    bytes = bytes1.getText();
		    bytes += "." + bytes2.getText() + "." + bytes3.getText()
			    + "." + bytes4.getText();
		    model.setNetwork(new ByteArray(bytes, false));
		} catch (Exception e1) {

		}
		try {
		    bytes = bytes5.getText();
		    bytes += "." + bytes6.getText() + "." + bytes7.getText()
			    + "." + bytes8.getText();
		    model.setMask(new ByteArray(bytes, false));
		} catch (Exception e2) {

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
	this.add(panel, BorderLayout.WEST);
	left = new JPanel();
	panel = new DescriptionView(model);
	left.add(panel);
	left.add(label);
	this.add(left, BorderLayout.CENTER);
	// this.add(label,BorderLayout.EAST);

    }
}
