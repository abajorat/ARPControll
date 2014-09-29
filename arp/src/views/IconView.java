package views;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IconView extends JPanel {
	
	
	public IconView(int size){
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(2,2));
		
	}
	
	public void addIcon(String path){
		
		try{
			
			BufferedImage pic = ImageIO.read(new File(path));
			JLabel picLabel = new JLabel(new ImageIcon(pic));
			this.add(picLabel);
		}catch(IOException e){
			System.err.println("Error! " +e.getMessage());
		}
		
	}
	
}
