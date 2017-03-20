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
@XmlRootElement(name = "SESSTRANSFORMATIONGROUP")
public class SESSTRANSFORMATIONGROUP {

    @XmlAttribute(name = "GROUP", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String group;
    @XmlAttribute(name = "PARTITIONTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String partitiontype;

    public SESSTRANSFORMATIONGROUP() {
  		super();
  	}  
    public SESSTRANSFORMATIONGROUP(String group, String partitiontype) {
		super();
		this.group = group;
		this.partitiontype = partitiontype;
	}  
    public SESSTRANSFORMATIONGROUP(SESSTRANSFORMATIONGROUP sesstransformationgroup) {
		super();
		this.group = sesstransformationgroup.group;
		this.partitiontype = sesstransformationgroup.partitiontype;
	}

	/**
     * Obtiene el valor de la propiedad group.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUP() {
        return group;
    }

    /**
     * Define el valor de la propiedad group.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUP(String value) {
        this.group = value;
    }

    /**
     * Obtiene el valor de la propiedad partitiontype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTITIONTYPE() {
        return partitiontype;
    }

    /**
     * Define el valor de la propiedad partitiontype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTITIONTYPE(String value) {
        this.partitiontype = value;
    }

}
