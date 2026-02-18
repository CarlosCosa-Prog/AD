public class Music{
    private String instrument;
    private String autor;

    //CONSTUCTOR
    //default
    public Music(){
        instrument="Guitarra";
        autor="Paco de Lucía";
    }
    //general
    public Music(String ins, String aut){
        instrument=ins;
        autor=aut;
    }
    //còpia
    public Music(Music m){
        instrument = m.instrument;
        autor = m.autor;
    }

    //METODES
    //setters
    public void setIntrument(String ins){
        instrument=ins;
    }
    public void setAutor(String aut){
        autor=aut;
    }
    //getters
    public String getIntrument(){
        return instrument;    
    }
    public String getAutor(){
        return autor;
    }
    //altres funcions
    public String toString(){
        return "El music "+autor+" usa l'instrument "+instrument;
    }


}
