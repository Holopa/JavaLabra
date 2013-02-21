/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Peli.Tulokset;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *Aloitetaan peli ja annetaan hahmolle nimi, näyttää myös tulostaulun
 * @author jwholopa
 */
public class AloitusLiittyma implements Runnable{
    
     private JFrame frame;
     private Tulokset tulokset;
     
     public AloitusLiittyma() throws FileNotFoundException{
    
         tulokset = new Tulokset();
}

    AloitusLiittyma(int pisteet) throws FileNotFoundException {
        tulokset = new Tulokset();
        tulokset.tuloksenLisays(pisteet);
    }
    
    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField nimi=new JTextField("Pelaajan nimi");
        container.add(nimi,BorderLayout.NORTH);
              
        container.add(kirjoitaTulokset(), BorderLayout.CENTER);
        
        JButton nappi = new JButton("Aloita peli");

        nappi.addActionListener(new Nappikuuntelija(nimi.getText(),frame));
        container.add(nappi,BorderLayout.SOUTH);

        
    }

    public JFrame getFrame() {
        return frame;
    }
/**
 * kirjoittaa tuloslistan
 * @return 
 */
    private JPanel kirjoitaTulokset() {
        JPanel paneeli=new JPanel(new GridLayout(11,1));
        JTextField taulu=new JTextField("Tulostaulu:");
        taulu.setEnabled(false);
        paneeli.add(taulu);
        for (int i = 1; i < 11; i++) {
            JTextField apumuuttuja=new JTextField(i+". "+tulokset.kirjoitaTulokset(i-1));
            apumuuttuja.setEnabled(false);
            paneeli.add(apumuuttuja);
        }
        return paneeli;
    }
    
}
