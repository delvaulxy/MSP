//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dailyfrequency",
    "repeat"
})
@XmlRootElement(name = "CUSTOM")
public class CUSTOM {

    @XmlElement(name = "DAILYFREQUENCY", required = true)
    protected DAILYFREQUENCY dailyfrequency;
    @XmlElement(name = "REPEAT")
    protected REPEAT repeat;

    /**
     * Obtiene el valor de la propiedad dailyfrequency.
     * 
     * @return
     *     possible object is
     *     {@link DAILYFREQUENCY }
     *     
     */
    public DAILYFREQUENCY getDAILYFREQUENCY() {
        return dailyfrequency;
    }

    /**
     * Define el valor de la propiedad dailyfrequency.
     * 
     * @param value
     *     allowed object is
     *     {@link DAILYFREQUENCY }
     *     
     */
    public void setDAILYFREQUENCY(DAILYFREQUENCY value) {
        this.dailyfrequency = value;
    }

    /**
     * Obtiene el valor de la propiedad repeat.
     * 
     * @return
     *     possible object is
     *     {@link REPEAT }
     *     
     */
    public REPEAT getREPEAT() {
        return repeat;
    }

    /**
     * Define el valor de la propiedad repeat.
     * 
     * @param value
     *     allowed object is
     *     {@link REPEAT }
     *     
     */
    public void setREPEAT(REPEAT value) {
        this.repeat = value;
    }

}
