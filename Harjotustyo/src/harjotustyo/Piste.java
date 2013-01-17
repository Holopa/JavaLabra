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
    
    public Piste(){
        
    }
    
    public void lisaaYhteys(Piste yhteys, int suunta){  //Suunta: 1=Pohjoinen, 2=itä, 3=etelä,4=lansi
        switch(suunta){
            case(1):
                Pohjoinen = yhteys;
                break;
            case(2):
                Ita=yhteys;
                break;
            case(3):
                Etela=yhteys;
                break;
            case(4):
                Lansi=yhteys;
                break;          
        }
       
    }
    
    public Piste Yhteys(int suunta){
        switch(suunta){
            case(1):
                return Pohjoinen;
            case(2):
                return Ita;
            case(3):
                return Etela;
            case(4):
                return Lansi;          
        }
        return null;
    }
    
    
    
    public boolean OnkoYhteysPohjoiseen(){
        if (Pohjoinen != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean OnkoYhteysitaan(){
        if (Ita != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean OnkoYhteysEtelaan(){
        if (Etela != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean OnkoYhteysLanteen(){
        if (Lansi != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
