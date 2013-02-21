/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 * Ohjaa näppäimistöltä tulevat komennot ohjelmalle.
 * 
 * @author jwholopa
 */
import Olennot.Hahmo;
import Olennot.Hahmo;
import Kartta.Suunta;
import Kartta.Suunta;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class NappaimistonKuuntelija implements KeyListener {

     private Component component;
    private Hahmo hahmo;
    private JTextField pisteet, voimat;


    NappaimistonKuuntelija(Hahmo ukko, Piirtoalusta piirto, JTextField pisteet, JTextField voima) {
        this.hahmo = ukko;
        this.component = piirto;
        this.pisteet= pisteet;
        this.voimat = voima;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hahmo.liiku(Suunta.Lansi);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hahmo.liiku(Suunta.Ita);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hahmo.liiku(Suunta.Pohjoinen);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hahmo.liiku(Suunta.Etela);
            System.out.println("aa");
        }

        pisteet.setText(hahmo.getPisteet());
        voimat.setText(hahmo.getVoima());
        component.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}

