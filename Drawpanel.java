package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;

//panel, w którym rysuje siê animacja
//Adam Ignaciuk: konstruktor, metody getImage
//Natalia Wasilewska: MouseListener, metoda paint, draw

public class Drawpanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	public static Timer gamelooptimer;
	String magnes = "/pictures/magnes1.png";
	String silver = "/pictures/silver1.png";
	String gold = "/pictures/gold1.png";
	String ces = "/pictures/ces1.png";
	String magnifier = "/pictures/magnifier.png";
	String cloud = "/pictures/chat.png"; 
	String reflector = "/pictures/reflector.png";
	int intHeight; 
	int intWidth;
	String material; 
	static PhotoelectricEffect effect; 
	static Photon photon;
	static Electron electron;
	static ImageIcon i; 
	int xElectron,yElectron = 0; 
	double Vx = 1; 

	public Drawpanel(PhotoelectricEffect pe) {	
		gamelooptimer = new Timer(15, this);
		effect = pe; 	
		this.setBackground(Color.WHITE);		
		photon = new Photon(effect); 	
		electron = new Electron(effect); 
		MouseListener mouse = new MouseListener();
	    this.addMouseListener(mouse);		
	}

	public void drawMaterial(Graphics2D g2d) {

		if (Menu.comboBox.getSelectedItem().equals("magnes")) {
			g2d.drawImage(getImagemagnes(), this.getWidth()/2-537/2, this.getHeight()-275,  this); 				
		}
		else if (Menu.comboBox.getSelectedItem().equals("gold")) {
			g2d.drawImage(getImagegold(), this.getWidth()/2-537/2, this.getHeight()-275,  this); 
		}
		else if (Menu.comboBox.getSelectedItem().equals("silver")) {
			g2d.drawImage(getImagesilver(),this.getWidth()/2-537/2,this.getHeight()-275,  this); 
		}
		else if (Menu.comboBox.getSelectedItem().equals("ces")) {	 
			g2d.drawImage(getImageces(),this.getWidth()/2-537/2,this.getHeight()-275,  this); 
		}
	}

	public void actionPerformed(ActionEvent e) {
		//electron.moveElectronAfterClose();
		photon.move();
 		repaint();
	
	}

	public Image getImagemagnes() {
		i = new ImageIcon(getClass().getResource(magnes));
		return i.getImage();
	}
	public Image getImagesilver() {
		i = new ImageIcon(getClass().getResource(silver));
		return i.getImage();
	}
	public Image getImagegold()	{
		i = new ImageIcon(getClass().getResource(gold));
		return i.getImage();
	}
	public Image getImageces() {
		i = new ImageIcon(getClass().getResource(ces));
		return i.getImage();
	}
	
	public Image getImageReflector() {
		i = new ImageIcon(getClass().getResource(reflector));
		return i.getImage();		 
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		xElectron = electron.xElectron; 
		yElectron = electron.yElectron; 
		g.drawImage(getImageReflector(), 0 , 20, this);
		photon.draw(g2d);
		drawMaterial(g2d);
		repaint();
		if(photon.getY()==this.getHeight()-249) {
			g.drawImage(getImageMagnifier(), this.getWidth()/2-140, this.getHeight()-350, this);
			g.drawImage(getImageCloud(), this.getWidth()/2, this.getHeight()-580, this);	
			repaint();
		}
		else if(photon.getY()>this.getHeight()-249) {
			//g.drawImage(electron.getImage(),xElectron+this.getWidth()/2-53, yElectron+this.getHeight()-268, this);
			repaint();
		}
	}

	public Image getImageMagnifier() {
		i = new ImageIcon(getClass().getResource(magnifier));
		return i.getImage();
	} 
	
	public Image getImageCloud() {
		i = new ImageIcon(getClass().getResource(cloud));
		return i.getImage();		 
	}

	class MouseListener extends MouseInputAdapter {
		public void mousePressed(MouseEvent e) {
			if(e.getX()>Drawpanel.this.getWidth()/2-80 && e.getY()>Drawpanel.this.getHeight()-380 && e.getX()<Drawpanel.this.getWidth()/2+80 && e.getY()<Drawpanel.this.getHeight()-250 ){ 
				Atom frame = new Atom();
				frame.setVisible(true);
	        }
		}
	}
}
