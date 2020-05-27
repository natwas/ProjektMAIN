package project;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Materials {
	int intHeight; 
	int intWidth;
	private String magnes = "magnes.png";
	private String silver = "silver.png";
	private String gold = "gold.png";
	private String ces = "ces.png";
	Drawpanel drawpanel;

	public Materials(Drawpanel panel) {
		drawpanel = panel;
}
	public void drawMaterial(Graphics2D g2d) {
		
		ComboBox cb = new ComboBox(); 
		String choosenMaterial = cb.choosenMaterial; 
		g2d = (Graphics2D) drawpanel.getGraphics();
			       			
		if (choosenMaterial=="magnes"){	        					    	        		
			g2d.drawImage(getImagemagnes(), 0, 180, null);
		}
		else if (choosenMaterial=="gold"){   			
			g2d.drawImage(getImagegold(), -250, 180, null);
		}
		else if (choosenMaterial=="silver") {
			g2d.drawImage(getImagesilver(), -250, 180, null);
		}
		else if (choosenMaterial=="ces"){      			
			g2d.drawImage(getImageces(), -250, 180, null);
		}
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

}
