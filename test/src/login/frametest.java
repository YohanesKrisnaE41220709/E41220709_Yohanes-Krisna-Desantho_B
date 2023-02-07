package login;
import admins.PanelPengaturan;
import admins.main_utama;
import admins.settings;
import users.main_user;
import connect.connect;
import javax.swing.JOptionPane;
import java.sql.*;
import login.forgot_pass;
public class frametest extends javax.swing.JFrame {
    public frametest() {
        initComponents();
        setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_user = new javax.swing.JTextField();
        btn_quit = new javax.swing.JLabel();
        btn_masuk = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 769));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_user.setForeground(new java.awt.Color(0, 0, 0));
        txt_user.setBorder(null);
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 170, 30));

        btn_quit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_quit.setForeground(new java.awt.Color(0, 0, 0));
        btn_quit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_quit.setText("Keluar");
        btn_quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_quitMouseClicked(evt);
            }
        });
        getContentPane().add(btn_quit, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 100, 30));

        btn_masuk.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_masuk.setForeground(new java.awt.Color(0, 0, 0));
        btn_masuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_masuk.setText("Masuk");
        btn_masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_masukMouseClicked(evt);
            }
        });
        getContentPane().add(btn_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 100, 30));

        txt_pass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(0, 0, 0));
        txt_pass.setBorder(null);
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Masuk");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Kata Sandi");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nama Pengguna");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Lupa Kata Sandi ?");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 427, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/login.png"))); // NOI18N
        jLabel1.setText("Masuk");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 1080, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_masukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_masukMouseClicked
        String user = txt_user.getText();
        String pass = new String(txt_pass.getPassword());
        
        if(user.equals("") && "".equals(pass)) {
            JOptionPane.showMessageDialog(rootPane, "Harap di isi kolom pengguna dan password");
        } else if(user.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Harap di isi kolom pengguna");
        } else if("".equals(pass)) { 
            JOptionPane.showMessageDialog(rootPane, "Harap di isi kolom password");
        } else {
            try {
            String query = "select nama,username,password,status from persons where username='"+user+"' and password='"+pass+"'";
            Connection conn = (Connection)connect.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
            if(res.next()) {
                if(res.getString("status").equals("admin")) {
                    main_utama main = new main_utama();
                    main.setTitle("Selamat Datang Admin - "+res.getString("username") );
                    main.username.setText(res.getString("nama"));
                    main.setVisible(true);
                    this.setVisible(false);
                } else if(res.getString("status").equals("karyawan")) {
                    main_user main = new main_user();
                    main.setTitle("Selamat Datang Karyawan - "+res.getString("username") );
                    main.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "nama pengguna atau password salah","peringatan",JOptionPane.WARNING_MESSAGE);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
    }//GEN-LAST:event_btn_masukMouseClicked

    private void btn_quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_quitMouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        forgot_pass forgot = new forgot_pass();
        forgot.setVisible(true);
    }//GEN-LAST:event_jLabel2MousePressed

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
            java.util.logging.Logger.getLogger(frametest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frametest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frametest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frametest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frametest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_masuk;
    private javax.swing.JLabel btn_quit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
