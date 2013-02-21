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
        kartta=new Kartta("111113020011002111111021100031111100111101411110011121111311000111211101100111111100111101113000011111011311111141111100111100001111111011110001121111113000001111114000000001111111110111111111111041111111120011111111111111111100001111111111101111111140011111100041111111110111111200001111101111111101114000002111111111201111111100001044000111121111100010011111110004100110111101100111111001111111011004100111001111113111111141111110021100001111111",20);
        ukko=new Hahmo(nimi, kartta.getKartta()[0][0]);
        kayttoliittyma=new PeliKayttis(kartta,ukko);
        kayttoliittyma.run();
    }
    
}
