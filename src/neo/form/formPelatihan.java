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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
 import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import neo.table.Dataset;
import neo.utils.C45;
import neo.utils.DatasetJpaController;
import neo.utils.SerializationUtil;
import neo.utils.consoleStream;
import neo.utils.methodUtil;
import org.apache.commons.io.FilenameUtils;

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
        refresh();
    }
    
    public void refresh()
    {
        System.setOut(printStream);
//        System.setErr(printStream);
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
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jSlider1 = new javax.swing.JSlider();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jFileChooser1.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5" }));
        jComboBox4.setEnabled(false);

        jLabel1.setText("JUMLAH PARTISI DATA");

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(0, 2));

        jButton1.setText("MULAI PELATIHAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("STATISTIK DATA LATIH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jLabel3.setText("METODE");
        jPanel1.add(jLabel3);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KNN", "NB", "C45" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox1);

        jLabel5.setText("METODE PENGUJIAN");
        jPanel1.add(jLabel5);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RANDOM USE TRAINNING", "SUPPLY TRAINNING", "CROSS VALIDATION" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox3);

        jLabel4.setText("NB K LAPLACIAN SMOOTH");
        jPanel1.add(jLabel4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboBox2.setEnabled(false);
        jPanel1.add(jComboBox2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("PRESENTASE DATA(MIN 0, MAX 100)");
        jPanel3.add(jLabel2);

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField3.setMinimumSize(new java.awt.Dimension(50, 30));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSlider1, org.jdesktop.beansbinding.ELProperty.create("${value}"), jFormattedTextField3, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel3.add(jFormattedTextField3);

        jPanel1.add(jPanel3);

        jSlider1.setMinimum(1);
        jSlider1.setValue(10);
        jPanel1.add(jSlider1);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setText("DARI");
        jPanel5.add(jLabel7);

        jFormattedTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField5.setText("0");
        jFormattedTextField5.setEnabled(false);
        jFormattedTextField5.setMinimumSize(new java.awt.Dimension(50, 30));
        jPanel5.add(jFormattedTextField5);

        jPanel1.add(jPanel5);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("SAMPAI");
        jPanel4.add(jLabel6);

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField4.setText("100");
        jFormattedTextField4.setEnabled(false);
        jFormattedTextField4.setMinimumSize(new java.awt.Dimension(50, 30));
        jPanel4.add(jFormattedTextField4);

        jPanel1.add(jPanel4);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

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
        String selectedItem = (String) jComboBox1.getSelectedItem();
        String selectedTrainning = (String) jComboBox3.getSelectedItem();
        System.out.println("Metode Kelasifikasi = " + selectedItem);
        System.out.println("Metode Trainning = " + selectedTrainning);
                              
        String namafile = selectedTrainning +"."+selectedItem;
        File file = new File(namafile);
        jFileChooser1.setSelectedFile(file);
        int retrival = jFileChooser1.showSaveDialog(null);
        if (retrival == JFileChooser.CANCEL_OPTION) {
            System.out.println("BATAL LATIH");
            return;
        }
        List<Dataset> dataLatih = null;
        List<Dataset> dataUji = null;
        Map<String, Object> MLOBJECT = new LinkedHashMap<>();
        //pilihan mode pelatihan
        if (jComboBox3.getSelectedIndex() == 0) {
            //USE TRAINNING
            int value = jSlider1.getValue();
            double persen = value * .01d;
            int datasetCount = djp.getDatasetCount();
            System.out.println("Total data = " + datasetCount);
            System.out.println("Data Latih = " + persen);
            int selectedCount = (int) Math.round(persen * datasetCount);
            System.out.println("Data Latih Terpilih= " + selectedCount);
            dataLatih = new LinkedList<>(pickNRandom(djp.findDatasetEntities(), selectedCount));
            MLOBJECT.put("TRAINNING", "USE TRAINNING");
            MLOBJECT.put("TRAINNINGKEY", 0);
        } else if (jComboBox3.getSelectedIndex() == 1) {
            //SUPPLY TRAINNING
            String fromText = jFormattedTextField5.getText();
            String toText = jFormattedTextField4.getText();
            int from = Integer.valueOf(fromText);
            int to = Integer.valueOf(toText);
            dataLatih = new LinkedList<>(djp.findDatasetEntities().subList(from, to));   
            MLOBJECT.put("TRAINNING", "SUPPLY TRAINNING");
            MLOBJECT.put("TRAINNINGKEY", 1);
        }
        else if (jComboBox3.getSelectedIndex() == 2) {
            //CROSS VALIDATION
            MLOBJECT.put("TRAINNING", "CROSS VALIDATION ");
            MLOBJECT.put("TRAINNINGKEY", 2);
            String fromText = jFormattedTextField5.getText();
            String toText = jFormattedTextField4.getText();
            int from = Integer.valueOf(fromText);
            int to = Integer.valueOf(toText);            
            dataUji = new LinkedList<>(djp.findDatasetEntities().subList(from, to));   
            System.out.println("dataUji = " + dataUji.size());
            dataLatih = djp.findDatasetEntities();
            dataLatih.removeAll(dataUji);
            System.out.println("dataLatih = " + dataLatih.size());
//            throw new NumberFormatException();
        }
        
        
        file = jFileChooser1.getSelectedFile();
        System.out.println("Save file = " + file);        
        if (JFileChooser.CANCEL_OPTION == retrival) {
            return ;
        }
            
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        Date start = new Date();
        System.out.println("start = " + start);
        System.out.println("beforeUsedMem = " + beforeUsedMem);
        MLOBJECT.put("METODE", selectedItem);
        if (jComboBox1.getSelectedIndex() == 0) {
            //KNN            
            System.out.println("KNN");
            MLOBJECT.put("DATA LATIH", dataLatih);
        }
        if (jComboBox1.getSelectedIndex() == 1) {
            int selectedK = jComboBox2.getSelectedIndex();
            selectedK++;
            System.out.println("NB");
            MLOBJECT.put("DATA LATIH", dataLatih);
            MLOBJECT.put("NB TRAIN", methodUtil.NBtraining(dataLatih, selectedK));
            MLOBJECT.put("K",selectedK);
            //NB            
        }
        if (jComboBox1.getSelectedIndex() == 2) {
            //C4.5
            System.out.println("C45");
            MLOBJECT.put("DATA LATIH", dataLatih);
            C45 C45train = null;
            try {
                C45train = methodUtil.C45train(dataLatih);
            } catch (Exception ex) {
                Logger.getLogger(formPelatihan.class.getName()).log(Level.SEVERE, null, ex);
            }
            MLOBJECT.put("TREE", C45train);                        
        }

        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        Date end = new Date();
        System.out.println("end = " + end);
        System.out.println("afterUsedMem = " + afterUsedMem);
        
        MLOBJECT.put("MEMORY USE", afterUsedMem - beforeUsedMem);
        MLOBJECT.put("TIME USE", end.getTime() - start.getTime());
        try {
            
                SerializationUtil.serialize(MLOBJECT, file.getPath());                

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
        if (jComboBox1.getSelectedIndex() == 1) 
            jComboBox2.setEnabled(true);
        else
            jComboBox2.setEnabled(false);        

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Train Files", "KNN", "NB", "C45"));
        int retrival = jFileChooser1.showOpenDialog(null);
        if (JFileChooser.CANCEL_OPTION == retrival) {
            return ;
        }
        File selectedFile = jFileChooser1.getSelectedFile();
        String extension = FilenameUtils.getExtension(selectedFile.getName());        
        System.out.println("selectedFile = " + selectedFile);        
        
        try {
           
           Map<String, Object> deserialize = (Map<String, Object>) SerializationUtil.deserialize(selectedFile.getPath());
           List<Dataset> DataLatih = (List<Dataset>) deserialize.get("DATA LATIH");
           EventQueue.invokeLater(() -> {
               JFrame frame = new JFrame("STATISTIK DATA LATIH "+ extension);
               frame.setContentPane(new formAnalisis(DataLatih));
               frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               frame.pack();
               frame.setExtendedState(6);
               frame.setVisible(true);
           });
            
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        if (jComboBox3.getSelectedIndex() == 1) 
            {
                jFormattedTextField4.setEnabled(true);
                jFormattedTextField5.setEnabled(true);
                jComboBox4.setEnabled(false);
                jSlider1.setEnabled(false);
            }
        else if (jComboBox3.getSelectedIndex() == 2) {
                jComboBox4.setEnabled(true);
                jFormattedTextField4.setEnabled(true);
                jFormattedTextField5.setEnabled(true);
                jSlider1.setEnabled(false);
        }
        else   if (jComboBox3.getSelectedIndex() == 0)    {
                jComboBox4.setEnabled(false);
                jSlider1.setEnabled(true);
                jFormattedTextField4.setEnabled(false);
                jFormattedTextField5.setEnabled(false);
            }

    }//GEN-LAST:event_jComboBox3ItemStateChanged

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
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
