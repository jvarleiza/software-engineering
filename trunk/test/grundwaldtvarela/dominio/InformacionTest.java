/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

import grundwaldtvarela.dominio.Informacion;
import grundwaldtvarela.dominio.Actividad;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Palmera
 */
public class InformacionTest {
    
    public InformacionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cargarPlayas method, of class Informacion.
     */
    
    //tienen que haber 8 playas ingresadas al sistema
    @Test
    public void testCargarPlayas() {
        System.out.println("cargarPlayas");
        ArrayList<Actividad> listaAct = new ArrayList<>();
        Informacion instance = new Informacion();
        instance.cargarPlayas(listaAct);
        int expResult = 8;
        int result = listaAct.size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of cargarRestaurantes method, of class Informacion.
     */
    
    //tienen que haber 5 restaurantes ingresados al sistema
    @Test
    public void testCargarRestaurantes() {
        System.out.println("cargarRestaurantes");
        ArrayList<Actividad> listaAct = new ArrayList<>();
        Informacion instance = new Informacion();
        instance.cargarRestaurantes(listaAct);
        int expResult = 5;
        int result = listaAct.size();
        assertEquals(expResult, result);
        
    }
}
