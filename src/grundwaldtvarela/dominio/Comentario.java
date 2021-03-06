/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

/**
 *
 * @author Palmera
 */
public class Comentario {

    private String usuario;
    private String comentario;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Comentario(String usuario, String comentario) {
        this.usuario = usuario;
        this.comentario = comentario;
    }

    //@Override
    //public String toString(){
    //   return this.usuario + "\n\n\n\n ---> " + this.comentario;
    // }
    @Override
    public boolean equals(Object o) {
        return this.usuario.equals(((Comentario) o).getUsuario()) && this.comentario.equals(((Comentario) o).getComentario());
    }
}