/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harjotustyo;

/**
 *
 * @author jwholopa
 */
public class Harjotustyo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kartta k=new Kartta("0101", 2);
        System.out.println(k.Maasto(0, 1));
        Kayttis kay =new Kayttis(k);
        kay.run();
    }
}
