import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ex8 {

	private static JMenuItem jmi1;
	private static JMenuItem jmi2;
	private static JMenuItem jmi3;
	private static JMenuItem jmi4;
	private static JTextField jt1;
	private static JTextField jt2;
	private static JLabel jl4;
	
    public static void main(String[] args) {
        JFrame jf= new JFrame("Exercici 8");
        jf.setLayout(new GridLayout(0,1));
        
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(400,300);
        jf.setLocationRelativeTo(null);

        JPanel jp1 =  new JPanel(new GridLayout(2,2));
        jp1.setSize(400,200);

        JLabel jl1= new JLabel("Primer operand");
        jt1=new JTextField("");
        jt1.setColumns(6);

        JLabel jl2= new JLabel("Segon operand");
        jt2=new JTextField("");
        jt2.setColumns(6);

	//jp1.add(jl1); jp1.add(jt1); jp1.add(jl2); jp1.add(jt2); 

	JPanel jp2 =  new JPanel(new FlowLayout());
        jp2.setSize(400,100);

        JLabel jl3= new JLabel("Resultat:");
        jl4 = new JLabel();

	//jp2.add(jl3); jp2.add(jl4);

	JMenuBar jmb = new JMenuBar();
	JMenu jm = new JMenu("Operacions aritmètiques");
	jmi1 = new JMenuItem("Suma");
	jmi2 = new JMenuItem("Resta");
	jmi3 = new JMenuItem("Multiplica");
	jmi4 = new JMenuItem("Divideix");
	jmb.add(jm);
	jm.add(jmi1); jm.add(jmi2); jm.add(jmi3); jm.add(jmi4); 

        //Afig els components al jp
	jf.setJMenuBar(jmb);
	//jf.add(jmb);
        jf.add(jp1);
        jf.add(jp2);

        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);

        jp2.add(jl3);
        jp2.add(jl4);

        jf.setVisible(true);

        jmi1.addActionListener(new ActionListener(){  // CLASSE ANONIMA
            @Override
            public void actionPerformed(ActionEvent e) {
		opera(e);
            }
        });

        jmi2.addActionListener(new ActionListener(){  // CLASSE ANONIMA
            @Override
            public void actionPerformed(ActionEvent e) {
		opera(e);
            }
        });
        
        jmi3.addActionListener(new ActionListener(){  // CLASSE ANONIMA
            @Override
            public void actionPerformed(ActionEvent e) {
		opera(e);
            }
        });
        
        jmi4.addActionListener(new ActionListener(){  // CLASSE ANONIMA
            @Override
            public void actionPerformed(ActionEvent e) {
		opera(e);
            }
        });
   }
        
	public static void opera(ActionEvent e)
	{
		double result;
            	
            	try
            	{
		        String n1 =jt1.getText();
		        double num1 = Double.parseDouble(n1);
		        String n2 =jt2.getText();
		        double num2 = Double.parseDouble(n2);
	 		JMenuItem jmi = (JMenuItem) e.getSource();
	 		if (jmi == jmi1)
	 			 result = num1 + num2;
	 		else
	 			if (jmi == jmi2)
	 				result = num1 - num2;
	 			else
	 				if (jmi == jmi3)
	 					result = num1 * num2;
	 				else
	 					result = num1 / num2;

	 		jl4.setText(String.valueOf(result));
	 	}
	 	catch (NumberFormatException ex)
	 	{
	 		jl4.setText("Falten valors o valors incorrectes");
	 	}
	}
}
