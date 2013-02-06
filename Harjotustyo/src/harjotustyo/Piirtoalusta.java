/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jwholopa
 */
public class Piirtoalusta extends JPanel {

    private Kartta kartta;
    public Piirtoalusta(Kartta kartta) {
        super.setBackground(Color.BLACK);
        this.kartta=kartta;
        
    }

    

    @Override
    protected void paintComponent(Graphics graphics) {
       
        Piste[][] k = kartta.getKartta();
        
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                piirrä(15*i,15*j,k[i][j].maasto(), graphics); 
            }
        }
    }

    private void piirrä(int i, int j, Maasto maasto, Graphics graphics) {
         switch (maasto){
            case METSA:{
                graphics.setColor(Color.PINK);
                graphics.fillRect(i, j, 10, 10);
                System.out.println("W");
                break;
            }
            case SEINA:{
                graphics.setColor(Color.RED);
                graphics.fillRect(i, j, 10, 10);
                break;
            }
         }
                
    }
   

}
