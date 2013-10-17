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
        ImageIcon imagenBikini = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_bikini_1.jpg"));
        String descripcionBikini = "Ubicada en el balneario de Manantiales, Bikini es una playa "
                + "excelente, con mar profundo y fuerte, arena abundante y protegida. "
                + "En verano es sumamente concurrida a la tarde, después de las tres."
                + "Siempre hay eventos, música, gimnasia aeróbica al atardecer, práctica de surf y jetsky.";        
        Actividad bikini = new Actividad("Playa", "Bikini",descripcionBikini, null, imagenBikini.getImage());     
        listaAct.add(bikini);  
        
        
        ImageIcon imagenJI = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_jose_ignacio.jpg"));
        String descripcionJI = "Las playas de Jose Ignacio se encuentran a 30 km al este de la península de Punta del Este "
                + "posee playa mansa y brava. La gente que visita estas playas disfrutan de la tranquilidad del balneario.";        
        Actividad playaJI = new Actividad("Playa", "Jose Ignacio",descripcionJI, null, imagenJI.getImage()); 
        listaAct.add(playaJI);
        
        
        ImageIcon imagenMansa = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_mansa.jpg"));
        String desPlayaMansa = "La playa mansa se extiene unos 7 km desde la península hacia el oeste. Es ideal para familias "
                + "que desean pasar un rato agradable. También es excelente para practicar deportes dentro y fuera del agua "
                + "debido a la tranquilidad de sus aguas.";        
        Actividad playaMansa = new Actividad("Playa", "Playa Mansa",desPlayaMansa, null, imagenMansa.getImage());
        listaAct.add(playaMansa);
        
        
        ImageIcon imagenBrava = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_brava.jpg"));
        String desPlayaBrava = "La playa brava se extiene unos 10 km desde la península hacia el este. Debido al mayor oleaje"
                + "es muy recomendable para la práctica de deportes acuaticos como el surf o body board.";        
        Actividad playaBrava = new Actividad("Playa", "Playa Brava",desPlayaBrava, null, imagenBrava.getImage());
        listaAct.add(playaBrava);
       
        
        ImageIcon imagenMontoya = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_montoya.jpg"));
        String desPlayaMontoya = "La playa de montoya es ancha, de arena gruesa y mar con olas de considerable fuerza y altura. "
                + "Por esta razon es que se lleva a cabo una de las etapas del campeonato mundial del surf. Es muy recomendada "
                + "entre la gente joven";        
        Actividad playaMontoya = new Actividad("Playa", "Montoya",desPlayaMontoya, null, imagenMontoya.getImage());
        listaAct.add(playaMontoya);
        
        
        ImageIcon imagenPostaDelCangrejo = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_la_posta_de_cangrejo.jpg"));
        String desPlayaPostaDelCangrejo = "La Posta de Cangrejo posee arena fina y humeda la cual ayuda a que la temperatura no "
                + "sea demasiado elevada en verano. El hecho de que la arena sea humeda facilita los juegos con pelota.";        
        Actividad playaPostaDelCangrejo = new Actividad("Playa", "La Posta de Cangrejo",desPlayaPostaDelCangrejo, null, imagenPostaDelCangrejo.getImage());
        listaAct.add(playaPostaDelCangrejo);
        
        
        ImageIcon imagenChorro = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_chorro.jpg"));
        String desElChorro = "Playa vecina al balneario de Manantiales a 20 minutos de la península de Punta del Este. "
                + "se considera una playa agresiva por el nivel de la corriente marina";        
        Actividad playaElChorro = new Actividad("Playa", "El Chorro",desElChorro, null, imagenChorro.getImage());
        listaAct.add(playaElChorro);     
        
        
        ImageIcon imagenDedos = new javax.swing.ImageIcon(getClass().getResource("/Interfaz/imagenes/playa_dedos.jpg"));
        String desDedos = "Playa muy famosa de Punta Del Este. Reconocida por la mano de gigante enterrada en la arena.";        
        Actividad playaDedos = new Actividad("Playa", "Los Dedos",desDedos, null, imagenDedos.getImage());
        listaAct.add(playaDedos);
    }
    
    
    public void cargarRestaurantes(ArrayList<Actividad> listaAct) {
        String desVirazon = "Ubicado a pasos del puerto de Punta del Este, sobre la mansa se disfruta de la vista a "
                + "la Playa Mansa con una variedad amplia de platos: mariscos, pescados y carnes, arroces, tragos. "
                + "Mirar también 'Lo De Tere' y 'Guappa'";        
        Actividad virazon = new Actividad("Restaurante", "Virazón",desVirazon, null, null);
        listaAct.add(virazon); 
        
        String desTere = "Ubicado a pasos del puerto de Punta del Este, sobre la mansa se disfruta de la vista a "
                + "la Playa Mansa con una variedad amplia de platos: mariscos, pescados y carnes, arroces, tragos. "
                + "Mirar también 'Virazon' y 'Guappa'";        
        Actividad loDeTere = new Actividad("Restaurante", "Lo de Tere",desTere, null, null);
        listaAct.add(loDeTere); 
        
        String desGuappa = "Ubicado a pasos del puerto de Punta del Este, sobre la mansa se disfruta de la vista a "
                + "la Playa Mansa con una variedad amplia de platos: mariscos, pescados y carnes, arroces, tragos. "
                + "Mirar también 'Lo De Tere' y 'Virazon'";       
        Actividad guappa = new Actividad("Restaurante", "Guappa",desGuappa, null, null);
        listaAct.add(guappa); 
        
        
        String desLau = "Conocida popularmente como la torre de los waffles es un hotel que ofrece excelente servicio "
                + "de salón de té muy lujoso. Especial para ir con pareja.";       
        Actividad lau = new Actividad("Restaurante", "L'Auberge",desLau, null, null);
        listaAct.add(lau); 
        
        
        String desArtico = "Reconocido restaurant para comer ricos mariscos y pescados al borde del agua a la hora del "
                + "almuerzo. Esta ubicado en el puerto de Punta del Este.";       
        Actividad artico = new Actividad("Restaurante", "Artico",desArtico, null, null);
        listaAct.add(artico);
            
    }
    
}
