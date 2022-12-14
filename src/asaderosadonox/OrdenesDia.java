/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package asaderosadonox;

/**
 *
 * @author Gerardo
 */
import javax.swing.*;

public class OrdenesDia extends javax.swing.JDialog {

    /**
     * Creates new form OrdenesDia
     */
    public OrdenesDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Conexion.mostrarOrdenesDelDia(t_ordenesDelDia);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_ordenesDelDia = new javax.swing.JTable();
        b_totalRepartidor = new javax.swing.JButton();
        b_cambiarRepartidor = new javax.swing.JButton();
        b_mostrarDatosCliente = new javax.swing.JButton();
        b_eliminarOrden = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenes del Día", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        t_ordenesDelDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nm de Orden", "Id Cliente", "Total", "Pagado", "Serv Domicilio", "Repartidor", "Forma de Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t_ordenesDelDia);
        if (t_ordenesDelDia.getColumnModel().getColumnCount() > 0) {
            t_ordenesDelDia.getColumnModel().getColumn(0).setResizable(false);
            t_ordenesDelDia.getColumnModel().getColumn(0).setPreferredWidth(40);
            t_ordenesDelDia.getColumnModel().getColumn(1).setResizable(false);
            t_ordenesDelDia.getColumnModel().getColumn(2).setResizable(false);
            t_ordenesDelDia.getColumnModel().getColumn(3).setResizable(false);
            t_ordenesDelDia.getColumnModel().getColumn(3).setPreferredWidth(35);
            t_ordenesDelDia.getColumnModel().getColumn(4).setResizable(false);
            t_ordenesDelDia.getColumnModel().getColumn(4).setPreferredWidth(35);
            t_ordenesDelDia.getColumnModel().getColumn(5).setResizable(false);
            t_ordenesDelDia.getColumnModel().getColumn(6).setResizable(false);
        }

        b_totalRepartidor.setText("Mostrar Total Repartidor");
        b_totalRepartidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_totalRepartidorMouseClicked(evt);
            }
        });

        b_cambiarRepartidor.setText("Cambiar Repartidor");
        b_cambiarRepartidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_cambiarRepartidorMouseClicked(evt);
            }
        });

        b_mostrarDatosCliente.setText("Mostrar Datos del Cliente");
        b_mostrarDatosCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_mostrarDatosClienteMouseClicked(evt);
            }
        });

        b_eliminarOrden.setText("Eliminar Orden");
        b_eliminarOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_eliminarOrdenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_totalRepartidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_mostrarDatosCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_cambiarRepartidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_eliminarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_totalRepartidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_mostrarDatosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_cambiarRepartidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_eliminarOrden)
                .addContainerGap(8, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_totalRepartidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_totalRepartidorMouseClicked
        int columnaRepartidor = 5;
        int row = t_ordenesDelDia.getSelectedRow();
        String nombreRepartidor = t_ordenesDelDia.getModel().getValueAt(row, columnaRepartidor).toString();
        Conexion.mostrarTotalRepartidor(t_ordenesDelDia, nombreRepartidor);
    }//GEN-LAST:event_b_totalRepartidorMouseClicked

    private void b_cambiarRepartidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_cambiarRepartidorMouseClicked
        int columnaNmOrden = 0;
        int columnaServicio = 4;
        int row = t_ordenesDelDia.getSelectedRow();
        double servicio = Double.parseDouble(t_ordenesDelDia.getModel().getValueAt(row, columnaServicio).toString());
        int nmOrden = Integer.parseInt(t_ordenesDelDia.getModel().getValueAt(row, columnaNmOrden).toString());
        if(servicio!=0){
            String cambioRepartidor = new JOptionPane().showInputDialog("Ingresa el nombre del Repartidor");
            if(!cambioRepartidor.isEmpty()){
                Conexion.cambiarRepartidor(t_ordenesDelDia, cambioRepartidor, nmOrden);
                Conexion.mostrarOrdenesDelDia(t_ordenesDelDia);
            }
        }
        else{
            new JOptionPane().showMessageDialog(null, "Esta Orden no es para llevar", "Orden", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_cambiarRepartidorMouseClicked

    private void b_mostrarDatosClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_mostrarDatosClienteMouseClicked
        
        int columnaIdCliente = 1;
        int row = t_ordenesDelDia.getSelectedRow();
        int id_cliente = Integer.parseInt(t_ordenesDelDia.getModel().getValueAt(row, columnaIdCliente).toString());
        Conexion.mostrarDatosCliente(id_cliente);
    }//GEN-LAST:event_b_mostrarDatosClienteMouseClicked

    private void b_eliminarOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_eliminarOrdenMouseClicked
        int columnaNmOrden = 0;
        int row = t_ordenesDelDia.getSelectedRow();
        int nmOrden = Integer.parseInt(t_ordenesDelDia.getModel().getValueAt(row, columnaNmOrden).toString());
        Conexion.eliminarOrden(nmOrden);
        Conexion.mostrarOrdenesDelDia(t_ordenesDelDia);
    }//GEN-LAST:event_b_eliminarOrdenMouseClicked

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
            java.util.logging.Logger.getLogger(OrdenesDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenesDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenesDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenesDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrdenesDia dialog = new OrdenesDia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cambiarRepartidor;
    private javax.swing.JButton b_eliminarOrden;
    private javax.swing.JButton b_mostrarDatosCliente;
    private javax.swing.JButton b_totalRepartidor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_ordenesDelDia;
    // End of variables declaration//GEN-END:variables
}
