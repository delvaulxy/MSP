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
@XmlRootElement(name = "SEBLJOIN")
public class SEBLJOIN {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "PKTABLE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String pktable;
    @XmlAttribute(name = "FKTABLE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fktable;
    @XmlAttribute(name = "OUTERJOINREL")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String outerjoinrel;
    @XmlAttribute(name = "SRCCOL", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String srccol;
    @XmlAttribute(name = "DESTCOL", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String destcol;

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
     * Obtiene el valor de la propiedad pktable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPKTABLE() {
        return pktable;
    }

    /**
     * Define el valor de la propiedad pktable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPKTABLE(String value) {
        this.pktable = value;
    }

    /**
     * Obtiene el valor de la propiedad fktable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFKTABLE() {
        return fktable;
    }

    /**
     * Define el valor de la propiedad fktable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFKTABLE(String value) {
        this.fktable = value;
    }

    /**
     * Obtiene el valor de la propiedad outerjoinrel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTERJOINREL() {
        return outerjoinrel;
    }

    /**
     * Define el valor de la propiedad outerjoinrel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTERJOINREL(String value) {
        this.outerjoinrel = value;
    }

    /**
     * Obtiene el valor de la propiedad srccol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCCOL() {
        return srccol;
    }

    /**
     * Define el valor de la propiedad srccol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCCOL(String value) {
        this.srccol = value;
    }

    /**
     * Obtiene el valor de la propiedad destcol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTCOL() {
        return destcol;
    }

    /**
     * Define el valor de la propiedad destcol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTCOL(String value) {
        this.destcol = value;
    }

}
