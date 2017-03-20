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
    "sesstransformationinst",
    "configreference",
    "sessioncomponent",
    "sessionextension",
    "attribute",
    "metadataextension",
    "resourcereference",
    "transformresourceref"
})
@XmlRootElement(name = "SESSION")
public class SESSION {

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
    @XmlAttribute(name = "MAPPINGNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mappingname;
    @XmlAttribute(name = "MAPPINGVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mappingversion;
    @XmlAttribute(name = "SORTORDER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sortorder;
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
    @XmlElement(name = "SESSTRANSFORMATIONINST")
    protected List<SESSTRANSFORMATIONINST> sesstransformationinst;
    @XmlElement(name = "CONFIGREFERENCE")
    protected CONFIGREFERENCE configreference;
    @XmlElement(name = "SESSIONCOMPONENT")
    protected List<SESSIONCOMPONENT> sessioncomponent;
    @XmlElement(name = "SESSIONEXTENSION")
    protected List<SESSIONEXTENSION> sessionextension;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;
    @XmlElement(name = "METADATAEXTENSION")
    protected List<METADATAEXTENSION> metadataextension;
    @XmlElement(name = "RESOURCEREFERENCE")
    protected List<RESOURCEREFERENCE> resourcereference;
    @XmlElement(name = "TRANSFORMRESOURCEREF")
    protected List<TRANSFORMRESOURCEREF> transformresourceref;

    public SESSION(){}
    
    public SESSION(String name, String description, String reusable, String isvalid, String mappingname,
			String sortorder, String versionnumber) {
		super();
		this.name = name;
		this.description = description;
		this.reusable = reusable;
		this.isvalid = isvalid;
		this.mappingname = mappingname;
		this.sortorder = sortorder;
		this.versionnumber = versionnumber;
	}

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
     * Obtiene el valor de la propiedad mappingname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAPPINGNAME() {
        return mappingname;
    }

    /**
     * Define el valor de la propiedad mappingname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAPPINGNAME(String value) {
        this.mappingname = value;
    }

    /**
     * Obtiene el valor de la propiedad mappingversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAPPINGVERSION() {
        return mappingversion;
    }

    /**
     * Define el valor de la propiedad mappingversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAPPINGVERSION(String value) {
        this.mappingversion = value;
    }

    /**
     * Obtiene el valor de la propiedad sortorder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSORTORDER() {
        return sortorder;
    }

    /**
     * Define el valor de la propiedad sortorder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSORTORDER(String value) {
        this.sortorder = value;
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
     * Gets the value of the sesstransformationinst property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sesstransformationinst property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSTRANSFORMATIONINST().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSTRANSFORMATIONINST }
     * 
     * 
     */
    public List<SESSTRANSFORMATIONINST> getSESSTRANSFORMATIONINST() {
        if (sesstransformationinst == null) {
            sesstransformationinst = new ArrayList<SESSTRANSFORMATIONINST>();
        }
        return this.sesstransformationinst;
    }

    /**
     * Obtiene el valor de la propiedad configreference.
     * 
     * @return
     *     possible object is
     *     {@link CONFIGREFERENCE }
     *     
     */
    public CONFIGREFERENCE getCONFIGREFERENCE() {
        return configreference;
    }

    /**
     * Define el valor de la propiedad configreference.
     * 
     * @param value
     *     allowed object is
     *     {@link CONFIGREFERENCE }
     *     
     */
    public void setCONFIGREFERENCE(CONFIGREFERENCE value) {
        this.configreference = value;
    }

    /**
     * Gets the value of the sessioncomponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sessioncomponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSIONCOMPONENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSIONCOMPONENT }
     * 
     * 
     */
    public List<SESSIONCOMPONENT> getSESSIONCOMPONENT() {
        if (sessioncomponent == null) {
            sessioncomponent = new ArrayList<SESSIONCOMPONENT>();
        }
        return this.sessioncomponent;
    }

    /**
     * Gets the value of the sessionextension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sessionextension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSIONEXTENSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSIONEXTENSION }
     * 
     * 
     */
    public List<SESSIONEXTENSION> getSESSIONEXTENSION() {
        if (sessionextension == null) {
            sessionextension = new ArrayList<SESSIONEXTENSION>();
        }
        return this.sessionextension;
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

    /**
     * Gets the value of the resourcereference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourcereference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRESOURCEREFERENCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RESOURCEREFERENCE }
     * 
     * 
     */
    public List<RESOURCEREFERENCE> getRESOURCEREFERENCE() {
        if (resourcereference == null) {
            resourcereference = new ArrayList<RESOURCEREFERENCE>();
        }
        return this.resourcereference;
    }

    /**
     * Gets the value of the transformresourceref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformresourceref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANSFORMRESOURCEREF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANSFORMRESOURCEREF }
     * 
     * 
     */
    public List<TRANSFORMRESOURCEREF> getTRANSFORMRESOURCEREF() {
        if (transformresourceref == null) {
            transformresourceref = new ArrayList<TRANSFORMRESOURCEREF>();
        }
        return this.transformresourceref;
    }

}
