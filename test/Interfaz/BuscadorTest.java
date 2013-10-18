/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import dominio.Actividad;
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
public class BuscadorTest {
    
    public BuscadorTest() {
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
     * Test of getTodosLosNombres method, of class Buscador.
     */
    @Test
    public void testGetTodosLosNombres() {
        System.out.println("getTodosLosNombres");
        ArrayList<Actividad> actividades = null;
        Buscador instance = null;
        String[] expResult = null;
        String[] result = instance.getTodosLosNombres(actividades);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarResultadosPorNombre method, of class Buscador.
     */
    @Test
    public void testCargarResultadosPorNombre() {
        System.out.println("cargarResultadosPorNombre");
        String buscar = "";
        Buscador instance = null;
        instance.cargarResultadosPorNombre(buscar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarResultadosPorNombreYDescripcion method, of class Buscador.
     */
    @Test
    public void testCargarResultadosPorNombreYDescripcion() {
        System.out.println("cargarResultadosPorNombreYDescripcion");
        String buscar = "";
        Buscador instance = null;
        instance.cargarResultadosPorNombreYDescripcion(buscar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInfo method, of class Buscador.
     */
    @Test
    public void testMostrarInfo() {
        System.out.println("mostrarInfo");
        Actividad act = null;
        Buscador instance = null;
        instance.mostrarInfo(act);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
