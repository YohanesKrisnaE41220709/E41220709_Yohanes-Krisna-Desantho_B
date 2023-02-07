package admins;
import javax.swing.JFrame;
import login.frametest;
import admins.PanelPengaturan;
import javax.swing.JOptionPane;

public class main_utama extends javax.swing.JFrame {
//    String name_pengaturan;
    menu_items menu1;
    menu_transaksi transaksi;
    menu_laporan laporan;
    PanelPengaturan pengaturan;
    
    public main_utama() {
        initComponents();
        
        pengaturan = new PanelPengaturan();
        menu1 = new menu_items();
        transaksi = new menu_transaksi();
        laporan = new menu_laporan();
        
        layouting.add(pengaturan);
        layouting.add(laporan);
        layouting.add(menu1);
        layouting.add(transaksi);
        
        pengaturan.setVisible(false);
        laporan.setVisible(false);
        transaksi.setVisible(false);
        menu1.setVisible(false);
        
        setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_logout = new javax.swing.JLabel();
        btn_utama = new javax.swing.JLabel();
        btn_transaksi = new javax.swing.JLabel();
        btn_laporan = new javax.swing.JLabel();
        btn_pengaturan = new javax.swing.JLabel();
        layouting = new javax.swing.JPanel();
        layout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(0, 0, 0));
        btn_logout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_logout.setText("Logout");
        btn_logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 100, 40));

        btn_utama.setBackground(new java.awt.Color(0, 102, 204));
        btn_utama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_utama.setForeground(new java.awt.Color(0, 0, 0));
        btn_utama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_utama.setText("Utama");
        btn_utama.setAlignmentY(0.0F);
        btn_utama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_utama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_utamaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_utama, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 0, 90, 40));

        btn_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_transaksi.setForeground(new java.awt.Color(0, 0, 0));
        btn_transaksi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_transaksi.setText("Transaksi");
        btn_transaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 120, 40));

        btn_laporan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(0, 0, 0));
        btn_laporan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_laporan.setText("Laporan");
        btn_laporan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 100, 40));

        btn_pengaturan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_pengaturan.setForeground(new java.awt.Color(0, 0, 0));
        btn_pengaturan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_pengaturan.setText("Pengaturan");
        btn_pengaturan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_pengaturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pengaturanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_pengaturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 130, 40));

        layouting.setBackground(new java.awt.Color(251, 243, 216));
        layouting.setAlignmentX(0.0F);
        layouting.setAlignmentY(0.0F);
        getContentPane().add(layouting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1080, 730));

        username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        username.setForeground(new java.awt.Color(0, 0, 0));
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                usernameMouseReleased(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 130, 40));

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/main_utama.png"))); // NOI18N
        layout.setIconTextGap(0);
        getContentPane().add(layout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_utamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_utamaMouseClicked
        menu1.setVisible(true);
        transaksi.setVisible(false);
        laporan.setVisible(false);
        pengaturan.setVisible(false);
    }//GEN-LAST:event_btn_utamaMouseClicked

    private void btn_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksiMouseClicked
        menu1.setVisible(false);
        transaksi.setVisible(true);
        laporan.setVisible(false);
        pengaturan.setVisible(false);
    }//GEN-LAST:event_btn_transaksiMouseClicked

    private void btn_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseClicked
        menu1.setVisible(false);
        transaksi.setVisible(false);
        laporan.setVisible(true);
        pengaturan.setVisible(false);
    }//GEN-LAST:event_btn_laporanMouseClicked

    private void btn_pengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengaturanMouseClicked
        menu1.setVisible(false);
        transaksi.setVisible(false);
        laporan.setVisible(true);
        PanelPengaturan settings = new PanelPengaturan();
        settings.nama = "";
        pengaturan.setVisible(false);
    }//GEN-LAST:event_btn_pengaturanMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        new frametest().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void usernameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseReleased
        String username = this.username.getText();
        settings settings = new settings();
        settings.viewprofil(username);
        settings.setVisible(true);
    }//GEN-LAST:event_usernameMouseReleased

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
            java.util.logging.Logger.getLogger(main_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_laporan;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_pengaturan;
    private javax.swing.JLabel btn_transaksi;
    private javax.swing.JLabel btn_utama;
    private javax.swing.JLabel layout;
    private javax.swing.JPanel layouting;
    public final javax.swing.JLabel username = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
