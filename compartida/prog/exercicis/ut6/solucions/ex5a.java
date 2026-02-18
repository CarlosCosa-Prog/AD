/* 5a. Realitza una aplicació gràfica que permeta a un bibliotecari llistar les pel·lícules guardades al fitxer ("films.dat") generat per a l'exercici 11 de la unitat anterior d'entrada/eixida (ut5). Per a mostrar les dades de cada pel·lícula has d'utilitzar components JTextField, de manera que amb cada clic sobre un botó "Següent" vaja mostrant-hi els valors per a cada pel·lícula. */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class finestra extends JFrame implements ActionListener
{
	FileInputStream fis;
	DataInputStream dis;
	JPanel jp1,jp2;
	JLabel jl1,jl2,jl3;
	JTextField jt1,jt2,jt3;
	JButton jb;

	public void iniciaDis()
	{
		try
		{
			fis = new FileInputStream("films.dat");
			dis = new DataInputStream(fis);
		}
		catch(IOException ex)
		{
			System.err.println(ex.getMessage());
		}
	}
	public void colocaComponents(LayoutManager lm)
	{
		setTitle("LlISTA PELICULES");
		setLayout(lm);
		jp1 = new JPanel(new GridLayout(3,3));
		jp2 = new JPanel(new FlowLayout());
		add(jp1);
		add(jp2);
		jl1 = new JLabel("Codi:");
		jl2 = new JLabel("Títol:");
		jl3 = new JLabel("Director:");
		jt1 = new JTextField();
		jt2 = new JTextField();
		jt3 = new JTextField();
		jb = new JButton("Següent");
		jp1.add(jl1); jp1.add(jt1);
		jp1.add(jl2); jp1.add(jt2);
		jp1.add(jl3); jp1.add(jt3);
		jp2.add(jb);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		jb.addActionListener(this);
		iniciaDis();
	}

	public void actionPerformed(ActionEvent e)
	{
		int cod=0; String tit="",dir="";
		try
		{
			cod = dis.readInt();
			tit = dis.readUTF();dir = dis.readUTF();
		}
		catch(IOException ex)
		{
			System.err.println(ex.getMessage());
		}
		jt1.setText(String.valueOf(cod));
		jt2.setText(tit);
		jt3.setText(dir);
	}

/*	public void	windowClosed(WindowEvent e)
	{

	}*/
}

public class ex5a
{
	public static void main(String[] args) {
		finestra f = new finestra();
		f.colocaComponents(new GridLayout(0,1));
	}
}
