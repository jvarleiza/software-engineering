/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * prueba.java
 *
 * Created on 17-oct-2013, 10:13:12
 */
package Interfaz;

import dominio.Actividad;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Palmera
 */
public class MostrarActividadesPorFiltro extends javax.swing.JDialog {
private ArrayList<Actividad> actividadLocal;
    /** Creates new form prueba */
    public MostrarActividadesPorFiltro(java.awt.Frame parent, boolean modal, ArrayList<Actividad> actividad) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        actividadLocal = actividad;
        
        this.getContentPane().setBackground(Color.WHITE);
        
        String[] nombres = getNombresActividades();
        listaActividades.setListData(nombres);
        cargarActividadDefault(actividad);


        listaActividades.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                mostrarActividadSeleccionada();

            }

            public void mostrarActividadSeleccionada() {
                int seleccionado = listaActividades.getSelectedIndex();
                Image mapa = actividadLocal.get(seleccionado).getMapa();
                Image imagen = actividadLocal.get(seleccionado).getImg();
                Image resizedMapa = mapa.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(), 0);
                Image resizedImage = imagen.getScaledInstance(imagenLabel.getWidth(), 300, 0);
                imagenLabel.setIcon(new ImageIcon(resizedImage));
                mapaLabel.setIcon(new ImageIcon(resizedMapa));
                nombreLabel.setText(actividadLocal.get(seleccionado).getNombre());
                String descripcion = actividadLocal.get(seleccionado).getDescripcion();
                descripcionTextArea.setText(descripcion);
                favoritoCheckBox.setSelected(actividadLocal.get(seleccionado).isFavorito());

                // throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        
    }

    public String[] getNombresActividades() {
        //imagenLabel.setBounds(0, 30, this.getWidth(), 300);
        String[] nombres = new String[actividadLocal.size()];
        for (int i = 0; i < actividadLocal.size(); i++) {
            String nombre = actividadLocal.get(i).getNombre();
            nombres[i] = nombre;
        }
        return nombres;
    }

    public void cargarActividadDefault(ArrayList<Actividad> actividadLocal) {
        String tipoActividad = actividadLocal.get(0).getTipo();
        tipoLabel.setText(tipoActividad);
        nombreLabel.setText(actividadLocal.get(0).getNombre());
        descripcionTextArea.setText(actividadLocal.get(0).getDescripcion());
        Image imagen = actividadLocal.get(0).getImg();
        Image mapa = actividadLocal.get(0).getMapa();
        Image resizedImage = imagen.getScaledInstance(this.getWidth()/2, 300, 0);
        Image resizedMapa = mapa.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(),0);
        imagenLabel.setIcon(new ImageIcon(resizedImage));
        mapaLabel.setIcon(new ImageIcon(resizedMapa));
        
        listaActividades.setSelectedIndex(0);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoLabel = new javax.swing.JLabel();
        imagenLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaActividades = new javax.swing.JList();
        infoPanel = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        mapaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        favoritoCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actividades");

        tipoLabel.setFont(new java.awt.Font("MS UI Gothic", 0, 36));
        tipoLabel.setText("jLabel1");

        listaActividades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaActividades);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        nombreLabel.setFont(new java.awt.Font("MS Gothic", 0, 36));
        nombreLabel.setText("jLabel1");

        descripcionTextArea.setColumns(20);
        descripcionTextArea.setEditable(false);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        jScrollPane2.setViewportView(descripcionTextArea);

        favoritoCheckBox.setText("Favorito");
        favoritoCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        favoritoCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                favoritoCheckBoxStateChanged(evt);
            }
        });
        favoritoCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                favoritoCheckBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(favoritoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(favoritoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tipoLabel)
                        .addComponent(imagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tipoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void favoritoCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_favoritoCheckBoxStateChanged
       
    }//GEN-LAST:event_favoritoCheckBoxStateChanged

    private void favoritoCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_favoritoCheckBoxItemStateChanged
         int seleccionado = listaActividades.getSelectedIndex();
        Actividad seleccionada = actividadLocal.get(seleccionado);
        if (favoritoCheckBox.isSelected()) {
            seleccionada.setFavorito(favoritoCheckBox.isSelected());
        }else{
            seleccionada.setFavorito(favoritoCheckBox.isSelected());
        }
    }//GEN-LAST:event_favoritoCheckBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JCheckBox favoritoCheckBox;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaActividades;
    private javax.swing.JLabel mapaLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel tipoLabel;
    // End of variables declaration//GEN-END:variables
}
