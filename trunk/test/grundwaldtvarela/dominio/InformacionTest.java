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
    @Test
    public void testCargarPlayas() {
        System.out.println("cargarPlayas");
        ArrayList<Actividad> listaAct = null;
        Informacion instance = new Informacion();
        instance.cargarPlayas(listaAct);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarRestaurantes method, of class Informacion.
     */
    @Test
    public void testCargarRestaurantes() {
        System.out.println("cargarRestaurantes");
        ArrayList<Actividad> listaAct = null;
        Informacion instance = new Informacion();
        instance.cargarRestaurantes(listaAct);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
