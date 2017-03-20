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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "attribute",
    "exprmacrodependency",
    "timer",
    "valuepair",
    "resourcereference"
})
@XmlRootElement(name = "TASK")
public class TASK {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "REUSABLE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusable;
    @XmlAttribute(name = "PARENT")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parent;
    @XmlAttribute(name = "PARENT_TYPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String parenttype;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;
    @XmlElement(name = "EXPRMACRODEPENDENCY")
    protected List<EXPRMACRODEPENDENCY> exprmacrodependency;
    @XmlElement(name = "TIMER")
    protected TIMER timer;
    @XmlElement(name = "VALUEPAIR")
    protected List<VALUEPAIR> valuepair;
    @XmlElement(name = "RESOURCEREFERENCE")
    protected List<RESOURCEREFERENCE> resourcereference;
    
    
    public TASK(){}
    public TASK(String name, String type, String reusable, String versionnumber) {
		super();
		this.name = name;
		this.type = type;
		this.reusable = reusable;
		this.versionnumber = versionnumber;
	}

    public TASK(String name, String description, String type, String reusable, String parent, String parenttype,
			String versionnumber, List<ATTRIBUTE> attribute, List<EXPRMACRODEPENDENCY> exprmacrodependency, TIMER timer,
			List<VALUEPAIR> valuepair, List<RESOURCEREFERENCE> resourcereference) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.reusable = reusable;
		this.parent = parent;
		this.parenttype = parenttype;
		this.versionnumber = versionnumber;
		this.attribute = attribute;
		this.exprmacrodependency = exprmacrodependency;
		this.timer = timer;
		this.valuepair = valuepair;
		this.resourcereference = resourcereference;
	}
    public TASK(TASK task) {
		super();
		this.name = task.name;
		this.description = task.description;
		this.type = task.type;
		this.reusable = task.reusable;
		this.parent = task.parent;
		this.parenttype = task.parenttype;
		this.versionnumber = task.versionnumber;
		this.attribute = task.attribute;
		this.exprmacrodependency = task.exprmacrodependency;
		this.timer = task.timer;
		this.valuepair = task.valuepair;
		this.resourcereference = task.resourcereference;
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
     * Obtiene el valor de la propiedad reusable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREUSABLE() {
        return reusable;
    }

    /**
     * Define el valor de la propiedad reusable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREUSABLE(String value) {
        this.reusable = value;
    }

    /**
     * Obtiene el valor de la propiedad parent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENT() {
        return parent;
    }

    /**
     * Define el valor de la propiedad parent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENT(String value) {
        this.parent = value;
    }

    /**
     * Obtiene el valor de la propiedad parenttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENTTYPE() {
        return parenttype;
    }

    /**
     * Define el valor de la propiedad parenttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENTTYPE(String value) {
        this.parenttype = value;
    }

    /**
     * Obtiene el valor de la propiedad versionnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERSIONNUMBER() {
        return versionnumber;
    }

    /**
     * Define el valor de la propiedad versionnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERSIONNUMBER(String value) {
        this.versionnumber = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ATTRIBUTE }
     * 
     * 
     */
    public List<ATTRIBUTE> getATTRIBUTE() {
        if (attribute == null) {
            attribute = new ArrayList<ATTRIBUTE>();
        }
        return this.attribute;
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

    /**
     * Obtiene el valor de la propiedad timer.
     * 
     * @return
     *     possible object is
     *     {@link TIMER }
     *     
     */
    public TIMER getTIMER() {
        return timer;
    }

    /**
     * Define el valor de la propiedad timer.
     * 
     * @param value
     *     allowed object is
     *     {@link TIMER }
     *     
     */
    public void setTIMER(TIMER value) {
        this.timer = value;
    }

    /**
     * Gets the value of the valuepair property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valuepair property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVALUEPAIR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VALUEPAIR }
     * 
     * 
     */
    public List<VALUEPAIR> getVALUEPAIR() {
        if (valuepair == null) {
            valuepair = new ArrayList<VALUEPAIR>();
        }
        return this.valuepair;
    }

    /**
     * Gets the value of the resourcereference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourcereference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRESOURCEREFERENCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RESOURCEREFERENCE }
     * 
     * 
     */
    public List<RESOURCEREFERENCE> getRESOURCEREFERENCE() {
        if (resourcereference == null) {
            resourcereference = new ArrayList<RESOURCEREFERENCE>();
        }
        return this.resourcereference;
    }

}
