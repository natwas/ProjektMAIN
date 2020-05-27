package project;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Photon extends Coordinates{
	int intHeight; 
	int intWidth;
	private String photon = "foton.png";
	
	public Photon(int x, int y) {
		super(x, y);
	}
	public void move() {
		x++;
		y++;
	}
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getImage(), x-100, y-200, null);
	}
	
	public Image getImage()	{
		ImageIcon i = new ImageIcon(getClass().getResource(photon));
		return i.getImage();
	}
	public void setSize( int intH, int intW) { 
		intHeight = intH; 
		intWidth = intW;
	}

}
