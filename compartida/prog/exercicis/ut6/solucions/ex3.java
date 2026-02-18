import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 3. Programa que, mitjançant un JFileChooser, afegeisca al fitxer el contingut del text escrit per l'usuari en un requadre de text (JTextField). El programa utilitzarà un botó que llançarà el selector de fitxer i un altre que escriga a fitxer el contingut indicat, després d'haver-lo seleccionat. */

class FileChooser extends JFrame implements ActionListener
	{
        	private File f;
		private Container contenidor;
		JLabel label; /*declarem l'objecte Label*/
		JTextField areaDetext;
		JButton botoSeleccionar; /*declarem l'objecte botó*/
		JButton botoGuardar; /*declarem l'objecte botó*/
//		JScrollPane scrollPaneArea;
		JFileChooser fileChooser; /*declarem l'objecte fileChooser*/
		String text;
    
		
		public FileChooser()//constructor
		{
            		f = null;
			contenidor=getContentPane();
			contenidor.setLayout(new GridLayout(0,1));
			
			/*Creem l'objecte*/
			fileChooser=new JFileChooser();
			
			label= new JLabel();
			label.setText("ESCRIU UN TEXT:");
			
			areaDetext = new JTextField();
   	
			/*Propietats del botó, l'instanciem, el seleccionem i activem els esdeveniments*/
			botoSeleccionar= new JButton("Seleccionar");
			botoSeleccionar.addActionListener(this);
			
			botoGuardar= new JButton("Guardar");
			botoGuardar.addActionListener(this);
			
			/*Agreguem els components al Contenidor*/
			contenidor.add(label);
			contenidor.add(areaDetext);
			contenidor.add(botoSeleccionar);
			contenidor.add(botoGuardar);
       			//Assigna un titol a la barra
			setTitle("Finestra ex3");
			//posa la finestra al centre de la pantalla
			setLocationRelativeTo(null);
			
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource()==botoSeleccionar)
				f = seleccionarArxiu();			
			if (event.getSource()==botoGuardar)
				guardarArxiu(f);
		}

		/**
		 * Permet mostrar la finestra que permet seleccionar el fitxer */
		private File seleccionarArxiu() {
		
	 			/*cridem al mètode que permet carregar la finestra*/
	    		fileChooser.showOpenDialog(this);
	    		/*obrim l'arxiu seleccionat*/
	 			f=fileChooser.getSelectedFile();
//                System.out.println(f.getName());
				return f;
		}
		
		/**
		 * Afegim el contingut del requadre de text a l'arxiu de text
		 */
		private void guardarArxiu(File f) {
	 		try
	 		{
				if(f !=null)
				{
		 			FileWriter  save=new FileWriter(f,true);
		 			save.write(areaDetext.getText());
                    //System.out.println("S'ha escrit a fitxer'");
		 			save.close();
		 			JOptionPane.showMessageDialog(null,
		 					"L'arxiu s'ha guardat correctament",
		 					"Informació",JOptionPane.INFORMATION_MESSAGE);
			    }
                else
                    System.out.println("Referència a fitxer nula'");
	 		 }
	 	   catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,
					 "L'arxiu no s'ha guardat",
					 "Advertència",JOptionPane.WARNING_MESSAGE);
                //System.err.println(ex.getMessage());
		   }
		}
	}
	
public class ex3
{
	public static void main(String[] args) {
		FileChooser fc = new FileChooser();
		fc.setVisible(true);
	}
}
