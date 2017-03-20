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
@XmlRootElement(name = "KEYRANGE")
public class KEYRANGE {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "STARTRANGE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String startrange;
    @XmlAttribute(name = "ENDRANGE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String endrange;
    @XmlAttribute(name = "SRCINSTANCENAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String srcinstancename;
    @XmlAttribute(name = "GROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String group;

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
     * Obtiene el valor de la propiedad startrange.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTRANGE() {
        return startrange;
    }

    /**
     * Define el valor de la propiedad startrange.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTRANGE(String value) {
        this.startrange = value;
    }

    /**
     * Obtiene el valor de la propiedad endrange.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDRANGE() {
        return endrange;
    }

    /**
     * Define el valor de la propiedad endrange.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDRANGE(String value) {
        this.endrange = value;
    }

    /**
     * Obtiene el valor de la propiedad srcinstancename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCINSTANCENAME() {
        return srcinstancename;
    }

    /**
     * Define el valor de la propiedad srcinstancename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCINSTANCENAME(String value) {
        this.srcinstancename = value;
    }

    /**
     * Obtiene el valor de la propiedad group.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUP() {
        return group;
    }

    /**
     * Define el valor de la propiedad group.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUP(String value) {
        this.group = value;
    }

}
