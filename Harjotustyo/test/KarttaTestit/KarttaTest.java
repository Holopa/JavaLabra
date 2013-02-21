package KarttaTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kartta.Kartta;
import Kartta.Maasto;
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
public class KarttaTest {
    
    Kartta map=new Kartta("0110", 2);
    
    public KarttaTest() {
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
    public void LuoKartanOikeinMaastot(){
        assertEquals(Maasto.METSA, map.Maasto(0, 1));
    }
    @Test
    public void LuoKartanOikeinKoko(){
        assertEquals(null, map.Maasto(3, 2));
    }
    @Test
    public void LuoKartanOikeinKoko2(){
        assertEquals(false, map.getKartta().length>2);
    }
    @Test
    public void LuoKartanOikeinNegatiivisetkordinaatit(){
        assertEquals(null, map.Maasto(-1, 2));
    }
    
}
