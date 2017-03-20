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
    "resourcereference"
})
@XmlRootElement(name = "TRANSFORMRESOURCEREF")
public class TRANSFORMRESOURCEREF {

    @XmlAttribute(name = "SINSTANCENAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sinstancename;
    @XmlAttribute(name = "TRANSFORMATIONTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String transformationtype;
    @XmlElement(name = "RESOURCEREFERENCE", required = true)
    protected List<RESOURCEREFERENCE> resourcereference;
    

    public TRANSFORMRESOURCEREF() {
		super();
	}
    public TRANSFORMRESOURCEREF(String sinstancename, String transformationtype,
			List<RESOURCEREFERENCE> resourcereference) {
		super();
		this.sinstancename = sinstancename;
		this.transformationtype = transformationtype;
		this.resourcereference = resourcereference;
	}
    public TRANSFORMRESOURCEREF(TRANSFORMRESOURCEREF transformresourceref) {
		super();
		this.sinstancename = transformresourceref.sinstancename;
		this.transformationtype = transformresourceref.transformationtype;
		this.resourcereference = transformresourceref.resourcereference;
	}

	/**
     * Obtiene el valor de la propiedad sinstancename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSINSTANCENAME() {
        return sinstancename;
    }

    /**
     * Define el valor de la propiedad sinstancename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSINSTANCENAME(String value) {
        this.sinstancename = value;
    }

    /**
     * Obtiene el valor de la propiedad transformationtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSFORMATIONTYPE() {
        return transformationtype;
    }

    /**
     * Define el valor de la propiedad transformationtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSFORMATIONTYPE(String value) {
        this.transformationtype = value;
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
