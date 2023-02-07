package admins;

import connect.connect;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class menu_laporan extends javax.swing.JPanel {
    public menu_laporan() {
        initComponents();
        table();
        table_stok();
        table_best_seller();
        table_transaksi.setDefaultEditor(Object.class, null);
        stok_barang.setDefaultEditor(Object.class, null);
        best_seller.setDefaultEditor(Object.class, null);
    }
    public void table_view() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No Transaksi");
        tbl.addColumn("Tanggal");
        tbl.addColumn("Total");
        tbl.addColumn("Nama Karyawan");
        table_transaksi.setModel(tbl);
    }
    public void table() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No Transaksi");
        tbl.addColumn("Tanggal");
        tbl.addColumn("Total");
        tbl.addColumn("Nama Karyawan");
        
        try{
            Statement stm = connect.configDB().createStatement();
            ResultSet res = stm.executeQuery("SELECT transaksi.id_transaksi,transaksi.tgl_transaksi,transaksi.total,persons.nama from transaksi inner join persons on transaksi.id_person = persons.id_person");
            
            while(res.next()){
                int angka = Integer.parseInt(res.getString("total"));
                String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
                StringTokenizer token = new StringTokenizer(ganti, ".");
                ganti = token.nextToken();
                ganti = ganti.replace(',','.');
                
                tbl.addRow(new Object []{
                    res.getString("id_transaksi"),
                    res.getString("tgl_transaksi"),
                    "Rp." + res.getString("total").format(ganti),
                    res.getString("nama"),
                    
                });
                table_transaksi.setModel(tbl);
            }
            ResultSet res_laba = stm.executeQuery("select sum(total) as jumlah from transaksi");
            while(res_laba.next()) {
                if(res_laba.getString("jumlah") == null) {
                    total_pendapatan.setText("0");
                    table_view();
                } else if(res_laba.getString("jumlah") != null){
                    int angka = Integer.parseInt(res_laba.getString("jumlah"));
                    String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
                    StringTokenizer token = new StringTokenizer(ganti, ".");
                    ganti = token.nextToken();
                    ganti = ganti.replace(',','.');
                    total_pendapatan.setText(res_laba.getString("jumlah").format(ganti));
                }

            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }  
    }
    public void table_stok() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No");
        tbl.addColumn("Nama Material");
        tbl.addColumn("Stok");
        tbl.addColumn("Satuan");
        try {
            Statement stm = connect.configDB().createStatement();
            ResultSet res = stm.executeQuery("select * from barang inner join satuan on barang.id_satuan = satuan.id_satuan where is_deleted='0' order by stok asc");
            while(res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("stok"),
                    res.getString("satuan.nama_satuan")
                });
                stok_barang.setModel(tbl);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void table_best_seller() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No");
        tbl.addColumn("Nama Material");
        tbl.addColumn("Barang Terjual");
        try {
            Statement stm = connect.configDB().createStatement();
            ResultSet res = stm.executeQuery("select barang.id_barang,barang.nama_barang,SUM(total_barang) as jml_barang from detail_transaksi INNER JOIN barang on detail_transaksi.id_barang = barang.id_barang GROUP BY barang.id_barang ORDER BY jml_barang DESC;");
            while (res.next()) {                
                tbl.addRow(new Object[]{
                    res.getString("barang.id_barang"),
                    res.getString("barang.nama_barang"),
                    res.getString("jml_barang"),
                });
                best_seller.setModel(tbl);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_cari = new javax.swing.JLabel();
        tgl_2 = new com.toedter.calendar.JDateChooser();
        tgl_1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        total_pendapatan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stok_barang = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        best_seller = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bckground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cari.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cari.setForeground(new java.awt.Color(0, 0, 0));
        btn_cari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_cari.setText("  Cari");
        btn_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cariMouseClicked(evt);
            }
        });
        add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 100, 40));

        tgl_2.setForeground(new java.awt.Color(0, 0, 0));
        tgl_2.setDateFormatString("yyyy-MM-dd");
        add(tgl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 220, 30));

        tgl_1.setBackground(new java.awt.Color(255, 255, 255));
        tgl_1.setForeground(new java.awt.Color(0, 0, 0));
        tgl_1.setDateFormatString("yyyy-MM-dd");
        add(tgl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 220, 30));

        table_transaksi.setForeground(new java.awt.Color(0, 0, 0));
        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_transaksi);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 590, 390));

        total_pendapatan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total_pendapatan.setForeground(new java.awt.Color(0, 0, 0));
        add(total_pendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 180, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Data Transaksi");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        stok_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(stok_barang);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 410, 180));

        best_seller.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(best_seller);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 410, 180));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("10.000.000");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 170, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Rp.");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Rp.");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Penjualan Terbaik");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Laba Kotor");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Laba Bersih");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Stok Barang");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

        bckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/menu_laporan_image.jpg"))); // NOI18N
        add(bckground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 1080, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cariMouseClicked
         String getDate = "yyyy-MM-dd";
         SimpleDateFormat fm = new SimpleDateFormat(getDate);
         String tanggal = String.valueOf(fm.format(tgl_1.getDate()));
         
         String getDate2 = "yyyy-MM-dd";
         SimpleDateFormat fm2 = new SimpleDateFormat(getDate2);
         String tanggal2 = String.valueOf(fm2.format(tgl_2.getDate()));
         
         DefaultTableModel tbl = new DefaultTableModel();
         tbl.addColumn("No Transaksi");
         tbl.addColumn("Tanggal");
         tbl.addColumn("Total");
         tbl.addColumn("Id karyawan");

         try{
            Statement stm = connect.configDB().createStatement();
            ResultSet res = stm.executeQuery("SELECT transaksi.id_transaksi,transaksi.tgl_transaksi,transaksi.total,persons.nama from transaksi inner join persons on transaksi.id_person = persons.id_person having tgl_transaksi between '"+tanggal+"' and '"+tanggal2+"'");

            while(res.next()){
                int angka = Integer.parseInt(res.getString("total"));
                String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
                StringTokenizer token = new StringTokenizer(ganti, ".");
                ganti = token.nextToken();
                ganti = ganti.replace(',','.');
                
                tbl.addRow(new Object []{
                    res.getString("id_transaksi"),
                    res.getString("tgl_transaksi"),
                    "Rp." + res.getString("total").format(ganti),
                    res.getString("nama"),
                    
                });
                table_transaksi.setModel(tbl);
            }
            ResultSet res_laba = stm.executeQuery("select sum(total) as jumlah from transaksi where tgl_transaksi between '"+tanggal+"' and '"+tanggal2+"'");
            while(res_laba.next()) {
                int angka = Integer.parseInt(res_laba.getString("jumlah"));
                String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
                StringTokenizer token = new StringTokenizer(ganti, ".");
                ganti = token.nextToken();
                ganti = ganti.replace(',','.');
                total_pendapatan.setText(res_laba.getString("jumlah").format(ganti));
            }
         } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
         }
    }//GEN-LAST:event_btn_cariMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bckground;
    private javax.swing.JTable best_seller;
    private javax.swing.JLabel btn_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable stok_barang;
    private javax.swing.JTable table_transaksi;
    private com.toedter.calendar.JDateChooser tgl_1;
    private com.toedter.calendar.JDateChooser tgl_2;
    private javax.swing.JLabel total_pendapatan;
    // End of variables declaration//GEN-END:variables
}
