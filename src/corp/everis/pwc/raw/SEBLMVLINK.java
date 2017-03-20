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
@XmlRootElement(name = "SEBLMVLINK")
public class SEBLMVLINK {

    @XmlAttribute(name = "BCNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bcname;
    @XmlAttribute(name = "MVLINK", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mvlink;
    @XmlAttribute(name = "DESTLINK", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String destlink;
    @XmlAttribute(name = "DESTBC", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String destbc;
    @XmlAttribute(name = "SRCFIELD", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String srcfield;
    @XmlAttribute(name = "PRIMARYID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String primaryid;

    /**
     * Obtiene el valor de la propiedad bcname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBCNAME() {
        return bcname;
    }

    /**
     * Define el valor de la propiedad bcname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBCNAME(String value) {
        this.bcname = value;
    }

    /**
     * Obtiene el valor de la propiedad mvlink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMVLINK() {
        return mvlink;
    }

    /**
     * Define el valor de la propiedad mvlink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMVLINK(String value) {
        this.mvlink = value;
    }

    /**
     * Obtiene el valor de la propiedad destlink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTLINK() {
        return destlink;
    }

    /**
     * Define el valor de la propiedad destlink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTLINK(String value) {
        this.destlink = value;
    }

    /**
     * Obtiene el valor de la propiedad destbc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTBC() {
        return destbc;
    }

    /**
     * Define el valor de la propiedad destbc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTBC(String value) {
        this.destbc = value;
    }

    /**
     * Obtiene el valor de la propiedad srcfield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCFIELD() {
        return srcfield;
    }

    /**
     * Define el valor de la propiedad srcfield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCFIELD(String value) {
        this.srcfield = value;
    }

    /**
     * Obtiene el valor de la propiedad primaryid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRIMARYID() {
        return primaryid;
    }

    /**
     * Define el valor de la propiedad primaryid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRIMARYID(String value) {
        this.primaryid = value;
    }

}
