/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
public class SistemaTest {
    
    
    Sistema data;
    
    public SistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        data = new Sistema();
        data.cargarData(data.getActividades());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getActividades method, of class Sistema.
     */
    @Test
    public void testGetActividadesSistemaVacio() {
        System.out.println("getActividades - sistema vacio");
        Sistema instance = new Sistema();
        ArrayList expResult = null;
        ArrayList result = instance.getActividades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActividades method, of class Sistema.
     */
    @Test
    public void testSetActividades() {
        System.out.println("setActividades");
        ArrayList<Actividad> actividades = null;
        Sistema instance = new Sistema();
        instance.setActividades(actividades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarData method, of class Sistema.
     */
    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        ArrayList<Actividad> actividad = null;
        Sistema instance = new Sistema();
        instance.cargarData(actividad);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBares method, of class Sistema.
     */
    @Test
    public void testGetBaresSistemaVacio() {
        System.out.println("getBares - sistema vacio");
        Sistema instance = new Sistema();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.getBares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetBaresSistemaCargado() {
        System.out.println("getBares - sistema cargado");
        Sistema instance = new Sistema();
        instance.cargarData(instance.getActividades());
        ArrayList todasActividades = instance.getActividades();
        ArrayList expResult = new ArrayList();
        for (int i = 0; i < todasActividades.size(); i++) {
            Actividad a = (Actividad)todasActividades.get(i);
            if(a.getTipo().equals("Bares"))
                expResult.add(a);
        }
        
        ArrayList result = instance.getBares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHeladerias method, of class Sistema.
     */
    @Test
    public void testGetHeladerias() {
        System.out.println("getHeladerias");
        Sistema instance = new Sistema();
        ArrayList expResult = null;
        ArrayList result = instance.getHeladerias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayas method, of class Sistema.
     */
    @Test
    public void testGetPlayasSistemaVacio() {
        System.out.println("getPlayas - sistema vacio");
        Sistema instance = new Sistema();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.getPlayas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetPlayasSistemaCargado() {
        System.out.println("getPlayas - sistema cargado");
        Sistema instance = new Sistema();
        instance.cargarData(instance.getActividades());
        ArrayList todasActividades = instance.getActividades();
        ArrayList expResult = new ArrayList();
        for (int i = 0; i < todasActividades.size(); i++) {
            Actividad a = (Actividad)todasActividades.get(i);
            if(a.getTipo().equals("Playas"))
                expResult.add(a);
        }
        
        ArrayList result = instance.getBares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of getRestaurantes method, of class Sistema.
     */
    @Test
    public void testGetRestaurantesSistemaVacio() {
        System.out.println("getRestaurantes - sistema vacio");
        Sistema instance = new Sistema();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.getRestaurantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetRestaurantesSistemaCargado() {
        System.out.println("getRestaurantes - sistema cargado");
        Sistema instance = new Sistema();
        instance.cargarData(instance.getActividades());
        ArrayList todasActividades = instance.getActividades();
        ArrayList expResult = new ArrayList();
        for (int i = 0; i < todasActividades.size(); i++) {
            Actividad a = (Actividad)todasActividades.get(i);
            if(a.getTipo().equals("Restaurantes"))
                expResult.add(a);
        }
        
        ArrayList result = instance.getBares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFavoritos method, of class Sistema.
     */
    @Test
    public void testGetFavoritos() {
        System.out.println("getFavoritos");
        Sistema instance = new Sistema();
        ArrayList expResult = data.getFavoritos();
        ArrayList result = instance.getFavoritos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
