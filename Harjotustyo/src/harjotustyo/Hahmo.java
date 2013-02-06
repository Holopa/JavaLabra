/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;

/**
 * Hahmo luokka pitää kirjaa hahmon nimestä, sijainnista ja suunnasta
 * 
 * @author jwholopa
 */
public class Hahmo {
    private String nimi;
    private Piste sijainti;
    private Suunta suunta;
    
    public Hahmo(String nimi, Piste aloituspaikka){
        this.nimi=nimi;
        sijainti=aloituspaikka;
    }
    
    public String hahmonnimi(){
        return nimi;
    }
    public Piste hahmonSijainti(){
        return sijainti;
    }
    
    /**
     * mitä tämä metodi tekee?
     * 
     * 
     * @param suunta mitä parametri suunta tekee
     */
    
    
    public void liiku(Suunta suunta){   //Suunta: 1=Pohjoinen, 2=itä, 3=etelä,4=lansi
        switch (suunta) {
            case Pohjoinen:
                liikupohjoiseen();
                break;
            case Ita:
                liikuitaan();
                break;
            case Etela:
                liikuetelaan();
                break;
            case Lansi:
                liikulanteen();
                break;

            
        }
    }

    private void liikupohjoiseen() {
        if (sijainti.OnkoYhteys(Suunta.Pohjoinen)){
            sijainti= sijainti.Yhteys(Suunta.Pohjoinen);
        }
            
    }

    private void liikulanteen() {
        if (sijainti.OnkoYhteys(Suunta.Lansi)){
            sijainti= sijainti.Yhteys(Suunta.Lansi);
        }
    }

    private void liikuetelaan() {
        if (sijainti.OnkoYhteys(Suunta.Etela)){
            sijainti= sijainti.Yhteys(Suunta.Etela);
        }
    }

    private void liikuitaan() {
        if (sijainti.OnkoYhteys(Suunta.Ita)){
            sijainti= sijainti.Yhteys(Suunta.Ita);
        }
    }
}
