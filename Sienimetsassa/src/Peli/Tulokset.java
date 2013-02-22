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
        teksti = new File("src/Tulokset.txt");
        if (teksti.exists()){
            skanneri= new Scanner(teksti);
            lueTulokset();
        }
        else {
            asetaTuloksetNolliksi();
        }
        }
    /**
     * lukee tulokset jos sakannerille annettiin kelvollinen tiedosto.
     */
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
    
    /**
     * palauttaa tulostaulun i:nen tuloksen, muuten palauttaa tyhjän stringin
     * @param i
     * @return 
     */
    public String kirjoitaTulokset(int i){
        if (i<10 && i >=0){
            return tulokset[i];
        }
        return "";
    }
    
    /**
     * Lisää tuloksen tuloslistaan jos lisättävä tulos on tarpeeksi suuri. tarkoitus olisi, että myös tulos tiedosto kirjoitettaisiin uudestaan joka kerta,
     * mutta tätä en saanut ajan puutteen takia toimimaan.
     * @param tulos 
     */
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

    private void asetaTuloksetNolliksi() {
        for (int i = 0; i < 10; i++) {
            lukutaulu[i]=0;
            tulokset[i]="0";
        }
    }

    
}
