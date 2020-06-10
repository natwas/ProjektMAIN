package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.text.DecimalFormat;
import javax.swing.JTextField;

//obliczenia - forma - Natalia Wasilewska, wartoœci matematyczne - Adam Ignaciuk

public class Countings {
	
	PhotoelectricEffect effect; 
	Menu menu; 	
	JTextField text; 	
	static final double exitWorkCes = 3.42;  //[J], 2.14 eV
	static final double exitWorkSilver = 6.81; //[J], 4.26 eV
	static final double exitWorkGold = 8.16; //[J], 5.1eV
	static final double exitWorkMagnes = 5.85; //[J],3.66 eV
	static final double planck = 6.62*(10^(-31)); 	
	static final double electronMass = 9.10*(10^(-34));
	static final double lightspeed = 3*10^8;
	double photonEnergy, x, y, electronSpeed, wave, freq; //energia fotonu wyrazona w J
	
	public Countings (PhotoelectricEffect pe) {	
		effect = pe; 
	}
		
	void countEnergy(Menu menu) {
		wave = menu.slider.getValue(); 
		freq=(lightspeed/wave*(10^(-9)));
		photonEnergy = planck*freq; 
		DecimalFormat df=new DecimalFormat("######.##"); 
		text = Menu.text1; 
		text.setText(df.format(photonEnergy) + "*10^-19 J");		
	}
	void countElectronSpeed() { //liczenie prêdkoœci wybitego elektronu w zale¿noœci od pracy wyjscia wybranego materia³u
		 if (Menu.comboBox.getSelectedItem().equals("magnes")) {	 
			 x = (2*(photonEnergy - exitWorkCes))/electronMass;
			 electronSpeed = Math.sqrt(x)*0.1;  		 		
		 }		 
		 else if (Menu.comboBox.getSelectedItem().equals("gold")){
			 x = (2*(photonEnergy - exitWorkGold))/electronMass; 
			 electronSpeed = Math.sqrt(x)*0.1;  
		 }		 
		 else if (Menu.comboBox.getSelectedItem().equals("silver")){	 
			 x = (2*(photonEnergy - exitWorkSilver))/electronMass; 
			 electronSpeed = Math.sqrt(x)*0.1; 	 
		 } 		 
		 else if (Menu.comboBox.getSelectedItem().equals("ces")){		 
			 x = (2*(photonEnergy - exitWorkMagnes))/electronMass; 
			 electronSpeed = Math.sqrt(x)*0.1; 	 
		 }
	}
}
