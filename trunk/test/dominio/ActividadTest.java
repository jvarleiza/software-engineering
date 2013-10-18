/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.awt.Image;
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
public class ActividadTest {
    
    
    Actividad prueba;
    public ActividadTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        prueba = new Actividad("Playa", "Bikini", "playa bikini", null, null);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMapa method, of class Actividad.
     */
    @Test
    public void testGetMapa() {
        System.out.println("getMapa");
        Actividad instance = null;
        Image expResult = null;
        Image result = instance.getMapa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapa method, of class Actividad.
     */
    @Test
    public void testSetMapa() {
        System.out.println("setMapa");
        Image mapa = null;
        Actividad instance = null;
        instance.setMapa(mapa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Actividad.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Actividad instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Actividad.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Actividad instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of getDescripcion method, of class Actividad.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Actividad instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Actividad.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Actividad instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFavorito method, of class Actividad.
     */
    @Test
    public void testIsFavorito() {
        System.out.println("isFavorito");
        Actividad instance = null;
        boolean expResult = false;
        boolean result = instance.isFavorito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFavorito method, of class Actividad.
     */
    @Test
    public void testSetFavorito() {
        System.out.println("setFavorito");
        boolean favorito = false;
        Actividad instance = null;
        instance.setFavorito(favorito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImg method, of class Actividad.
     */
    @Test
    public void testGetImg() {
        System.out.println("getImg");
        Actividad instance = null;
        Image expResult = null;
        Image result = instance.getImg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImg method, of class Actividad.
     */
    @Test
    public void testSetImg() {
        System.out.println("setImg");
        Image img = null;
        Actividad instance = null;
        instance.setImg(img);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Actividad.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Actividad instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Actividad.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Actividad instance = null;
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
