package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	PhotoelectricEffect effect;
	Drawpanel drawPanel; 
	Countings countings; 
	
	JLabel chooseFrequency; 
	JMenuBar menuBar;
	JMenu menu, language;
	JMenuItem menuSave, menuNewFile, polish, english, rus, german, creators, instruction; 
	JSlider slider;
	static JTextField text1;
	JTextField frequency;
	JButton selectMaterial, changeColor, start, stop;
	static JComboBox<String> comboBox; 
	static final int SLIDER_MIN = 300;
	static final int SLIDER_MAX = 800;
	static final int SLIDER_INIT = 300;
	static int frequencyValue = SLIDER_INIT;
	int choosenMaterial = 1; 
	
	MenuAction menuAction = new MenuAction(); 

	public Menu(PhotoelectricEffect pe) {
		
		effect = pe; 
		
		this.setLayout(new GridLayout(10,1));		
		menuBar = new JMenuBar();		
		menu = new JMenu("Menu");
		 
		menuSave=new JMenuItem(/*r1.getString(*/("menuZapisz")); 
		menuSave.setActionCommand("zapisz");
		menuSave.addActionListener(menuAction);
		  
		menuNewFile =new JMenuItem(/*r1.getString*/("menuNowyplik"));
		menuNewFile.setActionCommand("nowyplik");
		menuNewFile.addActionListener(menuAction);
		    
		menu.add(menuSave);
		menu.add(menuNewFile);
		menuBar.add(menu);
		
		comboBox = new JComboBox<String>(); 
		comboBox.addItem("magnes");
		comboBox.addItem("gold");
		comboBox.addItem("silver");
		comboBox.addItem("ces");
		comboBox.setActionCommand("combo"); 
		  		    
		JLabel selectMaterial = new JLabel(/*r1.getString*/("selectMaterial"));    		
		chooseFrequency = new JLabel("Wybierz czêstotliwoœæ [nHz]:"); 
	    	
		slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		slider.setBounds(300, 480, 100, 50);
		slider.setPreferredSize(new Dimension(300,100));
		slider.setMajorTickSpacing(100); 
		slider.setMinorTickSpacing(25); 
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 
		slider.addChangeListener(new SliderChangeListener());
		  
		frequency = new JTextField(); 

		start = new JButton("START");
		start.setActionCommand("start");
		start.setBounds(700, 480, 100, 50);
		start.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		start.addActionListener(menuAction);
		
		stop = new JButton("STOP"); 
		stop.setActionCommand("stop"); 
		stop.addActionListener(menuAction);
		
		text1 = new JTextField("0"); //tutaj bêdzie wyswietlac sie energia fotonu 
	    	
		JLabel label = new JLabel("Energia fotonu:"); 
	    this.add(chooseFrequency, GridLayout(1,1));
	    this.add(slider, GridLayout(2,1) );
	    this.add(frequency, GridLayout(3,1));		
	   	this.add(label, GridLayout(4,1));
	   	this.add(text1, GridLayout(5,1));
	   	this.add(selectMaterial, GridLayout(6,1));
	   	this.add(start, GridLayout(8,1));
	   	this.add(comboBox, GridLayout(9,1));
	   	this.add(stop, GridLayout(10,1)); 			
	}


	private Object GridLayout(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}


	public class SliderChangeListener implements ChangeListener { //klasa implemetnuj¹ca dzia³anie slidera//		
		 @Override
		 public void stateChanged(ChangeEvent arg0){
			 String value = String.format("%d nHz", slider.getValue());//nadanie sliderowi wartosci poprzez przesuniecie suwaka
			 frequency.setText(value); //wyswietlenie wartosci w okienku tekstowym
			 frequencyValue = slider.getValue(); // pobranie wybranej wartosci
			// countings.countEnergy(); //cos tu nie dziala xd
		  }   
	}


	class MenuAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "zapisz") {
				BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = image.createGraphics();
				drawPanel.paintAll(g2d);
				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", "png");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File outputFile = new File(chooser.getSelectedFile().getAbsolutePath() + ".png");
					try {
						ImageIO.write(image, "png", outputFile);
					} 
					catch (IOException exception) {
						System.out.println(exception.getMessage());
					 } 	
			} 
        
				else if (e.getActionCommand() == "nowyplik") {				
					JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());	
					FileNameExtensionFilter typeFilter = new FileNameExtensionFilter("PNG images", "png");
					fileChooser.setFileFilter(typeFilter);
					int returnValue = fileChooser.showOpenDialog(null);
					if(returnValue == JFileChooser.APPROVE_OPTION) {
						File inputFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
						try {
						
						image = ImageIO.read(inputFile);
						Graphics g = drawPanel.getGraphics();
						g.drawImage(image, 0, 0, null);
						}
						catch(IOException ex) {
							System.out.println(ex.getMessage());
						}			
					} 
					else if (e.getActionCommand() == "start") {
						//countElectronSpeed(); 
						//System.out.println("Photon energy:" + photonEnergy);  			
						Drawpanel.gamelooptimer.start();
											}	 

					else if (e.getActionCommand() == "stop") {
						System.exit(0);
					} 
					else if (e.getActionCommand() == "combo") {
						drawPanel.drawMaterial(null); 
					}
				}
			}
		}
	}
}

