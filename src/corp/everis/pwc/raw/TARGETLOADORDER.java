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
@XmlRootElement(name = "TARGETLOADORDER")
public class TARGETLOADORDER {

    @XmlAttribute(name = "TARGETINSTANCE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String targetinstance;
    @XmlAttribute(name = "ORDER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String order;
    public TARGETLOADORDER(){}
    public TARGETLOADORDER(String targetinstance, String order) {
		super();
		this.targetinstance = targetinstance;
		this.order = order;
	}

	public TARGETLOADORDER(TARGETLOADORDER targetloadorder) {
		super();
		this.targetinstance = targetloadorder.targetinstance;
		this.order = targetloadorder.order;
	}
	/**
     * Obtiene el valor de la propiedad targetinstance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTARGETINSTANCE() {
        return targetinstance;
    }

    /**
     * Define el valor de la propiedad targetinstance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTARGETINSTANCE(String value) {
        this.targetinstance = value;
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

}
