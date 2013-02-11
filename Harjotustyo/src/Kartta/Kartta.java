/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kartta;

import Kartta.Maasto;
import Kartta.Suunta;
import Kartta.Piste;

/**
 * Pitää sisällään 2 ulottaista taulukkoa, jonka alkioina on pisteitä.
 * 
 * 
 * @author jwholopa
 */
public class Kartta {
    
    private Piste[][] kartta;
    Suunta suunta;
    private int maxKoko;

    
    public Kartta(String maastot, int i){
        maxKoko=i;
        kartta=new Piste[i][i];
        LuoKartta(i, maastot);
        LisaaYhteydet();
    }
       
    /**
     * Palauttaa pisteen (i,j) maaston
     * @param i 
     * @param j
     * @return 
     */
    public Maasto Maasto(int i, int j){ 
        if((i>maxKoko || i<0) || (j> maxKoko || j<0)){
            return null;
        }
        return kartta[i][j].maasto();
    }

    public Piste[][] getKartta() {
        return kartta;
    }

    /**
     * Antaa kartan pisteille maastoparametrin annetun maastot muuttujan mukaan
     * @param i
     * @param maastot 
     */
    private void LuoKartta(int max, String maastot) {
        int apu=0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (maastot.length()>apu && maastot.charAt(apu)== '1'){
                    kartta[i][j]=new Piste(Maasto.METSA,i,j);
//                    System.out.println("Piste"+i+","+j+"on Metsää");
                }
                else if (maastot.length()>apu && maastot.charAt(apu)== '2'){
                    kartta[i][j]=new Piste(Maasto.METSA,i,j);
                    kartta[i][j].setSieni(Sieni.PISTESIENI);
//                    System.out.println("Piste"+i+","+j+"on Metsää ja sieni on "+ kartta[i][j].getSieni());
                }
                else if (maastot.length()>apu && maastot.charAt(apu)== '3'){
                    kartta[i][j]=new Piste(Maasto.METSA,i,j);
                    kartta[i][j].setSieni(Sieni.VOIMASIENI);
                }
                else if (maastot.length()>apu && maastot.charAt(apu)== '4'){
                    kartta[i][j]=new Piste(Maasto.METSA,i,j);
                    kartta[i][j].setSieni(Sieni.SIENIMIES);
                }
                else {
                    kartta[i][j]=new Piste(Maasto.SEINA,i,j);
//                    System.out.println("Piste"+i+","+j+"on Seinää");

                }
                apu=apu+1;
            }
           
       }
    }

    /**
     * Käy kartan läpi ja lisää yhteyden pisteestä naapuuriin, jos naapuri ei ole seinää.
     */
    private void LisaaYhteydet() {
        for (int i = 0; i < maxKoko; i++) {
            for (int j = 0; j < maxKoko; j++) {
                if(i-1>=0 && kartta[i-1][j].maasto() != Maasto.SEINA && kartta[i][j].maasto() != Maasto.SEINA){
                    kartta[i][j].lisaaYhteys(kartta[i-1][j], Suunta.Lansi);
                }
                if(j-1>=0 && kartta[i][j-1].maasto() != Maasto.SEINA && kartta[i][j].maasto() != Maasto.SEINA){
                    kartta[i][j].lisaaYhteys(kartta[i][j-1], Suunta.Pohjoinen);
                }
                if(i+1<maxKoko && kartta[i+1][j].maasto() != Maasto.SEINA && kartta[i][j].maasto() != Maasto.SEINA){
                    kartta[i][j].lisaaYhteys(kartta[i+1][j], Suunta.Ita);
                }
                if(j+1<maxKoko && kartta[i][j+1].maasto() != Maasto.SEINA && kartta[i][j].maasto() != Maasto.SEINA){
                    kartta[i][j].lisaaYhteys(kartta[i][j+1], Suunta.Etela);
                }
            }
            
        }
    }
    
}
