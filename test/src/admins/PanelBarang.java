package admins;
import connect.connect;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class PanelBarang extends javax.swing.JPanel {
    public PanelBarang() {
        initComponents();
        table_barang();
        viewBarang();
        list_jenis();
        table_barang.setDefaultEditor(Object.class, null);   
    }
    public void table_hapus(String key) {
        if (key == null) {
            JOptionPane.showMessageDialog(null,"Tolong klik salah satu data pada tabel");
        } else {
            try {
                String query = "update barang set is_deleted='1' where id_barang='"+key+"'";
                Connection conn = (Connection)connect.configDB();
                PreparedStatement stm = conn.prepareStatement(query);
                stm.execute();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Barang tidak di temukan / sudah terhapus, mohon di segarkan");
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    public void viewBarang() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No");
        tbl.addColumn("Nama Material");
        tbl.addColumn("Stok");
        tbl.addColumn("Jenis");
        tbl.addColumn("Satuan");
        tbl.addColumn("Harga Beli");
        tbl.addColumn("Harga Jual");
        table_barang.setModel(tbl);
    }
    public void table_barang() {
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
            ResultSet res = stm.executeQuery("select * from barang inner join jenis on barang.id_jenis = jenis.id_jenis inner join satuan on barang.id_satuan = satuan.id_satuan "
                    + "where barang.id_jenis = jenis.id_jenis and barang.id_satuan = satuan.id_satuan having barang.is_deleted='0'");
            while(res.next()) {
                int angka = Integer.parseInt(res.getString("harga_beli"));
                String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
                StringTokenizer token = new StringTokenizer(ganti, ".");
                ganti = token.nextToken();
                ganti = ganti.replace(',','.');
                
                int angka1 = Integer.parseInt(res.getString("harga_jual"));
                String ganti1 = NumberFormat.getNumberInstance(Locale.US).format(angka1);
                StringTokenizer token1 = new StringTokenizer(ganti1, ".");
                ganti1 = token1.nextToken();
                ganti1 = ganti1.replace(',','.');
                tbl.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("stok"),
                    res.getString("jenis.nama_jenis"),
                    res.getString("satuan.nama_satuan"),
                    "Rp. " + res.getString("harga_beli").format(ganti),
                    "Rp. " + res.getString("harga_jual").format(ganti1),
                });
                table_barang.setModel(tbl);
                tbl.fireTableDataChanged();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal : " + e.getMessage());
        }
    }
    public void cariData(String cari) {
        try {
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("No");
            tbl.addColumn("Nama Material");
            tbl.addColumn("Stok");
            tbl.addColumn("Jenis");
            tbl.addColumn("Satuan");
            tbl.addColumn("Harga Beli");
            tbl.addColumn("Harga Jual");
        
            String query = "select * from barang inner join jenis on barang.id_jenis = jenis.id_jenis inner join satuan on barang.id_satuan = satuan.id_satuan "
                    + "where barang.id_jenis = jenis.id_jenis and barang.id_satuan = satuan.id_satuan having id_barang like '%"+cari+"%' or nama_barang like '%"+cari+"%' or stok like '%"+cari+"%' or harga_beli like '%"+cari+"%' or harga_jual like '%"+cari+"%' or "
                    + "satuan.nama_satuan like '%"+cari+"%' or jenis.nama_jenis like '%"+cari+"%' and barang.is_deleted='0' order by id_barang";
            Connection conn = (Connection)connect.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("stok"),
                    res.getString("jenis.nama_jenis"),
                    res.getString("satuan.nama_satuan"),
                    res.getString("harga_beli"),
                    res.getString("harga_jual"),
                });
                table_barang.setModel(tbl);
                tbl.fireTableDataChanged();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void table_jenis(String nama_jenis) {
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
            ResultSet res = stm.executeQuery("select * from barang inner join jenis on barang.id_jenis = jenis.id_jenis inner join satuan on barang.id_satuan = satuan.id_satuan "
                    + "where barang.is_deleted='0' and jenis.nama_jenis='"+nama_jenis+"'");
            while(res.next()) {
                if(!res.getString("jenis.nama_jenis").equals(nama_jenis)) {
                    viewBarang();
                } else if(res.getString("jenis.nama_jenis").equals(nama_jenis)) {
                    tbl.addRow(new Object[]{
                        res.getString("id_barang"),
                        res.getString("nama_barang"),
                        res.getString("stok"),
                        res.getString("jenis.nama_jenis"),
                        res.getString("satuan.nama_satuan"),
                        res.getString("harga_beli"),
                        res.getString("harga_jual"),
                    });
                    table_barang.setModel(tbl);
                }
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal : " + e.getMessage());
        }
    }
    public void list_jenis() {
        try {
            String query = "select * from jenis";
            Connection conn = (Connection)connect.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(query);
            
            while(res.next()) {
                view_jenis.addItem(res.getString("nama_jenis"));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hapus_barang = new javax.swing.JLabel();
        ubah_barang = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        tambah_barang1 = new javax.swing.JLabel();
        tambah_jenis = new javax.swing.JLabel();
        hapus_jenis1 = new javax.swing.JLabel();
        view_jenis = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_barang = new javax.swing.JTable();
        bckground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hapus_barang.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        hapus_barang.setForeground(new java.awt.Color(0, 0, 0));
        hapus_barang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hapus_barang.setText("Barang");
        hapus_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus_barangMouseClicked(evt);
            }
        });
        add(hapus_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 100, 30));

        ubah_barang.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        ubah_barang.setForeground(new java.awt.Color(0, 0, 0));
        ubah_barang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ubah_barang.setText("Barang");
        ubah_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubah_barangMouseClicked(evt);
            }
        });
        add(ubah_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 100, 30));

        txt_cari.setBackground(new java.awt.Color(255, 255, 255));
        txt_cari.setForeground(new java.awt.Color(0, 0, 0));
        txt_cari.setBorder(null);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 220, 20));

        tambah_barang1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tambah_barang1.setForeground(new java.awt.Color(0, 0, 0));
        tambah_barang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambah_barang1.setText("   Barang");
        tambah_barang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah_barang1MouseClicked(evt);
            }
        });
        add(tambah_barang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 100, 30));

        tambah_jenis.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tambah_jenis.setForeground(new java.awt.Color(0, 0, 0));
        tambah_jenis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambah_jenis.setText("Jenis");
        tambah_jenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah_jenisMouseClicked(evt);
            }
        });
        add(tambah_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, 30));

        hapus_jenis1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        hapus_jenis1.setForeground(new java.awt.Color(0, 0, 0));
        hapus_jenis1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hapus_jenis1.setText("    Satuan");
        hapus_jenis1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus_jenis1MouseClicked(evt);
            }
        });
        add(hapus_jenis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 110, 30));

        view_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        view_jenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                view_jenisMouseReleased(evt);
            }
        });
        view_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_jenisActionPerformed(evt);
            }
        });
        add(view_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 240, 30));

        table_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_barang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 940, 300));

        bckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/panelBarang.jpg"))); // NOI18N
        add(bckground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 615));
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambah_barang1MouseClicked
        new FrameTambahBarang1().setVisible(true);
    }//GEN-LAST:event_tambah_barang1MouseClicked

    private void tambah_jenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambah_jenisMouseClicked
        new FrameTambahJenis1().setVisible(true);
    }//GEN-LAST:event_tambah_jenisMouseClicked

    private void ubah_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubah_barangMouseClicked
        new FrameUbahBarang1().setVisible(true);
    }//GEN-LAST:event_ubah_barangMouseClicked

    private void hapus_jenis1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapus_jenis1MouseClicked
        new FrameTambahSatuan1().setVisible(true);
    }//GEN-LAST:event_hapus_jenis1MouseClicked

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        String key = txt_cari.getText();
        System.out.println(key);
        if(key!="") {
            cariData(key);
        } else {
            table_barang();
        }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void hapus_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapus_barangMouseClicked
        try {
            int baris = table_barang.getSelectedRow();
            String id = (String) table_barang.getValueAt(baris, 0);
            table_hapus(id);
            table_barang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Tolong klik salah satu data pada tabel");
        }
    }//GEN-LAST:event_hapus_barangMouseClicked

    private void view_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_jenisActionPerformed
        String index = view_jenis.getSelectedItem().toString();
        table_jenis(index);
    }//GEN-LAST:event_view_jenisActionPerformed

    private void view_jenisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_jenisMouseReleased
        try {
            String index = view_jenis.getSelectedItem().toString();
            table_jenis(index);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(bckground, e.getMessage());
        }
    }//GEN-LAST:event_view_jenisMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bckground;
    private javax.swing.JLabel hapus_barang;
    private javax.swing.JLabel hapus_jenis1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_barang;
    private javax.swing.JLabel tambah_barang1;
    private javax.swing.JLabel tambah_jenis;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JLabel ubah_barang;
    private javax.swing.JComboBox<String> view_jenis;
    // End of variables declaration//GEN-END:variables
}
