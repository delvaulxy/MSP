//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exprmacrodependency"
})
@XmlRootElement(name = "WORKFLOWLINK")
public class WORKFLOWLINK {

    @XmlAttribute(name = "FROMTASK", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fromtask;
    @XmlAttribute(name = "TOTASK", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String totask;
    @XmlAttribute(name = "CONDITION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String condition;
    @XmlElement(name = "EXPRMACRODEPENDENCY")
    protected List<EXPRMACRODEPENDENCY> exprmacrodependency;

    public WORKFLOWLINK() {
		super();
	}

    public WORKFLOWLINK(String fromtask, String totask, String condition,
			List<EXPRMACRODEPENDENCY> exprmacrodependency) {
		super();
		this.fromtask = fromtask;
		this.totask = totask;
		this.condition = condition;
		this.exprmacrodependency = exprmacrodependency;
	}

    public WORKFLOWLINK(WORKFLOWLINK workflowlink) {
		super();
		this.fromtask = workflowlink.fromtask;
		this.totask = workflowlink.totask;
		this.condition = workflowlink.condition;
		this.exprmacrodependency = workflowlink.exprmacrodependency;
	}

	/**
     * Obtiene el valor de la propiedad fromtask.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFROMTASK() {
        return fromtask;
    }

    /**
     * Define el valor de la propiedad fromtask.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFROMTASK(String value) {
        this.fromtask = value;
    }

    /**
     * Obtiene el valor de la propiedad totask.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTASK() {
        return totask;
    }

    /**
     * Define el valor de la propiedad totask.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTASK(String value) {
        this.totask = value;
    }

    /**
     * Obtiene el valor de la propiedad condition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONDITION() {
        return condition;
    }

    /**
     * Define el valor de la propiedad condition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONDITION(String value) {
        this.condition = value;
    }

    /**
     * Gets the value of the exprmacrodependency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exprmacrodependency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEXPRMACRODEPENDENCY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EXPRMACRODEPENDENCY }
     * 
     * 
     */
    public List<EXPRMACRODEPENDENCY> getEXPRMACRODEPENDENCY() {
        if (exprmacrodependency == null) {
            exprmacrodependency = new ArrayList<EXPRMACRODEPENDENCY>();
        }
        return this.exprmacrodependency;
    }

}
