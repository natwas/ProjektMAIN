package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// panel opcji i komponentów
// Natalia Wasilewska: dzia³anie slidera, konstruktor
// Adam Ignaciuk: ActionListener

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	PhotoelectricEffect effect;
	Photon photon;
	Drawpanel drawPanel = new Drawpanel(effect);  
	Countings countings = new Countings(effect); 	
	JLabel chooseFrequency, label, selectMaterial; 	
	JSlider slider;
	static JTextField text1;
	JTextField frequency;
	JButton changeColor, start, stop, reset;
	static JComboBox<String> comboBox; 
	static final int SLIDER_MIN = 340;
	static final int SLIDER_MAX = 500;
	static final int SLIDER_INIT = 340;
	int wavelenghtValue = SLIDER_INIT;
	int choosenMaterial = 1; 

	MenuAction menuAction = new MenuAction(); 
	Languages languages;
	
	public Menu(PhotoelectricEffect pe) {
		
		effect = pe; 
		this.setLayout(new GridLayout(11,1));		 
		languages = new Languages(this);
		
		comboBox = new JComboBox<String>(); 
		comboBox.addItem("magnes");
		comboBox.addItem("gold");
		comboBox.addItem("silver");
		comboBox.addItem("ces");
		comboBox.setActionCommand("combo"); 
		  		    
		selectMaterial = new JLabel("Select Material"); 
	
		chooseFrequency = new JLabel("Select wave lenght [nm]:"); 
    	
		slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		slider.setBounds(300, 480, 100, 50);
		slider.setPreferredSize(new Dimension(300,100));
		slider.setMajorTickSpacing(40); 
		slider.setMinorTickSpacing(10); 
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 
		slider.addChangeListener(new SliderChangeListener());
		  
		frequency = new JTextField(); 
		frequency.setEditable(false);

		start = new JButton("START");
		start.setActionCommand("start");
		start.setBounds(700, 480, 100, 50);
		start.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		start.addActionListener(menuAction);
		
		stop = new JButton("STOP"); 
		stop.setActionCommand("stop"); 
		stop.addActionListener(menuAction);
		
		reset = new JButton("RESET");
		reset.setActionCommand("reset");
		reset.addActionListener(menuAction);
		
		text1 = new JTextField("0"); //tutaj bêdzie wyswietlac sie energia fotonu 
		text1.setEnabled(false);
	    	
		label = new JLabel("Photon's energy:"); 
	
		this.add(languages.menuBar, GridLayout(1,1));
	    this.add(chooseFrequency, GridLayout(2,1));
	    this.add(slider, GridLayout(3,1) );
	    this.add(frequency, GridLayout(4,1));		
	   	this.add(label, GridLayout(5,1));
	   	this.add(text1, GridLayout(6,1));
	   	this.add(selectMaterial, GridLayout(7,1));
	   	this.add(comboBox, GridLayout(8,1));
	  	this.add(start, GridLayout(9,1));
	  	this.add(reset, GridLayout(10,1));
	   	this.add(stop, GridLayout(11,1)); 		   	
	}


	private Object GridLayout(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public class SliderChangeListener implements ChangeListener { //klasa implemetnuj¹ca dzia³anie slidera//		
		 @Override
		 public void stateChanged(ChangeEvent arg0){
			 String value = String.format("%d nm", slider.getValue());//nadanie sliderowi wartosci poprzez przesuniecie suwaka
			 frequency.setText(value); //wyswietlenie wartosci w okienku tekstowym
			 wavelenghtValue = slider.getValue(); // pobranie wybranej wartosci
			 countings.countEnergy(Menu.this); 
			 revalidate(); //instruuje mened¿era uk³adu, aby ponownie obliczy³ uk³ad 
		  }   
	}


	class MenuAction implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "start") {
				countings.countElectronSpeed(); 
				Drawpanel.gamelooptimer.start();
				slider.setEnabled(false);
				comboBox.setEnabled(false);
			}	 
			else if (e.getActionCommand() == "stop") {
				Drawpanel.gamelooptimer.stop();										
			}
			else if(e.getActionCommand()=="reset") {
				Drawpanel.gamelooptimer.stop();
				Drawpanel.photon.reset(0,0);
				frequency.setText("340 nm");
				text1.setText(" ");
				slider.setValue(340);
				slider.setEnabled(true);
				comboBox.setEnabled(true);	
			}
		}
	}
}

