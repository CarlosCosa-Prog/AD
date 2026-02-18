//2. Realitza una aplicació que genere un número aleatori en fer clic sobre un botó. El nombre de dígits que tindrà 
//l'aleatori el prendrà d'un requadre de text (JTextField). Si el requadre té el valor 3, per exemple, 
//generarà aleatoris entre 0 i 999. Mostrarà el valor generat en una etiqueta.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.io.*;

public class ex2
{

	public static void main(String[] args) 
	{
		JFrame jf = new JFrame("Número aleatori");
		//CARACTERISTIQUES DEL FRAME
		jf.setSize(1180, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//JPanel i característiques
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 2, 10, 0));
		jf.add(jp);

		//creem el TextField i l'afegim al panell
		JLabel jl0 = new JLabel("Digits: "); jp.add(jl0);
		JTextField txtValor = new JTextField(); jp.add(txtValor);
		JButton jb = new JButton("Generar número aleatori (0-999)"); jp.add(jb);
		JLabel jl = new JLabel("Valor generat"); jp.add(jl);

		//jf.pack();
		jf.setVisible(true); 

		
		ActionListener al = new ActionListener()
		{	// classe anònima
			int numAtzar = 0;
			int valor = 0, potencia;
			public void actionPerformed(ActionEvent e)
			{	
				/*if (e.getSource() == jb)
				{*/
					valor = Integer.parseInt(txtValor.getText());
					potencia = (int) Math.pow(10,valor);
					numAtzar = (int)(Math.random() * potencia); jl.setText(String.valueOf(numtAzar));
				//}	

				try(FileWriter fw = new FileWriter("historicSortejos.txt",true))
 				{
 					fw.write(String.valueOf(numAtzar)+"\n");
 				}

 				catch (IOException e1)
 				{
 					System.err.println(e1.getMessage());
 				}

			}
		};
		jb.addActionListener(al);
		txtValor.addActionListener(al);

		// AMB EXPRESIO LAMBDA
		/* 
		ActionListener al = e -> 
		{ 
			double numAtzar = 0;
			int valor = 0;	
				if (e.getSource() == jb)
				{
					valor = Integer.parseInt(txtValor.getText());

					switch(valor)
					{
						default: jl.setText("Valor no valid"); break;
						case 1: numAtzar = (int)(Math.random() * 10) + 1; jl.setText(String.valueOf((int)numAtzar)); break;
						case 2: numAtzar = (int)(Math.random() * 100) + 1; jl.setText(String.valueOf((int)numAtzar)); break;
						case 3: numAtzar = (int)(Math.random() * 1000) + 1; jl.setText(String.valueOf((int)numAtzar));
					}
				}

				try(FileWriter fw = new FileWriter("historicSortejos.txt",true))
 				{
 					fw.write(String.valueOf(numAtzar)+"\n");
 				}

 				catch (IOException e1)
 				{
 					System.err.println(e1.getMessage());
 				}
		};
		jb.addActionListener(al);
		txtValor.addActionListener(al);*/
	}
}
