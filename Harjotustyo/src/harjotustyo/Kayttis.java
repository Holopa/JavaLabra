/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 *
 * @author jwholopa
 */
public class Kayttis implements Runnable{
    private JFrame frame;
    private JPanel paneeli;
    private Kartta kartta;
    private JButton ok;
            
    
    public Kayttis(Kartta k){
        kartta =  k;
        
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
        Piirtoalusta piirto= new Piirtoalusta(kartta);
        container.add(piirto);

        
    }

    public JFrame getFrame() {
        return frame;
    }
   
}
