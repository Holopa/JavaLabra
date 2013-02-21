/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import Olennot.Hahmo;
import Kartta.Kartta;
import java.awt.BorderLayout;
import kayttoliittyma.Piirtoalusta;
import kayttoliittyma.NappaimistonKuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 * Pitää huolta käyttöliittymästä
 * 
 * @author jwholopa
 */
public class PeliKayttis implements Runnable, ActionListener{
    private JFrame frame;
    private Kartta kartta;
    private Hahmo ukko;
            
    
    public PeliKayttis(Kartta k, Hahmo h){
        kartta =  k;
        ukko= h;
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
        JTextField pisteet=new JTextField(ukko.getPisteet());
        pisteet.setEnabled(false);
        JTextField voima=new JTextField(ukko.getVoima());
        voima.setEnabled(false);
        JLabel piste = new JLabel("Pisteet:");
        JLabel voimat = new JLabel("Voima:");
        JPanel panel = new JPanel(new GridLayout(1, 4));
        panel.add(piste);
        panel.add(pisteet);
        panel.add(voimat);
        panel.add(voima);
        
                
        JButton lopetusnappi=new JButton("Lopeta");
        lopetusnappi.addActionListener(this);
        lopetusnappi.transferFocus();
        container.add(lopetusnappi,BorderLayout.SOUTH);
        
        
       container.add(panel,BorderLayout.NORTH);
        
        Piirtoalusta piirto= new Piirtoalusta(kartta, ukko);
        container.add(piirto,BorderLayout.CENTER);
        piirto.addKeyListener(new NappaimistonKuuntelija(ukko, piirto,pisteet,voima));


        
    }

    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
            AloitusLiittyma peli = null;
        try {
            peli = new AloitusLiittyma(ukko.pisteet());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeliKayttis.class.getName()).log(Level.SEVERE, null, ex);
        }
            peli.run();
    }
   
}
