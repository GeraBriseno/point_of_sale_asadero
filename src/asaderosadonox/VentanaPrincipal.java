/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asaderosadonox;

import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gerardo
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ventana_principal
     */
    public VentanaPrincipal() {
        initComponents();
    }
    public void closeFrame(){
        super.dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b_ordenes = new javax.swing.JButton();
        b_precios = new javax.swing.JButton();
        b_ordenesDelDia = new javax.swing.JButton();
        b_repartidores = new javax.swing.JButton();
        b_historial = new javax.swing.JButton();
        b_gastos = new javax.swing.JButton();
        b_corteCaja = new javax.swing.JButton();
        b_clientes = new javax.swing.JButton();
        b_ingresos = new javax.swing.JButton();
        b_retiros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asaderos Adoño", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(102, 102, 255))); // NOI18N

        b_ordenes.setBackground(new java.awt.Color(153, 153, 255));
        b_ordenes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_ordenes.setText("Ordenes");
        b_ordenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ordenesMouseClicked(evt);
            }
        });

        b_precios.setBackground(new java.awt.Color(153, 153, 255));
        b_precios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_precios.setText("Precios");
        b_precios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_preciosMouseClicked(evt);
            }
        });

        b_ordenesDelDia.setBackground(new java.awt.Color(153, 153, 255));
        b_ordenesDelDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_ordenesDelDia.setText("Ver Ordenes del Día");
        b_ordenesDelDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ordenesDelDiaMouseClicked(evt);
            }
        });

        b_repartidores.setBackground(new java.awt.Color(153, 153, 255));
        b_repartidores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_repartidores.setText("Repartidores");
        b_repartidores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_repartidoresMouseClicked(evt);
            }
        });

        b_historial.setBackground(new java.awt.Color(153, 153, 255));
        b_historial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_historial.setText("Historial");
        b_historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_historialMouseClicked(evt);
            }
        });

        b_gastos.setBackground(new java.awt.Color(153, 153, 255));
        b_gastos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_gastos.setText("Gastos");
        b_gastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_gastosMouseClicked(evt);
            }
        });

        b_corteCaja.setBackground(new java.awt.Color(153, 204, 255));
        b_corteCaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_corteCaja.setText("Corte de Caja");
        b_corteCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_corteCajaMouseClicked(evt);
            }
        });

        b_clientes.setBackground(new java.awt.Color(153, 153, 255));
        b_clientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_clientes.setText("Clientes");
        b_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_clientesMouseClicked(evt);
            }
        });

        b_ingresos.setBackground(new java.awt.Color(153, 153, 255));
        b_ingresos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_ingresos.setText("Ingresos");
        b_ingresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ingresosMouseClicked(evt);
            }
        });

        b_retiros.setBackground(new java.awt.Color(153, 153, 255));
        b_retiros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_retiros.setText("Retiros");
        b_retiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_retirosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_precios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_ordenes, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(b_ingresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_ordenesDelDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_repartidores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_gastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_corteCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_historial, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(b_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_retiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_ordenesDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_historial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_precios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_repartidores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_ingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_gastos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_retiros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(b_corteCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_ordenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ordenesMouseClicked
        NuevaOrden nuevaOrden = new NuevaOrden(this, true);
        nuevaOrden.setVisible(true);
        nuevaOrden.addWindowListener(new WindowAdapter() 
        {
          @Override
          public void windowClosed(WindowEvent e)
          {
            Conexion.borrarOrden();
          }

        });
    }//GEN-LAST:event_b_ordenesMouseClicked

    private void b_preciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_preciosMouseClicked
        Precios precios = new Precios(this, true);
        precios.setVisible(true);
    }//GEN-LAST:event_b_preciosMouseClicked

    private void b_ordenesDelDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ordenesDelDiaMouseClicked
        OrdenesDia ordenesDia = new OrdenesDia(this, true);
        ordenesDia.setVisible(true);
    }//GEN-LAST:event_b_ordenesDelDiaMouseClicked

    private void b_repartidoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_repartidoresMouseClicked
        Repartidores repartidores = new Repartidores(this, true);
        repartidores.setVisible(true);
    }//GEN-LAST:event_b_repartidoresMouseClicked

    private void b_gastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_gastosMouseClicked
        Gastos gastos = new Gastos(this, true);
        gastos.setVisible(true);
    }//GEN-LAST:event_b_gastosMouseClicked

    private void b_corteCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_corteCajaMouseClicked
        String[] opcionesConfirmar = {"Confirmar", "Cancelar"};
        int confirmacion = new JOptionPane().showOptionDialog(
            null, "Confirmar Corte de Caja", "Corte de Caja", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesConfirmar, null);
        
        if(confirmacion==0){
            Conexion.corteDeCaja();
        }
    }//GEN-LAST:event_b_corteCajaMouseClicked

    private void b_historialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_historialMouseClicked
        Historial historial = new Historial(this, true);
        historial.setVisible(true);
    }//GEN-LAST:event_b_historialMouseClicked

    private void b_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_clientesMouseClicked
        Clientes clientes = new Clientes(this, true);
        clientes.setVisible(true);
    }//GEN-LAST:event_b_clientesMouseClicked

    private void b_ingresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ingresosMouseClicked
        Ingresos ingresos = new Ingresos(this, true);
        ingresos.setVisible(true);
    }//GEN-LAST:event_b_ingresosMouseClicked

    private void b_retirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_retirosMouseClicked
        Retiros retiros = new Retiros(this, true);
        retiros.setVisible(true);
    }//GEN-LAST:event_b_retirosMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_clientes;
    private javax.swing.JButton b_corteCaja;
    private javax.swing.JButton b_gastos;
    private javax.swing.JButton b_historial;
    private javax.swing.JButton b_ingresos;
    private javax.swing.JButton b_ordenes;
    private javax.swing.JButton b_ordenesDelDia;
    private javax.swing.JButton b_precios;
    private javax.swing.JButton b_repartidores;
    private javax.swing.JButton b_retiros;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
