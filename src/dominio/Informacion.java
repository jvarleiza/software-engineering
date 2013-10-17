/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

//import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Joaquin
 */

public class Informacion {
    public void cargarPlayas(ArrayList<Actividad> listaAct) {
        //URL resource = Sistema.class.getResource("/Interfaz/imagenes/playa_bikini.jpg"); 
        ImageIcon imagenBikini = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_bikini.jpg"));
        String descripcionBikini = "Ubicada en el balneario de Manantiales, Bikini es una playa "
                + "excelente, con mar profundo y fuerte, arena abundante y protegida. "
                + "En verano es sumamente concurrida a la tarde, después de las tres."
                + "Siempre hay eventos, música, gimnasia aeróbica al atardecer, práctica de surf y jetsky.";        
        Actividad bikini = new Actividad("Playa", "Playa Bikini",descripcionBikini, null, imagenBikini.getImage());     
        listaAct.add(bikini);  
        
        
        
        String descripcionJI = "Las playas de Jose Ignacio se encuentran a 30 km al este de la península de Punta del Este "
                + "posee playa mansa y brava. La gente que visita estas playas disfrutan de la tranquilidad del balneario.";        
        Actividad playaJI = new Actividad("Playa", "Playa Jose Ignacio",descripcionJI, null, null); 
        listaAct.add(playaJI);
        
        
        
        String desPlayaMansa = "La playa mansa se extiene unos 7 km desde la península hacia el oeste. Es ideal para familias "
                + "que desean pasar un rato agradable. También es excelente para practicar deportes dentro y fuera del agua "
                + "debido a la tranquilidad de sus aguas.";        
        Actividad playaMansa = new Actividad("Playa", "Playa Mansa",desPlayaMansa, null, null);
        listaAct.add(playaMansa);
        
        
        String desPlayaBrava = "La playa brava se extiene unos 10 km desde la península hacia el este. Debido al mayor oleaje"
                + "es muy recomendable para la práctica de deportes acuaticos como el surf o body board.";        
        Actividad playaBrava = new Actividad("Playa", "Playa Brava",desPlayaBrava, null, null);
        listaAct.add(playaBrava);
       
        
        String desPlayaMontoya = "La playa de montoya es ancha, de arena gruesa y mar con olas de considerable fuerza y altura. "
                + "Por esta razon es que se lleva a cabo una de las etapas del campeonato mundial del surf. Es muy recomendada "
                + "entre la gente joven";        
        Actividad playaMontoya = new Actividad("Playa", "Playa de la Barra",desPlayaMontoya, null, null);
        listaAct.add(playaMontoya);
        
        
        String desPlayaPostaDelCangrejo = "La Posta de Cangrejo posee arena fina y humeda la cual ayuda a que la temperatura no "
                + "sea demasiado elevada en verano. El hecho de que la arena sea humeda facilita los juegos con pelota.";        
        Actividad playaPostaDelCangrejo = new Actividad("Playa", "Playa de la Barra",desPlayaPostaDelCangrejo, null, null);
        listaAct.add(playaPostaDelCangrejo);
        
        
        
        
        
    }
    
}
