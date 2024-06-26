/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ies.torredelrey.vista;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ies.torredelrey.controlador.UsuariosJpaController;
import ies.torredelrey.modelo.Usuarios;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Daniel Gutierrez Ramirez
 * Clase Menu Usuarios
 * Permite moverte por las diferentes opciones de los usuarios agregar, editar, eliminar y actualizar. . 
 * @version 1.0
 */
public class MenuUsuarios extends javax.swing.JFrame {
    private UsuariosJpaController usur;
    /**
     * Creates new form Usuarios
     */
    
    /**
     * Constructor por defecto
     * Inicializa los componentes y establece configuraciones básicas de la ventana.
     */
    public MenuUsuarios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/LogoPaxis.jpeg")).getImage()); //icono de pantalla
        setLocationRelativeTo(null); //centrar la pantalla
        setResizable(false); // no se pueda maximizar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        // creamos una instancia del controlador UsuariosJpaController
        usur = new UsuariosJpaController(emf);
        actualizarTablaUsuarios();
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
        tblUsuarios = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paxis Inclusion - Menu Usuarios");

        panPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        panBlanco.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoPaxisPequeño.jpg"))); // NOI18N

        lblMenu.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 0, 0));
        lblMenu.setText("Usuarios");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarios);

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar1.setBackground(new java.awt.Color(0, 0, 255));
        btnActualizar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setText("Actualizar Usuarios");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0, 255, 0));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo Usuario");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 153, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar Usuario");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnActualizar1)
                .addGap(54, 54, 54)
                .addComponent(btnEliminar)
                .addGap(56, 56, 56)
                .addComponent(btnNuevo)
                .addGap(46, 46, 46)
                .addComponent(btnEditar)
                .addContainerGap(154, Short.MAX_VALUE))
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
                    .addComponent(btnActualizar1)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addGap(0, 204, Short.MAX_VALUE))
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
     * Actualiza la lista de actividades para mostrar en la tabla
     * 
     * @param evt El evento de acción.
     */
    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        //actualizamos la tabla
        actualizarTablaUsuarios();
    }//GEN-LAST:event_btnActualizar1ActionPerformed
    /**
     * Método que se ejecuta al presionar el botón "Eliminar".
     * Elimina el usuario seleccionada siempre y cuando no este en alguna reserva.
     * 
     * @param evt El evento de acción.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //eliminamos la fila seleccionada
        int selectedRow = tblUsuarios.getSelectedRow();

        if (selectedRow != -1) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el usuario?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                // Obtenemos la lista de usuarios y el usuario seleccionado
                List<Usuarios> usuarios = usur.findAllUsuarios(); 
                Usuarios usuario = usuarios.get(selectedRow);

                try {
                    usur.destroy(usuario.getId()); //eliminamos y actualizamos
                    actualizarTablaUsuarios();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el usuario, tiene una/s reserva/s en actividades. Primero elimina las reservas. ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed
    /** Acción ejecutada al presionar el botón de Nuevo
     * Cierra la ventana actual y abre la ventana de NuevoUsuario.
     * 
     * @param evt El evento de acción.
     **/
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //viajamos a la ventana de nuevo usuario
        NuevoUsuario nuevo = new NuevoUsuario();
        nuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed
    /**
     * Método que se ejecuta al presionar el botón "Editar".
     * Valida los datos ingresados y modifica los datos del usuario en la base de datos.
     * 
     * @param evt El evento de acción.
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // la fila selecionada es la que modificaremos
        int selectedRow = tblUsuarios.getSelectedRow();

        if (selectedRow != -1) {
            // Obtenemos la lista de usuarios y el selecionado
            List<Usuarios> usuarios = usur.findAllUsuarios(); 
            Usuarios usuario = usuarios.get(selectedRow);

            // Creamos una instancia de la ventana EditarUsuario y le pasamos el usuario seleccionado
            EditarUsuario editarUsuario = new EditarUsuario(usuario);
            editarUsuario.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed
    /** Acción ejecutada al presionar el botón de volver
     * Cierra la ventana actual y abre la ventana de Menu.
     * 
     * @param evt El evento de acción.
     **/
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //volvemos al menu principal
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
        
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
    private void actualizarTablaUsuarios() {
    // obtenemos todos los Usuarios
        List<Usuarios> usuarios = usur.findAllUsuarios();

        // mostramos la cabeza de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Dni");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Email");
        model.addColumn("Telefono");
        model.addColumn("Fecha de nacimiento");
        model.addColumn("Sexo");
        model.addColumn("Domicilio");
        model.addColumn("Codigo Postal");
        model.addColumn("Provincia");
        model.addColumn("Localidad");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        //rellenamos los usuarios
        for (Usuarios usuario : usuarios) {
            model.addRow(new Object[]{
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getTelefono(),
                dateFormat.format(usuario.getFechaNacimiento()),
                usuario.getSexo(),
                usuario.getDomicilio(),
                usuario.getCp(),
                usuario.getProvincia(),
                usuario.getLocalidad(),
                
            });
        }

        tblUsuarios.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JPanel panBlanco;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
