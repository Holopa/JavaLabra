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

public class NappaimistonKuuntelija implements KeyListener {

     private Component component;
    private Hahmo hahmo;

    public NappaimistonKuuntelija(Hahmo hahmo, Component component) {
        this.hahmo = hahmo;
        this.component = component;
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
        }

        component.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}

