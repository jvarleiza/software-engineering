/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

import grundwaldtvarela.dominio.Actividad;
import grundwaldtvarela.dominio.Sistema;
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

  
    @Test
    public void testGetBaresSistemaVacio() {
        System.out.println("getBares - sistema vacio");
        Sistema instance = new Sistema();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.getBares();
        assertEquals(expResult, result);
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
        
    }

   
    @Test
    public void testGetPlayasSistemaVacio() {
        System.out.println("getPlayas - sistema vacio");
        Sistema instance = new Sistema();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.getPlayas();
        assertEquals(expResult, result);
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
    }
    
    @Test
    public void testGetRestaurantesSistemaCargado() {
        System.out.println("getRestaurantes - sistema cargado");
        Sistema instance = new Sistema();
        instance.cargarData(instance.getActividades());
        ArrayList todasActividades = instance.getActividades();
        ArrayList<Actividad> expResult = new ArrayList<>();
        for (int i = 0; i < todasActividades.size(); i++) {
            Actividad a = (Actividad)todasActividades.get(i);
            if(a.getTipo().equals("Restaurantes"))
                expResult.add(a);
        }
        
        ArrayList result = instance.getRestaurantes();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of getActividades method, of class Sistema.
     */
    @Test
    public void testGetActividades() {
        setUp();
        System.out.println("getActividades");        
        ArrayList result = data.getActividades();
        int todasLasActividades = 13;
        int cantidadResultante = result.size();
        assertEquals(todasLasActividades, cantidadResultante);
    }

    /**
     * Test of getBares method, of class Sistema.
     */
    @Test
    public void testGetBares() {
        setUp();
        System.out.println("getBares");
        //Sistema instance = new Sistema();
        int expResult = 0;
        ArrayList lista = data.getBares();
        int result = lista.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPlayas method, of class Sistema.
     */
    @Test
    public void testGetPlayas() {
        setUp();
        System.out.println("getPlayas");
        int expResult = 8;
        ArrayList result = data.getPlayas();
        assertEquals(expResult, result.size());

    }

    /**
     * Test of getRestaurantes method, of class Sistema.
     */
    @Test
    public void testGetRestaurantes() {
        setUp();
        System.out.println("getRestaurantes");
        int expResult = 5;
        ArrayList result = data.getRestaurantes();
        assertEquals(expResult, result.size());

    }

    /**
     * Test of getTodosLosNombres method, of class Sistema.
     */
    @Test
    public void testGetTodosLosNombres() {
        System.out.println("getTodosLosNombres");
        ArrayList<Actividad> actividades = data.getPlayas();
        Sistema instance = new Sistema();
        String[] expResult = null;
        int totalEsperado = actividades.size();
        String[] result = instance.getTodosLosNombres(actividades);
        int totalResultante = result.length;
        assertEquals(totalEsperado, totalResultante);

    }

    /**
     * Test of filtrarActividades method, of class Sistema.
     */
    @Test
    public void testFiltrarActividades() {
        setUp();
        System.out.println("filtrarActividades");
        
        String tipoActividad = "Playas";
        Sistema instance = new Sistema();
        ArrayList expResult = data.getPlayas();
        ArrayList result = instance.filtrarActividades(data, tipoActividad);
        assertEquals(expResult, result);

    }
}
