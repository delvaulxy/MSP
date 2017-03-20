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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "MACROARGUMENT")
public class MACROARGUMENT {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DATATYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "PRECISION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "SCALE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scale;
    @XmlAttribute(name = "ARGORDER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String argorder;

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
     * Obtiene el valor de la propiedad argorder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getARGORDER() {
        return argorder;
    }

    /**
     * Define el valor de la propiedad argorder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setARGORDER(String value) {
        this.argorder = value;
    }

}
