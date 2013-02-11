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
import kayttoliittyma.Kayttis;

/**
 *
 * @author jwholopa
 */
public class Sienimetsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
//        Peli p =new Peli(Vaikeustaso.HELPPO,"Seppo");
        Tulokset t=new Tulokset();
        t.lueTulokset();
    }
}
