import motors.*;

public class ej4{
    public static void main(String[] args){
        MotorElectric me = new MotorElectric();
        System.out.println("Primer motor.");
        giraAcelera(me);

        MotorElectric meCopia = new MotorElectric(me);
        System.out.println("Segon motor.");
        giraAcelera(meCopia);

        Motor mMotor = new MotorElectric(meCopia); 
        System.out.println("Tercer motor.");
        giraAcelera((MotorElectric)mMotor);       

    }

    public static void giraAcelera(MotorElectric me){
        me.gira();
        me.accelerar();
        System.out.println(me);
        me.gira();
        me.accelerar();
    }
}


