package views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("Error!");
		}
		JFrame frame = new JFrame("Test");
		MainView view = new MainView();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(view,BorderLayout.CENTER);
		JMenuBar bar;
		JMenu main;
		JMenu options;
		JMenuItem mainItem;
		JMenuItem optionsItem;
		bar = new JMenuBar();
		main = new JMenu("Devices");
		options = new JMenu("Options");
		mainItem = new JMenuItem("Show");
		optionsItem = new JMenuItem("Show");
		
		mainItem.addActionListener(new ActionListener(){

		    @Override
		    public void actionPerformed(ActionEvent e) {
			
			
		    }
		    
		});
		
		optionsItem.addActionListener(new ActionListener(){

		    @Override
		    public void actionPerformed(ActionEvent e) {
			
			
		    }
		    
		});
		
		bar.add(main);
		bar.add(options);
		
		main.add(mainItem);
		options.add(optionsItem);
		
		panel.add(bar,BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(700,300));
		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
