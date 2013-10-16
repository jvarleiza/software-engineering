/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


/**
 *
 * @author Palmera
 */
public class Sistema {

    private ArrayList<Actividad> actividades;
    private ArrayList<Actividad> favoritos;

    public Sistema() {
        this.actividades = new ArrayList<Actividad>();
        this.favoritos = new ArrayList<Actividad>();
        
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<Actividad> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<Actividad> favoritos) {
        this.favoritos = favoritos;
    }

    public void cargarData(ArrayList<Actividad> actividad) {
        URL resource = Sistema.class.getResource("/Interfaz/imagenes/playa_bikini.jpg");
        
        String descripcionBikini = "";
      
        Actividad bikini = new Actividad("playa", "playa bikini",descripcionBikini, null);

        String descripcionArlechino = "";
        Actividad arlechino = new Actividad("heladeria","heladeria are¡lechino", descripcionArlechino, null);
        
        actividades.add(bikini);
        actividades.add(arlechino);


    }
}
