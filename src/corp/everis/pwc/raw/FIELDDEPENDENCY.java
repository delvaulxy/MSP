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
@XmlRootElement(name = "FIELDDEPENDENCY")
public class FIELDDEPENDENCY {

    @XmlAttribute(name = "INPUTFIELD", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String inputfield;
    @XmlAttribute(name = "OUTPUTFIELD", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String outputfield;

    /**
     * Obtiene el valor de la propiedad inputfield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINPUTFIELD() {
        return inputfield;
    }

    /**
     * Define el valor de la propiedad inputfield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINPUTFIELD(String value) {
        this.inputfield = value;
    }

    /**
     * Obtiene el valor de la propiedad outputfield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPUTFIELD() {
        return outputfield;
    }

    /**
     * Define el valor de la propiedad outputfield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPUTFIELD(String value) {
        this.outputfield = value;
    }

}
