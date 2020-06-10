package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JFrame;

// tworzenie okna wyskakuj¹cego po naciœniêciu lupy
//Adam Ignaciuk, Natalia Wasilewska: lokalizacja okna

public class Atom extends JFrame {
	
	private static final long serialVersionUID = 1L;
	AtomDrawPanel atomdrawpanel;
	Container container; 
	int width, height; 
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; 
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; 
	
	public Atom () {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(518,661);
		this.setLayout(new BorderLayout());
		this.setResizable(false); 
		width = (screenWidth/2)-(this.getWidth()/2); 
		height = (screenHeight/2)-(this.getHeight()/2);
		this.setLocation(width,height);  //ustawienie okna na œrodku ekranu		
		container = this.getContentPane();
		atomdrawpanel = new AtomDrawPanel();
		container.add(atomdrawpanel);
		atomdrawpanel.setVisible(true);	
		AtomDrawPanel.gamelooptimer.start();
		Drawpanel.gamelooptimer.start(); 
	}
	public static void main(String[] args){
		Atom frame = new Atom();
		frame.setVisible(true);	
	}
}
