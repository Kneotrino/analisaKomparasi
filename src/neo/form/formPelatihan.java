/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo.form;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
 import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import neo.table.Dataset;
import neo.utils.DatasetJpaController;
import neo.utils.SerializationUtil;
import neo.utils.consoleStream;

/**
 *
 * @author SEED
 */
public class formPelatihan extends javax.swing.JPanel {

    /**
     * Creates new form formPelatihan
     */
    private DatasetJpaController djp;
    public formPelatihan() {
        initComponents();
        djp = new DatasetJpaController(javax.persistence.Persistence.createEntityManagerFactory("analisiKomparasiPU"));
        printStream = new PrintStream(new consoleStream(jTextArea1));
        System.setOut(printStream);
        System.setErr(printStream);
    }
    
    public void refresh()
    {
        int datasetCount = djp.getDatasetCount();
        jFormattedTextField1.setValue(datasetCount);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jFileChooser1.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(0, 2));

        jButton1.setText("MULAI PELATHIAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jLabel1.setText("JUMLAH DATA");
        jPanel1.add(jLabel1);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jPanel1.add(jFormattedTextField1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("PRESENTASE DATA(MIN 0, MAX 100)");
        jPanel3.add(jLabel2);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField3.setMinimumSize(new java.awt.Dimension(50, 30));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSlider1, org.jdesktop.beansbinding.ELProperty.create("${value}"), jFormattedTextField3, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel3.add(jFormattedTextField3);

        jPanel1.add(jPanel3);
        jPanel1.add(jSlider1);

        jLabel3.setText("METODE");
        jPanel1.add(jLabel3);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KNN", "NB", "C4.5" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox1);

        jLabel4.setText("K");
        jPanel1.add(jLabel4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanel1.add(jComboBox2);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jProgressBar1.setValue(1);
        jPanel2.add(jProgressBar1, java.awt.BorderLayout.NORTH);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    PrintStream printStream;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        System.out.println("\nMULAI");
        //
        int value = jSlider1.getValue();
        double persen = value * .01d;
        int datasetCount = djp.getDatasetCount();
        String selectedItem = (String) jComboBox1.getSelectedItem();
        System.out.println("Metode = " + selectedItem);
        
        long selectedK = jComboBox2.getSelectedIndex();
        selectedK++;
        System.out.println("K = " + selectedK);
        
        System.out.println("Total data = " + datasetCount);
        System.out.println("Data Latih = " + persen);
        int selectedCount = (int) Math.round(persen * datasetCount);
        System.out.println("Data Latih Terpilih= " + selectedCount);

        List<Dataset> dataLatih = new LinkedList<>(pickNRandom(djp.findDatasetEntities(), selectedCount));
        
        String namafile = "Data latih."+selectedItem;
        File file = new File(namafile);
        jFileChooser1.setSelectedFile(file);
        int retrival = jFileChooser1.showSaveDialog(null);
        file = jFileChooser1.getSelectedFile();
        System.out.println(dataLatih.getClass());
        System.out.println("Save file = " + file);
        try {
            SerializationUtil.serialize(dataLatih, file.getPath());                
        } catch (IOException ex) {
            Logger.getLogger(formPelatihan.class.getName()).log(Level.SEVERE, null, ex);
        }        
        System.out.println("SELESAI\n");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    public List<Dataset> pickNRandom(List<Dataset> lst, int n) {
        List<Dataset> copy = new LinkedList<Dataset>(lst);
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (jComboBox1.getSelectedIndex() == 2) 
            jComboBox2.setEnabled(false);
        else
            jComboBox2.setEnabled(true);        

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int r = jFileChooser1.showOpenDialog(null);
        File selectedFile = jFileChooser1.getSelectedFile();
        try {
            List<Dataset> deserialize = (List<Dataset>) SerializationUtil.deserialize(selectedFile.getPath());
            int size = deserialize.size();
            System.out.println("size = " + size);
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(formOlahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formOlahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formOlahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formOlahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("PELATIHAN");
                frame.setContentPane(new formPelatihan());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(6);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
