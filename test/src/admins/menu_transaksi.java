package admins;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class menu_transaksi extends javax.swing.JPanel {
    private DefaultTableModel model;
    public menu_transaksi() {
        initComponents();
        model = new DefaultTableModel();
        jTable2.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        
        utama();
        txttotal.setText("0");
        txtBayar.setText("0");
        txtKembalian.setText("0");
        txtKaryawan.requestFocus();
    }
    public void TotalBiaya() {
        int jumlahBaris = jTable2.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, HargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(jTable2.getValueAt(i, 3).toString());
            HargaBarang = Integer.parseInt(jTable2.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * HargaBarang);
        }
        txttotal.setText(String.valueOf(totalBiaya));
        txtTampil.setText(""+totalBiaya+"");
    }
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        model.addRow(new Object[]{
            txtTransaksi.getText(),
            txtIdBarang.getText(),
            txtnamaBarang.getText(),
            txtJumlah.getText(),
            txtHarga.getText(),
            txttotal.getText(),
        });
    }
    public void kosong() {
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        while(model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    public void utama() {
        txtTransaksi.setText("");
        txtIdBarang.setText("");
        txtnamaBarang.setText("");
        txtJumlah.setText("");
        txtHarga.setText("");
    }
    public void clear2() {
        txtIdBarang.setText("0");
        txtHarga.setText("0");
        txtJumlah.setText("0");
        txtnamaBarang.setText("0");
    }
    public void clear() {
        txtKaryawan.setText("0");
        txtBayar.setText("0");
        txtKembalian.setText("0");
        txtTampil.setText("0");
    }
    public void TambahTransaksi() {
        int jumlah,harga,total;
        
        jumlah = Integer.valueOf(txtJumlah.getText());
        harga = Integer.valueOf(txtHarga.getText());
        total = jumlah * harga;
        
        txttotal.setText(String.valueOf(total));
        loadData();
        TotalBiaya();
        clear2();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTampil = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btn_cari1 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        btn_tambah1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        txtTransaksi = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnamaBarang = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        txtKaryawan = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bckground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdBarang.setActionCommand("<Not Set>");
        txtIdBarang.setBorder(null);
        txtIdBarang.setMinimumSize(new java.awt.Dimension(64, 20));
        add(txtIdBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Simpan  ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 610, 120, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Kembalian");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 690, 120, 30));

        txtTampil.setForeground(new java.awt.Color(0, 0, 0));
        txtTampil.setBorder(null);
        txtTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTampilActionPerformed(evt);
            }
        });
        add(txtTampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 250, 70));

        txtJumlah.setForeground(new java.awt.Color(0, 0, 0));
        txtJumlah.setBorder(null);
        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 180, 30));

        btn_cari1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cari1.setForeground(new java.awt.Color(0, 0, 0));
        btn_cari1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_cari1.setText("Cari");
        add(btn_cari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 120, 50));

        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(0, 0, 0));
        btn_hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 300, 120, 30));

        btn_tambah1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_tambah1.setForeground(new java.awt.Color(0, 0, 0));
        btn_tambah1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_tambah1.setText("     Tambah");
        btn_tambah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambah1MouseClicked(evt);
            }
        });
        add(btn_tambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 240, 120, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 910, 340));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nama Karyawan");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("No Transaksi");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("ID Karyawan");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        txtHarga.setBorder(null);
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 180, 30));

        txtKembalian.setBorder(null);
        txtKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKembalianActionPerformed(evt);
            }
        });
        add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 690, 180, 30));

        txtTransaksi.setActionCommand("null");
        txtTransaksi.setBorder(null);
        txtTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTransaksiActionPerformed(evt);
            }
        });
        add(txtTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 210, 40));

        txttotal.setBorder(null);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 590, 180, 30));

        txtBayar.setBorder(null);
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });
        add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 180, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Jumlah");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ID Barang");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Harga");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Total Bayar");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Bayar");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, 120, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Kembalian");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 690, 120, 30));

        txtnamaBarang.setActionCommand("null");
        txtnamaBarang.setBorder(null);
        txtnamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaBarangActionPerformed(evt);
            }
        });
        add(txtnamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 180, 180, 30));

        jTextField7.setActionCommand("null");
        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, 30));

        txtKaryawan.setActionCommand("null");
        txtKaryawan.setBorder(null);
        txtKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKaryawanActionPerformed(evt);
            }
        });
        add(txtKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 210, 30));

        jTextField9.setActionCommand("null");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 210, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total Harga");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nama Barang");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 120, 30));

        bckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Frame Transaksi revisi.jpg"))); // NOI18N
        add(bckground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 740));
    }// </editor-fold>//GEN-END:initComponents

    private void txtTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTampilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTampilActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKembalianActionPerformed

    private void txtTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTransaksiActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void txtnamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaBarangActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void txtKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKaryawanActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int row = jTable2.getSelectedRow();
        model.removeRow(row);
        TotalBiaya();
        txtBayar.setText("0");
        txtKembalian.setText("0");
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
//        int total,bayar,kembalian;
//        total = Integer.valueOf(txttotal.getText());
//        bayar = Integer.valueOf(txtBayar.getText());
//        if(total > bayar) {
//            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
//        } else {
//            kembalian = bayar - total;
//        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        int total,bayar,kembalian;
        total = Integer.valueOf(txttotal.getText());
        bayar = Integer.valueOf(txtBayar.getText());
        if(total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void btn_tambah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambah1MouseClicked
        TambahTransaksi();
    }//GEN-LAST:event_btn_tambah1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bckground;
    private javax.swing.JLabel btn_cari1;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_tambah1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKaryawan;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtTampil;
    private javax.swing.JTextField txtTransaksi;
    private javax.swing.JTextField txtnamaBarang;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
