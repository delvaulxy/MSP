//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "task",
    "session",
    "worklet",
    "taskinstance",
    "workflowlink",
    "workflowvariable",
    "workflowevent",
    "attribute",
    "metadataextension"
})
@XmlRootElement(name = "WORKLET")
public class WORKLET {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "REUSABLE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusable;
    @XmlAttribute(name = "ISVALID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isvalid;
    @XmlAttribute(name = "PARENT")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parent;
    @XmlAttribute(name = "PARENT_TYPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String parenttype;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlElement(name = "TASK")
    protected List<TASK> task;
    @XmlElement(name = "SESSION")
    protected List<SESSION> session;
    @XmlElement(name = "WORKLET")
    protected List<WORKLET> worklet;
    @XmlElement(name = "TASKINSTANCE")
    protected List<TASKINSTANCE> taskinstance;
    @XmlElement(name = "WORKFLOWLINK")
    protected List<WORKFLOWLINK> workflowlink;
    @XmlElement(name = "WORKFLOWVARIABLE")
    protected List<WORKFLOWVARIABLE> workflowvariable;
    @XmlElement(name = "WORKFLOWEVENT")
    protected List<WORKFLOWEVENT> workflowevent;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;
    @XmlElement(name = "METADATAEXTENSION")
    protected List<METADATAEXTENSION> metadataextension;

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad reusable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREUSABLE() {
        return reusable;
    }

    /**
     * Define el valor de la propiedad reusable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREUSABLE(String value) {
        this.reusable = value;
    }

    /**
     * Obtiene el valor de la propiedad isvalid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISVALID() {
        return isvalid;
    }

    /**
     * Define el valor de la propiedad isvalid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISVALID(String value) {
        this.isvalid = value;
    }

    /**
     * Obtiene el valor de la propiedad parent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENT() {
        return parent;
    }

    /**
     * Define el valor de la propiedad parent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENT(String value) {
        this.parent = value;
    }

    /**
     * Obtiene el valor de la propiedad parenttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENTTYPE() {
        return parenttype;
    }

    /**
     * Define el valor de la propiedad parenttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENTTYPE(String value) {
        this.parenttype = value;
    }

    /**
     * Obtiene el valor de la propiedad versionnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERSIONNUMBER() {
        return versionnumber;
    }

    /**
     * Define el valor de la propiedad versionnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERSIONNUMBER(String value) {
        this.versionnumber = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the task property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTASK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TASK }
     * 
     * 
     */
    public List<TASK> getTASK() {
        if (task == null) {
            task = new ArrayList<TASK>();
        }
        return this.task;
    }

    /**
     * Gets the value of the session property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the session property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSION }
     * 
     * 
     */
    public List<SESSION> getSESSION() {
        if (session == null) {
            session = new ArrayList<SESSION>();
        }
        return this.session;
    }

    /**
     * Gets the value of the worklet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the worklet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKLET().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKLET }
     * 
     * 
     */
    public List<WORKLET> getWORKLET() {
        if (worklet == null) {
            worklet = new ArrayList<WORKLET>();
        }
        return this.worklet;
    }

    /**
     * Gets the value of the taskinstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskinstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTASKINSTANCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TASKINSTANCE }
     * 
     * 
     */
    public List<TASKINSTANCE> getTASKINSTANCE() {
        if (taskinstance == null) {
            taskinstance = new ArrayList<TASKINSTANCE>();
        }
        return this.taskinstance;
    }

    /**
     * Gets the value of the workflowlink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowlink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOWLINK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOWLINK }
     * 
     * 
     */
    public List<WORKFLOWLINK> getWORKFLOWLINK() {
        if (workflowlink == null) {
            workflowlink = new ArrayList<WORKFLOWLINK>();
        }
        return this.workflowlink;
    }

    /**
     * Gets the value of the workflowvariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowvariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOWVARIABLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOWVARIABLE }
     * 
     * 
     */
    public List<WORKFLOWVARIABLE> getWORKFLOWVARIABLE() {
        if (workflowvariable == null) {
            workflowvariable = new ArrayList<WORKFLOWVARIABLE>();
        }
        return this.workflowvariable;
    }

    /**
     * Gets the value of the workflowevent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowevent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOWEVENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOWEVENT }
     * 
     * 
     */
    public List<WORKFLOWEVENT> getWORKFLOWEVENT() {
        if (workflowevent == null) {
            workflowevent = new ArrayList<WORKFLOWEVENT>();
        }
        return this.workflowevent;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ATTRIBUTE }
     * 
     * 
     */
    public List<ATTRIBUTE> getATTRIBUTE() {
        if (attribute == null) {
            attribute = new ArrayList<ATTRIBUTE>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the metadataextension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadataextension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMETADATAEXTENSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link METADATAEXTENSION }
     * 
     * 
     */
    public List<METADATAEXTENSION> getMETADATAEXTENSION() {
        if (metadataextension == null) {
            metadataextension = new ArrayList<METADATAEXTENSION>();
        }
        return this.metadataextension;
    }

}
