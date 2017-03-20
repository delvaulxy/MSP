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
@XmlRootElement(name = "SAPPROGRAM")
public class SAPPROGRAM {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "PROGRAMTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String programtype;
    @XmlAttribute(name = "INSTALLTIME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String installtime;
    @XmlAttribute(name = "HOSTNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String hostname;
    @XmlAttribute(name = "USERNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String username;
    @XmlAttribute(name = "CLIENTSPACE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String clientspace;
    @XmlAttribute(name = "ISVALID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isvalid;

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
     * Obtiene el valor de la propiedad programtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROGRAMTYPE() {
        return programtype;
    }

    /**
     * Define el valor de la propiedad programtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROGRAMTYPE(String value) {
        this.programtype = value;
    }

    /**
     * Obtiene el valor de la propiedad installtime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTALLTIME() {
        return installtime;
    }

    /**
     * Define el valor de la propiedad installtime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTALLTIME(String value) {
        this.installtime = value;
    }

    /**
     * Obtiene el valor de la propiedad hostname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOSTNAME() {
        return hostname;
    }

    /**
     * Define el valor de la propiedad hostname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOSTNAME(String value) {
        this.hostname = value;
    }

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERNAME() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERNAME(String value) {
        this.username = value;
    }

    /**
     * Obtiene el valor de la propiedad clientspace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLIENTSPACE() {
        return clientspace;
    }

    /**
     * Define el valor de la propiedad clientspace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLIENTSPACE(String value) {
        this.clientspace = value;
    }

    /**
     * Obtiene el valor de la propiedad isvalid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISVALID() {
        return isvalid;
    }

    /**
     * Define el valor de la propiedad isvalid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISVALID(String value) {
        this.isvalid = value;
    }

}
