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
    "startoptions",
    "scheduleoptions",
    "endoptions"
})
@XmlRootElement(name = "SCHEDULEINFO")
public class SCHEDULEINFO {

    @XmlAttribute(name = "SCHEDULETYPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String scheduletype;
    @XmlElement(name = "STARTOPTIONS")
    protected STARTOPTIONS startoptions;
    @XmlElement(name = "SCHEDULEOPTIONS")
    protected SCHEDULEOPTIONS scheduleoptions;
    @XmlElement(name = "ENDOPTIONS")
    protected ENDOPTIONS endoptions;

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
     * Obtiene el valor de la propiedad startoptions.
     * 
     * @return
     *     possible object is
     *     {@link STARTOPTIONS }
     *     
     */
    public STARTOPTIONS getSTARTOPTIONS() {
        return startoptions;
    }

    /**
     * Define el valor de la propiedad startoptions.
     * 
     * @param value
     *     allowed object is
     *     {@link STARTOPTIONS }
     *     
     */
    public void setSTARTOPTIONS(STARTOPTIONS value) {
        this.startoptions = value;
    }

    /**
     * Obtiene el valor de la propiedad scheduleoptions.
     * 
     * @return
     *     possible object is
     *     {@link SCHEDULEOPTIONS }
     *     
     */
    public SCHEDULEOPTIONS getSCHEDULEOPTIONS() {
        return scheduleoptions;
    }

    /**
     * Define el valor de la propiedad scheduleoptions.
     * 
     * @param value
     *     allowed object is
     *     {@link SCHEDULEOPTIONS }
     *     
     */
    public void setSCHEDULEOPTIONS(SCHEDULEOPTIONS value) {
        this.scheduleoptions = value;
    }

    /**
     * Obtiene el valor de la propiedad endoptions.
     * 
     * @return
     *     possible object is
     *     {@link ENDOPTIONS }
     *     
     */
    public ENDOPTIONS getENDOPTIONS() {
        return endoptions;
    }

    /**
     * Define el valor de la propiedad endoptions.
     * 
     * @param value
     *     allowed object is
     *     {@link ENDOPTIONS }
     *     
     */
    public void setENDOPTIONS(ENDOPTIONS value) {
        this.endoptions = value;
    }

}
