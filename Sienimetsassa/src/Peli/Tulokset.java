/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jwholopa
 */
public class Tulokset {
    
    private String[] tulokset;
    private int[] lukutaulu;
    private Scanner skanneri;
    private File teksti;
    
    public Tulokset() throws FileNotFoundException{
    tulokset = new String[10];
    lukutaulu= new int[10];
    teksti = new File("/cs/fs/home/jwholopa/JavaLabra/Tulokset.txt");
    skanneri= new Scanner(teksti);
    lueTulokset();
    }
    
    private void lueTulokset(){
        int apu=0;
        while(skanneri.hasNextLine()&& apu<10){
            if(skanneri.hasNextInt()){
                lukutaulu[apu]=skanneri.nextInt();
            }
            tulokset[apu]=skanneri.nextLine();
            
//            System.out.println(lukutaulu[apu]);
            apu++;
        }
    }
    
    public String kirjoitaTulokset(int i){
        if (i<10 && i >=0){
            return tulokset[i];
        }
        return "";
    }
    
    public void tuloksenLisays(int tulos){
        int apumuuttuja=tulos;
        int apumuuttuja2;
        for (int i = 0; i < 10; i++) {
            if (apumuuttuja>lukutaulu[i]){
                apumuuttuja2=lukutaulu[i];
                lukutaulu[i]=apumuuttuja;
                tulokset[i]=""+apumuuttuja;
                apumuuttuja=apumuuttuja2;
            }
        }
        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(teksti))) {
                for (int i = 0; i < 10; i++) {
                    out.write(tulokset[i] + "\n");
                }
            }
        } catch (IOException e) {}
    }

    
}
