//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.ArrayList;
import java.util.List;

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
    "macroargument",
    "macrodependency"
})
@XmlRootElement(name = "EXPRMACRO")
public class EXPRMACRO {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "OBJECTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String objectversion;
    @XmlAttribute(name = "PROTOTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String prototype;
    @XmlAttribute(name = "EXPRESSION", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expression;
    @XmlAttribute(name = "MACROTYPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String macrotype;
    @XmlAttribute(name = "RETURNTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String returntype;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlElement(name = "MACROARGUMENT")
    protected List<MACROARGUMENT> macroargument;
    @XmlElement(name = "MACRODEPENDENCY")
    protected List<MACRODEPENDENCY> macrodependency;

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
     * Obtiene el valor de la propiedad objectversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTVERSION() {
        return objectversion;
    }

    /**
     * Define el valor de la propiedad objectversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTVERSION(String value) {
        this.objectversion = value;
    }

    /**
     * Obtiene el valor de la propiedad prototype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROTOTYPE() {
        return prototype;
    }

    /**
     * Define el valor de la propiedad prototype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROTOTYPE(String value) {
        this.prototype = value;
    }

    /**
     * Obtiene el valor de la propiedad expression.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPRESSION() {
        return expression;
    }

    /**
     * Define el valor de la propiedad expression.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPRESSION(String value) {
        this.expression = value;
    }

    /**
     * Obtiene el valor de la propiedad macrotype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACROTYPE() {
        return macrotype;
    }

    /**
     * Define el valor de la propiedad macrotype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACROTYPE(String value) {
        this.macrotype = value;
    }

    /**
     * Obtiene el valor de la propiedad returntype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETURNTYPE() {
        return returntype;
    }

    /**
     * Define el valor de la propiedad returntype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETURNTYPE(String value) {
        this.returntype = value;
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
     * Gets the value of the macroargument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the macroargument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMACROARGUMENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MACROARGUMENT }
     * 
     * 
     */
    public List<MACROARGUMENT> getMACROARGUMENT() {
        if (macroargument == null) {
            macroargument = new ArrayList<MACROARGUMENT>();
        }
        return this.macroargument;
    }

    /**
     * Gets the value of the macrodependency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the macrodependency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMACRODEPENDENCY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MACRODEPENDENCY }
     * 
     * 
     */
    public List<MACRODEPENDENCY> getMACRODEPENDENCY() {
        if (macrodependency == null) {
            macrodependency = new ArrayList<MACRODEPENDENCY>();
        }
        return this.macrodependency;
    }

}
