/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import Kartta.Kartta;
import Olennot.Hahmo;
import kayttoliittyma.Kayttis;

/**
 *
 * @author jwholopa
 */
public class Peli {
    
    private Kartta kartta;
    private Hahmo ukko;
    private Kayttis kayttoliittyma;
    
    public Peli(Vaikeustaso taso, String nimi){
        kartta=new Kartta("114113020011",4);
        ukko=new Hahmo(nimi, kartta.getKartta()[0][0]);
        kayttoliittyma=new Kayttis(kartta,ukko);
        kayttoliittyma.run();
    }
    
}
