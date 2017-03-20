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
    "sapfuncinstanceparamfld"
})
@XmlRootElement(name = "SAPTABLEINSTANCEPARAM")
public class SAPTABLEINSTANCEPARAM {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "VALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "VALUETYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String valuetype;
    @XmlElement(name = "SAPFUNCINSTANCEPARAMFLD")
    protected List<SAPFUNCINSTANCEPARAMFLD> sapfuncinstanceparamfld;

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
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUE() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUE(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad valuetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUETYPE() {
        return valuetype;
    }

    /**
     * Define el valor de la propiedad valuetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUETYPE(String value) {
        this.valuetype = value;
    }

    /**
     * Gets the value of the sapfuncinstanceparamfld property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapfuncinstanceparamfld property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPFUNCINSTANCEPARAMFLD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPFUNCINSTANCEPARAMFLD }
     * 
     * 
     */
    public List<SAPFUNCINSTANCEPARAMFLD> getSAPFUNCINSTANCEPARAMFLD() {
        if (sapfuncinstanceparamfld == null) {
            sapfuncinstanceparamfld = new ArrayList<SAPFUNCINSTANCEPARAMFLD>();
        }
        return this.sapfuncinstanceparamfld;
    }

}
