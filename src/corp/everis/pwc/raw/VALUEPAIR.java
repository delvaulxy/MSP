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
@XmlRootElement(name = "VALUEPAIR")
public class VALUEPAIR {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "COMMENTS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String comments;
    @XmlAttribute(name = "VALUE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "EXECORDER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String execorder;
    @XmlAttribute(name = "REVERSEASSIGNMENT")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reverseassignment;

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
     * Obtiene el valor de la propiedad comments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMENTS() {
        return comments;
    }

    /**
     * Define el valor de la propiedad comments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMENTS(String value) {
        this.comments = value;
    }

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUE() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUE(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad execorder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXECORDER() {
        return execorder;
    }

    /**
     * Define el valor de la propiedad execorder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXECORDER(String value) {
        this.execorder = value;
    }

    /**
     * Obtiene el valor de la propiedad reverseassignment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREVERSEASSIGNMENT() {
        return reverseassignment;
    }

    /**
     * Define el valor de la propiedad reverseassignment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREVERSEASSIGNMENT(String value) {
        this.reverseassignment = value;
    }

}
