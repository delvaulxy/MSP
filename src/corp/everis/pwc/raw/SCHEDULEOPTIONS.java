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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recurring",
    "custom"
})
@XmlRootElement(name = "SCHEDULEOPTIONS")
public class SCHEDULEOPTIONS {

    @XmlAttribute(name = "SCHEDULETYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String scheduletype;
    @XmlElement(name = "RECURRING")
    protected RECURRING recurring;
    @XmlElement(name = "CUSTOM")
    protected CUSTOM custom;

    /**
     * Obtiene el valor de la propiedad scheduletype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCHEDULETYPE() {
        return scheduletype;
    }

    /**
     * Define el valor de la propiedad scheduletype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCHEDULETYPE(String value) {
        this.scheduletype = value;
    }

    /**
     * Obtiene el valor de la propiedad recurring.
     * 
     * @return
     *     possible object is
     *     {@link RECURRING }
     *     
     */
    public RECURRING getRECURRING() {
        return recurring;
    }

    /**
     * Define el valor de la propiedad recurring.
     * 
     * @param value
     *     allowed object is
     *     {@link RECURRING }
     *     
     */
    public void setRECURRING(RECURRING value) {
        this.recurring = value;
    }

    /**
     * Obtiene el valor de la propiedad custom.
     * 
     * @return
     *     possible object is
     *     {@link CUSTOM }
     *     
     */
    public CUSTOM getCUSTOM() {
        return custom;
    }

    /**
     * Define el valor de la propiedad custom.
     * 
     * @param value
     *     allowed object is
     *     {@link CUSTOM }
     *     
     */
    public void setCUSTOM(CUSTOM value) {
        this.custom = value;
    }

}
