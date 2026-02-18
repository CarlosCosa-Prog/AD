import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*6. Realitza el següent programa que permeta generar un nombre aleatori entre un mínim i un màxim introduïts per l'usuari en dos requadres de text. El número generat es mostrarà mitjançant una etiqueta en fer clic sobre el botó. Observa la captura de l'aplicació a "exercici6.jpg".

        Inclou a la finestra dos panells que continguen:
        - el primer les etiquetes Mínim i Màxim, així com ambdós requadres de text
        - el segon inclourà el botó i etiqueta amb el resultat.

        La disposició a utilitzar al primer panell serà FlowLayout i al segon GridLayout d'una columna (recorda que per això pots utilitzar el mètode setLayout).*/
public class ex6 {
    public static void main(String[] args) {
        JFrame jf= new JFrame("Exercici 6");
        jf.setLayout(new GridLayout(0,1));
        
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //jf.setSize(new Dimension(400,400));
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);

        // per a centrar el JFrame en pantalla
        //jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp1 =  new JPanel(/*new GridLayout(0,2)*/);
        jp1.setLayout(new FlowLayout());
        jp1.setSize(400,100);
        JPanel jp2 =  new JPanel(/*new GridLayout(0,2)*/);
        jp2.setLayout(new GridLayout(0,1));

        JLabel jl1= new JLabel("Màxim");
        //jl1.setBorder(BorderFactory.createBevelBorder(2));//Recuadre per a identificar millor els elements

        JLabel jl2= new JLabel("Mínim");
        //jl2.setBorder(BorderFactory.createBevelBorder(2));

        JLabel jl3= new JLabel("Resultat");
        //jl3.setBorder(BorderFactory.createBevelBorder(2));

        JButton jb= new JButton("Generar");

        JTextField jt1=new JTextField("");
        jt1.setColumns(6);
        JTextField jt2=new JTextField("");
        jt2.setColumns(6);


        //Afig els components al jp
        jf.add(jp1);
        jf.add(jp2);

        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);
        jp2.add(jb);
        jp2.add(jl3);
        jf.setVisible(true);

        jb.addActionListener(new ActionListener(){  // CLASSE ANONIMA
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //jl3.setText(jl3.getText()+"0");
                String max =jt1.getText();
                int numMax = Integer.parseInt(max);
                String min =jt2.getText();
                int numMin = Integer.parseInt(min);
                int resul=0;
                // Comprove que el minim es menor al màxim ja que de no ser així, l'operació donaria error.
                if(numMin<=numMax) {
                    resul = (int) (Math.random() * (numMax - numMin + 1) + numMin);
                    //String convertidor = String.valueOf(resul);
                    jl3.setText("Resultat: "+ resul);
                }
                else
                    jl3.setText("Comprova que el mínim es menor al màxim");

            }
        });


    }
}
