package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import arp.Communicator;

import models.Model;

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
	
	
	Model model = new Model();
	Communicator com = new Communicator(model);
	JFrame frame = new JFrame("Main");
	MainView view = new MainView(model);
	JPanel panel = new JPanel();
	final JPanel panel2 = new JPanel();
	final CardLayout card = new CardLayout();
	panel2.setLayout(card);
	panel.setLayout(new BorderLayout());
	panel.add(panel2, BorderLayout.CENTER);
	panel2.add(view, "main");
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

	mainItem.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		card.show(panel2, "main");

	    }

	});

	optionsItem.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		card.show(panel2, "options");

	    }

	});

	bar.add(main);
	bar.add(options);

	main.add(mainItem);
	options.add(optionsItem);

	panel.add(bar, BorderLayout.NORTH);
	panel.setPreferredSize(new Dimension(700, 300));
	OptionsView view2 = new OptionsView(model);
	panel2.add(view2, "options");
	card.show(panel2, "options");
	frame.setContentPane(panel);
	frame.setLocationRelativeTo(null);
	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame = new JFrame("Select");
	SelectView select = new SelectView(model);
	JDialog dialog = new JDialog(frame, Dialog.ModalityType.DOCUMENT_MODAL);
	dialog.add(select);
	frame.setContentPane(select);
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setSize(200, 100);
	frame.setVisible(true);
    }

}
