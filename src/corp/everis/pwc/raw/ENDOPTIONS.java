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
@XmlRootElement(name = "ENDOPTIONS")
public class ENDOPTIONS {

    @XmlAttribute(name = "ENDTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String endtype;
    @XmlAttribute(name = "ENDON")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String endon;
    @XmlAttribute(name = "ENDAFTER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String endafter;
    @XmlAttribute(name = "RUNFOREVER")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String runforever;

    /**
     * Obtiene el valor de la propiedad endtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDTYPE() {
        return endtype;
    }

    /**
     * Define el valor de la propiedad endtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDTYPE(String value) {
        this.endtype = value;
    }

    /**
     * Obtiene el valor de la propiedad endon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDON() {
        return endon;
    }

    /**
     * Define el valor de la propiedad endon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDON(String value) {
        this.endon = value;
    }

    /**
     * Obtiene el valor de la propiedad endafter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDAFTER() {
        return endafter;
    }

    /**
     * Define el valor de la propiedad endafter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDAFTER(String value) {
        this.endafter = value;
    }

    /**
     * Obtiene el valor de la propiedad runforever.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRUNFOREVER() {
        return runforever;
    }

    /**
     * Define el valor de la propiedad runforever.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRUNFOREVER(String value) {
        this.runforever = value;
    }

}
