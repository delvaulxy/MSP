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
    "recurring"
})
@XmlRootElement(name = "TIMER")
public class TIMER {

    @XmlAttribute(name = "TIMERTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String timertype;
    @XmlElement(name = "STARTOPTIONS")
    protected STARTOPTIONS startoptions;
    @XmlElement(name = "RECURRING")
    protected RECURRING recurring;

    /**
     * Obtiene el valor de la propiedad timertype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMERTYPE() {
        return timertype;
    }

    /**
     * Define el valor de la propiedad timertype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMERTYPE(String value) {
        this.timertype = value;
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

}
