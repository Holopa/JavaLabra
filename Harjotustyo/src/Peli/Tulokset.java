/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jwholopa
 */
public class Tulokset {
    
    private String[] tulokset;
    private Scanner skanneri;
    private File teksti;
    
    public Tulokset() throws FileNotFoundException{
    tulokset = new String[10];
    teksti = new File("/cs/fs/home/jwholopa/JavaLabra/Tulokset.txt");
    skanneri= new Scanner(teksti);
    lueTulokset();
    }
    
    public void lueTulokset(){
        int apu=0;
        while(skanneri.hasNextLine()){
            tulokset[apu]=skanneri.nextLine();
            
            System.out.println(tulokset[apu]);
            apu++;
        }
    }
    
    public void kirjoitaTulokset(){
        
    }
}
