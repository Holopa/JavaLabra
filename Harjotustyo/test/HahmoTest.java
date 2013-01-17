/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import harjotustyo.Hahmo;
import harjotustyo.Piste;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jwholopa
 */
public class HahmoTest {
    Piste alku = new Piste();
    Piste pohjoisessa = new Piste();
       Hahmo ukko = new Hahmo ("Testinimi",alku);
    
    
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
        alku.lisaaYhteys(pohjoisessa, 1);
        
        ukko.liiku(1);
        assertEquals(pohjoisessa,ukko.hahmonSijainti());
    }
    @Test
    public void HahmoEiLiikuJosEiYhteytta(){
        ukko.liiku(2);
        assertEquals(alku,ukko.hahmonSijainti());
    }
    @Test
    public void HahmoLiikkuuEdesTakas(){
        alku.lisaaYhteys(pohjoisessa, 1);
        pohjoisessa.lisaaYhteys(alku, 3);
        ukko.liiku(1);
        ukko.liiku(3);
        assertEquals(alku,ukko.hahmonSijainti());
    }
}
