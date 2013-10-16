/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Palmera
 */
public class Actividad {
    
    private String tipo;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String descripcion;
    private ArrayList<Comentario> comentarios;
    private boolean favorito;
   // private Image img;

    public Actividad(String tipo, String nombre, String descripcion, ArrayList<Comentario> comentarios) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.favorito = false;
        this.nombre = nombre;
     //   this.img = img;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

   /* public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }*/

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}