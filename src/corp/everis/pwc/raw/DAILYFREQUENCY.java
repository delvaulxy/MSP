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
@XmlRootElement(name = "DAILYFREQUENCY")
public class DAILYFREQUENCY {

    @XmlAttribute(name = "HOURS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String hours;
    @XmlAttribute(name = "MINUTES")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String minutes;
    @XmlAttribute(name = "RUNONCE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String runonce;

    /**
     * Obtiene el valor de la propiedad hours.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOURS() {
        return hours;
    }

    /**
     * Define el valor de la propiedad hours.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOURS(String value) {
        this.hours = value;
    }

    /**
     * Obtiene el valor de la propiedad minutes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMINUTES() {
        return minutes;
    }

    /**
     * Define el valor de la propiedad minutes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMINUTES(String value) {
        this.minutes = value;
    }

    /**
     * Obtiene el valor de la propiedad runonce.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRUNONCE() {
        return runonce;
    }

    /**
     * Define el valor de la propiedad runonce.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRUNONCE(String value) {
        this.runonce = value;
    }

}
