package ui.register;

import Logic.validate.validateRegister.ValidatePasswordRegister;
import bd.conectionBd.ConnectionBd;
import bd.usuarioDAO.InsertBd;
import config.ErrorCataloger;
import config.Hashed;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterPasswordFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegisterPasswordFrame.class.getName());
    private JFrame ventanaAnterior;
    private String name, lastname, dni;

    public RegisterPasswordFrame(JFrame ventanaAnterior, String name, String lastname, String dni) {
        initComponents();
        setLayout(null);
        setTitle("Banco nacional");
        setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);

        //referencia a la ventana RegisterDateFrame
        this.ventanaAnterior = ventanaAnterior;

        //referencia a la ventana LoginFrame
        this.ventanaAnterior = ventanaAnterior;

        //Cierra las ventanas RegisterDate y RegisterPassword
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                ventanaAnterior.dispose(); //Cierra la ventana Register cuando se cierra esta
            }
        });

        //Inicializa las variables recibidas
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPassword2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ingrese su contraseña:");

        jLabel2.setText("Ingrese de nuevo su contraseña:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ValidatePasswordRegister ms = new ValidatePasswordRegister();
        int esValido = ms.validatePassword(
                txtPassword1.getText(),
                txtPassword2.getText()
        );
        if (esValido == 0) {
            String password = txtPassword1.getText();
            InsertBd ins = new InsertBd();
            boolean registrado = ins.registerUsers(name, lastname, dni, password);
            
            if (registrado) {
                JOptionPane.showMessageDialog(this, "Registro exitoso\n"
                        + "Tu número de cuenta es: " + InsertBd.getBankAccount() );
                ventanaAnterior.dispose();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar al usuario en la base de datos");
            }

        } else {
            ErrorCataloger.errorCatalogerPasswordRegister(esValido);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtPassword2;
    // End of variables declaration//GEN-END:variables
}
