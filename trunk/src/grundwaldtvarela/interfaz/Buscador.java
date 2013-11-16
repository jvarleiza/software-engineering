/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Buscador.java
 *
 * Created on 17-oct-2013, 16:32:27
 */
package grundwaldtvarela.interfaz;

import grundwaldtvarela.dominio.Actividad;
import grundwaldtvarela.dominio.Sistema;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Palmera
 */
public class Buscador extends javax.swing.JDialog {

    private Sistema dataLocal;
    private ArrayList<Actividad> actividadesLocal;
    private ArrayList<Actividad> resultados;
    

    /** Creates new form Buscador */
    public Buscador(java.awt.Frame parent, boolean modal, Sistema data) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        dataLocal = data;
        String[] nombres = dataLocal.getTodosLosNombres(data.getActividades());
        actividadesLocal = dataLocal.getActividades();

        buscadorList.setListData(nombres);


    }

    public void cargarResultadosPorNombre(String buscar) {
        //buscar solo entre los nombres
        for (int i = 0; i < actividadesLocal.size(); i++) {
            Actividad act = actividadesLocal.get(i);
            String nombre = act.getNombre().toLowerCase();
            if (nombre.contains(buscar.toLowerCase())) {
                resultados.add(act);
            }
        }
    }

    public void cargarResultadosPorNombreYDescripcion(String buscar) {
        for (int i = 0; i < actividadesLocal.size(); i++) {
            Actividad act = actividadesLocal.get(i);
            String nombre = act.getNombre().toLowerCase();
            String descripcion = act.getDescripcion().toLowerCase();
            if (nombre.contains(buscar.toLowerCase()) || descripcion.contains(buscar.toLowerCase())) {
                resultados.add(act);
            }
        }
    }

    public void mostrarInfo(Actividad act) {
        nombreLabel.setText(act.getNombre());
        descripcionTextArea.setText(act.getDescripcion());

        Image foto = act.getImg();
        Image resizedMapa = foto.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(), 0);
        mapaLabel.setIcon(new ImageIcon(resizedMapa));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        buscadorList = new javax.swing.JList();
        buscadorImagenLabel = new javax.swing.JLabel();
        buscadorTextField = new javax.swing.JTextField();
        infoPanel = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        mapaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buscadorList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(buscadorList);

        buscadorImagenLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/2_action_search.png"))); // NOI18N

        buscadorTextField.setToolTipText("");
        buscadorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorTextFieldKeyTyped(evt);
            }
        });

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        nombreLabel.setFont(new java.awt.Font("MS Gothic", 0, 36)); // NOI18N
        nombreLabel.setText("Seleccione resultado");

        descripcionTextArea.setColumns(20);
        descripcionTextArea.setEditable(false);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        jScrollPane2.setViewportView(descripcionTextArea);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreLabel)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(mapaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscadorTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscadorImagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscadorTextField)
                            .addComponent(buscadorImagenLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorTextFieldKeyTyped
        String buscar = buscadorTextField.getText().toLowerCase();
        
        resultados = new ArrayList<>();
        boolean enter = false;
        if (evt.getKeyChar() != '\b') {
            buscar = buscadorTextField.getText() + evt.getKeyChar();
        }
        if (evt.getKeyChar() == '\n') {
            buscar = buscadorTextField.getText();
            enter = true;
        }

        if (enter == false) {
            cargarResultadosPorNombre(buscar);
        } else {
            cargarResultadosPorNombreYDescripcion(buscar);
        }
        String[] nombres = dataLocal.getTodosLosNombres(resultados);
        buscadorList.setListData(nombres);


    }//GEN-LAST:event_buscadorTextFieldKeyTyped

    private void buscadorListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorListMouseClicked
        if (!buscadorList.isSelectionEmpty()) {
            int posActividadSeleccionada = buscadorList.getSelectedIndex();
            Actividad act;
            if (resultados != null) {
                act = resultados.get(posActividadSeleccionada);
            } else {
                act = actividadesLocal.get(posActividadSeleccionada);
            }
            mostrarInfo(act);
        }
    }//GEN-LAST:event_buscadorListMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buscadorImagenLabel;
    private javax.swing.JList buscadorList;
    private javax.swing.JTextField buscadorTextField;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mapaLabel;
    private javax.swing.JLabel nombreLabel;
    // End of variables declaration//GEN-END:variables
}