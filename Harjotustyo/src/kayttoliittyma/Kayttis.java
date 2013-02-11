/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import Olennot.Hahmo;
import Kartta.Kartta;
import kayttoliittyma.Piirtoalusta;
import kayttoliittyma.NappaimistonKuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 * Pitää huolta käyttöliittymästä
 * 
 * @author jwholopa
 */
public class Kayttis implements Runnable{
    private JFrame frame;
    private Kartta kartta;
    private Hahmo ukko;
            
    
    public Kayttis(Kartta k, Hahmo h){
        kartta =  k;
        ukko= h;
    }
    
    
    
    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Piirtoalusta piirto= new Piirtoalusta(kartta, ukko);
        container.add(piirto);
        frame.addKeyListener(new NappaimistonKuuntelija(ukko, piirto));

        
    }

    public JFrame getFrame() {
        return frame;
    }
   
}
