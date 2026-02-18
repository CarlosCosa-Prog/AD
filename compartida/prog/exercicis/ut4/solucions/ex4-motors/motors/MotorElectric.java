/*defineix la classe MotorElectric que herete de l'anterior i incloga un atribut Voltatge de tipus
String (per exemple 220CA o 12CC, per a 220 Volts de corrent altern o 12 Volts de corrent
continu), amb el seu corresponent setter i getter, un constructor amb 2 paràmetres des del qual
es cride al constructor de la seua classe base, un constructor de còpia, i redefinisca o
sobreescriga (overriding) el mètode gira (un MotorElectric gira a 3000 rpm, mentre la resta de
motors el fa a 1500). A més, el MotorElectric incrementa la seua velocitat accelerant, amb el
mètode accelera, a 10 rpm més (revolucions per minut, incrementarà la seua velocitat en
aquesta quantitat en accelerar).*/

package motors;

public class MotorElectric extends Motor{
    private String voltatge;

    public MotorElectric(){
        super(3000);
        voltatge="12 V";
    }

    public MotorElectric(double velocitat, String voltatge){
        super(velocitat);
        this.voltatge = voltatge;        
    }

    public MotorElectric(MotorElectric m){
        //this.velocitat=m.velocitat;
        super(m.velocitat);
        this.voltatge = m.voltatge;
    }

    //setters and getters
    public void setvoltatge(String voltatge){
        this.voltatge=voltatge;
    }
    public String getvoltatge(){
        return this.voltatge;
    }
    
    public void para() { velocitat = 0; }

    //other methods
    @Override
    public void gira(){
    	velocitat = 3000;
        System.out.println("El motor ELECTRIC gira a una velocitat de "+this.velocitat+" revolucions per segon");
    }

    public void acelerar(){
        this.velocitat += 10;
    }
    
    public String toString() { return "Velocitat: " + velocitat; }
}
