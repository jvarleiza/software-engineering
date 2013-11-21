/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

import grundwaldtvarela.dominio.Actividad;
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
        prueba = new Actividad("Playa", "Bikini", "playa bikini", null, null, 100);
        prueba.setFavorito(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMapa method, of class Actividad.
     */
    @Test
    public void testGetMapa() {
        setUp();
        System.out.println("getMapa");
        Image expResult = null;
        Image result = prueba.getMapa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMapa method, of class Actividad.
     */
    @Test
    public void testSetMapa() {
        setUp();
        System.out.println("setMapa");
        Image mapa = null;
        prueba.setMapa(mapa);
        boolean resultado;
        boolean expResult = true;
        if(prueba.getMapa()== mapa)
            resultado = true;
        else 
            resultado = false;
        
        assertEquals(expResult, resultado);        
    }

    /**
     * Test of getNombre method, of class Actividad.
     */
    @Test
    public void testGetNombre() {
        setUp();
        System.out.println("getNombre");
        String expResult = "Bikini";
        String result = prueba.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Actividad.
     */
    @Test
    public void testSetNombre() {
        setUp();
        System.out.println("setNombre");
        String nombre = "EL cabo";
        prueba.setNombre(nombre);
        
        assertEquals(prueba.getNombre(), nombre);
    }



    /**
     * Test of getDescripcion method, of class Actividad.
     */
    @Test
    public void testGetDescripcion() {
        setUp();
        System.out.println("getDescripcion");
        String expResult = "playa bikini";
        String result = prueba.getDescripcion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescripcion method, of class Actividad.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        setUp();
        String nombre = "Descr prueba";
        prueba.setDescripcion(nombre);
        
        assertEquals(prueba.getDescripcion(), nombre);
    }

    /**
     * Test of isFavorito method, of class Actividad.
     */
    @Test
    public void testIsFavorito() {
        setUp();
        System.out.println("isFavorito");
        boolean expResult = true;
        boolean result = prueba.isFavorito();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFavorito method, of class Actividad.
     */
    @Test
    public void testSetFavorito() {
        setUp();
        System.out.println("setFavorito");
        boolean favorito = false;
        prueba.setFavorito(favorito);
        assertEquals(favorito, prueba.isFavorito());
    }

    /**
     * Test of getImg method, of class Actividad.
     */
    @Test
    public void testGetImg() {
        setUp();
        System.out.println("getImg");
        Image expResult = null;
        Image result = prueba.getImg();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImg method, of class Actividad.
     */
    @Test
    public void testSetImg() {
        setUp();
        System.out.println("setImg");
        Image img = null;
        prueba.setImg(img);
        boolean resultado;
        boolean expResult = true;
        if(prueba.getImg()== img)
            resultado = true;
        else 
            resultado = false;
        
        assertEquals(expResult, resultado);  
    }

    /**
     * Test of getTipo method, of class Actividad.
     */
    @Test
    public void testGetTipo() {
        setUp();
        System.out.println("getTipo");
        String expResult = "Playa";
        String result = prueba.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTipo method, of class Actividad.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        setUp();
        String nombre = "XXX";
        prueba.setTipo(nombre);
        
        assertEquals(prueba.getTipo(), nombre);
    }

    /**
     * Test of getPos method, of class Actividad.
     */
    @Test
    public void testGetPos() {
        System.out.println("getPos");
        Actividad instance = prueba;
        int result = instance.getPos();
        assertTrue(result==100);
    }

    /**
     * Test of setPos method, of class Actividad.
     */
    @Test
    public void testSetPos() {
        System.out.println("setPos");
        int pos = 10;
        Actividad instance = prueba;
        instance.setPos(pos);
        assertTrue(instance.getPos() == pos);
        assertFalse(instance.getPos() != pos);
    }

    /**
     * Test of insetarComentario method, of class Actividad.
     */
    @Test
    public void testInsetarComentario() {
        System.out.println("insetarComentario");
        String key = "joaquin";
        String value = "Bueno!";
        Actividad instance = prueba;
        instance.insetarComentario(key, value);
        Comentario com = new Comentario(key, value);
        assertTrue(instance.recuperarComentarios().contains(com));
    }

    /**
     * Test of recuperarComentarios method, of class Actividad.
     */
    @Test
    public void testRecuperarComentarios() {
        System.out.println("recuperarComentarios");
        Actividad instance = prueba;
        instance.insetarComentario("Juan", "Bueno!");
        instance.insetarComentario("joaquin", "Excelente!");
        int expResult = 2;
        int result = instance.recuperarComentarios().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Actividad.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Actividad unaAct = new Actividad("Playa", "Bikini", "playa bikini", null, null, 100);
        Actividad instance = prueba;
        int expResult = 0;
        int result = instance.compareTo(unaAct);
        assertEquals(expResult, result);
    }
}
