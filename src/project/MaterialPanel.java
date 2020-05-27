package project;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MaterialPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public MaterialPanel() {
	
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//material.drawMaterial(g2d);	
	}
	public void setBounds() {
	
	}
}
