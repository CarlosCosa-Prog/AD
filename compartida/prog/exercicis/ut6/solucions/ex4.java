/*Programa que, utilitzant 3 components JSlider amb valors de 0 a 255, permeta seleccionar graduació de color per als 3 colors RGB (vermell, verd i blau).
El programa mostrarà en un altre component (etiqueta o requadre de text, per exemple) el color resultant per als 3 valors escollits de graduació.
També pots afegir 3 components checkBox que permetan seleccionar o deseleccionar cada color per separat.
És a dir, si un color no té el checkBox corresponent seleccionat actuarà com si el slider estigués a zero.*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ex4
{
    //Creem les referències als objectes com a atributs.
    private static JFrame frame; //Finestra.
    private static JPanel panel1; //Panell 1 (Label i JTextField).
    private static JPanel panel2; //Panell 2. (Sliders)
    private static JLabel lText; //Label que mostrarà un text .
    private static JTextField color; //JTextField que mostrarà el color resultant.
    private static JLabel red;
    private static JSlider slider1; //Red.
    private static JLabel green;
    private static JSlider slider2; //Green.
    private static JLabel blue;
    private static JSlider slider3; //Blue.
    private static int redVal,greenVal,blueVal; //Valors dels colors.
    //Valors per als sliders
    static final int MIN = 0;
    static final int MAX = 255;
    static final int INIT = 128;

    public static void main(String[] args)
    {
        //FINESTRA
            //Creem la finestra principal del programa.
            frame = new JFrame("Selector de color");
            //Definim un layout.
            frame.setLayout(new GridLayout(0,1));
            //Centrem la finestra al centre de la pantalla.
            frame.setLocationRelativeTo(null);
            //Fem que el programa finalitze al tancar la finestra.
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            //Fem la finestra visible.
            frame.setVisible(true);

        //PANELLS
            //Creem el panell principal del programa amb un grid layout.
            panel1 = new JPanel(new GridLayout(0,1));
            panel2 = new JPanel(new GridLayout(0,1));
            //Creem el segón panell amb un grid layout
            //Afegim el panell a la finestra.
            frame.getContentPane().add(panel1);
            frame.getContentPane().add(panel2);

        //LABELS
            //Creem les etiquetes.
            lText = new JLabel("Modifica els sliders per a crear un color");
            red = new JLabel("Red");
            green = new JLabel("Green");
            blue = new JLabel("Blue");
            //Afegim les etiquetes al panel1.
            panel1.add(lText);

        //JTEXTFIELD
            //Creem el JTextField
            color = new JTextField("COLOR");
            //Fem que no es puga editar.
            color.setEditable(false);
            //Afegim el JTextField al panel 1
            panel1.add(color);

        //SLIDERS
            //Creem els 3 sliders.
            slider1 = new JSlider(JSlider.HORIZONTAL,MIN,MAX,INIT);
            slider2 = new JSlider(JSlider.HORIZONTAL,MIN,MAX,INIT);
            slider3 = new JSlider(JSlider.HORIZONTAL,MIN,MAX,INIT);
            //Afegim els sliders i els corresoponents labels al segón panel.
            panel2.add(red);
            panel2.add(slider1);
            panel2.add(green);
            panel2.add(slider2);
            panel2.add(blue);
            panel2.add(slider3);

        //CONTROL DE EVENTS DELS SLIDERS
            //Creem un ChangeListener
            ChangeListener cl = e ->{mouSlider(e);};
            //Agreguem el change listener als sliders.
            slider1.addChangeListener(cl);
            slider2.addChangeListener(cl);
            slider3.addChangeListener(cl);

        //EXTRAS
            //Definim la mida de la finestra al mínim dels components.
            frame.pack();
    }

    public static void mouSlider(ChangeEvent e)
    {
        JSlider obj = (JSlider)e.getSource();
        if(!obj.getValueIsAdjusting()) //Si el valor no està adjustant-se, és a dir, ja s'ha ajustat.
        {
            redVal=slider1.getValue();
            greenVal=slider2.getValue();
            blueVal=slider3.getValue();
            color.setBackground(new Color(redVal,greenVal,blueVal));
        }
    }
}
