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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "connectionreference",
    "attribute"
})
@XmlRootElement(name = "SESSIONEXTENSION")
public class SESSIONEXTENSION {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "SUBTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subtype;
    @XmlAttribute(name = "SINSTANCENAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sinstancename;
    @XmlAttribute(name = "TRANSFORMATIONTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String transformationtype;
    @XmlAttribute(name = "DSQINSTNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dsqinstname;
    @XmlAttribute(name = "DSQINSTTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dsqinsttype;
    @XmlAttribute(name = "COMPONENTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String componentversion;
    @XmlElement(name = "CONNECTIONREFERENCE")
    protected List<CONNECTIONREFERENCE> connectionreference;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;

    public SESSIONEXTENSION() {
		super();
	}

    public SESSIONEXTENSION(String name, String type, String subtype, String sinstancename, String transformationtype,
			String dsqinstname, String dsqinsttype, String componentversion,
			List<CONNECTIONREFERENCE> connectionreference, List<ATTRIBUTE> attribute) {
		super();
		this.name = name;
		this.type = type;
		this.subtype = subtype;
		this.sinstancename = sinstancename;
		this.transformationtype = transformationtype;
		this.dsqinstname = dsqinstname;
		this.dsqinsttype = dsqinsttype;
		this.componentversion = componentversion;
		this.connectionreference = connectionreference;
		this.attribute = attribute;
	}

    public SESSIONEXTENSION(SESSIONEXTENSION sessionextension) {
		super();
		this.name = sessionextension.name;
		this.type = sessionextension.type;
		this.subtype = sessionextension.subtype;
		this.sinstancename = sessionextension.sinstancename;
		this.transformationtype = sessionextension.transformationtype;
		this.dsqinstname = sessionextension.dsqinstname;
		this.dsqinsttype = sessionextension.dsqinsttype;
		this.componentversion = sessionextension.componentversion;
		this.connectionreference = sessionextension.connectionreference;
		this.attribute = sessionextension.attribute;
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
     * Obtiene el valor de la propiedad subtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBTYPE() {
        return subtype;
    }

    /**
     * Define el valor de la propiedad subtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBTYPE(String value) {
        this.subtype = value;
    }

    /**
     * Obtiene el valor de la propiedad sinstancename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSINSTANCENAME() {
        return sinstancename;
    }

    /**
     * Define el valor de la propiedad sinstancename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSINSTANCENAME(String value) {
        this.sinstancename = value;
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
     * Obtiene el valor de la propiedad dsqinstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSQINSTNAME() {
        return dsqinstname;
    }

    /**
     * Define el valor de la propiedad dsqinstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSQINSTNAME(String value) {
        this.dsqinstname = value;
    }

    /**
     * Obtiene el valor de la propiedad dsqinsttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSQINSTTYPE() {
        return dsqinsttype;
    }

    /**
     * Define el valor de la propiedad dsqinsttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSQINSTTYPE(String value) {
        this.dsqinsttype = value;
    }

    /**
     * Obtiene el valor de la propiedad componentversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPONENTVERSION() {
        return componentversion;
    }

    /**
     * Define el valor de la propiedad componentversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPONENTVERSION(String value) {
        this.componentversion = value;
    }

    /**
     * Gets the value of the connectionreference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectionreference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONNECTIONREFERENCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CONNECTIONREFERENCE }
     * 
     * 
     */
    public List<CONNECTIONREFERENCE> getCONNECTIONREFERENCE() {
        if (connectionreference == null) {
            connectionreference = new ArrayList<CONNECTIONREFERENCE>();
        }
        return this.connectionreference;
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

}
