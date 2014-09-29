package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Device;


public class IconView extends JPanel {
	
	Device device;
	public IconView(Device d, int size){
	    this.device = d;	
	    this.setBackground(Color.WHITE);
	    this.setLayout(new GridLayout(2,2));
		
	}
	
	public void addIcon(String path){
		
		try{
			
			BufferedImage pic = ImageIO.read(new File(path));
			JLabel picLabel = new JLabel("Bla",new ImageIcon(pic),JLabel.CENTER);
			picLabel.setVerticalTextPosition(JLabel.BOTTOM);
			picLabel.setHorizontalTextPosition(JLabel.CENTER);
			picLabel.addMouseListener(new MouseAdapter() {
			    
			    public void mouseClicked(MouseEvent e){
				
				if(e.getButton()==MouseEvent.BUTTON1){
				    
				    if(e.getClickCount()==2){
					JFrame frame = new JFrame(device.getMac());
					DeviceView view = new DeviceView(device);
					frame.setContentPane(view);
					view.setPreferredSize(new Dimension(400,200));
					frame.setLocationRelativeTo(null);
					frame.pack();
					frame.setVisible(true);
				    }
				    
				}
			    }
			    
			});
			this.add(picLabel);
		}catch(IOException e){
			System.err.println("Error! " +e.getMessage());
		}
		
	}
	
}
