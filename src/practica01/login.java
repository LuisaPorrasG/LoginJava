
package practica01;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import practica.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.Statement;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.Locale;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import practica.Conexion;
import java.sql.*;
import java.beans.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class login extends javax.swing.JFrame {
    
    Conexion cx;

    public login() {
        initComponents();
        this.setTitle("Login");
        this.setSize(400, 400);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/login.png"));
        lblLogo.setIcon(new ImageIcon(img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(img);
        this.setLocationRelativeTo(null);
        cx = new Conexion ("login");
        cx.conectar();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, 30));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 73, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 80, -1));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 100, 80));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
      try {
        String user = txtUsuario.getText(); // recupero el texto del campo usuario
        String password = new String(txtPassword.getPassword());

        String query = "SELECT * FROM login WHERE user=? AND password=?";
        try (Connection conn = cx.conectar();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, user);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "El usuario está en la base de datos");
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no existe en la base de datos");
                }
            }
        }
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_btnIniciarActionPerformed

    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
