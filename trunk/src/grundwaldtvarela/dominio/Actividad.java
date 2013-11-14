/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Palmera
 */
public class Actividad implements Comparable{
    
    private String tipo;
    private String nombre;
    private String descripcion;
    private boolean favorito;
    private Image img;
    private Image mapa;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    private ArrayList<Comentario> comentarios;
    private int pos;
   


    public Actividad(String tipo, String nombre, String descripcion, Image img, Image mapa, int pos) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.favorito = false;
        this.nombre = nombre;
        this.img = img;
        this.mapa = mapa;
        comentarios = new ArrayList<>();
        this.pos = pos;
    }

    public Image getMapa() {
        return mapa;
    }

    public void setMapa(Image mapa) {
        this.mapa = mapa;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public void insetarComentario(String key, String value){
        Comentario nuevo = new Comentario(key, value);
        this.comentarios.add(nuevo);
    }
    
    
    public ArrayList<Comentario> recuperarComentarios(){
        return this.comentarios;
    }
    
    @Override
    public int compareTo(Object unaAct){
        return (((Actividad)unaAct).getNombre().compareTo(this.getNombre()))*(-1);
    }
    
}
