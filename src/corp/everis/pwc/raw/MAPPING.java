//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    "transformation",
    "instance",
    "connector",
    "mapdependency",
    "targetloadorder",
    "mappingvariable",
    "erpinfo",
    "metadataextension"
})
@XmlRootElement(name = "MAPPING")
public class MAPPING {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "OBJECTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String objectversion;
    @XmlAttribute(name = "ISVALID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String isvalid;
    @XmlAttribute(name = "ISPROFILEMAPPING")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isprofilemapping;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlAttribute(name = "CRCVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String crcvalue;
    @XmlElement(name = "TRANSFORMATION")
    protected List<TRANSFORMATION> transformation;
    @XmlElement(name = "INSTANCE")
    protected List<INSTANCE> instance;
    @XmlElement(name = "CONNECTOR")
    protected List<CONNECTOR> connector;
    @XmlElement(name = "MAPDEPENDENCY")
    protected List<MAPDEPENDENCY> mapdependency;
    @XmlElement(name = "TARGETLOADORDER")
    protected List<TARGETLOADORDER> targetloadorder;
    @XmlElement(name = "MAPPINGVARIABLE")
    protected List<MAPPINGVARIABLE> mappingvariable;
    @XmlElement(name = "ERPINFO")
    protected List<ERPINFO> erpinfo;
    @XmlElement(name = "METADATAEXTENSION")
    protected List<METADATAEXTENSION> metadataextension;
    
    

    public MAPPING() {
		super();
	}
    public MAPPING(String name, String description, String objectversion, String isvalid, String versionnumber){
    	super();
		this.name = name;
		this.description = description;
		this.objectversion = objectversion;
		this.isvalid = isvalid;
		this.versionnumber = versionnumber;
	}
    public MAPPING(String name, String description, String objectversion, String isvalid, String isprofilemapping,
			String versionnumber, String crcvalue, List<TRANSFORMATION> transformation, List<INSTANCE> instance,
			List<CONNECTOR> connector, List<MAPDEPENDENCY> mapdependency, List<TARGETLOADORDER> targetloadorder,
			List<MAPPINGVARIABLE> mappingvariable, List<ERPINFO> erpinfo, List<METADATAEXTENSION> metadataextension) {
		super();
		this.name = name;
		this.description = description;
		this.objectversion = objectversion;
		this.isvalid = isvalid;
		this.isprofilemapping = isprofilemapping;
		this.versionnumber = versionnumber;
		this.crcvalue = crcvalue;
		this.transformation = transformation;
		this.instance = instance;
		this.connector = connector;
		this.mapdependency = mapdependency;
		this.targetloadorder = targetloadorder;
		this.mappingvariable = mappingvariable;
		this.erpinfo = erpinfo;
		this.metadataextension = metadataextension;
	}
    public MAPPING(MAPPING mapping) {
		super();
		this.name = mapping.name;
		this.description = mapping.description;
		this.objectversion = mapping.objectversion;
		this.isvalid = mapping.isvalid;
		this.isprofilemapping = mapping.isprofilemapping;
		this.versionnumber = mapping.versionnumber;
		this.crcvalue = mapping.crcvalue;
		this.transformation = mapping.transformation;
		this.instance = mapping.instance;
		this.connector = mapping.connector;
		this.mapdependency = mapping.mapdependency;
		this.targetloadorder = mapping.targetloadorder;
		this.mappingvariable = mapping.mappingvariable;
		this.erpinfo = mapping.erpinfo;
		this.metadataextension = mapping.metadataextension;
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
     * Obtiene el valor de la propiedad objectversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTVERSION() {
        return objectversion;
    }

    /**
     * Define el valor de la propiedad objectversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTVERSION(String value) {
        this.objectversion = value;
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
     * Obtiene el valor de la propiedad isprofilemapping.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISPROFILEMAPPING() {
        return isprofilemapping;
    }

    /**
     * Define el valor de la propiedad isprofilemapping.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISPROFILEMAPPING(String value) {
        this.isprofilemapping = value;
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
     * Obtiene el valor de la propiedad crcvalue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRCVALUE() {
        return crcvalue;
    }

    /**
     * Define el valor de la propiedad crcvalue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRCVALUE(String value) {
        this.crcvalue = value;
    }

    /**
     * Gets the value of the transformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANSFORMATION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANSFORMATION }
     * 
     * 
     */
    public List<TRANSFORMATION> getTRANSFORMATION() {
        if (transformation == null) {
            transformation = new ArrayList<TRANSFORMATION>();
        }
        return this.transformation;
    }

    /**
     * Gets the value of the instance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getINSTANCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link INSTANCE }
     * 
     * 
     */
    public List<INSTANCE> getINSTANCE() {
        if (instance == null) {
            instance = new ArrayList<INSTANCE>();
        }
        return this.instance;
    }

    /**
     * Gets the value of the connector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONNECTOR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CONNECTOR }
     * 
     * 
     */
    public List<CONNECTOR> getCONNECTOR() {
        if (connector == null) {
            connector = new ArrayList<CONNECTOR>();
        }
        return this.connector;
    }

    /**
     * Gets the value of the mapdependency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapdependency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMAPDEPENDENCY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MAPDEPENDENCY }
     * 
     * 
     */
    public List<MAPDEPENDENCY> getMAPDEPENDENCY() {
        if (mapdependency == null) {
            mapdependency = new ArrayList<MAPDEPENDENCY>();
        }
        return this.mapdependency;
    }

    /**
     * Gets the value of the targetloadorder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetloadorder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTARGETLOADORDER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TARGETLOADORDER }
     * 
     * 
     */
    public List<TARGETLOADORDER> getTARGETLOADORDER() {
        if (targetloadorder == null) {
            targetloadorder = new ArrayList<TARGETLOADORDER>();
        }
        return this.targetloadorder;
    }

    /**
     * Gets the value of the mappingvariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mappingvariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMAPPINGVARIABLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MAPPINGVARIABLE }
     * 
     * 
     */
    public List<MAPPINGVARIABLE> getMAPPINGVARIABLE() {
        if (mappingvariable == null) {
            mappingvariable = new ArrayList<MAPPINGVARIABLE>();
        }
        return this.mappingvariable;
    }

    /**
     * Gets the value of the erpinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erpinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getERPINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ERPINFO }
     * 
     * 
     */
    public List<ERPINFO> getERPINFO() {
        if (erpinfo == null) {
            erpinfo = new ArrayList<ERPINFO>();
        }
        return this.erpinfo;
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
    @Override
    public boolean equals(Object v) {
    	boolean retVal = false;

    	if (v instanceof MAPPING){
    		MAPPING ptr = (MAPPING) v;
    		retVal = true;
    		
    		if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.getNAME())){
    			retVal = false;
    		}
    		if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.getDESCRIPTION())){
    			retVal = false;
    		}
    		/*if(null!=ptr.getCONNECTOR() && !ptr.getCONNECTOR().equals(this.getCONNECTOR())){
    			retVal = false;
    		}*/
    		if(null!=ptr.getTRANSFORMATION() && !ptr.getTRANSFORMATION().equals(this.getTRANSFORMATION())){
    			retVal = false;
    		}

    	}
    	return retVal;
    }
    @Override
    public int hashCode() {
    	return Objects.hash(name, description,transformation);//, connector,transformation);
    }
}
