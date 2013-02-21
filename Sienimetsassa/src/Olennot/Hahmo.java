/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Olennot;

import Kartta.Suunta;
import Kartta.Piste;
import Kartta.Sieni;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Hahmo luokka pitää kirjaa hahmon nimestä, sijainnista ja suunnasta
 * 
 * @author jwholopa
 */
public class Hahmo {
    private String nimi;
    private Piste sijainti;
    private Suunta suunta;
    private BufferedImage kuva;
    private int pisteet =0;
    private int voima = 0;
    private boolean hengissa;
    
    public Hahmo(String nimi, Piste aloituspaikka){
        this.nimi=nimi;
        sijainti=aloituspaikka;
        hengissa=true;
    }

    public String getPisteet() {
        String apu=""+pisteet;
        return apu;
    }

    public String getVoima() {
        String apu=""+voima;
        return apu;
    }
    
    
    public String hahmonnimi(){
        return nimi;
    }
    public Piste hahmonSijainti(){
        return sijainti;
    }
    
    /**
     * Liikuttaa hahmoa parametrin suuntaan jos mahdollista
     * Jos uudessa sijainnissa on sieni poimitaan se.
     * 
     * @param suunta kertoo mihin hahmoa pitäisi liikuttaa
     */
    
    
    public void liiku(Suunta suunta){
        boolean liikuttiinko = false;
        switch (suunta) {
            case Pohjoinen:
                liikuttiinko=liikupohjoiseen();
                break;
            case Ita:
                liikuttiinko=liikuitaan();
                break;
            case Etela:
                liikuttiinko=liikuetelaan();
                break;
            case Lansi:
                liikuttiinko=liikulanteen();
                break; 
        }
        if (sijainti.getSieni() != null){
            poimiSieni();
        }
        else{
            if(liikuttiinko){
                pisteet= pisteet - 5;
            }
        }
    }

    public int pisteet() {
        return pisteet;
    }
    /**
     * Piirtää hahmon sen sijaintiin
     * jos hahmo on kuollut pirtää ison punaisen läntin kuolinpaikkaan
     * 
     * @param graphics 
     */
     public void piirra(Graphics graphics, int skaalaus) {
         
       if (hengissa){ 
       try{ 
           kuva = ImageIO.read(new File("/fs/home/jwholopa/JavaLabra/HahmoMetsassa.jpg"));
           graphics.drawImage(kuva, sijainti.getX()*skaalaus, sijainti.getY()*skaalaus, null);
       } catch (IOException ex) {
             graphics.setColor(Color.RED);
             graphics.fillOval(sijainti.getX()*skaalaus, sijainti.getY()*skaalaus, 10, 10);
       }
       }
       else{
           graphics.setColor(Color.RED);
             graphics.fillOval(sijainti.getX()*skaalaus, sijainti.getY()*skaalaus, 45, 40);
       }
               
        
    }

    private boolean liikupohjoiseen() {
        if (sijainti.OnkoYhteys(Suunta.Pohjoinen)){
            sijainti= sijainti.Yhteys(Suunta.Pohjoinen);
            return true;
        }
        return false;    
    }

    private boolean liikulanteen() {
        if (sijainti.OnkoYhteys(Suunta.Lansi)){
            sijainti= sijainti.Yhteys(Suunta.Lansi);
            return true;
        }
        return false; 
    }

    private boolean liikuetelaan() {
        if (sijainti.OnkoYhteys(Suunta.Etela)){
            sijainti= sijainti.Yhteys(Suunta.Etela);
            return true;
        }
        return false; 
    }

    private boolean liikuitaan() {
        if (sijainti.OnkoYhteys(Suunta.Ita)){
            sijainti= sijainti.Yhteys(Suunta.Ita);
            return true;
        }
        return false; 
    }

    /**
     * poimii sienen jos hahmon sijannissa on sieni
     * jos joutuu tappeluun sienimiehen kanssa ja häviää hahmo kuolee ja yhteydet seuraaviin pisteisiin katkaistaan jotta hahmo ei voi enään liikkua
     */
    private void poimiSieni() {
        if (sijainti.getSieni() == Sieni.PISTESIENI){
            pisteet= pisteet+100;
            sijainti.setSieni(null);
        }
        else if (sijainti.getSieni() == Sieni.VOIMASIENI){
            voima = voima +10;
            sijainti.setSieni(null);
        }
         else if (sijainti.getSieni() == Sieni.SIENIMIES){
            boolean voittiko= tappele();
            if (voittiko){
                pisteet= pisteet+100;
                sijainti.setSieni(null);
            }
            else{
                hengissa=false;
                katkaiseyhteydet();
            }
        }
    }

    /**
     * molemmat taisteluun osallistuvat arpovat luvun 0-100 hahmo saa bonusta kerätyistä voimasienistä kuitenkin vain 75 verran.
     * @return paluttaa false jos hahmo häviää
     */
    private boolean tappele() {
        int sienimies=(int) ( 100*Math.random());
        int hahmo=(int) ( 100*Math.random()) +Math.min(voima, 75);
        if (hahmo>=sienimies){
            return true;
        }
        return false;
    }

    /**
     * hahmon luollessa katkaisee kaikki yhteydet hahmon sijannista
     * @param sijainti 
     */
    private void katkaiseyhteydet() {
        sijainti.lisaaYhteys(null, Suunta.Etela);
        sijainti.lisaaYhteys(null, Suunta.Ita);
        sijainti.lisaaYhteys(null, Suunta.Lansi);
        sijainti.lisaaYhteys(null, Suunta.Pohjoinen);
    }
}
