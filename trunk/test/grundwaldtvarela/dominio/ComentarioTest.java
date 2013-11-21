/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Joaquin
 */
public class ComentarioTest {
    private Comentario comentario;
    
    public ComentarioTest() {        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        comentario = new Comentario("Juan Miguel Pérez", "Excelente Playa. Me encantó!");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getComentario method, of class Comentario.
     */
    @Test
    public void testGetComentario() {
        System.out.println("getComentario");
        Comentario instance = comentario;
        String expResult = "Excelente Playa. Me encantó!";
        String result = instance.getComentario();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setComentario method, of class Comentario.
     */
    @Test
    public void testSetComentario() {
        System.out.println("setComentario");
        String com = "muy bueno!";
        Comentario instance = this.comentario;        
        instance.setComentario(com);
        assertEquals("muy bueno!",instance.getComentario());
    }

    /**
     * Test of getUsuario method, of class Comentario.
     */
    @Test
    public void testGetUsuario() {
        Comentario instance = comentario;
        String expResult = "Juan Miguel Pérez";
        String result = instance.getUsuario();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setUsuario method, of class Comentario.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String com = "Joaquin";
        Comentario instance = this.comentario;        
        instance.setUsuario(com);
        assertEquals("Joaquin",instance.getUsuario());
    }

    /**
     * Test of equals method, of class Comentario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Comentario o = new Comentario("Juan Miguel Pérez", "Excelente Playa. Me encantó!");
        Comentario instance = comentario;
        boolean result = instance.equals(o);
       assertTrue(result);
    }
}
