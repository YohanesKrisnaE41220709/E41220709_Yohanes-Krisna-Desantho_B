package admins;
import com.mysql.cj.jdbc.ConnectionImpl;
import connect.connect;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import static java.util.Collections.replaceAll;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
public class FrameTambahBarang1 extends javax.swing.JFrame {
    public FrameTambahBarang1() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        comboBoxJenis();
        comboBoxSatuan();
        kode_otomatis();
        table();
        setResizable(false);
        setTitle("Tambah Barang");
        table_view.setDefaultEditor(Object.class, null);
    }
    public void comboBoxJenis() {
        try {
            String query = "select * from jenis";
            Connection conn = (Connection)connect.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
            
            while(res.next()) {
                cbx_jenis.addItem(res.getString("nama_jenis"));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void comboBoxSatuan() {
        try {
            String query = "select * from satuan";
            Connection conn = (Connection)connect.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
            
            while(res.next()) {
                cbx_satuan.addItem(res.getString("nama_satuan"));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
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

        txt_id.setText("B"+tanggal+tanggal2+tanggal3+format);
    }
    public void clear() {
        txt_id.setText(null);
        txt_nama.setText(null);
        txt_stok.setText(null);
        cbx_jenis.setSelectedIndex(0);
        cbx_satuan.setSelectedIndex(0);
        txt_harga_beli.setText(null);
        txt_harga_jual.setText(null);
    }
    public void table() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No");
        tbl.addColumn("Nama Material");
        tbl.addColumn("Stok");
        tbl.addColumn("Jenis");
        tbl.addColumn("Satuan");
        tbl.addColumn("Harga Beli");
        tbl.addColumn("Harga Jual");
        try {
            Statement stm = connect.configDB().createStatement();
            ResultSet res = stm.executeQuery("select * from barang,jenis,satuan where barang.id_jenis = jenis.id_jenis and barang.id_satuan = satuan.id_satuan");
            while(res.next()) {
                int angka = Integer.parseInt(res.getString("harga_beli"));
                String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
                StringTokenizer token = new StringTokenizer(ganti, ".");
                ganti = token.nextToken();
                ganti = ganti.replace(',',',');
                
                int angka1 = Integer.parseInt(res.getString("harga_jual"));
                String ganti1 = NumberFormat.getNumberInstance(Locale.US).format(angka1);
                StringTokenizer token1 = new StringTokenizer(ganti1, ".");
                ganti1 = token1.nextToken();
                ganti1 = ganti1.replace(',',',');
                
                int stok1 = Integer.parseInt(res.getString("stok"));
                String ganti_stok = NumberFormat.getNumberInstance(Locale.US).format(stok1);
                StringTokenizer token2 = new StringTokenizer(ganti_stok, ".");
                ganti_stok = token2.nextToken();
                ganti_stok = ganti_stok.replace(',',',');
                
                tbl.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("stok").format(ganti_stok),
                    res.getString("jenis.nama_jenis"),
                    res.getString("satuan.nama_satuan"),
                    res.getString("harga_beli").format(ganti),
                    res.getString("harga_jual").format(ganti1),
                });
                table_view.setModel(tbl);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal : " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_stok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_view = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_harga_jual = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_harga_beli = new javax.swing.JTextField();
        cbx_satuan = new javax.swing.JComboBox<>();
        cbx_jenis = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NAMA PRODUK");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("STOK");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txt_stok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_stok.setBorder(null);
        txt_stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stokKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stokKeyTyped(evt);
            }
        });
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 270, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("JENIS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 70, 60, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Satuan Berat");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("HARGA JUAL");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, 20));

        table_view.setModel(new javax.swing.table.DefaultTableModel(
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
        table_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_view);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 1020, 240));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("     Simpan");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 110, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Bersihkan ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 110, 30));

        txt_id.setBackground(new java.awt.Color(102, 102, 102));
        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id.setForeground(new java.awt.Color(153, 153, 153));
        txt_id.setBorder(null);
        txt_id.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setEnabled(false);
        txt_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idKeyTyped(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 270, 20));

        txt_harga_jual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_harga_jual.setBorder(null);
        txt_harga_jual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_harga_jualKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_harga_jualKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_harga_jualKeyTyped(evt);
            }
        });
        getContentPane().add(txt_harga_jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 270, 30));

        txt_nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nama.setBorder(null);
        txt_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_namaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 270, 30));

        txt_harga_beli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_harga_beli.setBorder(null);
        txt_harga_beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_harga_beliKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_harga_beliKeyTyped(evt);
            }
        });
        getContentPane().add(txt_harga_beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 270, 30));

        cbx_satuan.setBackground(new java.awt.Color(255, 255, 255));
        cbx_satuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbx_satuan.setForeground(new java.awt.Color(0, 0, 0));
        cbx_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---" }));
        cbx_satuan.setToolTipText("");
        cbx_satuan.setAutoscrolls(true);
        cbx_satuan.setBorder(null);
        cbx_satuan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(cbx_satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 270, 30));
        cbx_satuan.getAccessibleContext().setAccessibleName("");

        cbx_jenis.setBackground(new java.awt.Color(255, 255, 255));
        cbx_jenis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbx_jenis.setForeground(new java.awt.Color(0, 0, 0));
        cbx_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---" }));
        cbx_jenis.setToolTipText("");
        cbx_jenis.setAutoscrolls(true);
        cbx_jenis.setBorder(null);
        cbx_jenis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(cbx_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 270, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("HARGA BELI");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/frameTambahBarang_image.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 615));

        setSize(new java.awt.Dimension(1083, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        try {
            String id = txt_id.getText();
            String nama = txt_nama.getText().toLowerCase();
            String stok = txt_stok.getText();
            String harga_beli = txt_harga_beli.getText();
            String harga_jual = txt_harga_jual.getText();
            if(id == null || nama == null || stok == null || harga_beli == null || harga_jual == null || cbx_jenis.getSelectedItem() == null || cbx_satuan.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Tolong wajib di isi field nya");
            } else {
                int stok1 = Integer.parseInt(stok.replace(",", ""));
                String jenis = (String)cbx_jenis.getSelectedItem();
                String jns = null;
                try {
                    String query_jenis = "select * from jenis where nama_jenis='"+jenis+"'";
                    Connection conn_jenis = (Connection)connect.configDB();
                    Statement stm_jenis = conn_jenis.createStatement();
                    ResultSet res_jenis = stm_jenis.executeQuery(query_jenis);
                    if(res_jenis.next()) {
                       jns = res_jenis.getString("id_jenis"); 
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                String satuan = (String)cbx_satuan.getSelectedItem();
                String stn = null;
                try {
                    String query_jenis = "select * from satuan where nama_satuan='"+satuan+"'";
                    Connection conn_satuan = (Connection)connect.configDB();
                    Statement stm_satuan = conn_satuan.createStatement();
                    ResultSet res_satuan = stm_satuan.executeQuery(query_jenis);
                    if(res_satuan.next()) {
                        stn = res_satuan.getString("id_satuan");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                int harga_beli1 = Integer.parseInt(harga_beli.replace(",", ""));;
                int harga_jual1 = Integer.parseInt(harga_jual.replace(",",""));
                try {
                    String query = "insert into barang values ('"+id+"','"+nama+"','"+stok1+"','"+harga_beli1+"','"+harga_jual1+"','0','"+stn+"','"+jns+"')";
                    Connection conn = (Connection)connect.configDB();
                    Statement stm = conn.createStatement();
                    stm.execute(query);
                } catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, "Tolong di isi fieldnya dengan lengkap");
                }
                table();
                clear();
                kode_otomatis();
            }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(rootPane,"Tolong di isi field nya");
            }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_harga_beliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_harga_beliKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_harga_beliKeyTyped

    private void txt_stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stokKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_stokKeyTyped

    private void txt_harga_jualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_harga_jualKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_harga_jualKeyTyped

    private void txt_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyTyped

    }//GEN-LAST:event_txt_idKeyTyped

    private void txt_namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namaKeyTyped
        char enter = evt.getKeyChar();
        if((Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_namaKeyTyped

    private void table_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_viewMouseClicked
        int baris = table_view.getSelectedRow();
        
        txt_id.setText(table_view.getValueAt(baris, 0).toString());
        txt_nama.setText(table_view.getValueAt(baris, 1).toString());
        txt_stok.setText(table_view.getValueAt(baris, 2).toString());
        cbx_jenis.setSelectedItem(table_view.getValueAt(baris, 3).toString());
        cbx_satuan.setSelectedItem(table_view.getValueAt(baris, 4).toString());
        txt_harga_beli.setText(table_view.getValueAt(baris, 5).toString());
        txt_harga_jual.setText(table_view.getValueAt(baris, 6).toString());
    }//GEN-LAST:event_table_viewMouseClicked

    private void txt_harga_jualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_harga_jualKeyPressed

    }//GEN-LAST:event_txt_harga_jualKeyPressed

    private void txt_harga_beliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_harga_beliKeyReleased
        String S_angka_normal = txt_harga_beli.getText().replaceAll("\\,", "");
        double D_angka_Normal = Double.parseDouble(S_angka_normal);
        DecimalFormat DF = new DecimalFormat("#,###,###");        
        txt_harga_beli.setText(DF.format(D_angka_Normal));
    }//GEN-LAST:event_txt_harga_beliKeyReleased

    private void txt_harga_jualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_harga_jualKeyReleased
        String S_angka_normal = txt_harga_jual.getText().replaceAll("\\,", "");
        double D_angka_Normal = Double.parseDouble(S_angka_normal);
        DecimalFormat DF = new DecimalFormat("#,###,###");        
        txt_harga_jual.setText(DF.format(D_angka_Normal));
    }//GEN-LAST:event_txt_harga_jualKeyReleased

    private void txt_stokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stokKeyReleased
        String S_angka_normal = txt_stok.getText().replaceAll("\\,", "");
        double D_angka_Normal = Double.parseDouble(S_angka_normal);
        DecimalFormat DF = new DecimalFormat("#,###,###");        
        txt_stok.setText(DF.format(D_angka_Normal));
    }//GEN-LAST:event_txt_stokKeyReleased

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
            java.util.logging.Logger.getLogger(FrameTambahBarang1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTambahBarang1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTambahBarang1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTambahBarang1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTambahBarang1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx_jenis;
    private javax.swing.JComboBox<String> cbx_satuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_view;
    private javax.swing.JTextField txt_harga_beli;
    private javax.swing.JTextField txt_harga_jual;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_stok;
    // End of variables declaration//GEN-END:variables
}
