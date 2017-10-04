/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo.form;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import java.awt.EventQueue;
import java.beans.Beans;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import neo.table.Dataset;

/**
 *
 * @author SEED
 */
public class formOlahData extends JPanel {
    
    public formOlahData() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
//        refreshButtonActionPerformed(null);
    }
    public void reset()
    {
        refreshButtonActionPerformed(null);
    }
    public List<Dataset> getDataAll()
    {
        Query q = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Dataset d ORDER BY d.id");
        List<Dataset> dataAll = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(q.getResultList());                 
        return dataAll;
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

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("analisiKomparasiPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Dataset d ORDER BY d.id").setMaxResults(100);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jFileChooser1 = new javax.swing.JFileChooser();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        refreshButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        newButton1 = new javax.swing.JButton();
        newButton2 = new javax.swing.JButton();
        newButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        newButton3 = new javax.swing.JButton();
        newButton4 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        jFileChooser1.setApproveButtonText("IMPORT");
        jFileChooser1.setDialogTitle("IMPORT DATASET TENAGA KERJA");

        setLayout(new java.awt.BorderLayout());

        masterTable.setDefaultEditor(String.class, new TablePopupEditor());
        masterTable.setDefaultEditor(Double.class, new TablePopupEditor());
        masterTable.setDefaultEditor(Integer.class, new TablePopupEditor());
        masterTable.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${satisfaction}"));
        columnBinding.setColumnName("Satisfaction");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${evaluation}"));
        columnBinding.setColumnName("Evaluation");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numberproject}"));
        columnBinding.setColumnName("Numberproject");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${avaragehours}"));
        columnBinding.setColumnName("Avaragehours");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${timespendcompany}"));
        columnBinding.setColumnName("Timespendcompany");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workaccident}"));
        columnBinding.setColumnName("Workaccident");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${promotion}"));
        columnBinding.setColumnName("Promotion");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${division}"));
        columnBinding.setColumnName("Division");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${salary}"));
        columnBinding.setColumnName("Salary");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lefts}"));
        columnBinding.setColumnName("Lefts");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        add(masterScrollPane, java.awt.BorderLayout.CENTER);

        newButton.setText("BARU");
        newButton.addActionListener(formListener);
        jPanel1.add(newButton);

        deleteButton.setText("HAPUS");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);
        jPanel1.add(deleteButton);

        deleteButton1.setText("HAPUS SEMUA");
        deleteButton1.addActionListener(formListener);
        jPanel1.add(deleteButton1);

        saveButton.setText("SIMPAN");
        saveButton.addActionListener(formListener);
        jPanel1.add(saveButton);

        refreshButton.setText("REFRESH");
        refreshButton.addActionListener(formListener);
        jPanel1.add(refreshButton);

        refreshButton1.setText("IMPORT CSV");
        refreshButton1.addActionListener(formListener);
        jPanel1.add(refreshButton1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        newButton1.setText("AWAL");
        newButton1.addActionListener(formListener);
        jPanel2.add(newButton1);

        newButton2.setText("SEBELUMNYA");
        newButton2.addActionListener(formListener);
        jPanel2.add(newButton2);

        newButton5.setText("GO TO");
        newButton5.addActionListener(formListener);
        jPanel2.add(newButton5);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox1);

        newButton3.setText("SELANJUTNYA");
        newButton3.addActionListener(formListener);
        jPanel2.add(newButton3);

        newButton4.setText("AKHIR");
        newButton4.addActionListener(formListener);
        jPanel2.add(newButton4);

        add(jPanel2, java.awt.BorderLayout.SOUTH);

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == newButton) {
                formOlahData.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                formOlahData.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton1) {
                formOlahData.this.deleteButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                formOlahData.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                formOlahData.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton1) {
                formOlahData.this.refreshButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton1) {
                formOlahData.this.newButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton2) {
                formOlahData.this.newButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton5) {
                formOlahData.this.newButton5ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton3) {
                formOlahData.this.newButton3ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton4) {
                formOlahData.this.newButton4ActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings({"unchecked", "empty-statement"})
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        Query createQuery = entityManager.createQuery("SELECT COUNT(d) FROM Dataset d");
        long get = (long) createQuery.getResultList().get(0);
        System.out.println("get = " + get);
        int max = (int) get;
        int clunkSize = max / 100;
        System.out.println("clunkSize = " + clunkSize);
        String[] arr = new String[clunkSize];
        for (int i = 0; i < clunkSize; i++) {
                    arr[i] = "Ke-"+(i+1);
                }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
        jComboBox1.setSelectedIndex(temp);

//        int size = list.size();

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<neo.table.Dataset> toRemove = new ArrayList<neo.table.Dataset>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            neo.table.Dataset d = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(d);
            entityManager.remove(d);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        neo.table.Dataset d = new neo.table.Dataset();
        entityManager.persist(d);
        list.add(d);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<neo.table.Dataset> merged = new ArrayList<neo.table.Dataset>(list.size());
            for (neo.table.Dataset d : list) {
                merged.add(entityManager.merge(d));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // DELETE ALL DATASET
        Query createQuery = entityManager.createQuery("DELETE FROM Dataset d");
        int executeUpdate = createQuery.executeUpdate();
        list.clear();
        System.out.println("executeUpdate = " + executeUpdate);
        javax.swing.JOptionPane.showMessageDialog(masterScrollPane, executeUpdate + " Data di hapus");
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void refreshButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButton1ActionPerformed
        try {
            int showOpenDialog = jFileChooser1.showOpenDialog(jPanel1);
            System.out.println("showOpenDialog = " + showOpenDialog);
            if (showOpenDialog == javax.swing.JFileChooser.APPROVE_OPTION) {
                File selectedFile = jFileChooser1.getSelectedFile();
                System.out.println("selectedFile = " + selectedFile);
                FileReader fileReader = new FileReader(selectedFile);
                com.opencsv.CSVReader reader = new CSVReader(fileReader);
                HeaderColumnNameMappingStrategy<Dataset> beanStrategy = new HeaderColumnNameMappingStrategy<>();
                beanStrategy.setType(Dataset.class);	
                CsvToBean<Dataset> csvToBean = new CsvToBean<>();
                List<Dataset> temps = csvToBean.parse(beanStrategy, reader);	
                temps.forEach((temp) -> {
                        entityManager.persist(temp);
                });
                list.addAll(temps);
                int size = temps.size();
                javax.swing.JOptionPane.showMessageDialog(masterScrollPane, size + " Data di import");
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(formOlahData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(formOlahData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButton1ActionPerformed

    private void newButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton1ActionPerformed
        temp = 0;
        query.setFirstResult(0);
        query.setMaxResults(100);                    
        refreshButtonActionPerformed(evt);        
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton1ActionPerformed
    int temp = 0;
    private void newButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton2ActionPerformed
        if (temp > 0) {
            temp--;            
            int x = temp * 100;            
            int y = (temp+1) * 100;
            query.setFirstResult(x);
            query.setMaxResults(100);            
        }
        else {
            query.setFirstResult(0);
            query.setMaxResults(100);                    
        }
        System.out.println("temp = " + temp);
        refreshButtonActionPerformed(evt);        
    }//GEN-LAST:event_newButton2ActionPerformed

    private void newButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton3ActionPerformed
        temp++;            
        int x = temp * 100;
        System.out.println("temp = " + temp);
        int y = temp * 100;
        query.setFirstResult(x);
        query.setMaxResults(100);
        refreshButtonActionPerformed(evt);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton3ActionPerformed

    private void newButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton4ActionPerformed
        Query createQuery = entityManager.createQuery("SELECT COUNT(d) FROM Dataset d");
        long get = (long) createQuery.getResultList().get(0);
        System.out.println("get = " + get);
        int max = (int) get;
        temp = max / 100;
        System.out.println("temp = " + temp);
        query.setFirstResult(max-100);
        query.setMaxResults(max);                    
        refreshButtonActionPerformed(evt);        
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton4ActionPerformed

    private void newButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton5ActionPerformed
        int selectedIndex = jComboBox1.getSelectedIndex();
        temp = selectedIndex;
        System.out.println("selectedIndex = " + selectedIndex);
        int x = temp * 100;
        System.out.println("temp = " + temp);
        int y = 100;
        if (temp > 0 ) {
            y = (temp+1) * 100;
        }
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        query.setFirstResult(x);
        query.setMaxResults(100);
        refreshButtonActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteButton1;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.util.List<neo.table.Dataset> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton newButton1;
    private javax.swing.JButton newButton2;
    private javax.swing.JButton newButton3;
    private javax.swing.JButton newButton4;
    private javax.swing.JButton newButton5;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refreshButton1;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
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
                JFrame frame = new JFrame();
                frame.setContentPane(new formOlahData());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
