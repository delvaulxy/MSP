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
    "fieldattribute"
})
@XmlRootElement(name = "TARGETFIELD")
public class TARGETFIELD {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "BUSINESSNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String businessname;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "DATATYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "KEYTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String keytype;
    @XmlAttribute(name = "PRECISION", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "SCALE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scale;
    @XmlAttribute(name = "FIELDNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fieldnumber;
    @XmlAttribute(name = "NULLABLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nullable;
    @XmlAttribute(name = "PICTURETEXT")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String picturetext;
    @XmlAttribute(name = "REFERENCEDTABLE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referencedtable;
    @XmlAttribute(name = "REFERENCEDFIELD")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referencedfield;
    @XmlAttribute(name = "GROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String group;
    @XmlAttribute(name = "ISFILENAMEFIELD")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isfilenamefield;
    @XmlElement(name = "FIELDATTRIBUTE")
    protected List<FIELDATTRIBUTE> fieldattribute;

    public TARGETFIELD(){}
	
    public TARGETFIELD(String name, String datatype, String keytype, String precision, String scale, String nullable, String fieldnumber) {
		super();
		this.name = name;
		this.datatype = datatype;
		this.keytype = keytype;
		this.precision = precision;
		this.scale = scale;
		this.nullable = nullable;
		this.fieldnumber = fieldnumber;
	}

	public TARGETFIELD(String name, String businessname, String description, String datatype, String keytype,
			String precision, String scale, String fieldnumber, String nullable, String picturetext,
			String referencedtable, String referencedfield, String group, String isfilenamefield,
			List<FIELDATTRIBUTE> fieldattribute) {
		super();
		this.name = name;
		this.businessname = businessname;
		this.description = description;
		this.datatype = datatype;
		this.keytype = keytype;
		this.precision = precision;
		this.scale = scale;
		this.fieldnumber = fieldnumber;
		this.nullable = nullable;
		this.picturetext = picturetext;
		this.referencedtable = referencedtable;
		this.referencedfield = referencedfield;
		this.group = group;
		this.isfilenamefield = isfilenamefield;
		this.fieldattribute = fieldattribute;
	}
	public TARGETFIELD(TARGETFIELD targetfield) {
		super();
		this.name = targetfield.name;
		this.businessname = targetfield.businessname;
		this.description = targetfield.description;
		this.datatype = targetfield.datatype;
		this.keytype = targetfield.keytype;
		this.precision = targetfield.precision;
		this.scale = targetfield.scale;
		this.fieldnumber = targetfield.fieldnumber;
		this.nullable = targetfield.nullable;
		this.picturetext = targetfield.picturetext;
		this.referencedtable = targetfield.referencedtable;
		this.referencedfield = targetfield.referencedfield;
		this.group = targetfield.group;
		this.isfilenamefield = targetfield.isfilenamefield;
		this.fieldattribute = targetfield.fieldattribute;
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
     * Obtiene el valor de la propiedad businessname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSNAME() {
        return businessname;
    }

    /**
     * Define el valor de la propiedad businessname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSNAME(String value) {
        this.businessname = value;
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
     * Obtiene el valor de la propiedad datatype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATATYPE() {
        return datatype;
    }

    /**
     * Define el valor de la propiedad datatype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATATYPE(String value) {
        this.datatype = value;
    }

    /**
     * Obtiene el valor de la propiedad keytype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKEYTYPE() {
        return keytype;
    }

    /**
     * Define el valor de la propiedad keytype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKEYTYPE(String value) {
        this.keytype = value;
    }

    /**
     * Obtiene el valor de la propiedad precision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRECISION() {
        return precision;
    }

    /**
     * Define el valor de la propiedad precision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRECISION(String value) {
        this.precision = value;
    }

    /**
     * Obtiene el valor de la propiedad scale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCALE() {
        return scale;
    }

    /**
     * Define el valor de la propiedad scale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCALE(String value) {
        this.scale = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDNUMBER() {
        return fieldnumber;
    }

    /**
     * Define el valor de la propiedad fieldnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDNUMBER(String value) {
        this.fieldnumber = value;
    }

    /**
     * Obtiene el valor de la propiedad nullable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNULLABLE() {
        return nullable;
    }

    /**
     * Define el valor de la propiedad nullable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNULLABLE(String value) {
        this.nullable = value;
    }

    /**
     * Obtiene el valor de la propiedad picturetext.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPICTURETEXT() {
        return picturetext;
    }

    /**
     * Define el valor de la propiedad picturetext.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPICTURETEXT(String value) {
        this.picturetext = value;
    }

    /**
     * Obtiene el valor de la propiedad referencedtable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCEDTABLE() {
        return referencedtable;
    }

    /**
     * Define el valor de la propiedad referencedtable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCEDTABLE(String value) {
        this.referencedtable = value;
    }

    /**
     * Obtiene el valor de la propiedad referencedfield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCEDFIELD() {
        return referencedfield;
    }

    /**
     * Define el valor de la propiedad referencedfield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCEDFIELD(String value) {
        this.referencedfield = value;
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
     * Obtiene el valor de la propiedad isfilenamefield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISFILENAMEFIELD() {
        return isfilenamefield;
    }

    /**
     * Define el valor de la propiedad isfilenamefield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISFILENAMEFIELD(String value) {
        this.isfilenamefield = value;
    }

    /**
     * Gets the value of the fieldattribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldattribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFIELDATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FIELDATTRIBUTE }
     * 
     * 
     */
    public List<FIELDATTRIBUTE> getFIELDATTRIBUTE() {
        if (fieldattribute == null) {
            fieldattribute = new ArrayList<FIELDATTRIBUTE>();
        }
        return this.fieldattribute;
    }

}
