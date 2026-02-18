/*una classe Motor que implemente la interfície anterior i, almenys, 
amb un atribut velocitat, un constructor amb un paràmetre, setter, 
getter, i mètode abstracte accelera().*/
package motors;

public abstract class Motor implements Potencia{
    protected double velocitat;
    
    public Motor(){
        velocitat=1500;
    }

    public Motor(double velocitat){
        this.velocitat=velocitat;
    }

    //setters and getters
    public void setvelocitat(double velocitat){
        this.velocitat=velocitat;
    }
    public double getvelocitat(){
        return this.velocitat;
    }

    //other methods
    public void gira(){
    	velocitat = 1500;
        System.out.println("El motor gira a una velocitat de "+this.velocitat+" revolucions per segon");
    }

    public abstract void acelerar();
}
