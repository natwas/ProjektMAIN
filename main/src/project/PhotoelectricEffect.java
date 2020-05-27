package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class PhotoelectricEffect extends JFrame {
	private static final long serialVersionUID = 1L;

	Drawpanel drawPanel;
	MaterialPanel MaterialPanel;
	JPanel buttonPanel;
	Materials materials;
	Image img;
	
	public int intWidth =1000; 
	public int intHeight = 640;
		
	JMenuBar menuBar;
	JMenu menu, language;
	JMenuItem menuSave, menuNewFile, polish, english, rus, german, creators, effect, instruction; 
	JSlider slider;
	JTextField text1, frequency;
	JButton selectMaterial, changeColor, start, magnes, ces, silver, gold;
	static final int SLIDER_MIN = 300;
	static final int SLIDER_MAX = 800;
	static final int SLIDER_INIT = 300;
	static int frequencyValue = SLIDER_INIT;
	String choosenPanel = "choice";
	String choosenMaterial = "choosenMaterial"; 
	//Deklaracje do rysowania 
	static final int promien = 100;
	public JLabel chooseFrequency; 
	BufferedImage image1 = null;
	BufferedImage image2; 
	
	JComboBox<String> comboBox; 

	String ang="en";
	String country="US";
	Locale l1 = new Locale(ang,country);
	ResourceBundle r1 = ResourceBundle.getBundle("project/language_en_ENG",l1);
//do obliczania energii fotonu
	static final double exitWorkCes = 3.42;  //[J], 2.14 eV
	static final double exitWorkSilver = 6.81; //[J], 4.26 eV
	static final double exitWorkGold = 8.16; //[J], 5.1eV
	static final double exitWorkMagnes = 5.85; //[J],3.66 eV

	static final double planck = 0.00000000000000662; 	//tutaj 6,62 jest przemno¿ona przez 10^-15, aby otrzymana liczba by³a
															// równa 6,62*10^-19 (bo cala stala plancka jest *10^-34)
													//, poniewaz przy liczeniu predkosci elektronu
													// musimy odjac od energi fotonu prace wyjscia, ktora wyrazona jest w elektronowoltach zamienionych na d¿ule, 
													// wiec ich wartoœc to x*10^-19. 
	static final double electronMass = 0.00000000000910;//*10^-31, tutaj to samo, skalujemy przez 10^-12 aby ta wartosc byla *10^-19

	double photonEnergy, x, y, electronSpeed; //energia fotonu wyrazona w J
	BufferedImage image;

	public PhotoelectricEffect() {
		this.setTitle("Simulation");
		this.setSize(intWidth, intHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // ramka 
		this.setVisible(true);
		this.setLayout(new BorderLayout()); 
		
		menuBar = new JMenuBar();		
		menu = new JMenu("Menu");
		 
		 menuSave=new JMenuItem(r1.getString("menuZapisz")); 
		    menuSave.setActionCommand("zapisz");
		    menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				}
		  });
				
				
		    menuNewFile =new JMenuItem(r1.getString("menuNowyplik"));
		    menuNewFile.setActionCommand("nowyplik");
		    menuNewFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", "png");
					chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						BufferedImage image = null;
						File inputFile = new File(chooser.getSelectedFile().getAbsolutePath());
						try {
							image = ImageIO.read(inputFile);
							Graphics g = drawPanel.getGraphics();
							g.drawImage(image, 0, 0, null);
						}
						catch(IOException ex) {
							System.out.println(ex.getMessage());
			            }

					 }	
					
				}
		    	
		    });
		    
		    
		    menu.add(menuSave);
		    menu.add(menuNewFile);
				
		    language=new JMenu(r1.getString("language"));
		    
		    polish=new JMenuItem("PL");
		    polish.setActionCommand("polish");
		    polish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pol="pl";
				String kraj="PL";
				Locale l2 = new Locale(pol,kraj);
				ResourceBundle r2 = ResourceBundle.getBundle("project/language_pl_PL",l2);
				language.setText(r2.getString("language"));
				frequency.setText(r2.getString("frequency"));
				menuSave.setText(r2.getString("menuZapisz"));
				menuNewFile.setText(r2.getString("menuNowyplik"));
				magnes.setText(r2.getString("magnes"));
				ces.setText(r2.getString("ces"));
				gold.setText(r2.getString("gold"));
				silver.setText(r2.getString("silver"));
				changeColor.setText(r2.getString("Tlo"));
				effect.setText(r2.getString("effect"));
				//selectMaterial.setText(r2.getString("selectMaterial"));	
				}	
		    });	
		    english=new JMenuItem("ENG");
		    english.setActionCommand("english");
		    english.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					language.setText(r1.getString("language"));
					frequency.setText(r1.getString("frequency"));
					menuSave.setText(r1.getString("menuZapisz"));
					menuNewFile.setText(r1.getString("menuNowyplik"));
					magnes.setText(r1.getString("magnes"));
					ces.setText(r1.getString("ces"));
					gold.setText(r1.getString("gold"));
					silver.setText(r1.getString("silver"));
					changeColor.setText(r1.getString("Tlo"));
					effect.setText(r1.getString("effect"));
					//selectMaterial.setText(r1.getString("selectMaterial"));	
				}	
		    });	
		    rus=new JMenuItem("RUS");
		    rus.setActionCommand("rus");
		    rus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ru="ru";
					String kraj="RUS";
					Locale l3 = new Locale(ru,kraj);
					ResourceBundle r3 = ResourceBundle.getBundle("project/language_ru_RUS",l3);
					language.setText(r3.getString("language"));
					frequency.setText(r3.getString("frequency"));
					menuSave.setText(r3.getString("menuZapisz"));
					menuNewFile.setText(r3.getString("menuNowyplik"));
					magnes.setText(r3.getString("magnes"));
					ces.setText(r3.getString("ces"));
					gold.setText(r3.getString("gold"));
					silver.setText(r3.getString("silver"));
					changeColor.setText(r3.getString("Tlo"));
					//selectMaterial.setText(r3.getString("selectMaterial"));	
				}
		    });
				
		    german=new JMenuItem("GE");
		    german.setActionCommand("german");
		    german.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ge="ge";
					String kraj="GE";
					Locale l4 = new Locale(ge,kraj);
					ResourceBundle r4 = ResourceBundle.getBundle("project/language_ge_GE",l4);
					language.setText(r4.getString("language"));
					//frequency.setText(r4.getString("frequency"));
					menuSave.setText(r4.getString("menuZapisz"));
					menuNewFile.setText(r4.getString("menuNowyplik"));
					magnes.setText(r4.getString("magnes"));
					ces.setText(r4.getString("ces"));
					gold.setText(r4.getString("gold"));
					silver.setText(r4.getString("silver"));
					changeColor.setText(r4.getString("Tlo"));
					effect.setText(r4.getString("effect"));
					//selectMaterial.setText(r4.getString("selectMaterial"));
					
				} 	
		    });
		    
		    
		    language.add(english);
		    language.add(polish);
		    language.add(rus);
		    language.add(german); 
		
		    menuBar.add(menu);
		    menuBar.add(language);
		
			drawPanel = new Drawpanel();
			drawPanel.setLayout(new BorderLayout());
			drawPanel.setBounds(0, 0, intWidth, intHeight-215);
			drawPanel.setBackground(Color.white);
	

			MaterialPanel = new MaterialPanel();
			MaterialPanel.setBounds(-250, 180,-250, 180);
		

			buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(10,1));
			//buttonPanel.setSize(intWidth, intHeight);
	 
			this.add(drawPanel, BorderLayout.CENTER);
			this.add(buttonPanel, BorderLayout.LINE_START);
			this.add(MaterialPanel, BorderLayout.LINE_END);
			this.setJMenuBar(menuBar);
	        
	        JLabel selectMaterial = new JLabel(r1.getString("selectMaterial")); 
	            		
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

	    	start = new JButton("START/STOP");
	    	start.setActionCommand("start");
	    	start.setBounds(700, 480, 100, 50);
	    	start.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	start.addActionListener(new ActionListener() 		 
	    	{
	    		@Override
	    		public void actionPerformed(ActionEvent e) 
	    		{
	    			//countElectronSpeed(); 
	    		    //	System.out.println("Photon energy:" + photonEnergy); 
	    			
	    			Drawpanel.gamelooptimer.start();
	    			//materials.drawmagnes(g2d);
	    			
	    		}
	    	});
	    	
	    	text1 = new JTextField("0"); //tutaj bêdzie wyswietlac sie energia fotonu 
	    	
	    	JLabel label = new JLabel("Energia fotonu:"); 
	    	buttonPanel.add(chooseFrequency, GridLayout(1,1));
	    	buttonPanel.add(slider, GridLayout(2,1) );
	    	buttonPanel.add(frequency, GridLayout(3,1));		
	    	buttonPanel.add(label, GridLayout(4,1));
	    	buttonPanel.add(text1, GridLayout(5,1));
	    	buttonPanel.add(selectMaterial, GridLayout(6,1));
	    	buttonPanel.add(start, GridLayout(8,1));
	    	ComboBox cb = new ComboBox(); 
	    	buttonPanel.add(cb); 
			
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
			 countEnergy(); //liczenie energii na podstawie wybranej wartosci czestotliwosci ze slidera
		  }
	   
	}
	

	void countEnergy() {
		
		photonEnergy = planck*frequencyValue; 
		DecimalFormat df=new DecimalFormat("######.##"); 
		y= photonEnergy*1000000000*1000;//wprowadzam now¹ zmienn¹, któr¹ przeskalujê na potrzeby wyœwietlenia energii
		//nie chce zeby zmieniala ona rz¹d w liczeniu ni¿ej prêdkoœci, wiec nie uzywam oryginalnej zmiennej photonEnergy
		//przemnozono przez taka wartosc, aby wyswietlila sie sama liczba, bo gdy wynik jest
		//za daleko po przecinku, to liczba sie nie chce wyswietlic w polu tekstowym
		//dodatkowo sam wynik jest rzedu 10^-19, wiec aby zgadzal sie rzad bierzemy rz¹d wyniku i mnozymy jeszcze przez
		//rz¹d, ktory sztucznie dodalismy na potrzeby mozliwosci wyswietlenia (10^-12) (pomniejszamy o tyle, bo tyle ddoalismy sztucznie)
		text1.setText(df.format(y) + "x10^-31 J");		
	}
	void countElectronSpeed() { //liczenie prêdkoœci wybitego elektronu w zale¿noœci od pracy wyjscia wybranego materia³u
		
		 if (choosenMaterial == "ces") {		 
			 
			 x = (2*(photonEnergy - exitWorkCes))/electronMass;//tutaj wszystkie liczby sa rzêdu 10^-19,wiec wynik bedzie po prostu x
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 
			 		 		
		 }
			 
		 else if (choosenMaterial == "gold"){
			 			
			 x = (2*(photonEnergy - exitWorkGold))/electronMass; 
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 
		 }
		 
		 else if (choosenMaterial == "silver"){
			 
			 x = (2*(photonEnergy - exitWorkSilver))/electronMass; 
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 
			 
		 } 
		 
		 else if (choosenMaterial == "magnes"){
			 
			 x = (2*(photonEnergy - exitWorkMagnes))/electronMass; 
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 
			 
		 }
	}
}
