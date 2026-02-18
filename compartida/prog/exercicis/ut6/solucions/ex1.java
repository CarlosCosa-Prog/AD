/*1. Programa que, mitjançant 3 botons ( 0 , 1 i C per a esborrar) permeta compondre un valor numèric en binari que serà mostrat en binari i en decimal amb les corresponents etiquetes.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex1
{
	//Creem els 4 botons com a atributs.
	private static JButton boto1 = new JButton("1");
	private static JButton boto2 = new JButton("0");
	private static JButton boto3 = new JButton("=");
	private static JButton boto4 = new JButton("C");
	//Creem els labels com a atributs.
	private static JLabel jl1 = new JLabel("");
	private static JLabel lbinari = new JLabel("BINARI: ");
	private static JLabel ldecimal = new JLabel("DECIMAL: ");


	public static void main(String[] args)
	{
		//FINESTRA
			//Creem la finestra principal de l'aplicació.
			JFrame jf = new JFrame("Conversor Binari");
			//
			jf.setLayout(new GridLayout(0,1));
			//Fem la finestra visible.
			jf.setVisible(true);
			//Fem que el programa acabe al tancar la finestra.
			jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			//Centrem la finestra amb el valor null.
			jf.setLocationRelativeTo(null);

		//PANELS
			//Creem un panell que contindrà les etiquetes
			JPanel jp1 = new JPanel(new GridLayout(1,1));
			//Creem un panell que contendrà les etiquetes de binari i les dades.
			JPanel jp2 = new JPanel(new GridLayout(1,0));
			//Creem un altre panell que contindrà els botons amb un layout de 2 columnes.
			JPanel jp3 = new JPanel(new GridLayout(0,2));
			//Incorporem els panells a la finestra.
			jf.getContentPane().add(jp1);
			jf.getContentPane().add(jp2);
			jf.getContentPane().add(jp3);

		//LABEL
			//Agreguem l'etiqueta al panell superior.
			jp2.add(lbinari);
			jp2.add(jl1); 
			jp1.add(jp2);
			jp1.add(ldecimal); 
			 
			

		//BOTONS
			//Agreguem els botons al panell inferior.
			jp3.add(boto1);
			jp3.add(boto2);
			jp3.add(boto3);
			jp3.add(boto4);

		//RESPOSTA ALS CLICKS
			//Creem un action listener utilitzant una expressió lambda.
			ActionListener al = e -> {accions(e);};
			//S'agrega el action listener als botó.
			boto1.addActionListener(al);
			boto2.addActionListener(al);
			boto3.addActionListener(al);
			boto4.addActionListener(al);
			
		//EXTRAS
			//Definim la grandària de la finestra al mínim dels components.
			jf.pack();
	}

	public static void accions(ActionEvent e)
	{
		// Cride a getSource que retornarà l'objecte que ha generat l'esdeveniment
		Object obj = e.getSource();

		if(obj==boto1) //Botó "1"
		{
			jl1.setText(jl1.getText()+"1");
		}
		if(obj==boto2) //Botó "0"
		{
			jl1.setText(jl1.getText()+"0");
		}
		if(obj==boto3) //Botó "="
		{
			String s = jl1.getText();
			Integer dec = Integer.parseInt(s,2);
			ldecimal.setText(ldecimal.getText()+""+dec.toString());
		}
		if(obj==boto4) //Botó "C"
		{
			jl1.setText("");
			ldecimal.setText("DECIMAL: ");
		}


	}
}
