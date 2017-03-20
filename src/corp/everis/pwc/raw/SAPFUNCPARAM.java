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
@XmlRootElement(name = "SAPFUNCPARAM")
public class SAPFUNCPARAM {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "ISREFERENCE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isreference;
    @XmlAttribute(name = "SUBTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String subtype;
    @XmlAttribute(name = "DEF")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String def;
    @XmlAttribute(name = "DATATYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "PRECISION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "SCALE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scale;
    @XmlAttribute(name = "ISOPTIONAL")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isoptional;
    @XmlAttribute(name = "DEFAULTVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String defaultvalue;
    @XmlAttribute(name = "ORDER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String order;

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
     * Obtiene el valor de la propiedad isreference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISREFERENCE() {
        return isreference;
    }

    /**
     * Define el valor de la propiedad isreference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISREFERENCE(String value) {
        this.isreference = value;
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
     * Obtiene el valor de la propiedad def.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEF() {
        return def;
    }

    /**
     * Define el valor de la propiedad def.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEF(String value) {
        this.def = value;
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
     * Obtiene el valor de la propiedad isoptional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOPTIONAL() {
        return isoptional;
    }

    /**
     * Define el valor de la propiedad isoptional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOPTIONAL(String value) {
        this.isoptional = value;
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
     * Obtiene el valor de la propiedad order.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDER() {
        return order;
    }

    /**
     * Define el valor de la propiedad order.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDER(String value) {
        this.order = value;
    }

}
