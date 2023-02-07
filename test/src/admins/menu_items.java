package admins;
public class menu_items extends javax.swing.JPanel {
    PanelBarang barang;
    PanelKaryawan karyawan;
    public menu_items() {
        initComponents();
        barang = new PanelBarang();
        karyawan = new PanelKaryawan();
        
        layouting2.add(barang);
        layouting2.add(karyawan);
        
        karyawan.setVisible(false);
        barang.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_karyawan = new javax.swing.JLabel();
        btn_barang = new javax.swing.JLabel();
        layouting2 = new javax.swing.JPanel();
        bckground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_karyawan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_karyawan.setForeground(new java.awt.Color(0, 0, 0));
        btn_karyawan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_karyawan.setText("Karyawan");
        btn_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_karyawanMouseClicked(evt);
            }
        });
        add(btn_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 0, 110, 40));

        btn_barang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_barang.setForeground(new java.awt.Color(0, 0, 0));
        btn_barang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_barang.setText("Barang");
        btn_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_barangMouseClicked(evt);
            }
        });
        add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 0, 90, 40));

        layouting2.setBackground(new java.awt.Color(251, 243, 216));
        add(layouting2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1080, 730));

        bckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/menu_itm.jpg"))); // NOI18N
        add(bckground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_barangMouseClicked
        barang.setVisible(true);
        barang.table_barang();
        karyawan.setVisible(false);
    }//GEN-LAST:event_btn_barangMouseClicked

    private void btn_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_karyawanMouseClicked
        barang.setVisible(false);
        karyawan.setVisible(true);
    }//GEN-LAST:event_btn_karyawanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bckground;
    private javax.swing.JLabel btn_barang;
    private javax.swing.JLabel btn_karyawan;
    private javax.swing.JPanel layouting2;
    // End of variables declaration//GEN-END:variables
}
