
package grundwaldtvarela.dominio;

import java.util.ArrayList;
import java.util.Collections;


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

    public void ordenarListaActividades() {
        Collections.sort(this.actividades);
    }

    public void cargarData(ArrayList<Actividad> actividad) {
        
        InformacionPuntaDelEste info = new InformacionPuntaDelEste();
        info.cargarPlayas(actividad);
        info.cargarRestaurantes(actividad);

        info.cargarBares(actividad);

        info.cargarHeladerias(actividad);


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
    
    public ArrayList<Actividad> getCercaMio(){
        ArrayList<Actividad> retorno = new ArrayList<>();
        int x = 50;
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad actividad = this.actividades.get(i);
            
            if(actividad.getPos()<x)
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
    
    
    public String[] getTodosLosNombres(ArrayList<Actividad> actividades) {
        String[] nombres = new String[actividades.size()];
        for (int i = 0; i < actividades.size(); i++) {
            String nombre = actividades.get(i).getNombre();
            nombres[i] = nombre;
        }
        return nombres;
    }
    
    public ArrayList<Actividad> filtrarActividades(Sistema data, String tipoActividad) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        switch (tipoActividad) {
            case "Playas":
                actividades = data.getPlayas();
                break;
            case "Bares":
                actividades = data.getBares();
                break;
            case "Heladerias":
                actividades = data.getHeladerias();
                break;
            case "Favoritos":
                actividades = data.getFavoritos();
                break;
            case "Restaurantes":
                actividades = data.getRestaurantes();
                break;
            case "Buscador":
                actividades = data.getActividades();
                break;
        }
        return actividades;
    }    
}
