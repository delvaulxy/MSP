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
@XmlRootElement(name = "CONNECTOR")
public class CONNECTOR {

    @XmlAttribute(name = "FROMINSTANCE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String frominstance;
    @XmlAttribute(name = "FROMINSTANCETYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String frominstancetype;
    @XmlAttribute(name = "FROMFIELD", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fromfield;
    @XmlAttribute(name = "TOINSTANCE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String toinstance;
    @XmlAttribute(name = "TOINSTANCETYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String toinstancetype;
    @XmlAttribute(name = "TOFIELD", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tofield;
    public CONNECTOR(){}
    public CONNECTOR(String fromfield, String frominstance, String frominstancetype,
			String toinstancetype,  String toinstance, String tofield) {
		super();
		this.frominstance = frominstance;
		this.frominstancetype = frominstancetype;
		this.fromfield = fromfield;
		this.toinstance = toinstance;
		this.toinstancetype = toinstancetype;
		this.tofield = tofield;
	}

    
	public CONNECTOR(CONNECTOR connector) {
		super();
		this.frominstance = connector.frominstance;
		this.frominstancetype = connector.frominstancetype;
		this.fromfield = connector.fromfield;
		this.toinstance = connector.toinstance;
		this.toinstancetype = connector.toinstancetype;
		this.tofield = connector.tofield;
	}
	/**
     * Obtiene el valor de la propiedad frominstance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFROMINSTANCE() {
        return frominstance;
    }

    /**
     * Define el valor de la propiedad frominstance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFROMINSTANCE(String value) {
        this.frominstance = value;
    }

    /**
     * Obtiene el valor de la propiedad frominstancetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFROMINSTANCETYPE() {
        return frominstancetype;
    }

    /**
     * Define el valor de la propiedad frominstancetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFROMINSTANCETYPE(String value) {
        this.frominstancetype = value;
    }

    /**
     * Obtiene el valor de la propiedad fromfield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFROMFIELD() {
        return fromfield;
    }

    /**
     * Define el valor de la propiedad fromfield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFROMFIELD(String value) {
        this.fromfield = value;
    }

    /**
     * Obtiene el valor de la propiedad toinstance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOINSTANCE() {
        return toinstance;
    }

    /**
     * Define el valor de la propiedad toinstance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOINSTANCE(String value) {
        this.toinstance = value;
    }

    /**
     * Obtiene el valor de la propiedad toinstancetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOINSTANCETYPE() {
        return toinstancetype;
    }

    /**
     * Define el valor de la propiedad toinstancetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOINSTANCETYPE(String value) {
        this.toinstancetype = value;
    }

    /**
     * Obtiene el valor de la propiedad tofield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOFIELD() {
        return tofield;
    }

    /**
     * Define el valor de la propiedad tofield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOFIELD(String value) {
        this.tofield = value;
    }
    @Override
    public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof CONNECTOR){
        	CONNECTOR ptr = (CONNECTOR) v;
            if(ptr.toinstance.equals(this.toinstance) && ptr.tofield.equals(this.tofield) && ptr.toinstancetype.equals(this.toinstancetype)
            		&& ptr.fromfield.equals(this.fromfield) && ptr.frominstance.equals(this.frominstance) && ptr.frominstancetype.equals(this.frominstancetype)){
            	retVal = true;
            }
        }
	
     return retVal;
  }

    @Override
    public int hashCode() {
    	return Objects.hash(fromfield, frominstance, frominstancetype,tofield,toinstance,toinstancetype);
    }
}
