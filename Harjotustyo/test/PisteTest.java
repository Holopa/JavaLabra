/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import harjotustyo.Piste;
import harjotustyo.Suunta;
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
public class PisteTest {
    
    Piste eka = new Piste();
    Piste toka =new Piste();
    Suunta suunta;
    
    public PisteTest() {
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
    public void LisätäänYhteys(){
        eka.lisaaYhteys(toka, Suunta.Pohjoinen);
        assertEquals(true,eka.OnkoYhteys(Suunta.Pohjoinen));
    }
    @Test
    public void YhteysTosiaanOnOlemassaTokaan(){
        eka.lisaaYhteys(toka, Suunta.Pohjoinen);
        assertEquals(toka,eka.Yhteys(Suunta.Pohjoinen));        
    }
    @Test
    public void YhdistetaanTyhjaan(){
        eka.lisaaYhteys(null, Suunta.Pohjoinen);
        assertEquals(false,eka.OnkoYhteys(Suunta.Pohjoinen));
    }
    @Test
    public void YhteysItseensaOnnistuu(){
        eka.lisaaYhteys(eka, Suunta.Pohjoinen);
        assertEquals(true,eka.OnkoYhteys(Suunta.Pohjoinen));
    }
    @Test
    public void YhteydenPaalleLaitetaanUusiYhteys(){
        Piste kolmas = new Piste();
        eka.lisaaYhteys(toka, Suunta.Pohjoinen);
        eka.lisaaYhteys(kolmas, Suunta.Pohjoinen);
        assertEquals(kolmas,eka.Yhteys(Suunta.Pohjoinen));
    }
    
    
}
