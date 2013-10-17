/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author Palmera
 */
public class Sistema {

    private ArrayList<Actividad> actividades;

    public Sistema() {
        this.actividades = new ArrayList<>();
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }


    public void cargarData(ArrayList<Actividad> actividad) {
        
        Informacion info = new Informacion();
        info.cargarPlayas(actividad);
        info.cargarRestaurantes(actividad);
        //String descripcionBikini = "";
        //ImageIcon iconoBoton = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_bikini.jpg"));
     //   Actividad bikini = new Actividad("Playa", "playa bikini",descripcionBikini, null, iconoBoton.getImage());

        String descripcionArlechino = "";
        ImageIcon iconoArlechino = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/Arlecchino.gif"));
        Actividad arlechino = new Actividad("Heladeria","heladeria Arlecchino", descripcionArlechino, null, iconoArlechino.getImage());
        
       // actividades.add(bikini);
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
    
    public ArrayList<Actividad> getHeladerias(){
        ArrayList<Actividad> retorno = new ArrayList<>();
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad actividad = this.actividades.get(i);
            String tipo = actividad.getTipo();
            if(tipo.equals("Heladeria"))
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
    
    public ArrayList<Actividad> getRestaurantes(){
        ArrayList<Actividad> retorno = new ArrayList<>();
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad actividad = this.actividades.get(i);
            String tipo = actividad.getTipo();
            if(tipo.equals("Restaurante"))
                retorno.add(actividad);
        }
        return retorno;
    }
    public ArrayList<Actividad> getFavoritos(){
        ArrayList<Actividad> retorno = new ArrayList<>();
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad actividad = this.actividades.get(i);
            if(actividad.isFavorito())
                retorno.add(actividad);
        }
        return retorno;
    }
    
    
}
