/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sienimetsa;

import Olennot.Hahmo;
import Kartta.Kartta;
import Peli.Peli;
import Peli.Tulokset;
import Peli.Vaikeustaso;
import java.io.FileNotFoundException;
import kayttoliittyma.AloitusLiittyma;
import kayttoliittyma.PeliKayttis;

/**
 *
 * @author jwholopa
 */
public class Sienimetsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        AloitusLiittyma peli=new AloitusLiittyma();
        peli.run();
        
        
//        Kartta kartta = new Kartta("111211310110200114002", 5);
//        Hahmo seppo=new Hahmo("Seppo", kartta.getKartta()[0][0]);
//        Kayttis kayttoliittyma = new Kayttis(kartta,seppo);
//        kayttoliittyma.run();
    }
}
