/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PisteTest {
    
    Piste eka = new Piste();
    Piste toka =new Piste();
    
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
        eka.lisaaYhteys(toka, 1);
        assertEquals(true,eka.OnkoYhteysPohjoiseen());
    }
    @Test
    public void YhteysTosiaanOnOlemassaTokaan(){
        eka.lisaaYhteys(toka, 1);
        assertEquals(toka,eka.Yhteys(1));        
    }
    @Test
    public void YhdistetaanTyhjaan(){
        eka.lisaaYhteys(null, 1);
        assertEquals(false,eka.OnkoYhteysPohjoiseen());
    }
    @Test
    public void YhteysItseensaOnnistuu(){
        eka.lisaaYhteys(eka, 1);
        assertEquals(true,eka.OnkoYhteysPohjoiseen());
    }
    @Test
    public void YhteydenPaalleLaitetaanUusiYhteys(){
        Piste kolmas = new Piste();
        eka.lisaaYhteys(toka, 1);
        eka.lisaaYhteys(kolmas, 1);
        assertEquals(kolmas,eka.Yhteys(1));
    }
    
    
}
