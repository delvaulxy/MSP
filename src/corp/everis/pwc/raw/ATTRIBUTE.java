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
@XmlRootElement(name = "ATTRIBUTE")
public class ATTRIBUTE {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "VALUE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "PARTITIONNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String partitionname;
    
    public ATTRIBUTE(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
    public ATTRIBUTE(){}
    
	public ATTRIBUTE(ATTRIBUTE attribute) {
		this.name = attribute.name;
		this.value = attribute.value;
		this.partitionname = attribute.partitionname;
	}
    
    
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
     * Obtiene el valor de la propiedad partitionname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTITIONNAME() {
        return partitionname;
    }

    /**
     * Define el valor de la propiedad partitionname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTITIONNAME(String value) {
        this.partitionname = value;
    }

    

}
