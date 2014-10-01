package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

import models.Device;

public class Icon extends JPanel implements Observer {

    private Device device;

    public Icon(Device d) {

	this.device = d;
	d.addObserver(this);
	this.setBackground(Color.white);
	this.build();
    }

    public void build(){

	try {

	    BufferedImage pic = ImageIO.read(new File(device.getPath()));
	    final JLabel picLabel = new JLabel("Bla", new ImageIcon(pic),
		    JLabel.CENTER);
	    picLabel.setVerticalTextPosition(JLabel.BOTTOM);
	    picLabel.setHorizontalTextPosition(JLabel.CENTER);
	    picLabel.addMouseListener(new MouseAdapter() {

		public void mouseClicked(MouseEvent e) {

		    if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getClickCount() == 2) {
			    JFrame frame = new JFrame(device.getMac().getString());
			    DeviceView view = new DeviceView(device);
			    frame.setContentPane(view);
			    view.setPreferredSize(new Dimension(250, 100));
			    frame.setLocationRelativeTo(null);
			    frame.pack();
			    frame.setVisible(true);
			}

		    }

		    if (e.getButton() == MouseEvent.BUTTON3) {

			class PopMenu extends JPopupMenu {

			    public void addItem(JMenuItem item) {
				this.add(item);
			    }
			}
			;

			PopMenu menu = new PopMenu();
			JMenuItem item1 = new JMenuItem("Change Type");
			JMenuItem item2 = new JMenuItem("Show");
			item1.addActionListener(new ActionListener() {

			    public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame("Devices");
				Devices view = new Devices(device);
				frame.setContentPane(view);
				view.setPreferredSize(new Dimension(250, 400));
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);

			    }
			});
			item2.addActionListener(new ActionListener() {

			    public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame(device.getMac().getString());
				DeviceView view = new DeviceView(device);
				frame.setContentPane(view);
				view.setPreferredSize(new Dimension(250, 100));
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);

			    }
			});
			menu.addItem(item1);
			menu.addItem(item2);
			menu.show(e.getComponent(), e.getX(), e.getY());

		    }
		}

		public void mouseEntered(MouseEvent e) {

		    picLabel.setBorder(BorderFactory.createLineBorder(
			    Color.yellow, 5));

		}

		public void mouseExited(MouseEvent e) {

		    picLabel.setBorder(null);

		}

	    });
	    
	    this.add(picLabel);
	} catch (IOException e) {
	    System.err.println("Error! " + e.getMessage());
	}
    }
    @Override
    public void update(Observable o, Object arg) {
	
	if(((Device)o).getMac().toString().equals(this.device.getMac().toString())){
	    this.removeAll();
	    this.build();
	    this.updateUI();
	}
    }
}
