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
@XmlRootElement(name = "MAPPINGVARIABLE")
public class MAPPINGVARIABLE {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "DATATYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "PRECISION", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "SCALE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scale;
    @XmlAttribute(name = "DEFAULTVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String defaultvalue;
    @XmlAttribute(name = "AGGFUNCTION")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String aggfunction;
    @XmlAttribute(name = "USERDEFINED")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String userdefined;
    @XmlAttribute(name = "ISPARAM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isparam;
    @XmlAttribute(name = "ISEXPRESSIONVARIABLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isexpressionvariable;

    public MAPPINGVARIABLE() {
		super();
	}

    public MAPPINGVARIABLE(String name, String description, String datatype, String precision, String scale,
			String defaultvalue, String aggfunction, String userdefined, String isparam, String isexpressionvariable) {
		super();
		this.name = name;
		this.description = description;
		this.datatype = datatype;
		this.precision = precision;
		this.scale = scale;
		this.defaultvalue = defaultvalue;
		this.aggfunction = aggfunction;
		this.userdefined = userdefined;
		this.isparam = isparam;
		this.isexpressionvariable = isexpressionvariable;
	}

    public MAPPINGVARIABLE(MAPPINGVARIABLE mappingvariable) {
		super();
		this.name = mappingvariable.name;
		this.description = mappingvariable.description;
		this.datatype = mappingvariable.datatype;
		this.precision = mappingvariable.precision;
		this.scale = mappingvariable.scale;
		this.defaultvalue = mappingvariable.defaultvalue;
		this.aggfunction = mappingvariable.aggfunction;
		this.userdefined = mappingvariable.userdefined;
		this.isparam = mappingvariable.isparam;
		this.isexpressionvariable = mappingvariable.isexpressionvariable;
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
     * Obtiene el valor de la propiedad precision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRECISION() {
        return precision;
    }

    /**
     * Define el valor de la propiedad precision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRECISION(String value) {
        this.precision = value;
    }

    /**
     * Obtiene el valor de la propiedad scale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCALE() {
        return scale;
    }

    /**
     * Define el valor de la propiedad scale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCALE(String value) {
        this.scale = value;
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
     * Obtiene el valor de la propiedad aggfunction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGGFUNCTION() {
        return aggfunction;
    }

    /**
     * Define el valor de la propiedad aggfunction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGGFUNCTION(String value) {
        this.aggfunction = value;
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
     * Obtiene el valor de la propiedad isparam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISPARAM() {
        return isparam;
    }

    /**
     * Define el valor de la propiedad isparam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISPARAM(String value) {
        this.isparam = value;
    }

    /**
     * Obtiene el valor de la propiedad isexpressionvariable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISEXPRESSIONVARIABLE() {
        return isexpressionvariable;
    }

    /**
     * Define el valor de la propiedad isexpressionvariable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISEXPRESSIONVARIABLE(String value) {
        this.isexpressionvariable = value;
    }

}
