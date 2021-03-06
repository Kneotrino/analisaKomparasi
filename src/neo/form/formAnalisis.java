/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo.form;

import java.awt.EventQueue;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JTable;
import neo.table.Dataset;
import neo.table.deskriptif;

/**
 *
 * @author SEED
 */
public class formAnalisis extends javax.swing.JPanel {

    /**
     * Creates new form formAnalisis
     */
    public formAnalisis() {
        initComponents();
//        List<Double> testData = IntStream.range(1, 100)
//                    .mapToDouble(d -> d)
//                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//            deskriptif stat = new deskriptif();
//             stat.setNameDesc("foo");
//             list1.add(stat);
//             testData.forEach((v) -> stat.addValue(v));           
    }    

    public JTable getjTable1() {
        return jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }
    
    
    public void tableFormat(List<Dataset> data)
    {
//        initComponents();
//        initTable(data);
        Class<?> myType = Double.TYPE;
        for (Field field : Dataset.class.getDeclaredFields()) {
            Class<?> type = field.getType();
            if ( (type.equals(Double.class)) || (type.equals(Integer.class))) {
                deskriptif stat = new deskriptif();
                try {
                        List<Double> beanList = getBeanList(field.getName(), data);
                        beanList.forEach(stat::addValue);
                        Map<Double, Long> collect = beanList
                                .stream()
                                .collect( Collectors.groupingBy( d -> d, Collectors.counting()));
                        Double key = collect.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
                        stat.setModeValue(key);
                } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(formAnalisis.class.getName()).log(Level.SEVERE, null, ex);
                }
                stat.setNameDesc(field.getName());
                list1.add(stat);
            }
            
            if (type.equals(String.class)) {                
                deskriptif stat = new deskriptif();
                Set<String> collect = data
                        .stream()
                        .collect(Collectors.mapping((Dataset a) -> (String) a.getMeta(field.getName()), Collectors.toSet())
                        );                
                System.out.println("collect = " + collect);
                Map<String,Double> mapping = new LinkedHashMap<>();
                Double x = 0d;
                 for (String string : collect) {
                     x++;
                     mapping.put(string, x);             
                 }
                 List<Double> beanList = new LinkedList<>();
                 for (Dataset dataset : data) {
                    beanList.add( mapping.getOrDefault(dataset.getMeta(field.getName()), x) );
                }
                 beanList.forEach(stat::addValue);
                
                
                stat.setNameDesc(field.getName());
                list1.add(stat);
            }
       }            
    }
    public formAnalisis(List<Dataset> data) {
        initComponents();
        initTable(data);
        tableFormat(data);
    }    
    
     private List<Double> getBeanList(String bean,List<Dataset> data) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
     {
          List<Double> value = new LinkedList<>();
          List<String> nope = new LinkedList<>();

         for (Dataset dataset : data) {
             Field field = Dataset.class.getDeclaredField(bean);
             field.setAccessible(true);
             if (field.get(dataset) instanceof Double) {
                 value.add((Double) field.get(dataset));                 
             }
             if (field.get(dataset) instanceof Integer) {
                 value.add((Integer) field.get(dataset) * 1d);                 
             }
         }         
         return value;
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

        list1 = org.jdesktop.observablecollections.ObservableCollections.observableList(new LinkedList<neo.table.deskriptif>());
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout(2, 0));

        jTable2.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list1, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nameDesc}"));
        columnBinding.setColumnName("Name Desc");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${n}"));
        columnBinding.setColumnName("N");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${min}"));
        columnBinding.setColumnName("Min");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quartal1}"));
        columnBinding.setColumnName("Quartal1");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quartal2}"));
        columnBinding.setColumnName("Quartal2");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quartal3}"));
        columnBinding.setColumnName("Quartal3");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${max}"));
        columnBinding.setColumnName("Max");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${mean}"));
        columnBinding.setColumnName("Mean");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${modeValue}"));
        columnBinding.setColumnName("Mode");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sum}"));
        columnBinding.setColumnName("Sum");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${standardDeviation}"));
        columnBinding.setColumnName("Standard Deviation");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2);

        jTable1.setAutoCreateRowSorter(true);
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

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

                EntityManager entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("analisiKomparasiPU").createEntityManager();
                Query query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Dataset d ORDER BY d.id");
                List<Dataset> list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());         

                frame.setContentPane(new formAnalisis(list));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.util.List<neo.table.deskriptif> list1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void Reset()
    {
        this.list1.clear();
    }
    public  void initTable(List<Dataset> data) {
        List<Map<String,Long>> listMap = new LinkedList<>();
        Map<String,Long> mapper = new TreeMap<>();
        mapper.put("0.Data", (long) data.size());
        mapper.put("0.Attribut", 9l);
        mapper.put("0.Kelas", 2l);
        mapper.put("0.Binary", 2l);
        mapper.put("0.Double", 2l);
        mapper.put("0.Enum", 3l);
        mapper.put("0.Numeric", 2l);
        listMap.add(mapper);
        
        NavigableSet<Double> groups = new TreeSet<>();
        BigDecimal temp = BigDecimal.ZERO;        
         for (int i = 0; i < 10; i++) {
             temp = temp.add(BigDecimal.valueOf(.1d));
             groups.add(temp.doubleValue());
         }
        NavigableSet<Integer> rangeInt = new TreeSet<>();
         for (int i = 0; i < 500; i+=10) {
             rangeInt.add(i);
         }
            List<Function> ListFun = new LinkedList<>();
            Function<Dataset, String> funcTemp;
            funcTemp = (Dataset a) -> "1.Satisfaction:"+groups.ceiling(a.getSatisfaction());
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "2.Evaluation:"+groups.ceiling(a.getSatisfaction());
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "3.Number Project:"+a.getNumberproject();
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "4.Avarage Montly Hours:"+ rangeInt.floor(a.getAvaragehours());
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "5.Time Spend Company:"+a.getTimespendcompany();
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "6.Work Accident:"+a.getWorkaccident();
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "7.Promotion:"+a.getPromotion();
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "8.Division:"+a.getDivision();
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "9.Salary:"+a.getSalary();
            ListFun.add(funcTemp);
            funcTemp = (Dataset a) -> "10.Left:"+a.getLefts();
            ListFun.add(funcTemp);
            int m = 0;
            for (Function function : ListFun) {
                    m++;
                     Map<String, Long> fun = data.stream()
                            .collect(Collectors.groupingBy(
                                    function, Collectors.counting()
                            ));
                     Map<String , Long> map = new TreeMap<>();
                     map.putAll(fun);
                     listMap.add(map);
                     mapper.put("0. Variasi Data Column:"+m, map.size()*1l);
         }
            
        //Populate table
        List<String> listString = new LinkedList<>();
        int max = -1;
        m = -1;
        for (Map<String, Long> map : listMap) {
                m++;
                listString.add("Key:"+m);
                listString.add("Value:"+m);            
                if (max < map.size()) {
                    max = map.size();
            }
        }
//        System.out.println("max = " + max);
        String[] title = listString.stream().toArray(String[]::new);
//        Object tableValue  = new Object[10][10];
        Object[][] dataTable = new Object[max+1][title.length];
        int j = 0;
        for (Map<String, Long> map : listMap) {
                int i = 0;                
                for(Map.Entry<String, Long> entry : map.entrySet()) {
                  dataTable[i][j] = entry.getKey();
                  dataTable[i][j+1] = entry.getValue();
                  i++;
                }
                j+=2;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            dataTable,
            title
        ));        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
