/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kartta;

/**
 * Pitää kirjaa pisteen maastosta ja mihin pisteeseen siitä on yhteys.
 *
 * @author jwholopa
 */
public class Piste {
    
    private Piste Pohjoinen,Etela,Ita,Lansi;
    private Maasto maasto;
    private int x,y;
    private Sieni sieni;
    
    public Piste(Maasto maasto, int x, int y){
        this.x=x;
        this.y=y;
        this.maasto=maasto;      
    }

    public void setSieni(Sieni sieni) {
        this.sieni = sieni;
    }

    public Sieni getSieni() {
        return sieni;
    }
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
     public  Maasto maasto() {
        return maasto;
    }

   /**
    * Lisää yhteyden toiseen pisteeseen, mitä kautta hahmo pääsee kulkemaan.
    * @param yhteys kertoo mihin pisteeseen yhteys luodaan
    * @param suunta Kertoo mihin suuntaan yhteys luodaan
    */
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
    /**
     * Palauttaa pisteen annetusta suunnasta jos sinne on yhteys.
     * @param suunta mistä suunnsta yhteys annetaan
     * @return 
     */
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
    /**
     * Kertoo onko kyseiseen suuntaan olemassa yhteyttä.
     * @param suunta
     * @return 
     */
    
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


}
