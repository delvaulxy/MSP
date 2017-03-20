//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "seblsrcinfo"
})
@XmlRootElement(name = "ERPSRCINFO")
public class ERPSRCINFO {

    @XmlElement(name = "SEBLSRCINFO")
    protected SEBLSRCINFO seblsrcinfo;

    /**
     * Obtiene el valor de la propiedad seblsrcinfo.
     * 
     * @return
     *     possible object is
     *     {@link SEBLSRCINFO }
     *     
     */
    public SEBLSRCINFO getSEBLSRCINFO() {
        return seblsrcinfo;
    }

    /**
     * Define el valor de la propiedad seblsrcinfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SEBLSRCINFO }
     *     
     */
    public void setSEBLSRCINFO(SEBLSRCINFO value) {
        this.seblsrcinfo = value;
    }

}
