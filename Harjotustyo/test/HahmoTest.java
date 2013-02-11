/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kartta.Kartta;
import Olennot.Hahmo;
import Kartta.Maasto;
import Kartta.Piste;
import Kartta.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jwholopa
 */
public class HahmoTest {
    Kartta k=new Kartta("1230", 2);
    Hahmo ukko = new Hahmo ("Testinimi",k.getKartta()[0][0]);
    Suunta suunta;
    
    
    public HahmoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void NimiTuleeOikein(){
       
       assertEquals("Testinimi",ukko.hahmonnimi() );
    }
    @Test
    public void VoimaAlussaYksi(){
        assertEquals(1,ukko.getVoima());
    }
    @Test
    public void PisteetAlussaNolla(){
        assertEquals(0,ukko.getPisteet());
    }
    @Test
    public void SijantiTuleeOikein(){
        assertEquals(k.getKartta()[0][0],ukko.hahmonSijainti());
    }
    
    @Test
    public void LiikkuukoHahmoItaan(){               
        ukko.liiku(Suunta.Ita);
        assertEquals(k.getKartta()[1][0],ukko.hahmonSijainti());
    }
    @Test
    public void HahmoEiLiikuJosEiYhteytta(){
        ukko.liiku(Suunta.Pohjoinen);
        assertEquals(k.getKartta()[0][0],ukko.hahmonSijainti());
    }
    @Test
    public void HahmoLiikkuuEdesTakas(){
        ukko.liiku(Suunta.Etela);
        ukko.liiku(Suunta.Pohjoinen);
        assertEquals(k.getKartta()[0][0],ukko.hahmonSijainti());
    }
    @Test
    public void PoimiikoHahmoSienen(){
        ukko.liiku(Suunta.Etela);
        assertEquals(null,k.getKartta()[0][1].getSieni());
    }
    @Test
    public void SaakoPistesienestaPisteita(){
        ukko.liiku(Suunta.Etela);
        assertEquals(100,ukko.getPisteet());
    }
    @Test
    public void SaakoVoimasienestaVoimaa(){
        ukko.liiku(Suunta.Ita);
        assertEquals(11,ukko.getVoima());
    }
    @Test
    public void EiMenetaPisteitaJosLiikkuuSeinaaPain(){
        ukko.liiku(Suunta.Ita);
        ukko.liiku(Suunta.Etela);
        ukko.liiku(Suunta.Etela);
        assertEquals(0,ukko.getPisteet());
    }
    @Test
    public void PisteetVaheneeKunLiikkuu(){
        ukko.liiku(Suunta.Ita);
        ukko.liiku(Suunta.Lansi);
        assertEquals(-5,ukko.getPisteet());
    }
}
