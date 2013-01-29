/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import harjotustyo.Hahmo;
import harjotustyo.Piste;
import harjotustyo.Suunta;
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
    Piste alku = new Piste();
    Piste pohjoisessa = new Piste();
       Hahmo ukko = new Hahmo ("Testinimi",alku);
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
    public void SijantiTuleeOikein(){
        assertEquals(alku,ukko.hahmonSijainti());
    }
    
    @Test
    public void LiikkuukoHahmoPohjoiseen(){
        alku.lisaaYhteys(pohjoisessa, Suunta.Pohjoinen);
        
        ukko.liiku(Suunta.Pohjoinen);
        assertEquals(pohjoisessa,ukko.hahmonSijainti());
    }
    @Test
    public void HahmoEiLiikuJosEiYhteytta(){
        ukko.liiku(Suunta.Ita);
        assertEquals(alku,ukko.hahmonSijainti());
    }
    @Test
    public void HahmoLiikkuuEdesTakas(){
        alku.lisaaYhteys(pohjoisessa, Suunta.Pohjoinen);
        pohjoisessa.lisaaYhteys(alku, Suunta.Etela);
        ukko.liiku(Suunta.Pohjoinen);
        ukko.liiku(Suunta.Etela);
        assertEquals(alku,ukko.hahmonSijainti());
    }
}
