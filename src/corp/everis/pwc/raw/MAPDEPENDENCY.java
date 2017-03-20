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
@XmlRootElement(name = "MAPDEPENDENCY")
public class MAPDEPENDENCY {

    @XmlAttribute(name = "FROMINSTANCE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String frominstance;
    @XmlAttribute(name = "FROMINSTANCETYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String frominstancetype;
    @XmlAttribute(name = "TOINSTANCE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String toinstance;
    @XmlAttribute(name = "TOINSTANCETYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String toinstancetype;

    public MAPDEPENDENCY() {
		super();
	}

    public MAPDEPENDENCY(String frominstance, String frominstancetype, String toinstance, String toinstancetype) {
		super();
		this.frominstance = frominstance;
		this.frominstancetype = frominstancetype;
		this.toinstance = toinstance;
		this.toinstancetype = toinstancetype;
	}

    public MAPDEPENDENCY(MAPDEPENDENCY mapdependency) {
		super();
		this.frominstance = mapdependency.frominstance;
		this.frominstancetype = mapdependency.frominstancetype;
		this.toinstance = mapdependency.toinstance;
		this.toinstancetype = mapdependency.toinstancetype;
	}

	/**
     * Obtiene el valor de la propiedad frominstance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFROMINSTANCE() {
        return frominstance;
    }

    /**
     * Define el valor de la propiedad frominstance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFROMINSTANCE(String value) {
        this.frominstance = value;
    }

    /**
     * Obtiene el valor de la propiedad frominstancetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFROMINSTANCETYPE() {
        return frominstancetype;
    }

    /**
     * Define el valor de la propiedad frominstancetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFROMINSTANCETYPE(String value) {
        this.frominstancetype = value;
    }

    /**
     * Obtiene el valor de la propiedad toinstance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOINSTANCE() {
        return toinstance;
    }

    /**
     * Define el valor de la propiedad toinstance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOINSTANCE(String value) {
        this.toinstance = value;
    }

    /**
     * Obtiene el valor de la propiedad toinstancetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOINSTANCETYPE() {
        return toinstancetype;
    }

    /**
     * Define el valor de la propiedad toinstancetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOINSTANCETYPE(String value) {
        this.toinstancetype = value;
    }

}
