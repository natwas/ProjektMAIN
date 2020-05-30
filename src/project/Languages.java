package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Languages implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 
	 * 
	 * 		    language=new JMenu(r1.getString("language"));
		    
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
		*/

}
