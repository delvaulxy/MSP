//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.Objects;

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
@XmlRootElement(name = "TABLEATTRIBUTE")
public class TABLEATTRIBUTE {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "VALUE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    public TABLEATTRIBUTE(){}
    public TABLEATTRIBUTE(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
    public TABLEATTRIBUTE(TABLEATTRIBUTE tableattribute) {
		super();
		this.name = tableattribute.name;
		this.value = tableattribute.value;
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
    @Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof TABLEATTRIBUTE){
			TABLEATTRIBUTE ptr = (TABLEATTRIBUTE) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getVALUE() && !ptr.getVALUE().equals(this.value)){
				retVal = false;
			}
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,value);
	}
}
