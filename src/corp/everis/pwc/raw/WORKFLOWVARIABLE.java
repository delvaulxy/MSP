//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "WORKFLOWVARIABLE")
public class WORKFLOWVARIABLE {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "USERDEFINED", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String userdefined;
    @XmlAttribute(name = "DATATYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "DEFAULTVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String defaultvalue;
    @XmlAttribute(name = "ISPERSISTENT")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ispersistent;
    @XmlAttribute(name = "ISNULL")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isnull;

    public WORKFLOWVARIABLE(WORKFLOWVARIABLE workflowvariable) {
		super();
		this.name = workflowvariable.name;
		this.description = workflowvariable.description;
		this.userdefined = workflowvariable.userdefined;
		this.datatype = workflowvariable.datatype;
		this.defaultvalue = workflowvariable.defaultvalue;
		this.ispersistent = workflowvariable.ispersistent;
		this.isnull = workflowvariable.isnull;
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
     * Obtiene el valor de la propiedad userdefined.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERDEFINED() {
        return userdefined;
    }

    /**
     * Define el valor de la propiedad userdefined.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERDEFINED(String value) {
        this.userdefined = value;
    }

    /**
     * Obtiene el valor de la propiedad datatype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATATYPE() {
        return datatype;
    }

    /**
     * Define el valor de la propiedad datatype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATATYPE(String value) {
        this.datatype = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultvalue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEFAULTVALUE() {
        return defaultvalue;
    }

    /**
     * Define el valor de la propiedad defaultvalue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEFAULTVALUE(String value) {
        this.defaultvalue = value;
    }

    /**
     * Obtiene el valor de la propiedad ispersistent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISPERSISTENT() {
        return ispersistent;
    }

    /**
     * Define el valor de la propiedad ispersistent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISPERSISTENT(String value) {
        this.ispersistent = value;
    }



	/**
     * Obtiene el valor de la propiedad isnull.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISNULL() {
        return isnull;
    }

    /**
     * Define el valor de la propiedad isnull.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISNULL(String value) {
        this.isnull = value;
    }
    public WORKFLOWVARIABLE(String name, String description, String userdefined, String datatype, String defaultvalue,
			String ispersistent, String isnull) {
		super();
		this.name = name;
		this.description = description;
		this.userdefined = userdefined;
		this.datatype = datatype;
		this.defaultvalue = defaultvalue;
		this.ispersistent = ispersistent;
		this.isnull = isnull;
	}
    public WORKFLOWVARIABLE(){
			
	}
}
