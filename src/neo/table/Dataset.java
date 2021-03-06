/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo.table;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SEED
 */
@Entity
@Table(name = "DATASET", catalog = "", schema = "HUMAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataset.findAll", query = "SELECT d FROM Dataset d")
    , @NamedQuery(name = "Dataset.findById", query = "SELECT d FROM Dataset d WHERE d.id = :id")
    , @NamedQuery(name = "Dataset.findBySatisfaction", query = "SELECT d FROM Dataset d WHERE d.satisfaction = :satisfaction")
    , @NamedQuery(name = "Dataset.findByEvaluation", query = "SELECT d FROM Dataset d WHERE d.evaluation = :evaluation")
    , @NamedQuery(name = "Dataset.findByNumberproject", query = "SELECT d FROM Dataset d WHERE d.numberproject = :numberproject")
    , @NamedQuery(name = "Dataset.findByAvaragehours", query = "SELECT d FROM Dataset d WHERE d.avaragehours = :avaragehours")
    , @NamedQuery(name = "Dataset.findByTimespendcompany", query = "SELECT d FROM Dataset d WHERE d.timespendcompany = :timespendcompany")
    , @NamedQuery(name = "Dataset.findByWorkaccident", query = "SELECT d FROM Dataset d WHERE d.workaccident = :workaccident")
    , @NamedQuery(name = "Dataset.findByPromotion", query = "SELECT d FROM Dataset d WHERE d.promotion = :promotion")
    , @NamedQuery(name = "Dataset.findByDivision", query = "SELECT d FROM Dataset d WHERE d.division = :division")
    , @NamedQuery(name = "Dataset.findBySalary", query = "SELECT d FROM Dataset d WHERE d.salary = :salary")
    , @NamedQuery(name = "Dataset.findByLefts", query = "SELECT d FROM Dataset d WHERE d.lefts = :lefts")
    , @NamedQuery(name = "Dataset.findByOthers", query = "SELECT d FROM Dataset d WHERE d.others = :others")
    , @NamedQuery(name = "Dataset.findByTime", query = "SELECT d FROM Dataset d WHERE d.time = :time")})
public class Dataset implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SATISFACTION", precision = 52)
    private Double satisfaction;
    @Column(name = "EVALUATION", precision = 52)
    private Double evaluation;
    @Column(name = "NUMBERPROJECT")
    private Integer numberproject;
    @Column(name = "AVARAGEHOURS")
    private Integer avaragehours;
    @Column(name = "TIMESPENDCOMPANY")
    private Integer timespendcompany;
    @Column(name = "WORKACCIDENT")
    private Integer workaccident;
    @Column(name = "PROMOTION")
    private Integer promotion;
    @Column(name = "DIVISION", length = 64)
    private String division;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "LEFTS")
    private Integer lefts;
    @Column(name = "OTHERS", length = 255)
    private String others;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    
    
    public Object getMetaClass(String key,Object key2)
    {
        Object meta = getMeta(key);        
        return key+";"+key2.toString()+";"+lefts;
    }
    public Object getMeta(String key)
    {
        Map<String,Object> datasetMeta = new LinkedHashMap<>();
        datasetMeta.put("workAccident;", workaccident);
        datasetMeta.put("workAccident", workaccident);
        datasetMeta.put("promotion;", promotion);        
        datasetMeta.put("promotion", promotion);        
        datasetMeta.put("Division;", division);        
        datasetMeta.put("division", division);        
        datasetMeta.put("Salary;", salary.toString());        
        datasetMeta.put("SalaryString", salary.toString());        
        datasetMeta.put("salary", salary);        
        
        datasetMeta.put("numberproject;", numberproject * 1d);        
        datasetMeta.put("numberproject", numberproject * 1d);        
        datasetMeta.put("timespendcompany;", timespendcompany * 1d);        
        datasetMeta.put("timespendcompany", timespendcompany * 1d);        
        datasetMeta.put("avaragehours;", avaragehours * 1d);        
        datasetMeta.put("avaragehours", avaragehours * 1d);        

        datasetMeta.put("satisfaction;", satisfaction);        
        datasetMeta.put("satisfaction", satisfaction);        
        datasetMeta.put("evaluation;", evaluation);  
        datasetMeta.put("evaluation", evaluation);  

//        DecimalFormat df = new DecimalFormat("#.0"); 
//        datasetMeta.put("evaluation", df.format(evaluation));  
        
        datasetMeta.put("lefts", lefts);        
        datasetMeta.put("leftsString", lefts==0?"left":"stay");        
        return datasetMeta.get(key);    
    }
    
    
    public Map<String,Double> getMetaDouble()
    {
        Map<String,Double> datasetMeta = new LinkedHashMap<>();
//        datasetMeta.put("workAccident;", workaccident);
//        datasetMeta.put("promotion;", promotion);        
//        datasetMeta.put("Division;", division);        
//        datasetMeta.put("Salary;", salary.toString());        
        
        datasetMeta.put("numberproject;", numberproject * 1d);        
        datasetMeta.put("timespendcompany;", timespendcompany * 1d);        
        datasetMeta.put("avaragehours;", avaragehours * 1d);        

//        datasetMeta.put("satisfaction;", satisfaction);        
//        datasetMeta.put("evaluation;", evaluation);        
        return datasetMeta;    
    }
    public Dataset() {
        time = new Date();        
    }

    @Transient
    private double distance = 9d;
//    public static final String PROP_DISTANCE = "distance";

    /**
     * Get the value of distance
     *
     * @return the value of distance
     */
    public double getDistance() {
        return distance;
    }
    public String getRelevancy()
    {
        if  ( ( getLeftsDouble() == 0d) && (getKelas() == 0d) ) {
            return "TP";
        }
        if  ( ( getLeftsDouble() == 0d) && (getKelas() == 1d) ) {
            return "FN";
        }
        if  ( ( getLeftsDouble() == 1d) && (getKelas() == 0d) ) {
            return "FP";
        }
        if  ( ( getLeftsDouble()== 1d) && (getKelas()== 1d) ) {
            return "TN";
        }
        return "null";
    }
    /**
     * Set the value of distance
     *
     * @param distance new value of distance
     */
    public void setDistance(double distance) {
        double oldDistance = this.distance;
        this.distance = distance;
        changeSupport.firePropertyChange("distance", oldDistance, distance);
    }
 
    @Transient    
    private double kelas = -1;

//    public static final String PROP_KELAS = "kelas";

    /**
     * Get the value of kelas
     *
     * @return the value of kelas
     */
    public double getKelas() {
        return kelas;
    }

    /**
     * Set the value of kelas
     *
     * @param kelas new value of kelas
     */
    public void setKelas(double kelas) {
        double oldKelas = this.kelas;
        this.kelas = kelas;
        changeSupport.firePropertyChange("kelas", oldKelas, kelas);
    }


    public Dataset(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Double satisfaction) {
        Double oldSatisfaction = this.satisfaction;
        this.satisfaction = satisfaction;
        changeSupport.firePropertyChange("satisfaction", oldSatisfaction, satisfaction);
    }

    public Double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Double evaluation) {
        Double oldEvaluation = this.evaluation;
        this.evaluation = evaluation;
        changeSupport.firePropertyChange("evaluation", oldEvaluation, evaluation);
    }

    public Integer getNumberproject() {
        return numberproject;
    }

    public void setNumberproject(Integer numberproject) {
        Integer oldNumberproject = this.numberproject;
        this.numberproject = numberproject;
        changeSupport.firePropertyChange("numberproject", oldNumberproject, numberproject);
    }

    public Integer getAvaragehours() {
        return avaragehours;
    }

    public void setAvaragehours(Integer avaragehours) {
        Integer oldAvaragehours = this.avaragehours;
        this.avaragehours = avaragehours;
        changeSupport.firePropertyChange("avaragehours", oldAvaragehours, avaragehours);
    }

    public Integer getTimespendcompany() {
        return timespendcompany;
    }

    public void setTimespendcompany(Integer timespendcompany) {
        Integer oldTimespendcompany = this.timespendcompany;
        this.timespendcompany = timespendcompany;
        changeSupport.firePropertyChange("timespendcompany", oldTimespendcompany, timespendcompany);
    }

    public Integer getWorkaccident() {
        return workaccident;
    }


    public void setWorkaccident(Integer workaccident) {
        Integer oldWorkaccident = this.workaccident;
        this.workaccident = workaccident;
        changeSupport.firePropertyChange("workaccident", oldWorkaccident, workaccident);
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        Integer oldPromotion = this.promotion;
        this.promotion = promotion;
        changeSupport.firePropertyChange("promotion", oldPromotion, promotion);
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        String oldDivision = this.division;
        this.division = division;
        changeSupport.firePropertyChange("division", oldDivision, division);
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        Integer oldSalary = this.salary;
        this.salary = salary;
        changeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    public Integer getLefts() {
        return lefts;
    }
    
    public Double getLeftsDouble()
    {
        return lefts * 1d;
    }

    public void setLefts(Integer lefts) {
        Integer oldLefts = this.lefts;
        this.lefts = lefts;
        changeSupport.firePropertyChange("lefts", oldLefts, lefts);
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        String oldOthers = this.others;
        this.others = others;
        changeSupport.firePropertyChange("others", oldOthers, others);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        Date oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dataset)) {
            return false;
        }
        Dataset other = (Dataset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[No=" + id+ " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
