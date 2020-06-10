package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//panel, ktory jest zamieszczony w oknie wyskakuj¹cym po wcisniêciu lupy
//Natalia Wasilewska: actionPerformed, Adam Ignaciuk: konstruktor, metoda paint

public class AtomDrawPanel  extends JPanel implements ActionListener {

	Atom atom;
	Photon photon;
	Electron electron;
	PhotoelectricEffect effect;
	public static Timer gamelooptimer;
	private static final long serialVersionUID = 1L;
	private String background = "/pictures/background1.png";

	public AtomDrawPanel() {
		electron = new Electron(effect);
		photon = new Photon(null); 
		gamelooptimer = new Timer(15, this);
	}

	public void paint(Graphics g) {
		super.paint(g);	
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(), 0, 0, null);
		this.setToolTipText("Electron shell");
		electron.draw(g2d);
		repaint(); 
	}

	public void actionPerformed(ActionEvent e) {	
		electron.moveElectron();	
		electron.movePhoton();
		electron.moveElectron2(); 
		repaint();
	}
	
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
}

