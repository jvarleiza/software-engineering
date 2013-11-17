/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.dominio;

//import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Joaquin
 */

public class InformacionPuntaDelEste {
    
    public void cargarPlayas(ArrayList<Actividad> listaAct) {
        //URL resource = Sistema.class.getResource("/Interfaz/imagenes/playa_bikini.jpg"); 
        ImageIcon imagenBikini = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_bikini_1.jpg"));
        ImageIcon mapaBikini = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_bikini.png"));
        String descripcionBikini = "Ubicada en el balneario de Manantiales, Bikini es una playa "
                + "excelente, con mar profundo y fuerte, arena abundante y protegida. "
                + "En verano es sumamente concurrida a la tarde, después de las tres."
                + "Siempre hay eventos, música, gimnasia aeróbica al atardecer, práctica de surf y jetsky.";        
        Actividad bikini = new Actividad("Playa", "Bikini",descripcionBikini,  imagenBikini.getImage(), mapaBikini.getImage(), 100);     
        listaAct.add(bikini);  
        
        
        ImageIcon mapaJI = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_ji.png"));
        ImageIcon imagenJI = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_jose_ignacio.jpg"));
        String descripcionJI = "Las playas de Jose Ignacio se encuentran a 30 km al este de la península de Punta del Este "
                + "posee playa mansa y brava. La gente que visita estas playas disfrutan de la tranquilidad del balneario.";        
        Actividad playaJI = new Actividad("Playa", "Jose Ignacio",descripcionJI,  imagenJI.getImage(), mapaJI.getImage(), 150); 
        listaAct.add(playaJI);
        
        
        ImageIcon mapaMansa = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_mansa.jpg"));
        ImageIcon imagenMansa = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_mansa.jpg"));
        String desPlayaMansa = "La playa mansa se extiene unos 7 km desde la península hacia el oeste. Es ideal para familias "
                + "que desean pasar un rato agradable. También es excelente para practicar deportes dentro y fuera del agua "
                + "debido a la tranquilidad de sus aguas.";        
        Actividad playaMansa = new Actividad("Playa", "Playa Mansa",desPlayaMansa, imagenMansa.getImage(), mapaMansa.getImage(), 20);
        listaAct.add(playaMansa);
        
        
        ImageIcon mapaBrava = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_brava.png"));
        ImageIcon imagenBrava = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_brava.jpg"));
        String desPlayaBrava = "La playa brava se extiene unos 10 km desde la península hacia el este. Debido al mayor oleaje"
                + "es muy recomendable para la práctica de deportes acuaticos como el surf o body board.";        
        Actividad playaBrava = new Actividad("Playa", "Playa Brava",desPlayaBrava,  imagenBrava.getImage(), mapaBrava.getImage(), 10);
        listaAct.add(playaBrava);
       
        
        ImageIcon mapaMontoya = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_montoya.png"));
        ImageIcon imagenMontoya = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_montoya.jpg"));
        String desPlayaMontoya = "La playa de montoya es ancha, de arena gruesa y mar con olas de considerable fuerza y altura. "
                + "Por esta razon es que se lleva a cabo una de las etapas del campeonato mundial del surf. Es muy recomendada "
                + "entre la gente joven";        
        Actividad playaMontoya = new Actividad("Playa", "Montoya",desPlayaMontoya,  imagenMontoya.getImage(), mapaMontoya.getImage(), 120);
        listaAct.add(playaMontoya);
        
        
        ImageIcon mapaPosta = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_posta.png"));
        ImageIcon imagenPostaDelCangrejo = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_la_posta_de_cangrejo.jpg"));
        String desPlayaPostaDelCangrejo = "La Posta de Cangrejo posee arena fina y humeda la cual ayuda a que la temperatura no "
                + "sea demasiado elevada en verano. El hecho de que la arena sea humeda facilita los juegos con pelota.";        
        Actividad playaPostaDelCangrejo = new Actividad("Playa", "La Posta de Cangrejo",desPlayaPostaDelCangrejo,  imagenPostaDelCangrejo.getImage(),mapaPosta.getImage(), 70);
        listaAct.add(playaPostaDelCangrejo);
        
        
        ImageIcon mapaChorro = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_chorro.png"));
        ImageIcon imagenChorro = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_chorro.jpg"));
        String desElChorro = "Playa vecina al balneario de Manantiales a 20 minutos de la península de Punta del Este. "
                + "se considera una playa agresiva por el nivel de la corriente marina";        
        Actividad playaElChorro = new Actividad("Playa", "El Chorro",desElChorro,  imagenChorro.getImage(), mapaChorro.getImage(), 110);
        listaAct.add(playaElChorro);     
        
        
        ImageIcon mapaDedos = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_dedos.png"));
        ImageIcon imagenDedos = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/playa_dedos.jpg"));
        String desDedos = "Playa muy famosa de Punta Del Este. Reconocida por la mano de gigante enterrada en la arena.";        
        Actividad playaDedos = new Actividad("Playa", "Los Dedos",desDedos,  imagenDedos.getImage(), mapaDedos.getImage(), 5);
        listaAct.add(playaDedos);
    }
    
    
    public void cargarRestaurantes(ArrayList<Actividad> listaAct) {
        ImageIcon mapaGuappa = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_guappa.png"));
        ImageIcon imagenGuappa = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/res_guappa.jpeg"));
        String desGuappa = "Ubicado a pasos del puerto de Punta del Este, sobre la mansa se disfruta de la vista a "
                + "la Playa Mansa con una variedad amplia de platos: mariscos, pescados y carnes, arroces, tragos. ";       
        Actividad guappa = new Actividad("Restaurante", "Guappa",desGuappa,  imagenGuappa.getImage(), mapaGuappa.getImage(), 10);
        listaAct.add(guappa); 
        
        
        ImageIcon mapaLau = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_lauberge.png"));
        ImageIcon imagenLau = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/res_lauberge.jpg"));
        String desLau = "Conocida popularmente como la torre de los waffles es un hotel que ofrece excelente servicio "
                + "de salón de té muy lujoso. Especial para ir con pareja.";       
        Actividad lau = new Actividad("Restaurante", "L'Auberge",desLau,  imagenLau.getImage(), mapaLau.getImage(), 60);
        listaAct.add(lau); 
        
        
        ImageIcon mapaArtico = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_artico.png"));
        ImageIcon imagenArtico = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/res_artico.jpg"));
        String desArtico = "Reconocido restaurant para comer ricos mariscos y pescados al borde del agua a la hora del "
                + "almuerzo. Esta ubicado en el puerto de Punta del Este.";       
        Actividad artico = new Actividad("Restaurante", "Artico",desArtico,  imagenArtico.getImage(), mapaArtico.getImage(), 3);
        listaAct.add(artico);
        
        
        ImageIcon mapaPizza = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_pizza.png"));
        ImageIcon imagenPizza = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/res_pizzasing.JPG"));
        String desPizza = "Si le gusta el karaoke y le gusta la pizza, venga a Pizza Sing. Ubicada atrás del punta "
                + "shopping se ubica la divertida pizzería.";       
        Actividad pizza = new Actividad("Restaurante", "Pizza Sing",desPizza,  imagenPizza.getImage(), mapaPizza.getImage(), 11);
        listaAct.add(pizza);
        
        
        ImageIcon mapaConrad = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/mapa_conrad.png"));
        ImageIcon imagenConrad = new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/res_conrad.jpg"));
        String desConrad = "El restaurante del hotel/casino del conrad ofrece lujosos servicios para una elegante cena o almuerzo "
                + "para aquellos que lo deseen. incluye mucha variedad de platos distintos.";       
        Actividad conrad = new Actividad("Restaurante", "Conrad",desConrad,  imagenConrad.getImage(), mapaConrad.getImage(), 7);
        listaAct.add(conrad);
            
    }
    
}
