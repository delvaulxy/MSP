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
@XmlRootElement(name = "SEBLLINK")
public class SEBLLINK {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "PARENTBC", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parentbc;
    @XmlAttribute(name = "CHILDBC", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String childbc;
    @XmlAttribute(name = "DESTBCBASETABLE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String destbcbasetable;
    @XmlAttribute(name = "SRCCOL", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String srccol;
    @XmlAttribute(name = "DESTCOL", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String destcol;
    @XmlAttribute(name = "INTERCHILDCOL", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String interchildcol;
    @XmlAttribute(name = "INTERPARENTCOL", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String interparentcol;
    @XmlAttribute(name = "INTERTABLE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String intertable;
    @XmlAttribute(name = "PRIMARYID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String primaryid;

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
     * Obtiene el valor de la propiedad parentbc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENTBC() {
        return parentbc;
    }

    /**
     * Define el valor de la propiedad parentbc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENTBC(String value) {
        this.parentbc = value;
    }

    /**
     * Obtiene el valor de la propiedad childbc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHILDBC() {
        return childbc;
    }

    /**
     * Define el valor de la propiedad childbc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHILDBC(String value) {
        this.childbc = value;
    }

    /**
     * Obtiene el valor de la propiedad destbcbasetable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTBCBASETABLE() {
        return destbcbasetable;
    }

    /**
     * Define el valor de la propiedad destbcbasetable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTBCBASETABLE(String value) {
        this.destbcbasetable = value;
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

    /**
     * Obtiene el valor de la propiedad interchildcol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERCHILDCOL() {
        return interchildcol;
    }

    /**
     * Define el valor de la propiedad interchildcol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERCHILDCOL(String value) {
        this.interchildcol = value;
    }

    /**
     * Obtiene el valor de la propiedad interparentcol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERPARENTCOL() {
        return interparentcol;
    }

    /**
     * Define el valor de la propiedad interparentcol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERPARENTCOL(String value) {
        this.interparentcol = value;
    }

    /**
     * Obtiene el valor de la propiedad intertable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERTABLE() {
        return intertable;
    }

    /**
     * Define el valor de la propiedad intertable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERTABLE(String value) {
        this.intertable = value;
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
