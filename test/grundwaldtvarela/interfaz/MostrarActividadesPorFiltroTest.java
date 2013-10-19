/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.interfaz;

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
public class MostrarActividadesPorFiltroTest {

    ArrayList<Actividad> actividadesPlayas;
    ArrayList<Actividad> actividadesFavoritos;
    Sistema data;

    public MostrarActividadesPorFiltroTest() {
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
        actividadesPlayas = data.getPlayas();
        actividadesFavoritos = data.getFavoritos();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombresActividades method, of class MostrarActividadesPorFiltro.
     */
    @Test
    public void testGetNombresActividades() {
        System.out.println("getNombresActividades");
        MostrarActividadesPorFiltro instance = null;
        String[] expResult = null;
        String[] result = instance.getNombresActividades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarActividadDefault method, of class MostrarActividadesPorFiltro.
     */
    @Test
    public void testCargarActividadDefault() {
        System.out.println("cargarActividadDefault");
        ArrayList<Actividad> actividadLocal = actividadesPlayas;
        MostrarActividadesPorFiltro instance = null;
        if (!actividadLocal.isEmpty()) {
            instance.cargarActividadDefault(actividadLocal);
        } else {
            //fail("La lista esta vacia");
        }
        // TODO review the generated test code and remove the default call to fail.

    }
}
