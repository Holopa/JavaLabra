/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Olennot.Hahmo;
import Kartta.Kartta;
import Kartta.Maasto;
import Kartta.Piste;
import Kartta.Sieni;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Piirtää käyttöliittymän
 * 
 * @author jwholopa
 */
public class Piirtoalusta extends JPanel {
    
    
    public final int skaalaus = 15;
    private BufferedImage kuva;
    private Kartta kartta;
    private Hahmo ukko;
    public Piirtoalusta(Kartta kartta, Hahmo hahmo) {
        super.setBackground(Color.BLACK);
        this.kartta=kartta;
        ukko=hahmo;
    }

    

    @Override
    protected void paintComponent(Graphics graphics) {
       
        Piste[][] k = kartta.getKartta();
        
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {               
                if (k[i][j].getSieni() != null){
                    piirräSieni(skaalaus*i,skaalaus*j,k[i][j].getSieni(), graphics);
                }
                else {
                    piirrä(skaalaus*i,skaalaus*j,k[i][j].maasto(), graphics);
                }
            }
        }
        ukko.piirra(graphics, skaalaus);
    }

    private void piirrä(int i, int j, Maasto maasto, Graphics graphics) {
         switch (maasto){
            case METSA:{
                graphics.setColor(Color.GREEN);
                graphics.fillRect(i, j, skaalaus, skaalaus);
//                System.out.println("W");
                break;
            }
            case SEINA:{
                graphics.setColor(Color.BLACK);
                graphics.fillRect(i, j, skaalaus, skaalaus);
                break;
            }
         }
                
    }

    private void piirräSieni(int i, int j, Sieni sieni, Graphics graphics) {
        switch(sieni){
            case VOIMASIENI:{     
                try{ 
                   kuva = ImageIO.read(new File("/cs/fs/home/jwholopa/JavaLabra/VoimaSieni.jpg"));
                   graphics.drawImage(kuva, i, j, null);
                    
               } catch (IOException ex) {
                    graphics.fillOval(i*skaalaus, j*skaalaus, 10, 10);
               }
                break;
            }
                
            case PISTESIENI:{
                try{ 
                   kuva = ImageIO.read(new File("/cs/fs/home/jwholopa/JavaLabra/PisteSieni.jpg"));
                   graphics.drawImage(kuva, i, j, null);
               } catch (IOException ex) {
                    graphics.fillOval(i*skaalaus, j*skaalaus, 10, 10);
               }
                break;
            }
                case SIENIMIES:{
                try{ 
                   kuva = ImageIO.read(new File("/cs/fs/home/jwholopa/JavaLabra/Sienimies.jpg"));
                   graphics.drawImage(kuva, i, j, null);
               } catch (IOException ex) {
                    graphics.fillOval(i*skaalaus, j*skaalaus, 10, 10);
               }
                break;
            }
    }
   

}
}
