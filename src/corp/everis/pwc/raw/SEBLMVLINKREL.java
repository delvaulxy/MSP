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
@XmlRootElement(name = "SEBLMVLINKREL")
public class SEBLMVLINKREL {

    @XmlAttribute(name = "SRCMVLINK")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String srcmvlink;
    @XmlAttribute(name = "DESTMVLINK")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String destmvlink;
    @XmlAttribute(name = "FIELD", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String field;

    /**
     * Obtiene el valor de la propiedad srcmvlink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCMVLINK() {
        return srcmvlink;
    }

    /**
     * Define el valor de la propiedad srcmvlink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCMVLINK(String value) {
        this.srcmvlink = value;
    }

    /**
     * Obtiene el valor de la propiedad destmvlink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTMVLINK() {
        return destmvlink;
    }

    /**
     * Define el valor de la propiedad destmvlink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTMVLINK(String value) {
        this.destmvlink = value;
    }

    /**
     * Obtiene el valor de la propiedad field.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELD() {
        return field;
    }

    /**
     * Define el valor de la propiedad field.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELD(String value) {
        this.field = value;
    }

}
