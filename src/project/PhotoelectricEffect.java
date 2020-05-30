package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;

public class PhotoelectricEffect extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Drawpanel drawPanel;
	Menu menu; 
	
	Container container; 
	
	public int intWidth =1000; 
	public int intHeight = 640;
	String choosenPanel = "choice";
	String choosenMaterial = "choosenMaterial"; 
	static final int promien = 100;

	String ang="en";
	String country="US";
	Locale l1 = new Locale(ang,country);
	ResourceBundle r1 = ResourceBundle.getBundle("project/language_en_ENG",l1);


	public PhotoelectricEffect() {
		
		this.setTitle("Simulation");
		this.setSize(intWidth, intHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // ramka 
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		container = this.getContentPane();
		menu = new Menu(this); 
	    container.add(menu, BorderLayout.LINE_START);
		menu.setVisible(true);
		
		drawPanel = new Drawpanel(this); 
		container.add(drawPanel, BorderLayout.CENTER);
		drawPanel.setVisible(true);
	 		
	}

}
