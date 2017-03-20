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
@XmlRootElement(name = "SAPOUTPUTPORT")
public class SAPOUTPUTPORT {

    @XmlAttribute(name = "PORTNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String portname;
    @XmlAttribute(name = "FIELDNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fieldname;
    @XmlAttribute(name = "VARNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String varname;
    @XmlAttribute(name = "DSQINSTNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dsqinstname;

    /**
     * Obtiene el valor de la propiedad portname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPORTNAME() {
        return portname;
    }

    /**
     * Define el valor de la propiedad portname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPORTNAME(String value) {
        this.portname = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDNAME() {
        return fieldname;
    }

    /**
     * Define el valor de la propiedad fieldname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDNAME(String value) {
        this.fieldname = value;
    }

    /**
     * Obtiene el valor de la propiedad varname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVARNAME() {
        return varname;
    }

    /**
     * Define el valor de la propiedad varname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVARNAME(String value) {
        this.varname = value;
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
