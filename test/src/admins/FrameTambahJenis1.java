package admins;
import connect.connect;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FrameTambahJenis1 extends javax.swing.JFrame {
    public FrameTambahJenis1() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        table();
        kode_otomatis();
        setTitle("Jenis");
        setResizable(false);
    }
    public void kode_otomatis() {
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt = new SimpleDateFormat("yy", Locale.getDefault());
        String tanggal = smpdtfmt.format(tglsekarang);

        java.util.Date tglsekarang2 = new java.util.Date();
        SimpleDateFormat smpdtfmt2 = new SimpleDateFormat("MM", Locale.getDefault());
        String tanggal2 = smpdtfmt2.format(tglsekarang2);

        java.util.Date tglsekarang3 = new java.util.Date();
        SimpleDateFormat smpdtfmt3 = new SimpleDateFormat("dd", Locale.getDefault());
        String tanggal3 = smpdtfmt3.format(tglsekarang3);

        Random rad = new Random();
        int number = rad.nextInt(999);
        String format = String.format("%03d", number);

        txt_id.setText("J"+tanggal+tanggal2+tanggal3+format);
    }
    public void table() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No");
        tbl.addColumn("Nama Jenis");
        
        try {
            Statement stm = connect.configDB().createStatement();
            ResultSet res = stm.executeQuery("select * from jenis");
            while(res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_jenis"),
                    res.getString("nama_jenis"),
                });
                jTable1.setModel(tbl);
//                tbl.fireTableDataChanged();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal : " + e.getMessage());
        }
    }
    public void clear() {
        txt_id.setText(null);
        txt_jenis.setText(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_jenis = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 530, 340));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, 30));

        txt_jenis.setForeground(new java.awt.Color(0, 0, 0));
        txt_jenis.setBorder(null);
        txt_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jenisActionPerformed(evt);
            }
        });
        getContentPane().add(txt_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 220, 40));

        txt_id.setForeground(new java.awt.Color(0, 0, 0));
        txt_id.setBorder(null);
        txt_id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 220, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Jenis");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 275, -1, 30));

        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(0, 0, 0));
        btn_simpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_simpan.setText("   Simpan");
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/tambah_jenis.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 615));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jenisActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        String id = txt_id.getText();
        String nama = txt_jenis.getText().toLowerCase();
        try {
            if(nama.length() <= 1) {
                JOptionPane.showMessageDialog(null, "Harus di isi dengan benar");
            }  else {
                String query = "insert into jenis values('"+id+"','"+nama.toLowerCase()+"',now())";
                Connection conn = (Connection)connect.configDB();
                Statement stm = conn.createStatement();
                stm.execute(query);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, txt_jenis.getText() + " sudah di pakai");
        }
        table();
        clear();
        kode_otomatis();
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();
        
        String id = jTable1.getValueAt(baris, 0).toString();
        txt_id.setText(id);
        String jenis = jTable1.getValueAt(baris, 1).toString();
        txt_jenis.setText(jenis);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(FrameTambahJenis1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTambahJenis1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTambahJenis1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTambahJenis1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTambahJenis1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jenis;
    // End of variables declaration//GEN-END:variables
}
