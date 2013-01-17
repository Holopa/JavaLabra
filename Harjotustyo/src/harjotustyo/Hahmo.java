/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;

/**
 *
 * @author jwholopa
 */
public class Hahmo {
    private String nimi;
    private Piste sijainti;
    
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
    public void liiku(int suunta){   //Suunta: 1=Pohjoinen, 2=itä, 3=etelä,4=lansi
        switch (suunta) {
            case 1:
                liikupohjoiseen();
                break;
            case 4:
                liikulanteen();
                break;
            case 3:
                liikuetelaan();
                break;
            case 2:
                liikuitaan();
                break;
        }
    }

    private void liikupohjoiseen() {
        if (sijainti.OnkoYhteysPohjoiseen()){
            sijainti= sijainti.Yhteys(1);
        }
            
    }

    private void liikulanteen() {
        if (sijainti.OnkoYhteysLanteen()){
            sijainti= sijainti.Yhteys(4);
        }
    }

    private void liikuetelaan() {
        if (sijainti.OnkoYhteysEtelaan()){
            sijainti= sijainti.Yhteys(3);
        }
    }

    private void liikuitaan() {
        if (sijainti.OnkoYhteysitaan()){
            sijainti= sijainti.Yhteys(2);
        }
    }
}
