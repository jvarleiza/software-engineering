/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaCompleta.java
 *
 * Created on 04-nov-2013, 17:47:56
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Palmera
 */
public class VentanaCompleta extends javax.swing.JFrame {

    Sistema data;
    ArrayList<Actividad> actividadSeleccionada;
    boolean cambiarEstado;

    /**
     * Creates new form VentanaCompleta
     */
    public VentanaCompleta() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        cambiarEstado = true;
        favoritosLabel.setText("");
        //this.setResizable(false);
        //this.setSize(480, 510);
        data = new Sistema();
        data.cargarData(data.getActividades());
        data.ordenarListaActividades();
        //categoriasScrollPane.setBounds(0, 0, 100, this.getHeight());
        //categoriasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        cargarVentana(data.getPlayas());
        crearBotonera();
        listaActividades.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                //listaActividades.setSelectedIndex(0);
                mostrarActividadSeleccionada();

            }

            public void mostrarActividadSeleccionada() {
                int seleccionado = listaActividades.getSelectedIndex();
                if (seleccionado < 0) {
                    seleccionado = 0;
                }
                cargarInfo(seleccionado);

                // throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        listaActividades.setSelectedIndex(0);

    }

    final public void cargarInfo(int seleccionado) {

        if (actividadSeleccionada.isEmpty()) {
            tipoLabel.setText("No hay favoritos actualmete.");
            favoritoCheckBox.setEnabled(false);
            nombreLabel.setText("");
            imagenLabel.setEnabled(false);
            mapaLabel.setEnabled(false);
            descripcionTextArea.setText("");
            buscadorTextField.setEnabled(false);
        } else {
            favoritoCheckBox.setEnabled(true);
            imagenLabel.setEnabled(true);
            mapaLabel.setEnabled(true);
            buscadorTextField.setEnabled(true);
            Image mapa = actividadSeleccionada.get(seleccionado).getMapa();
            Image imagen = actividadSeleccionada.get(seleccionado).getImg();
            Image resizedMapa = mapa.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(), 0);
            Image resizedImage = imagen.getScaledInstance(imagenLabel.getWidth(), 300, 0);
            imagenLabel.setIcon(new ImageIcon(resizedImage));
            mapaLabel.setIcon(new ImageIcon(resizedMapa));
            nombreLabel.setText(actividadSeleccionada.get(seleccionado).getNombre());
            String descripcion = actividadSeleccionada.get(seleccionado).getDescripcion();
            descripcionTextArea.setText(descripcion);
            cambiarEstado = false;
            favoritoCheckBox.setSelected(actividadSeleccionada.get(seleccionado).isFavorito());
            cambiarEstado = true;
            String textTipoLabel = actividadSeleccionada.get(seleccionado).getTipo();
            tipoLabel.setText(textTipoLabel);
        }
        // throw new UnsupportedOperationException("Not supported yet.");
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

    public JButton crearBoton(String rutaImagen, int x, int y, int lado, String tipo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, lado, lado);
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
                actividadSeleccionada = actividades;
                cargarVentana(actividades);
                listaActividades.setSelectedIndex(0);
                cargarInfo(0);
                if (tipoActividad.equals("Favoritos")) {
                    favoritosLabel.setText("Favoritos");
                } else {
                    favoritosLabel.setText("");
                }

                //abrirVentanaCorrespondiente(actividades, tipoActividad);
            }
        });
        return boton;
    }

    public String[] getNombresActividades(ArrayList<Actividad> actividades) {
        //imagenLabel.setBounds(0, 30, this.getWidth(), 300);
        String[] nombres = new String[actividades.size()];
        for (int i = 0; i < actividades.size(); i++) {
            String nombre = actividades.get(i).getNombre();
            nombres[i] = nombre;
        }
        return nombres;
    }

    public void cargarVentana(final ArrayList<Actividad> actividades) {
        String[] nombres = getNombresActividades(actividades);
        listaActividades.setListData(nombres);
        //micargarActividadDefault(actividades);



    }

    public void crearBotonera() {
        int x = this.getHeight() / 6;
        //JButton todos [] = new JButton[7];


        String rutaPlaya = "/grundwaldtvarela/imagenes/playa_icono.png";
        JButton playaBoton = crearBoton(rutaPlaya, 0, 0 * x, x, "Playas");
        playaBoton.doClick();
        this.add(playaBoton);

        //todos[0] = playaBoton;

        //categoriasList.add(playaBoton);



        String rutaBares = "/grundwaldtvarela/imagenes/bares_icono.png";
        JButton baresBoton = crearBoton(rutaBares, 0, 1 * x, x, "Bares");
        baresBoton.setEnabled(false);
        this.add(baresBoton);
        //categoriasList.add(baresBoton);

        //todos[1] = baresBoton;

        String rutaRestaurantes = "/grundwaldtvarela/imagenes/restaurantes_icono.png";
        JButton restaurantesBoton = crearBoton(rutaRestaurantes, 0, 2 * x, x, "Restaurantes");
        this.add(restaurantesBoton);
        //categoriasList.add(restaurantesBoton);
        // todos[2] = restaurantesBoton;


        String rutaFavoritos = "/grundwaldtvarela/imagenes/favoritos_icono.png";
        JButton favoritosBoton = crearBoton(rutaFavoritos, 0, 3 * x, x, "Favoritos");
        this.add(favoritosBoton);
        //categoriasList.add(favoritosBoton);
        //   todos[3] = favoritosBoton;

        String rutaHeladeria = "/grundwaldtvarela/imagenes/heladeria_icono.png";
        JButton heladeriaBoton = crearBoton(rutaHeladeria, 0, 4 * x, x, "Heladerias");
        heladeriaBoton.setEnabled(false);
        this.add(heladeriaBoton);
        //categoriasList.add(heladeriaBoton);

        //     todos[4] = heladeriaBoton;

        String rutaCercaMio = "/grundwaldtvarela/imagenes/pin.png";
        JButton cercaMioBoton = crearBoton(rutaCercaMio, 0, 5 * x, x, "CM");
        cercaMioBoton.setEnabled(false);
        this.add(cercaMioBoton);
        //categoriasList.add(cercaMioBoton);
        //    todos[5] = cercaMioBoton;

//        String rutaBuscador = "/grundwaldtvarela/imagenes/lupa.png";
//        JButton buscadorBoton = crearBoton(rutaBuscador, 0, 6*x,x, "Buscador");
//        this.add(buscadorBoton);
//        //categoriasList.add(buscadorBoton);
//  //      todos[6] = buscadorBoton;





        //pruebaScrollPane.add(prueba,0);
        //pruebaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //this.add(prueba);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaActividades = new javax.swing.JList();
        tipoLabel = new javax.swing.JLabel();
        buscadorTextField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        favoritoCheckBox = new javax.swing.JCheckBox();
        mapaLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        favoritosLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaActividades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaActividades);

        tipoLabel.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        tipoLabel.setText("jLabel1");

        buscadorTextField.setText("Buscar");
        buscadorTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorTextFieldFocusLost(evt);
            }
        });

        nombreLabel.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        nombreLabel.setText("jLabel1");

        favoritoCheckBox.setText("Favorito");
        favoritoCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        favoritoCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                favoritoCheckBoxItemStateChanged(evt);
            }
        });

        descripcionTextArea.setColumns(20);
        descripcionTextArea.setEditable(false);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        jScrollPane3.setViewportView(descripcionTextArea);

        favoritosLabel.setText("Favoritos");
        favoritosLabel.setToolTipText("");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(favoritosLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscadorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favoritoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mapaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buscadorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoLabel)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(favoritoCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(mapaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(favoritosLabel)
                        .addGap(0, 355, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorTextFieldFocusGained
        buscadorTextField.setText("");
    }//GEN-LAST:event_buscadorTextFieldFocusGained

    private void buscadorTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorTextFieldFocusLost
        buscadorTextField.setText("Buscador");
    }//GEN-LAST:event_buscadorTextFieldFocusLost

    private void favoritoCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_favoritoCheckBoxItemStateChanged
        int seleccionado = listaActividades.getSelectedIndex();
        if (seleccionado < 0) {
            seleccionado = 0;
        }
        Actividad seleccionada = actividadSeleccionada.get(seleccionado);
        if (cambiarEstado && !favoritoCheckBox.isSelected()) {
            String texto = "¿Desea eliminar a " + actividadSeleccionada.get(seleccionado).getNombre() + " de sus favoritos?";
            int resultado = JOptionPane.showConfirmDialog(this, texto);
            if (resultado == JOptionPane.OK_OPTION) {
                seleccionada.setFavorito(false);
                cambiarEstado = false;
                favoritoCheckBox.setSelected(false);


//                if (favoritosLabel.getText().equals("Favoritos") && actividadSeleccionada.isEmpty()) {
//                    tipoLabel.setText("No hay favoritos actualmete.");
//                    favoritoCheckBox.setEnabled(false);
//                    nombreLabel.setText("");
//                    imagenLabel.setEnabled(false);
//                    mapaLabel.setEnabled(false);
//                    descripcionTextArea.setText("");
//                    buscadorTextField.setEnabled(false);
//                }
            }
        } else {
            seleccionada.setFavorito(favoritoCheckBox.isSelected());
        }
        cambiarEstado = true;
    }//GEN-LAST:event_favoritoCheckBoxItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscadorTextField;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JCheckBox favoritoCheckBox;
    private javax.swing.JLabel favoritosLabel;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaActividades;
    private javax.swing.JLabel mapaLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel tipoLabel;
    // End of variables declaration//GEN-END:variables
}
