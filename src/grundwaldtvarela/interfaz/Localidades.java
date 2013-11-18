/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grundwaldtvarela.interfaz;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class Localidades extends javax.swing.JFrame {

    /**
     * Creates new form Localidades
     */
    public Localidades() {
        initComponents();
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        mensajeLabel.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapaLabel = new javax.swing.JLabel();
        deptosComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mensajeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mapaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grundwaldtvarela/imagenes/uruguay_tocado.png"))); // NOI18N

        deptosComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Artigas", "Canelones", "Cerro Largo", "Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro", "Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));

        jLabel1.setFont(new java.awt.Font("Vivaldi", 0, 36));
        jLabel1.setText("Descubre Punta!");

        jButton1.setText("Ir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        mensajeLabel.setForeground(new java.awt.Color(255, 0, 0));
        mensajeLabel.setText("*");
        mensajeLabel.setMaximumSize(new java.awt.Dimension(6, 14));
        mensajeLabel.setMinimumSize(new java.awt.Dimension(6, 14));
        mensajeLabel.setPreferredSize(new java.awt.Dimension(6, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deptosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mensajeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                        .addComponent(mapaLabel, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deptosComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(mensajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mapaLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        if (deptosComboBox.getSelectedIndex() == 8) {
            MenuPrincipal menu = new MenuPrincipal(null, true);
            menu.setVisible(true);
        }else{
            String depto = deptosComboBox.getSelectedItem().toString();
            mensajeLabel.setText("El departamento de "+depto + " no esta disponible en este momento");
        }
    }//GEN-LAST:event_jButton1MouseReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox deptosComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mapaLabel;
    private javax.swing.JLabel mensajeLabel;
    // End of variables declaration//GEN-END:variables
}