/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.interfaz;

import grundwaldtvarela.dominio.Actividad;
import grundwaldtvarela.dominio.Sistema;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class MenuPrincipal extends javax.swing.JDialog {

    /**
     * Creates new form MenuPrincipal
     */
    Sistema data;
    
    
    public MenuPrincipal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setSize(480, 510);
        data = new Sistema();
        data.cargarData(data.getActividades());
        crearBotonera();
    }
    
    
    
    
    public void crearBotonera() {
        String rutaPlaya = "/grundwaldtvarela/imagenes/playa_icono.png";
        JButton playaBoton = crearBoton(rutaPlaya, 10, 30, "Playas");
        this.add(playaBoton);


        String rutaBares = "/grundwaldtvarela/imagenes/bares_icono.png";
        JButton baresBoton = crearBoton(rutaBares, 160, 30, "Bares");
        baresBoton.setEnabled(false);
        this.add(baresBoton);

        String rutaRestaurantes = "/grundwaldtvarela/imagenes/restaurantes_icono.png";
        JButton restaurantesBoton = crearBoton(rutaRestaurantes, 10, 180, "Restaurantes");
        this.add(restaurantesBoton);

        String rutaFavoritos = "/grundwaldtvarela/imagenes/favoritos_icono.png";
        JButton favoritosBoton = crearBoton(rutaFavoritos, 310, 30, "Favoritos");
        this.add(favoritosBoton);

        String rutaHeladeria = "/grundwaldtvarela/imagenes/heladeria_icono.png";
        JButton heladeriaBoton = crearBoton(rutaHeladeria, 160, 180, "Heladerias");
        heladeriaBoton.setEnabled(false);
        this.add(heladeriaBoton);

        String rutaCercaMio = "/grundwaldtvarela/imagenes/pin.png";
        JButton cercaMioBoton = crearBoton(rutaCercaMio, 310, 180, "CM");
        cercaMioBoton.setEnabled(false);
        this.add(cercaMioBoton);

        String rutaBuscador = "/grundwaldtvarela/imagenes/lupa.png";
        JButton buscadorBoton = crearBoton(rutaBuscador, 160, 330, "Buscador");
        this.add(buscadorBoton);
    }
    
    
    
    
    
    
    public JButton crearBoton(String rutaImagen, int x, int y, String tipo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, 150, 150);
        Image resizedImage = getImageIcon(rutaImagen, boton);
        boton.setIcon(new ImageIcon(resizedImage));
        boton.setVisible(true);
        boton.setToolTipText(tipo);
        final String tipoActividad = tipo;
        boton.addActionListener(new ActionListener() {
            //cuando hacen click en el boton, filtra las actividades correspondientes

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Actividad> actividades = filtrarActividades(data, tipoActividad);
                abrirVentanaCorrespondiente(actividades, tipoActividad);
            }
        });
        return boton;
    }
    
    
    
    
    
    public void abrirVentanaCorrespondiente(ArrayList<Actividad> actividades, String tipoActividad) {
        boolean buscador = tipoActividad.equals("Buscador");
        boolean favoritos = tipoActividad.equals("Favoritos");
        if (buscador == false) {
            if (actividades.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No tienes favoritos todavía");
            } else {
                MostrarActividadesPorFiltro actividad = new MostrarActividadesPorFiltro(null, true, actividades, favoritos);
                actividad.setVisible(true);
            }

        } else {
            Buscador buscadorVentana = new Buscador(null, true, actividades);
            buscadorVentana.setVisible(true);
        }
        //throw new UnsupportedOperationException("Not supported yet.");
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
    
    
     public Image getImageIcon(String rutaImagen, JButton boton) {
        ImageIcon iconoBoton = new javax.swing.ImageIcon(getClass().getResource(rutaImagen));
        Image imagen = iconoBoton.getImage();
        Image resizedImage = imagen.getScaledInstance(boton.getWidth(), boton.getHeight(), 0);
        return resizedImage;
    }
     
     
     
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Comience con su búsqueda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(344, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 433, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
