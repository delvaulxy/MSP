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
    "sapfunctioninstance",
    "sapcodeblock"
})
@XmlRootElement(name = "SAPPROGRAMFLOWOBJECT")
public class SAPPROGRAMFLOWOBJECT {

    @XmlAttribute(name = "REF_SOURCE_NAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refsourcename;
    @XmlAttribute(name = "REF_DBD_NAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refdbdname;
    @XmlAttribute(name = "REF_SOURCEINSTNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refsourceinstname;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "JOINBITMAP", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String joinbitmap;
    @XmlAttribute(name = "ORDER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String order;
    @XmlAttribute(name = "DSQINSTNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dsqinstname;
    @XmlElement(name = "SAPFUNCTIONINSTANCE")
    protected SAPFUNCTIONINSTANCE sapfunctioninstance;
    @XmlElement(name = "SAPCODEBLOCK")
    protected SAPCODEBLOCK sapcodeblock;

    /**
     * Obtiene el valor de la propiedad refsourcename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFSOURCENAME() {
        return refsourcename;
    }

    /**
     * Define el valor de la propiedad refsourcename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFSOURCENAME(String value) {
        this.refsourcename = value;
    }

    /**
     * Obtiene el valor de la propiedad refdbdname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFDBDNAME() {
        return refdbdname;
    }

    /**
     * Define el valor de la propiedad refdbdname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFDBDNAME(String value) {
        this.refdbdname = value;
    }

    /**
     * Obtiene el valor de la propiedad refsourceinstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFSOURCEINSTNAME() {
        return refsourceinstname;
    }

    /**
     * Define el valor de la propiedad refsourceinstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFSOURCEINSTNAME(String value) {
        this.refsourceinstname = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad joinbitmap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJOINBITMAP() {
        return joinbitmap;
    }

    /**
     * Define el valor de la propiedad joinbitmap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJOINBITMAP(String value) {
        this.joinbitmap = value;
    }

    /**
     * Obtiene el valor de la propiedad order.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDER() {
        return order;
    }

    /**
     * Define el valor de la propiedad order.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDER(String value) {
        this.order = value;
    }

    /**
     * Obtiene el valor de la propiedad dsqinstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSQINSTNAME() {
        return dsqinstname;
    }

    /**
     * Define el valor de la propiedad dsqinstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSQINSTNAME(String value) {
        this.dsqinstname = value;
    }

    /**
     * Obtiene el valor de la propiedad sapfunctioninstance.
     * 
     * @return
     *     possible object is
     *     {@link SAPFUNCTIONINSTANCE }
     *     
     */
    public SAPFUNCTIONINSTANCE getSAPFUNCTIONINSTANCE() {
        return sapfunctioninstance;
    }

    /**
     * Define el valor de la propiedad sapfunctioninstance.
     * 
     * @param value
     *     allowed object is
     *     {@link SAPFUNCTIONINSTANCE }
     *     
     */
    public void setSAPFUNCTIONINSTANCE(SAPFUNCTIONINSTANCE value) {
        this.sapfunctioninstance = value;
    }

    /**
     * Obtiene el valor de la propiedad sapcodeblock.
     * 
     * @return
     *     possible object is
     *     {@link SAPCODEBLOCK }
     *     
     */
    public SAPCODEBLOCK getSAPCODEBLOCK() {
        return sapcodeblock;
    }

    /**
     * Define el valor de la propiedad sapcodeblock.
     * 
     * @param value
     *     allowed object is
     *     {@link SAPCODEBLOCK }
     *     
     */
    public void setSAPCODEBLOCK(SAPCODEBLOCK value) {
        this.sapcodeblock = value;
    }

}
