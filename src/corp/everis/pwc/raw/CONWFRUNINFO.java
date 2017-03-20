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
@XmlRootElement(name = "CONWFRUNINFO")
public class CONWFRUNINFO {

    @XmlAttribute(name = "CONWFRUNINSTNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String conwfruninstname;
    @XmlAttribute(name = "CONWFPARAMFILE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String conwfparamfile;

    /**
     * Obtiene el valor de la propiedad conwfruninstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONWFRUNINSTNAME() {
        return conwfruninstname;
    }

    /**
     * Define el valor de la propiedad conwfruninstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONWFRUNINSTNAME(String value) {
        this.conwfruninstname = value;
    }

    /**
     * Obtiene el valor de la propiedad conwfparamfile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONWFPARAMFILE() {
        return conwfparamfile;
    }

    /**
     * Define el valor de la propiedad conwfparamfile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONWFPARAMFILE(String value) {
        this.conwfparamfile = value;
    }

}
