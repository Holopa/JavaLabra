/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;

/**
 * 
 * 
 * 
 * @author jwholopa
 */
public class Kartta {
    
    private Piste[][] kartta;
    Suunta suunta;
    private int maxKoko;

    
    public Kartta(String s, int i){
        maxKoko=i;
        kartta=new Piste[i][i];
        LuoKartta(i, s);
    }
    
    public void AlustaKartta(Piste alkupiste){
        kartta[10][10] = alkupiste;
    }
    
    public void Lisaayhteys(Piste mihin, Suunta suunta){
        
    }
    public Maasto Maasto(int i, int j){ 
        if(i>maxKoko || j> maxKoko){
            return null;
        }
        return kartta[i][j].maasto();
    }

    public Piste[][] getKartta() {
        return kartta;
    }

    private void LuoKartta(int i, String s) {
        int apu=0;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if (s.charAt(apu)== '1'){
                    kartta[j][k]=new Piste(Maasto.METSA);
                    System.out.println("Piste"+j+","+k+"on Metsää");
                }
                else {
                    kartta[j][k]=new Piste(Maasto.SEINA);
                    System.out.println("Piste"+j+","+k+"on Seinää");

                }
                apu=apu+1;
            }
           
       }
    }
    
}
