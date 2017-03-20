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
@XmlRootElement(name = "GROUP")
public class GROUP {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "ORDER", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String order;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "EXPRESSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expression;

    
    
    
    
    public GROUP() {
		super();
	}
    
    public GROUP(String name, String description, String order, String type, String expression) {
		super();
		this.name = name;
		this.description = description;
		this.order = order;
		this.type = type;
		this.expression = expression;
	}

    public GROUP(GROUP group) {
		super();
		this.name = group.name;
		this.description = group.description;
		this.order = group.order;
		this.type = group.type;
		this.expression = group.expression;
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
	@Override
	public boolean equals(Object v) {
		boolean retVal = true;

		if (v instanceof GROUP){
			GROUP ptr = (GROUP) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.description)){
				retVal = false;
			}
			if(null!=ptr.getORDER() && !ptr.getORDER().equals(this.order)){
				retVal = false;
			}
			if(null!=ptr.getTYPE() && !ptr.getTYPE().equals(this.type)){
				retVal = false;
			}
			if(null!=ptr.getEXPRESSION() && !ptr.getEXPRESSION().equals(this.expression)){
				retVal = false;
			}
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,description,order,type,expression);
	}

}
