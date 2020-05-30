package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Drawpanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	public static Timer gamelooptimer;
	private String magnes = "magnes.png";
	private String silver = "silver.png";
	private String gold = "gold.png";
	private String ces = "ces.png";
	int intHeight; 
	int intWidth;
	String material; 
	
	static PhotoelectricEffect effect; 
	Photon photon; 
	
	public Drawpanel(PhotoelectricEffect pe) {
		
		gamelooptimer = new Timer(15, this);
		effect = pe; 	
		this.setBackground(Color.WHITE);		
		photon = new Photon(); 
	}

	public void drawMaterial(Graphics2D g2d) {
		
		//g2d = (Graphics2D) this.getGraphics();
	
		if (Menu.comboBox.getSelectedItem().equals("magnes")) {
			material = "magnes"; 
			System.out.println(material); 
			g2d.drawImage(getImagemagnes(), 0, 0, this); 				
		}
		else if (Menu.comboBox.getSelectedItem().equals("gold")) {
			g2d.drawImage(getImagegold(), -250, 180, this);
			material = "gold";
			System.out.println(material);
		}
		else if (Menu.comboBox.getSelectedItem().equals("silver")) {
			g2d.drawImage(getImagesilver(), -250, 180, this); 
			material = "silver"; 
			System.out.println(material);
		}
		else if (Menu.comboBox.getSelectedItem().equals("ces")) {	 
			g2d.drawImage(getImageces(), -250, 180, this);
			material = "ces"; 
			System.out.println(material);
		}
	}

	public void actionPerformed(ActionEvent e) {
		photon.move();	
		repaint();
	}


	public Image getImagemagnes() {
		ImageIcon i = new ImageIcon(getClass().getResource(magnes));
		return i.getImage();
	}
	public Image getImagesilver() {
		ImageIcon i = new ImageIcon(getClass().getResource(silver));
		return i.getImage();
	}
	public Image getImagegold()	{
		ImageIcon i = new ImageIcon(getClass().getResource(gold));
		return i.getImage();
	}
	public Image getImageces() {
		ImageIcon i = new ImageIcon(getClass().getResource(ces));
		return i.getImage();
	}
	public void setSize( int intH, int intW) { 
		intHeight = intH; 
		intWidth = intW;
	}

	public void paint(Graphics g){
		//System.out.println("hejka"); 
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		photon.draw(g2d);	
		drawMaterial(g2d); 
	}
}
