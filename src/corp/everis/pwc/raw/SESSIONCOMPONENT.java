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
    "task",
    "valuepair",
    "attribute"
})
@XmlRootElement(name = "SESSIONCOMPONENT")
public class SESSIONCOMPONENT {

    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "REFOBJECTNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refobjectname;
    @XmlAttribute(name = "REUSABLE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusable;
    @XmlAttribute(name = "ISNONE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isnone;
    @XmlElement(name = "TASK")
    protected TASK task;
    @XmlElement(name = "VALUEPAIR")
    protected List<VALUEPAIR> valuepair;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;

    public SESSIONCOMPONENT() {
		super();
	}
    public SESSIONCOMPONENT(String type, String refobjectname, String reusable, String isnone, TASK task,
			List<VALUEPAIR> valuepair, List<ATTRIBUTE> attribute) {
		super();
		this.type = type;
		this.refobjectname = refobjectname;
		this.reusable = reusable;
		this.isnone = isnone;
		this.task = task;
		this.valuepair = valuepair;
		this.attribute = attribute;
	}
    public SESSIONCOMPONENT(SESSIONCOMPONENT sessioncomponent) {
		super();
		this.type = sessioncomponent.type;
		this.refobjectname = sessioncomponent.refobjectname;
		this.reusable = sessioncomponent.reusable;
		this.isnone = sessioncomponent.isnone;
		this.task = sessioncomponent.task;
		this.valuepair = sessioncomponent.valuepair;
		this.attribute = sessioncomponent.attribute;
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
     * Obtiene el valor de la propiedad refobjectname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFOBJECTNAME() {
        return refobjectname;
    }

    /**
     * Define el valor de la propiedad refobjectname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFOBJECTNAME(String value) {
        this.refobjectname = value;
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
     * Obtiene el valor de la propiedad isnone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISNONE() {
        return isnone;
    }

    /**
     * Define el valor de la propiedad isnone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISNONE(String value) {
        this.isnone = value;
    }

    /**
     * Obtiene el valor de la propiedad task.
     * 
     * @return
     *     possible object is
     *     {@link TASK }
     *     
     */
    public TASK getTASK() {
        return task;
    }

    /**
     * Define el valor de la propiedad task.
     * 
     * @param value
     *     allowed object is
     *     {@link TASK }
     *     
     */
    public void setTASK(TASK value) {
        this.task = value;
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

}
