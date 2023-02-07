package admins;

import javax.swing.JOptionPane;

public class PanelKaryawan extends javax.swing.JPanel {

    public PanelKaryawan() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tambah_karyawan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        bckground = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1080, 615));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Segarkan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, 140, 30));

        tambah_karyawan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tambah_karyawan.setForeground(new java.awt.Color(0, 0, 0));
        tambah_karyawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambah_karyawan.setText("     Tambah ");
        tambah_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah_karyawanMouseClicked(evt);
            }
        });
        add(tambah_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 46, 120, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("      Ubah Data");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("      Hapus Data");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cari");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 120, 40));

        txt_cari.setForeground(new java.awt.Color(0, 0, 0));
        txt_cari.setBorder(null);
        add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 220, 20));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 270, 1020, 330));

        bckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/panelKaryawan.jpg"))); // NOI18N
        add(bckground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 615));
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambah_karyawanMouseClicked
        new FrameTambahKaryawan1().setVisible(true);
    }//GEN-LAST:event_tambah_karyawanMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new FrameUbahKaryawan1().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bckground;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tambah_karyawan;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
