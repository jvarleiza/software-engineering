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

    /** Creates new form prueba */
    public MostrarActividadesPorFiltro(java.awt.Frame parent, boolean modal, ArrayList<Actividad> actividad) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        String tipoActividad = actividad.get(0).getTipo();
        tipoLabel.setText(tipoActividad);
        nombreLabel.setText(actividad.get(0).getNombre());
        descripcionTextArea.setText(actividad.get(0).getDescripcion());
        setResizable(false);
        Image imagen = actividad.get(0).getImg();
        Image mapa = actividad.get(0).getMapa();
        Image resizedImage = imagen.getScaledInstance(this.getWidth()/2, 300, 0);
        Image resizedMapa = mapa.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(),0);
        imagenLabel.setIcon(new ImageIcon(resizedImage));
        mapaLabel.setIcon(new ImageIcon(resizedMapa));
        //imagenLabel.setBounds(0, 30, this.getWidth(), 300);
        String[] nombres = new String[actividad.size()];
        for (int i = 0; i < actividad.size(); i++) {
            String nombre = actividad.get(i).getNombre();
            nombres[i] = nombre;
        }
        listaActividades.setListData(nombres);
        final ArrayList<Actividad> act = actividad;


        listaActividades.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int seleccionado = listaActividades.getSelectedIndex();
                Image mapa = act.get(seleccionado).getMapa();
                Image imagen = act.get(seleccionado).getImg();
                Image resizedMapa = mapa.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(), 0);
                Image resizedImage = imagen.getScaledInstance(imagenLabel.getWidth(), 300, 0);
                imagenLabel.setIcon(new ImageIcon(resizedImage));
                mapaLabel.setIcon(new ImageIcon(resizedMapa));
                nombreLabel.setText(act.get(seleccionado).getNombre());
                String descripcion = act.get(seleccionado).getDescripcion();
                descripcionTextArea.setText(descripcion);

                // throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
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
        jScrollPane3 = new javax.swing.JScrollPane();
        comentariosList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actividades");

        tipoLabel.setFont(new java.awt.Font("MS UI Gothic", 0, 36)); // NOI18N
        tipoLabel.setText("jLabel1");

        listaActividades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaActividades);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        nombreLabel.setFont(new java.awt.Font("MS Gothic", 0, 36)); // NOI18N
        nombreLabel.setText("jLabel1");

        descripcionTextArea.setColumns(20);
        descripcionTextArea.setEditable(false);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        jScrollPane2.setViewportView(descripcionTextArea);

        comentariosList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(comentariosList);

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
                        .addContainerGap(232, Short.MAX_VALUE))))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList comentariosList;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaActividades;
    private javax.swing.JLabel mapaLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel tipoLabel;
    // End of variables declaration//GEN-END:variables
}