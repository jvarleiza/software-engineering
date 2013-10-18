/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuPrincipal.java
 *
 * Created on 16-oct-2013, 20:33:49
 */
package Interfaz;

import dominio.Actividad;
import dominio.Sistema;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Palmera
 */
public class MenuPrincipal extends javax.swing.JFrame {

    Sistema data;

    /** Creates new form MenuPrincipal */
    public MenuPrincipal() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setSize(480, 510);
        data = new Sistema();
        data.cargarData(data.getActividades());
        crearBotonera();



    }

    public void crearBotonera() {
        String rutaPlaya = "/Interfaz/imagenes/playa_icono.png";
        JButton playaBoton = crearBoton(rutaPlaya, 10, 30, "Playas");
        this.add(playaBoton);


        String rutaBares = "/Interfaz/imagenes/bares_icono.png";
        JButton baresBoton = crearBoton(rutaBares, 160, 30, "Bares");
        baresBoton.setEnabled(false);
        this.add(baresBoton);

        String rutaRestaurantes = "/Interfaz/imagenes/restaurantes_icono.png";
        JButton restaurantesBoton = crearBoton(rutaRestaurantes, 10, 180, "Restaurantes");
        this.add(restaurantesBoton);

        String rutaFavoritos = "/Interfaz/imagenes/favoritos_icono.png";
        JButton favoritosBoton = crearBoton(rutaFavoritos, 310, 30, "Favoritos");
        this.add(favoritosBoton);

        String rutaHeladeria = "/Interfaz/imagenes/heladeria_icono.png";
        JButton heladeriaBoton = crearBoton(rutaHeladeria, 160, 180, "Heladerias");
        heladeriaBoton.setEnabled(false);
        this.add(heladeriaBoton);

        String rutaCercaMio = "/Interfaz/imagenes/pin.png";
        JButton cercaMioBoton = crearBoton(rutaCercaMio, 310, 180, "CM");
        cercaMioBoton.setEnabled(false);
        this.add(cercaMioBoton);

        String rutaBuscador = "/Interfaz/imagenes/lupa.png";
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
        if (buscador == false) {
            if (actividades.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No tienes favoritos todavía");
            } else {
                MostrarActividadesPorFiltro actividad = new MostrarActividadesPorFiltro(null, true, actividades);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Descubre Punta!");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Seleccione categoria para empezar su busqueda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(620, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
