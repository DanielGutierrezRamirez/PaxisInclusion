/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ies.torredelrey.vista;

import ies.torredelrey.controlador.UsuariosJpaController;
import ies.torredelrey.controlador.ActividadJpaController;
import ies.torredelrey.controlador.ReservasJpaController;
import ies.torredelrey.modelo.Usuarios;
import ies.torredelrey.modelo.Actividad;
import ies.torredelrey.modelo.Reservas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 34662
 */
public class NuevaReserva extends javax.swing.JFrame {
    private ReservasJpaController res;
    private UsuariosJpaController usur;
    private ActividadJpaController activ;
    private String dniSeleccionado;    //donde guardaremos el dni que hemos seleccionado
    private String nombreActividadSeleccionada; //donde guardaremos el nombre de la actividad seleccionada
    /**
     * Creates new form NuevoUsuario
     */
    public NuevaReserva() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/LogoPaxis.jpeg")).getImage()); //icono de pantalla
        setLocationRelativeTo(null); //centrar la pantalla
        setResizable(false); // no se pueda maximizar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        
        activ = new ActividadJpaController(emf);
        usur = new UsuariosJpaController(emf);
        res = new ReservasJpaController(emf);
        

        //cargamos en la lista los dni que ya tenemos de los usuarios
        cargarDnis();
        lstDni.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lstDniMouseClicked(evt);
            }
        });
        
        //cargamos en la lista los nombre de la actividad que ya tenemos en las actividades
        cargarNombresActividades();
        lstNombreActividad.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lstDniMouseClicked(evt);
            }
        });
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
        lblPlazas = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        scrDni = new javax.swing.JScrollPane();
        lstDni = new javax.swing.JList<>();
        scrDni1 = new javax.swing.JScrollPane();
        lstNombreActividad = new javax.swing.JList<>();
        txtPlazas = new javax.swing.JTextField();
        spnFecha = new javax.swing.JSpinner();
        lblIdUsuario = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        lblIdActividad = new javax.swing.JLabel();
        txtIdActividad = new javax.swing.JTextField();
        lblIdUsuario1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblBuscarAct = new javax.swing.JLabel();
        txtNombreActividad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paxis Inclusion - Nueva Reserva");

        panBlanco.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoPaxisPequeño.jpg"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 0, 0));
        lblTitulo.setText("Nueva Reserva");

        panPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre De Actividad:");

        lblPlazas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPlazas.setText("Numero de plazas Restantes:");

        btnReservar.setBackground(new java.awt.Color(0, 255, 0));
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
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

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreUsuario.setText("Nombre Usuario:");

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBuscar.setText("Buscar Usuario:");

        lblApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Fecha de reserva: ");

        txtNombre.setEnabled(false);

        txtApellido.setEnabled(false);

        lstDni.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstDni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDniMouseClicked(evt);
            }
        });
        scrDni.setViewportView(lstDni);

        lstNombreActividad.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstNombreActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstNombreActividadMouseClicked(evt);
            }
        });
        scrDni1.setViewportView(lstNombreActividad);

        txtPlazas.setEnabled(false);

        spnFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(946681200000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        spnFecha.setEnabled(false);

        lblIdUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdUsuario.setText("Id Usuario: ");

        txtIdUsuario.setEnabled(false);

        lblIdActividad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdActividad.setText("Id Actividad: ");

        txtIdActividad.setEnabled(false);

        lblIdUsuario1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdUsuario1.setText("Dni Usuario: ");

        txtDni.setEnabled(false);

        lblBuscarAct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBuscarAct.setText("Buscar Actividad:");

        txtNombreActividad.setEnabled(false);

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPlazas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblNombre)
                            .addComponent(lblIdActividad))
                        .addGap(30, 30, 30)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spnFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlazas, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdUsuario)
                            .addComponent(txtIdActividad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreActividad))
                        .addGap(77, 77, 77)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblBuscarAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnReservar))
                        .addGap(31, 31, 31)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrDni1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrDni, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(btnSalir)))))
                .addGap(30, 30, 30))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUsuario1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUsuario)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombreUsuario)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBuscar))
                    .addComponent(scrDni, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscarAct)
                            .addComponent(scrDni1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdActividad)
                            .addComponent(txtIdActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlazas)
                            .addComponent(txtPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReservar)
                            .addComponent(btnReset)
                            .addComponent(btnSalir))))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panBlancoLayout = new javax.swing.GroupLayout(panBlanco);
        panBlanco.setLayout(panBlancoLayout);
        panBlancoLayout.setHorizontalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addComponent(imgLogo)
                .addGap(186, 186, 186)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panBlancoLayout.setVerticalGroup(
            panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBlancoLayout.createSequentialGroup()
                .addGroup(panBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgLogo)
                    .addGroup(panBlancoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblTitulo)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        //crear la nueva reserva
        Reservas reserva = new Reservas();
        //variables donde cogen el valor de los txt
        String dni = txtDni.getText();
        String nombres = txtNombre.getText();
        String apellidos = txtApellido.getText();
        String textoPlazas = txtPlazas.getText();
        String textoidUsur = txtIdUsuario.getText();
        String textoidAct = txtIdActividad.getText();
        String nombreActividad = txtNombreActividad.getText();
        //variables enteras donde le pasaremos la conversion de string a enteros
        int plazas = 0;
        int idU = 0;
        int idA = 0;

        // Validacion de numeros al convertirlo en int
        try {
            plazas = Integer.parseInt(textoPlazas);
            idU = Integer.parseInt(textoidUsur);
            idA = Integer.parseInt(textoidAct);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir texto a número: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico válido para las plazas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // verificar si quedan plazas disponibles de la actividad que hemos seleccionado
        if (plazas == 0) {
            JOptionPane.showMessageDialog(this, "Todas las plazas para esta actividad están agotadas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Creamos la reserva
        boolean reservaExistente = res.existeReserva(dni, nombreActividad); //creamos un metodo para obtener dni y nombre actividad en el jpa
        // verificamos si ya existe una reserva para este usuario y esta actividad
        if (reservaExistente) {
            JOptionPane.showMessageDialog(this, "Este usuario ya ha reservado esta actividad.", "Error", JOptionPane.ERROR_MESSAGE);
        } else { //en caso contrario la creamos y rellenamos los datos en la tabla
            
            Usuarios usuario2 = usur.findUsuarios(idU); //metodo que acepta un entero del jpa
            reserva.setUsuarios(usuario2); 
            reserva.setIdActividad(activ.findActividad(idA)); //metodo que acepta un entero del jpa
            reserva.setDniUsuario(dni);
            reserva.setNombreUsuario(nombres);
            reserva.setApellidosUsuario(apellidos);
            reserva.setNombreActividad(nombreActividad);
            reserva.setNumeroPlazasReserva(plazas);
            reserva.setFechaReserva((Date) spnFecha.getValue());

            // Guardamos la reserva en la base de datos
            try {
                // Reducimos las plazas en 1 por cada reserva
                Actividad actividad = activ.findActividad(idA);
                actividad.setNumeroPlazas(actividad.getNumeroPlazas() - 1);
                activ.edit(actividad); // editamos el numero de plazas en la base de datos
                res.create(reserva);
                JOptionPane.showMessageDialog(this, "Reserva creada con éxito.");
                this.dispose(); // Cerrar ventana
            } catch (Exception e) {
                Logger.getLogger(NuevaReserva.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, "Error al crear la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //volvemos al menu reserva
        MenuReserva menu = new MenuReserva();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // limpiamos los campos de texto
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtIdUsuario.setText("");
        txtNombreActividad.setText("");
        txtIdActividad.setText("");
        txtPlazas.setText("");
        spnFecha.setValue(new Date()); // restablecemos la fecha actual

        // deseleccionamos elementos en las listas
        lstDni.clearSelection();
        lstNombreActividad.clearSelection();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //volvemos al menu reserva
        MenuReserva menu = new MenuReserva();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lstDniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDniMouseClicked
        //cuando seleccione el dni me rellene el nombre el apellido dni y id
        String dniSeleccionado = lstDni.getSelectedValue();
        
        Usuarios usuario = usur.findUsuariosByDni(dniSeleccionado);
        int id = usuario.getId();
        String textoId = String.valueOf(id);
        
        if (usuario != null) {
            txtNombre.setText(usuario.getNombre());
            txtApellido.setText(usuario.getApellidos());
            txtDni.setText(usuario.getDni());
            txtIdUsuario.setText(textoId);
            
        }
    }//GEN-LAST:event_lstDniMouseClicked

    private void lstNombreActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstNombreActividadMouseClicked
        //cuando sellecione el nombre me rellene las plazas nombre id y la fecha de reserva
        String nombreSeleccionado = lstNombreActividad.getSelectedValue();
        nombreActividadSeleccionada = nombreSeleccionado;
        Actividad actividad = activ.findByNombre(nombreSeleccionado);
        int numeroPlazas = actividad.getNumeroPlazas();
        int id = actividad.getId();
        String textoPlazas = String.valueOf(numeroPlazas);
        String textoId = String.valueOf(id); 
        // Para validar la fecha de nacimiento
        Calendar calendario = Calendar.getInstance();
        Date fecha = (Date) spnFecha.getValue();
        
        
        if (actividad != null) {
        txtPlazas.setText(textoPlazas);
        txtNombreActividad.setText(actividad.getNombreActividad());
        txtIdActividad.setText(textoId);
        spnFecha.setValue(new Date());
        
        }
    }//GEN-LAST:event_lstNombreActividadMouseClicked

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
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaReserva().setVisible(true);
            }
        });
    }
    //metodo para cargar la lista de dni
    private void cargarDnis() {
        DefaultListModel<String> model = new DefaultListModel<>();
        List<Usuarios> usuarios = usur.findUsuariosEntities();
        for (Usuarios usuario : usuarios) {
            model.addElement(usuario.getDni());
        }
        lstDni.setModel(model);
    }
    //metodo para cargar nombre de actividades
    private void cargarNombresActividades() {
        DefaultListModel<String> model = new DefaultListModel<>();
        List<Actividad> actividades = activ.findAllActividad();
        
        for (Actividad actividad : actividades) {
            model.addElement(actividad.getNombreActividad());
        }
        
        lstNombreActividad.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarAct;
    private javax.swing.JLabel lblIdActividad;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblIdUsuario1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPlazas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> lstDni;
    private javax.swing.JList<String> lstNombreActividad;
    private javax.swing.JPanel panBlanco;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JScrollPane scrDni;
    private javax.swing.JScrollPane scrDni1;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdActividad;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreActividad;
    private javax.swing.JTextField txtPlazas;
    // End of variables declaration//GEN-END:variables
}
