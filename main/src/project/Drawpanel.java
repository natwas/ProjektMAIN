package project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Drawpanel extends JPanel implements ActionListener{
private static final long serialVersionUID = 1L;
public static Timer gamelooptimer;
Photon photon = new Photon(0,0);
Materials material = new Materials(this);
public Drawpanel() {
	gamelooptimer = new Timer(15, this);
}
public void paint(Graphics g){
	super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	photon.draw(g2d);	
	material.drawMaterial(g2d);
	
}


public void actionPerformed(ActionEvent e) {
	photon.move();	
	//material.drawmagnes();
	repaint();
	}

}

