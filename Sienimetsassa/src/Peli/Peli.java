/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import Kartta.Kartta;
import Olennot.Hahmo;
import kayttoliittyma.PeliKayttis;

/**
 *
 * @author jwholopa
 */
public class Peli {
    
    private Kartta kartta;
    private Hahmo ukko;
    private PeliKayttis kayttoliittyma;
    
    public Peli(Vaikeustaso taso, String nimi){
        kartta=new Kartta("11111302001100211011"
                        + "10211000311111001041"
                        + "01411110011121111001"
                        + "00011121110110011111"
                        + "11001111011130000113"
                        + "11011311111141111100"
                        + "11110000111111101111"
                        + "00011211111130000011"
                        + "11114000000001111111"
                        + "11011111111111104111"
                        + "11111200111111101031"
                        + "11111100001111100001"
                        + "10111111114001111000"
                        + "00301111111101111111"
                        + "00001111101110111102"
                        + "11400000411110111120"
                        + "11111111100010440001"
                        + "11121111100010011111"
                        + "11000410011011110110"
                        + "01111110011111110111",20);
        ukko=new Hahmo(nimi, kartta.getKartta()[0][0]);
        kayttoliittyma=new PeliKayttis(kartta,ukko);
        kayttoliittyma.run();
    }
    
}
