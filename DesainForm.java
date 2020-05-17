import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
public class DesainForm extends javax.swing.JFrame {
    List record = new ArrayList();//untukmenampunggetAll()
    InterfaceMahasiswa mhsServis; //untukmembuatobjekdariclass implement mahasiswa
    int row;//untukmembantudalammenampilkandata di textfieldnimnamaalamat.
    String kFak, kThn;
    public DesainForm() {
        initComponents();
        mhsServis= new ImplementMahasiswa();
        //supayakalodata di table di klikmakadata akanmuncullangsungdi textfieldnimnamaalamat
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                row = jTable1.getSelectedRow();
                if (row != -1) {
                    isiText();
                }
            }
        });
    this.statusAwal();
    daftarKode();
    }
    
    void daftarKode() {
        Object[] fak= {"130", "145"};
        Object[] thn= {"2012", "2013", "2014", "2015", "2016", "2017", "2018"};
        for (int i= 0; i< fak.length; i++) {
            CbKodeFak.addItem(fak[i].toString());
        }
        kFak= CbKodeFak.getSelectedItem().toString();
        for (int i= 0; i< thn.length; i++) {
            CbThn.addItem(thn[i].toString());
        }
        kThn= CbThn.getSelectedItem().toString();
    }

    void loadData() {
        try {
            record = mhsServis.getAll();
            } 
        catch (SQLException ex) {
            Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void statusAwal() {
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if ("Simpan".equals(this. BtnSimpan.getText())) {
                Mahasiswa mhs= new Mahasiswa();
                mhs.setNim(kFak+ kThn+ txtNim.getText());
                mhs.setNama(txtNama.getText());
                mhs.setAlamat(txtAlamat.getText());
                mhsServis.insert(mhs);
                this.statusAwal();
                JOptionPane.showMessageDialog(this, "data tersimpan");
            } else {
                txtNim.setEditable(true);
                CbKodeFak.setVisible(true);
                CbThn.setVisible(true);
                BtnSimpan.setText("Simpan");
                kosongkanText();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void kosongkanText() {
        txtNim.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
    }

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Mahasiswa mhs= new Mahasiswa();
            mhs.setNim(txtNim.getText());
            mhs.setNama(txtNama.getText());
            mhs.setAlamat(txtAlamat.getText());
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasildiubah");
        } catch (SQLException ex) {
            Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String nim= txtNim.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasildihapus");
        } catch (SQLException ex) {
            Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void isiTabel() {
        Object data[][] = new Object[record.size()][3];
        int x = 0;
        for (Iterator it = record.iterator(); it.hasNext();) {
            Mahasiswa mhs= (Mahasiswa) it.next();
            data[x][0] = mhs.getNim();
            data[x][1] = mhs.getNama();
            data[x][2] = mhs.getAlamat();
            x++;
        }
        String judul[] = {"NIM", "NAMA", "ALAMAT"};
        jTable1.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(jTable1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CbKodeFak = new javax.swing.JComboBox<>();
        CbThn = new javax.swing.JComboBox<>();
        txtNim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        BtnSimpan = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ketnim = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setText("NIM");

        CbKodeFak.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        CbKodeFak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "130", "131" }));
        CbKodeFak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbKodeFakActionPerformed(evt);
            }
        });

        CbThn.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        CbThn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));
        CbThn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbThnActionPerformed(evt);
            }
        });

        txtNim.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setText("Nama");

        txtNama.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setText("Alamat");

        txtAlamat.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N

        BtnSimpan.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        BtnSimpan.setText("Simpan");

        BtnEdit.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        BtnEdit.setText("Edit");

        BtnHapus.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        BtnHapus.setText("Hapus");

        jTable2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIM", "NAMA", "ALAMAT"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(BtnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(BtnHapus))
                            .addComponent(txtAlamat)
                            .addComponent(txtNama)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CbKodeFak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CbThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ketnim)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CbKodeFak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ketnim))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnEdit)
                    .addComponent(BtnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CbKodeFakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbKodeFakActionPerformed
       kFak= CbKodeFak.getSelectedItem().toString();
    }//GEN-LAST:event_CbKodeFakActionPerformed

    private void CbThnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbThnActionPerformed
        kThn= CbThn.getSelectedItem().toString();
    }//GEN-LAST:event_CbThnActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed
    
    private void txtNimKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        txtNim.setToolTipText("4 Angka");
        if(txtNim.getText().length()>3){
            ketnim.setText("4 Angka");
            txtNim.setEditable(false);
        }
    }

    private void txtNimMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        txtNim.setEditable(true);
        ketnim.setText(null);
    }

    void isiText() {
        Mahasiswa mhs= (Mahasiswa) record.get(row);
        txtNim.setText(mhs.getNim());
        txtNim.setEditable(false);
        txtNama.setText(mhs.getNama());
        txtAlamat.setText(mhs.getAlamat());
        CbKodeFak.setVisible(false);
        CbThn.setVisible(false);
        BtnSimpan.setText("Aktif");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                   DesainForm form = new DesainForm();
                    form.setLocationRelativeTo(null);
                    form.setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JComboBox<String> CbKodeFak;
    private javax.swing.JComboBox<String> CbThn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel ketnim;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    // End of variables declaration//GEN-END:variables
}
