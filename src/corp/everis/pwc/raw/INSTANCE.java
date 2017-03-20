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
    "tableattribute",
    "exprmacrodependency",
    "initprop",
    "associatedsourceinstance"
})
@XmlRootElement(name = "INSTANCE")
public class INSTANCE {
	
    public INSTANCE(String name, String description, String type, String reusable, String transformationtype,
			String transformationname,  String associateddsq, String associateddsqtype,
			String instanceid, List<TABLEATTRIBUTE> tableattribute, List<EXPRMACRODEPENDENCY> exprmacrodependency,
			List<INITPROP> initprop, List<ASSOCIATEDSOURCEINSTANCE> associatedsourceinstance) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.reusable = reusable;
		this.transformationtype = transformationtype;
		this.transformationname = transformationname;
		this.associateddsq = associateddsq;
		this.associateddsqtype = associateddsqtype;
		this.instanceid = instanceid;
		this.tableattribute = tableattribute;
		this.exprmacrodependency = exprmacrodependency;
		this.initprop = initprop;
		this.associatedsourceinstance = associatedsourceinstance;
	}
    public INSTANCE(INSTANCE instance) {
		super();
		this.name = instance.name;
		this.description = instance.description;
		this.type = instance.type;
		this.reusable = instance.reusable;
		this.transformationtype = instance.transformationtype;
		this.transformationname = instance.transformationname;
		this.associateddsq = instance.associateddsq;
		this.associateddsqtype = instance.associateddsqtype;
		this.instanceid = instance.instanceid;
		this.tableattribute = instance.tableattribute;
		this.exprmacrodependency = instance.exprmacrodependency;
		this.initprop = instance.initprop;
		this.associatedsourceinstance = instance.associatedsourceinstance;
	}
    public INSTANCE(String name, String type, String reusable, String transformationtype,String transformationname) {
		super();
		this.name = name;
		this.type = type;
		this.reusable = reusable;
		this.transformationtype = transformationtype;
		this.transformationname = transformationname;
	}
    public INSTANCE(String dbdname,String name, String type, String reusable, String transformationtype,String transformationname) {
		super();
		this.dbdname = dbdname;
		this.name = name;
		this.type = type;
		this.reusable = reusable;
		this.transformationtype = transformationtype;
		this.transformationname = transformationname;
	}
    public INSTANCE(){}
	@XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "TYPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "REUSABLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusable;
    @XmlAttribute(name = "TRANSFORMATION_TYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String transformationtype;
    @XmlAttribute(name = "TRANSFORMATION_NAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String transformationname;
    @XmlAttribute(name = "DBDNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dbdname;
    @XmlAttribute(name = "ASSOCIATED_DSQ")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String associateddsq;
    @XmlAttribute(name = "ASSOCIATED_DSQ_TYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String associateddsqtype;
    @XmlAttribute(name = "INSTANCEID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String instanceid;
    @XmlElement(name = "TABLEATTRIBUTE")
    protected List<TABLEATTRIBUTE> tableattribute;
    @XmlElement(name = "EXPRMACRODEPENDENCY")
    protected List<EXPRMACRODEPENDENCY> exprmacrodependency;
    @XmlElement(name = "INITPROP")
    protected List<INITPROP> initprop;
    @XmlElement(name = "ASSOCIATED_SOURCE_INSTANCE")
    protected List<ASSOCIATEDSOURCEINSTANCE> associatedsourceinstance;

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
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
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
     * Obtiene el valor de la propiedad transformationtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSFORMATIONTYPE() {
        return transformationtype;
    }

    /**
     * Define el valor de la propiedad transformationtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSFORMATIONTYPE(String value) {
        this.transformationtype = value;
    }

    /**
     * Obtiene el valor de la propiedad transformationname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSFORMATIONNAME() {
        return transformationname;
    }

    /**
     * Define el valor de la propiedad transformationname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSFORMATIONNAME(String value) {
        this.transformationname = value;
    }

    /**
     * Obtiene el valor de la propiedad dbdname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBDNAME() {
        return dbdname;
    }

    /**
     * Define el valor de la propiedad dbdname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBDNAME(String value) {
        this.dbdname = value;
    }

    /**
     * Obtiene el valor de la propiedad associateddsq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSOCIATEDDSQ() {
        return associateddsq;
    }

    /**
     * Define el valor de la propiedad associateddsq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSOCIATEDDSQ(String value) {
        this.associateddsq = value;
    }

    /**
     * Obtiene el valor de la propiedad associateddsqtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSOCIATEDDSQTYPE() {
        return associateddsqtype;
    }

    /**
     * Define el valor de la propiedad associateddsqtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSOCIATEDDSQTYPE(String value) {
        this.associateddsqtype = value;
    }

    /**
     * Obtiene el valor de la propiedad instanceid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTANCEID() {
        return instanceid;
    }

    /**
     * Define el valor de la propiedad instanceid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTANCEID(String value) {
        this.instanceid = value;
    }

    /**
     * Gets the value of the tableattribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableattribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTABLEATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TABLEATTRIBUTE }
     * 
     * 
     */
    public List<TABLEATTRIBUTE> getTABLEATTRIBUTE() {
        if (tableattribute == null) {
            tableattribute = new ArrayList<TABLEATTRIBUTE>();
        }
        return this.tableattribute;
    }

    /**
     * Gets the value of the exprmacrodependency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exprmacrodependency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEXPRMACRODEPENDENCY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EXPRMACRODEPENDENCY }
     * 
     * 
     */
    public List<EXPRMACRODEPENDENCY> getEXPRMACRODEPENDENCY() {
        if (exprmacrodependency == null) {
            exprmacrodependency = new ArrayList<EXPRMACRODEPENDENCY>();
        }
        return this.exprmacrodependency;
    }

    /**
     * Gets the value of the initprop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the initprop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getINITPROP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link INITPROP }
     * 
     * 
     */
    public List<INITPROP> getINITPROP() {
        if (initprop == null) {
            initprop = new ArrayList<INITPROP>();
        }
        return this.initprop;
    }

    /**
     * Gets the value of the associatedsourceinstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedsourceinstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getASSOCIATEDSOURCEINSTANCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ASSOCIATEDSOURCEINSTANCE }
     * 
     * 
     */
    public List<ASSOCIATEDSOURCEINSTANCE> getASSOCIATEDSOURCEINSTANCE() {
        if (associatedsourceinstance == null) {
            associatedsourceinstance = new ArrayList<ASSOCIATEDSOURCEINSTANCE>();
        }
        return this.associatedsourceinstance;
    }
    
    @Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof INSTANCE){
			INSTANCE ptr = (INSTANCE) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.getNAME())){
				retVal = false;
			}
			if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.getDESCRIPTION())){
				retVal = false;
			}
			if(null!=ptr.getTYPE() && !ptr.getTYPE().equals(this.getTYPE())){
				retVal = false;
			}
			if(null!=ptr.getTRANSFORMATIONNAME() && !ptr.getTRANSFORMATIONNAME().equals(this.getTRANSFORMATIONNAME())){
				retVal = false;
			}
			
		}
		return retVal;
    }
    @Override
	public int hashCode() {
		return Objects.hash(name, description, type, transformationname);
	}
}
