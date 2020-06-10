package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

//klasa rysujaca i opisuj¹ca ruch fotonu emitowanego przez zród³o œwiat³a
//Adam Ignaciuk

public class Photon {
	PhotoelectricEffect effect; 
	int intHeight; 
	int intWidth;
	int x,y = 0; 
	double Vx=2;
	
	private String photon = "/pictures/foton.png";
	ImageIcon i;	
	public Photon(PhotoelectricEffect pe) {
		super();
		effect = pe; 
	}
	public void move() {
		if (y<effect.drawPanel.getHeight()-250){
			x+=Vx;
			y+=Vx;
		}
		else if (y==effect.drawPanel.getHeight()-250){
			x=-300;
			y= 300;
		}
		else if (y==-300){
			x=-300;
			y=-300;
		}
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getImage(), x-200, y-200, null);
	}
	
	public Image getImage()	{
		i = new ImageIcon(getClass().getResource(photon));
		return i.getImage();
	}
	public void setSize( int intH, int intW) { 
		intHeight = intH; 
		intWidth = intW;
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y;
	}
	public void reset(int x1, int y1) {		
		x = x1;
		y = y1;
			
	}
	
}
