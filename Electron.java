package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//klasa opisujaca ruch fotonu i elektronow po kliknieciu w lupê
//Natalia Wasilewska

public class Electron {
	int intHeight; 
	int intWidth;
	int xElectron,yElectron = 0; 
	double Vx = 1; 
	int xElectron2,yElectron2 = 0; 
	double Vx2 = 1; 
	int xPhoton,yPhoton = 0; 
	double Vxp = 2; 
	AtomDrawPanel atomdrawpanel; 
	Drawpanel drawpanel; 
	Atom atom; 
	PhotoelectricEffect effect; 
	Photon photon; 
	Countings countings = new Countings(effect); 
	private String electron = "/pictures/ele.png";
	private String photon2 = "/pictures/foton.png";
	ImageIcon i;
	
	public Electron(PhotoelectricEffect pe) {
		super();
		effect = pe; 
		photon = new Photon(effect); 
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getImage(), xElectron+240, yElectron+520, null);
		g2d.drawImage(getImage(), xElectron2+150, yElectron2+450, null);
		g2d.drawImage(getImagePhoton(), xPhoton, yPhoton, null);
	}
	
	public Image getImage()	{
		ImageIcon i = new ImageIcon(getClass().getResource(electron));
		return i.getImage();
	}
	
	public Image getImagePhoton()	{
		i = new ImageIcon(getClass().getResource(photon2));
		return i.getImage();
	}
	public void moveElectron() {
		if (xElectron<120){
			xElectron += Vx; 
			yElectron -= Vx;
		}
		else if(xElectron>=120){
			xElectron+=2*Vx;
			yElectron-=9*Vx;
		}
	}
	public void movePhoton() {
		if (xPhoton>-10 && xPhoton<240){
			xPhoton += Vxp; 
			yPhoton += Vxp;
		}
		else if(xPhoton>=240){
			xPhoton = -300; 
			yPhoton = 300;
		} 
		else if (xPhoton == -300) {
			xPhoton = -300;
			yPhoton = -300; 
		}
	}
	public void moveElectron2() {
		if (xElectron2<140){	
			xElectron2 += Vx2; 
			yElectron2 -= Vx2;	
		}
		else if(xElectron2>=140 && xElectron2<170){	
			xElectron2+=2*Vx2;
			yElectron2+=8*Vx2;	
		}
		
		else if(xElectron2>=170 && xElectron<570){		
			xElectron2+=Vx2;
			yElectron2-=Vx2;
		}
		else if(xElectron==570){	
			countings.countElectronSpeed();
			JOptionPane.showConfirmDialog(null,"Elektron zosta³ wybity i poch³on¹³ foton! Prêdkoœæ tego elektronu wynosi: " + countings.electronSpeed + " *10^-9 m/s", "Wybicie" , JOptionPane.DEFAULT_OPTION);
			Drawpanel.gamelooptimer.stop();
			Drawpanel.photon.reset(0,0);
			AtomDrawPanel.gamelooptimer.stop(); 
			//atom.setVisible(false);
			//atom.dispatchEvent(new WindowEvent(atom, WindowEvent.WINDOW_CLOSING));
		}
		
	}
	public void moveElectronAfterClose() {
		yPhoton = photon.y; 
		if (yPhoton<effect.drawPanel.getHeight()-250){
			xElectron+=2*Vx;
			yElectron-=9*Vx; 
		}
		
	/*else if (y==effect.drawPanel.getHeight()-250){
		x=-300;
		y= 300;
	}
	else if (y==-300){
		x=-300;
		y=-300;
	}*/
	}
}
