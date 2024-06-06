/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ies.torredelrey.vista;

import ies.torredelrey.controlador.UsuariosJpaController;
import ies.torredelrey.modelo.Usuarios;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Gutierrez Ramirez
 * 
 * clase EditarUusuario
 * Edita a los usuarios existentes
 * @version 1.0
 */
public class EditarUsuario extends javax.swing.JFrame {
    private Usuarios usuario;
    private UsuariosJpaController Usur;
    
    /**
     * Constructor por defecto
     */
    public EditarUsuario() {
        
    }
    /**
     * Constructor que recibe un objeto Usuarios.
     * Inicializa los componentes de la interfaz gráfica y carga los datos del usuario en los campos correspondientes.
     * 
     * @param usuario El usuario cuyos datos se desean editar.
     */
    public EditarUsuario(Usuarios usuario) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/LogoPaxis.jpeg")).getImage()); //icono de pantalla
        setLocationRelativeTo(null); //centrar la pantalla
        setResizable(false); // no se pueda maximizar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        Usur = new UsuariosJpaController(emf);
        
        // asignamos el parametro correcto al campo de la instancia
        this.usuario = usuario;
        
        // Carga los datos del usuario 
        txtDni.setText(usuario.getDni());
        txtNombre.setText(usuario.getNombre());
        txtApellidos.setText(usuario.getApellidos());
        txtEmail.setText(usuario.getEmail());
        txtTelefono.setText(usuario.getTelefono());
        spnFecha.setValue(usuario.getFechaNacimiento());
        cbxGenero.setSelectedItem(usuario.getSexo());
        txtDomicilio.setText(usuario.getDomicilio());
        txtCP.setText(usuario.getCp());
        txtProvincia.setText(usuario.getProvincia());
        txtLocalidad.setText(usuario.getLocalidad());

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
        lblDni = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtCP = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        spnFecha = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paxis Inclusion - Editar Usuario");

        panBlanco.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoPaxisPequeño.jpg"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 0, 0));
        lblTitulo.setText("Modificar Usuario");

        panPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        lblDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDni.setText("Dni: ");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellido.setText("Apellidos:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefono.setText("Telefono:");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setText("Fecha de Nac.:");

        lblSexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSexo.setText("Sexo:");

        lblDomicilio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDomicilio.setText("Domicilio:");

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCodigo.setText("Codigo Postal:");

        lblProvincia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblProvincia.setText("Provincia:");

        lblLocalidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLocalidad.setText("Localidad:");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genero", "Masculino", "Femenino" }));

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

        spnFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(946681200000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(lblProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(txtDni)
                                .addComponent(txtDomicilio)
                                .addComponent(txtCP)
                                .addComponent(txtProvincia)
                                .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82))))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDomicilio)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalidad)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 201, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panBlancoLayout = new javax.swing.GroupLayout(panBlanco);
        panBlanco.setLayout(panBlancoLayout);
        panBlancoLayout.setHorizontalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addComponent(imgLogo)
                .addGap(27, 27, 27)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panBlancoLayout.setVerticalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addGroup(panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBlancoLayout.createSequentialGroup()
                        .addComponent(imgLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBlancoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(41, 41, 41)))
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que se ejecuta al presionar el botón "Modificar".
     * Valida los datos ingresados y modifica los datos del usuario en la base de datos.
     * 
     * @param evt El evento de acción.
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        boolean salir = false;
        //Patrones para el dni, email,telefono y codigo postal
        String dniPattern = "^[0-9]{8}[a-zA-Z]$";
        Pattern patterndni = Pattern.compile(dniPattern); 
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; 
        Pattern patternemail = Pattern.compile(emailPattern);
        String telefonoPattern = "^[0-9]{9}$";
        Pattern patternTelefono = Pattern.compile(telefonoPattern);
        String cpPattern = "^[0-9]{5}$";
        Pattern patternCp = Pattern.compile(cpPattern);
        //variable para el genero
        String seleccionarGenero = (String) cbxGenero.getSelectedItem();
        
        //validaciones de datos en blanco o de formato incorrecto
        try {
            if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || spnFecha.getValue() == null || txtTelefono.getText().isEmpty() || txtDomicilio.getText().isEmpty()  || txtCP.getText().isEmpty() || txtProvincia.getText().isEmpty() || txtLocalidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!"Masculino".equals(seleccionarGenero) && !"Femenino".equals(seleccionarGenero)) {
                JOptionPane.showMessageDialog(this, "Elija un genero valido (Masculino o Femenino).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!patterndni.matcher(txtDni.getText()).matches()) {
                JOptionPane.showMessageDialog(this, "El formato del DNI es incorrecto. Debe ser 00000000X.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!patternTelefono.matcher(txtTelefono.getText()).matches()) {
                JOptionPane.showMessageDialog(this, "El formato del telefono es incorrecto. Debe tener 9 digitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!patternemail.matcher(txtEmail.getText()).matches()) {
                JOptionPane.showMessageDialog(this, "El formato del Email es incorrecto. Debe ser aaa@aaa.aa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!patternCp.matcher(txtCP.getText()).matches()) {
                JOptionPane.showMessageDialog(this, "El formato del codigo postal es incorrecto. Debe tener 5 digitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //obetenemos los datos existentes
            String dni = txtDni.getText();
            String email = txtEmail.getText();
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String telefono = txtTelefono.getText();
            Date fecha = (Date) spnFecha.getValue();
            String domicilio = txtDomicilio.getText();
            String cp = txtCP.getText();
            String provincia = txtProvincia.getText();
            String localidad = txtLocalidad.getText();
            String sexo = (String) cbxGenero.getSelectedItem();

            Calendar calLimite = Calendar.getInstance();
            //fecha anterior al 1 de enero de 1900 no disponible
            calLimite.set(1900, Calendar.JANUARY, 1);

            if (fecha.before(calLimite.getTime())) {
                JOptionPane.showMessageDialog(rootPane, "La fecha de nacimiento no puede ser anterior al 1 de Enero de 1900", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //modificamos fecha
            usuario.setEmail(email);
            usuario.setDni(dni);
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setTelefono(telefono);
            usuario.setFechaNacimiento(fecha);
            usuario.setDomicilio(domicilio);
            usuario.setCp(cp);
            usuario.setProvincia(provincia);
            usuario.setLocalidad(localidad);
            usuario.setSexo(sexo);

            try {
                Usur.edit(usuario); // Modifica el usuario existente en la base de datos
                JOptionPane.showMessageDialog(rootPane, "Usuario modificado con éxito");
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al modificar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    /**
     * Método que se ejecuta al presionar el botón "Reset".
     * Restaura los datos originales del usuario en los campos correspondientes.
     * 
     * @param evt El evento de acción.
     */
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Resetea los campos de texto cargando los datos de la actividad  existente
        txtDni.setText(usuario.getDni());
        txtNombre.setText(usuario.getNombre());
        txtApellidos.setText(usuario.getApellidos());
        txtEmail.setText(usuario.getEmail());
        txtTelefono.setText(usuario.getTelefono());
        spnFecha.setValue(usuario.getFechaNacimiento());
        cbxGenero.setSelectedItem(usuario.getSexo());
        txtDomicilio.setText(usuario.getDomicilio());
        txtCP.setText(usuario.getCp());
        txtProvincia.setText(usuario.getProvincia());
        txtLocalidad.setText(usuario.getLocalidad());
    }//GEN-LAST:event_btnResetActionPerformed
    /**
     * Método que se ejecuta al presionar el botón "Salir".
     * Cierra la ventana actual y abre el menú de usuarios.
     * 
     * @param evt El evento de acción.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //sale al menu de usuarios
        MenuUsuarios usuariomenu = new MenuUsuarios();
        usuariomenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarUsuario().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBlanco;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
