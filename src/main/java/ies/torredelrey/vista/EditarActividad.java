/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ies.torredelrey.vista;

import ies.torredelrey.controlador.ActividadJpaController;
import ies.torredelrey.modelo.Actividad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 34662
 */
public class EditarActividad extends javax.swing.JFrame {
    private Actividad actividad;
    private ActividadJpaController activ;
    /**
     * Creates new form NuevoUsuario
     */
    public EditarActividad() {
    }

    public EditarActividad(Actividad actividades) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/LogoPaxis.jpeg")).getImage()); //icono de pantalla
        setLocationRelativeTo(null); //centrar la pantalla
        setResizable(false); // no se pueda maximizar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        activ = new ActividadJpaController(emf);

        // asignamos el parametro correcto al campo de la instancia
        this.actividad = actividades;

        // cargamos los datos de la actividad
        if (this.actividad != null) {
            txtNombre.setText(actividad.getNombreActividad());
            spnNplazas.setValue(actividad.getNumeroPlazas());
        } else {
            JOptionPane.showMessageDialog(this, "La actividad no está disponible", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBlanco = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        panPrincipal = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblNPlazas = new javax.swing.JLabel();
        spnNplazas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paxis Inclusion - Editar Actividad");

        panBlanco.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoPaxisPequeño.jpg"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 0, 0));
        lblTitulo.setText("Modificar Actividad");

        panPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        btnModificar.setBackground(new java.awt.Color(0, 255, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 0, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblNPlazas.setText("Nº Plazas:");

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnModificar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addGap(68, 68, 68)
                        .addComponent(btnSalir))
                    .addComponent(spnNplazas, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnNplazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNPlazas))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnReset)
                    .addComponent(btnSalir))
                .addGap(0, 111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panBlancoLayout = new javax.swing.GroupLayout(panBlanco);
        panBlanco.setLayout(panBlancoLayout);
        panBlancoLayout.setHorizontalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addComponent(imgLogo)
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addGap(0, 26, Short.MAX_VALUE))
            .addComponent(panPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panBlancoLayout.setVerticalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addGroup(panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBlancoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(41, 41, 41))
                    .addComponent(imgLogo))
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //validaciones de espacios en blanco
        try {
            if (txtNombre.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(rootPane, "El campo de nombre de la actividad no puede estar en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //asignacion de los datos
            String nombre = txtNombre.getText();
            int nplazas = (int) spnNplazas.getValue();
            

            
            //cambiamos los datos por los nuevos
            actividad.setNombreActividad(nombre);
            actividad.setNumeroPlazas(nplazas);
            
            try {
                activ.edit(actividad); // modifica la actividad en la base de datos
                JOptionPane.showMessageDialog(rootPane, "actividad modificada con exito");
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(EditarActividad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al modificar la actividad", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(EditarActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Resetea los campos de texto cargando los datos de la actividad  existente
        txtNombre.setText(actividad.getNombreActividad());
        spnNplazas.setValue(actividad.getNumeroPlazas());
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //salir al menu de actividades sin realizar cambios
        MenuActividades actividadesmenu = new MenuActividades();
        actividadesmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(EditarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarActividad().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lblNPlazas;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBlanco;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JSpinner spnNplazas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
