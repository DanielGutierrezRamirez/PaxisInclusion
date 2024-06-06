/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ies.torredelrey.vista;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ies.torredelrey.controlador.ReservasJpaController;
import ies.torredelrey.modelo.Usuarios;
import ies.torredelrey.modelo.Reservas;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Daniel Gutierrez Ramirez
 * Clase Menu Reserva
 * Permite moverte por las diferentes opciones de las reservas agregar, eliminar y actualizar. . 
 * @version 1.0
 */
public class MenuReserva extends javax.swing.JFrame {
    private ReservasJpaController res;
    /**
     * Creates new form Usuarios
     */
    
    /**
     * Constructor por defecto
     * Inicializa los componentes y establece configuraciones básicas de la ventana.
     */
    public MenuReserva() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/LogoPaxis.jpeg")).getImage()); //icono de pantalla
        setLocationRelativeTo(null); //centrar la pantalla
        setResizable(false); // no se pueda maximizar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        // creamos una instancia del controlador UsuariosJpaController
        res = new ReservasJpaController(emf);
        actualizarTablaReservas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPrincipal = new javax.swing.JPanel();
        panBlanco = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paxis Inclusion - Menu Reservas");

        panPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        panBlanco.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoPaxisPequeño.jpg"))); // NOI18N

        lblMenu.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 0, 0));
        lblMenu.setText("Reservas");

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBlancoLayout = new javax.swing.GroupLayout(panBlanco);
        panBlanco.setLayout(panBlancoLayout);
        panBlancoLayout.setHorizontalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addComponent(imgLogo)
                .addGap(253, 253, 253)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(55, 55, 55))
        );
        panBlancoLayout.setVerticalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addComponent(imgLogo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addGroup(panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBlancoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panBlancoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblReservas);

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Reservas");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 51, 255));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar Reservas");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0, 255, 0));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Crear Reservas");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(125, 125, 125)
                .addComponent(btnNuevo)
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnNuevo))
                .addGap(0, 206, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que se ejecuta al presionar el botón "Actualizar".
     * Actualiza la lista de reervas para mostrar en la tabla
     * 
     * @param evt El evento de acción.
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //actualizamos la tabla
        actualizarTablaReservas();
    }//GEN-LAST:event_btnActualizarActionPerformed
    /**
     * Método que se ejecuta al presionar el botón "Eliminar".
     * Elimina la reserva seleccionada.
     * 
     * @param evt El evento de acción.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tblReservas.getSelectedRow();

        if (selectedRow != -1) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar la reserva?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                List<Reservas> reservas = res.findAllReservas(); 
                Reservas reserva = reservas.get(selectedRow);

                try {
                    res.destroy(reserva.getId()); // Eliminamos y actualizamos
                    actualizarTablaReservas();
                    JOptionPane.showMessageDialog(this, "Reserva eliminada y plaza incrementada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed
    /** Acción ejecutada al presionar el botón de Nuevo
     * Cierra la ventana actual y abre la ventana de NuevaReserva.
     * 
     * @param evt El evento de acción.
     **/
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //viajamos a la ventana de nueva reserva
        NuevaReserva nueva = new NuevaReserva();
        nueva.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed
    /** Acción ejecutada al presionar el botón de volver
     * Cierra la ventana actual y abre la ventana de Menu.
     * 
     * @param evt El evento de acción.
     **/
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //volvemos al menu principal

        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Método principal que lanza la aplicación.
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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Usuarios().setVisible(true);
            }
        });
    }
    private void actualizarTablaReservas() {
        // obtener todas las reservas
        List<Reservas> reservas = res.findAllReservas();
        // mostramos la cabezas de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Dni");
        model.addColumn("Nombre_Usuario");
        model.addColumn("Apellidos");
        model.addColumn("Nombre_Actividad");
        model.addColumn("Nº_Plazas");
        model.addColumn("Fecha_Reserva");


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //rellenamos la tabla
        for (Reservas reserva : reservas) {
            model.addRow(new Object[]{
                
                reserva.getDniUsuario(),
                reserva.getNombreUsuario(),
                reserva.getApellidosUsuario(),
                reserva.getNombreActividad(),
                reserva.getNumeroPlazasReserva(),
                dateFormat.format(reserva.getFechaReserva()),
            });
        }

        tblReservas.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JPanel panBlanco;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JTable tblReservas;
    // End of variables declaration//GEN-END:variables
}
