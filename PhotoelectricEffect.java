package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.BorderLayout;
import java.awt.Container;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//klasa g³ówna, w niej tworzymy obiekty pozosta³ych klas
//Natalia Wasilewska: konstruktor, Adam Ignaciuk:muzyka

public class PhotoelectricEffect extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Drawpanel drawPanel;
	Menu menu; 
	Container container; 
	URL audioUrl;
	AudioInputStream audio; 
	Clip music;
	
	public int intWidth =1000; 
	public int intHeight = 640;
	String choosenPanel = "choice";
	String choosenMaterial = "choosenMaterial"; 
	static final int promien = 100;
	FloatControl gain;
	public PhotoelectricEffect() {
		
		this.setTitle("Simulation");
		this.setSize(intWidth, intHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setIconImage(new ImageIcon(getClass().getResource("/pictures/icon.png")).getImage());
 
		container = this.getContentPane();
		menu = new Menu(this); 
	    container.add(menu, BorderLayout.LINE_START);
		menu.setVisible(true);
		
		drawPanel = new Drawpanel(this); 
		container.add(drawPanel, BorderLayout.CENTER);
		drawPanel.setVisible(true);
	
		try {
			audioUrl = getClass().getResource("/pictures/chemia.wav");
		    audio = AudioSystem.getAudioInputStream(audioUrl);
		    music = AudioSystem.getClip();
		    music.open(audio);
		    music.loop(-1);
		    music.start();
		   
		    FloatControl gain = (FloatControl)music.getControl(FloatControl.Type.MASTER_GAIN);
		    gain.setValue(-35);
		} 
		catch (Exception e) {
		}

	}

}
