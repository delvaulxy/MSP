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
@XmlRootElement(name = "SAPCODEBLOCK")
public class SAPCODEBLOCK {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "CODEBLOCK")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String codeblock;
    @XmlAttribute(name = "DSQINSTNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dsqinstname;

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
     * Obtiene el valor de la propiedad codeblock.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODEBLOCK() {
        return codeblock;
    }

    /**
     * Define el valor de la propiedad codeblock.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODEBLOCK(String value) {
        this.codeblock = value;
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

}
