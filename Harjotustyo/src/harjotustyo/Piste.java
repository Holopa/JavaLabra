/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;

/**
 *
 * @author jwholopa
 */
public class Piste {
    
    private Piste Pohjoinen,Etela,Ita,Lansi;
    private Maasto maasto;
    
    public Piste(Maasto maasto){
        this.maasto=maasto;      
    }
    
    public void lisaaYhteys(Piste yhteys, Suunta suunta){  //Suunta: 1=Pohjoinen, 2=itä, 3=etelä,4=lansi
        switch(suunta){
            case Pohjoinen:
                Pohjoinen = yhteys;
                break;
            case Ita:
                Ita=yhteys;
                break;
            case Etela:
                Etela=yhteys;
                break;
            case Lansi:
                Lansi=yhteys;
                break;          
        }
       
    }
    
    public Piste Yhteys(Suunta suunta){
        switch(suunta){
            case Pohjoinen:
                return Pohjoinen;
            case Ita:
                return Ita;
            case Etela:
                return Etela;
            case Lansi:
                return Lansi;          
        }
        return null;
    }
    
    public boolean OnkoYhteys(Suunta suunta){
        switch(suunta){
            case Pohjoinen:
                return OnkoYhteysPohjoiseen();
            case Ita:
                return OnkoYhteysitaan();
            case Etela:
                return OnkoYhteysEtelaan();
            case Lansi:
                return OnkoYhteysLanteen();          
        }
        return false;
    }
    
    private boolean OnkoYhteysPohjoiseen(){
        if (Pohjoinen != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean OnkoYhteysitaan(){
        if (Ita != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean OnkoYhteysEtelaan(){
        if (Etela != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean OnkoYhteysLanteen(){
        if (Lansi != null) {
            return true;
        }
        else {
            return false;
        }
    }

    Maasto maasto() {
        return maasto;
    }
}
