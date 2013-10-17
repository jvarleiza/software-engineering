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
        this.actividades = new ArrayList<>();
        this.favoritos = new ArrayList<>();
        
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
      
        Actividad bikini = new Actividad("Playa", "playa bikini",descripcionBikini, null);

        String descripcionArlechino = "";
        Actividad arlechino = new Actividad("Heladeria","heladeria are¡lechino", descripcionArlechino, null);
        
        actividades.add(bikini);
        actividades.add(arlechino);


    }
    public ArrayList<Actividad> getBares(){
        ArrayList<Actividad> retorno = new ArrayList<>();
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad actividad = this.actividades.get(i);
            String tipo = actividad.getTipo();
            if(tipo.equals("Bar"))
                retorno.add(actividad);
        }
        return retorno;
    }
    
    public ArrayList<Actividad> getPlayas(){
        ArrayList<Actividad> retorno = new ArrayList<>();
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad actividad = this.actividades.get(i);
            String tipo = actividad.getTipo();
            if(tipo.equals("Playa"))
                retorno.add(actividad);
        }
        return retorno;
    }
}
