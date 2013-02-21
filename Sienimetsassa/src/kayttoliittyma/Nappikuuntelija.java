/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Olennot.Hahmo;
import Peli.Peli;
import Peli.Vaikeustaso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *Aloittaa uuden pelin napin painalluksesta ja sulkee alkukäyttiksen
 * 
 * @author jwholopa
 */
public class Nappikuuntelija implements ActionListener{
    
    private String nimi;
    private final JFrame frame;

    

    Nappikuuntelija(String text, JFrame frame) {
        this.nimi=nimi;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Peli peli=new Peli(Vaikeustaso.VAIKEA,nimi);
        frame.setVisible(false);
    }
    
}
