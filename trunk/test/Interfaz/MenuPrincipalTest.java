/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import dominio.Actividad;
import dominio.Sistema;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class MenuPrincipalTest {
    
    JButton boton;
    MenuPrincipal menu;
    Sistema data;
    
    public MenuPrincipalTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        menu = new MenuPrincipal();
        data = new Sistema();
        data.cargarData(data.getActividades());
        
        boton = new JButton();
        boton.setBounds(10, 30, 150, 150);
        Image resizedImage = menu.getImageIcon("/Interfaz/imagenes/playa_icono.png", boton);
        boton.setIcon(new ImageIcon(resizedImage));
        boton.setVisible(true);
        final String tipoActividad = "Playas";
        boton.addActionListener(new ActionListener() {
            //cuando hacen click en el boton, filtra las actividades correspondientes
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ArrayList<Actividad> actividades = menu.filtrarActividades(data, tipoActividad);
                menu.abrirVentanaCorrespondiente(actividades, tipoActividad);
            }
        });
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearBotonera method, of class MenuPrincipal.
     */
    @Test
    public void testCrearBotonera() {
        System.out.println("crearBotonera");
        MenuPrincipal instance = new MenuPrincipal();
        instance.crearBotonera();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearBoton method, of class MenuPrincipal.
     */
    @Test
    public void testCrearBoton() {
        setUp();
        System.out.println("crearBoton");
        String rutaImagen = "/Interfaz/imagenes/playa_icono.png";
        int x = 10;
        int y = 30;
        String tipo = "Playas";
        MenuPrincipal instance = new MenuPrincipal();
        JButton expResult = boton;
        JButton result = instance.crearBoton(rutaImagen, x, y, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of abrirVentanaCorrespondiente method, of class MenuPrincipal.
     */
    @Test
    public void testAbrirVentanaCorrespondiente() {
        System.out.println("abrirVentanaCorrespondiente");
        ArrayList<Actividad> actividades = null;
        String tipoActividad = "";
        MenuPrincipal instance = new MenuPrincipal();
        instance.abrirVentanaCorrespondiente(actividades, tipoActividad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filtrarActividades method, of class MenuPrincipal.
     */
    @Test
    public void testFiltrarActividades() {
        System.out.println("filtrarActividades - playas");
        Sistema data = new Sistema();
        data.cargarData(data.getActividades());
        
        String tipoActividad = "Playas";
        MenuPrincipal instance = new MenuPrincipal();
        ArrayList expResult = data.getPlayas();
        ArrayList result = instance.filtrarActividades(data, tipoActividad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImageIcon method, of class MenuPrincipal.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        String rutaImagen = "";
        JButton boton = null;
        MenuPrincipal instance = new MenuPrincipal();
        Image expResult = null;
        Image result = instance.getImageIcon(rutaImagen, boton);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MenuPrincipal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MenuPrincipal.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
