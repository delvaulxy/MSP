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
@XmlRootElement(name = "FILTER")
public class FILTER {

    @XmlAttribute(name = "DAYOFMONTH")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dayofmonth;
    @XmlAttribute(name = "DAY")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String day;
    @XmlAttribute(name = "OCCURRENCE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String occurrence;

    public FILTER() {
		super();
	}
    
    public FILTER(String dayofmonth, String day, String occurrence) {
		super();
		this.dayofmonth = dayofmonth;
		this.day = day;
		this.occurrence = occurrence;
	}
    
    public FILTER(FILTER filter) {
		super();
		this.dayofmonth = filter.dayofmonth;
		this.day = filter.day;
		this.occurrence = filter.occurrence;
	}

	/**
     * Obtiene el valor de la propiedad dayofmonth.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDAYOFMONTH() {
        return dayofmonth;
    }

    /**
     * Define el valor de la propiedad dayofmonth.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDAYOFMONTH(String value) {
        this.dayofmonth = value;
    }

    /**
     * Obtiene el valor de la propiedad day.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDAY() {
        return day;
    }

    /**
     * Define el valor de la propiedad day.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDAY(String value) {
        this.day = value;
    }

    /**
     * Obtiene el valor de la propiedad occurrence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCCURRENCE() {
        return occurrence;
    }

    /**
     * Define el valor de la propiedad occurrence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCCURRENCE(String value) {
        this.occurrence = value;
    }

}
