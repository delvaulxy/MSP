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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "scheduleinfo"
})
@XmlRootElement(name = "SCHEDULER")
public class SCHEDULER {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "REUSABLE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusable;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlElement(name = "SCHEDULEINFO", required = true)
    protected SCHEDULEINFO scheduleinfo;

    
    public SCHEDULER(){}
    public SCHEDULER(String name, String reusable, String versionnumber) {
		super();
		this.name = name;
		this.reusable = reusable;
		this.versionnumber = versionnumber;
	}

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
     * Obtiene el valor de la propiedad reusable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREUSABLE() {
        return reusable;
    }

    /**
     * Define el valor de la propiedad reusable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREUSABLE(String value) {
        this.reusable = value;
    }

    /**
     * Obtiene el valor de la propiedad versionnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERSIONNUMBER() {
        return versionnumber;
    }

    /**
     * Define el valor de la propiedad versionnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERSIONNUMBER(String value) {
        this.versionnumber = value;
    }

    /**
     * Obtiene el valor de la propiedad scheduleinfo.
     * 
     * @return
     *     possible object is
     *     {@link SCHEDULEINFO }
     *     
     */
    public SCHEDULEINFO getSCHEDULEINFO() {
        return scheduleinfo;
    }

    /**
     * Define el valor de la propiedad scheduleinfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SCHEDULEINFO }
     *     
     */
    public void setSCHEDULEINFO(SCHEDULEINFO value) {
        this.scheduleinfo = value;
    }

}
