//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    "sourcefield",
    "fieldattribute"
})
@XmlRootElement(name = "SOURCEFIELD")
public class SOURCEFIELD {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "BUSINESSNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String businessname;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "DATATYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "KEYTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String keytype;
    @XmlAttribute(name = "PRECISION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "SCALE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scale;
    @XmlAttribute(name = "NULLABLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nullable;
    @XmlAttribute(name = "USAGE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String usage;
    @XmlAttribute(name = "USAGE_FLAGS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String usageflags;
    @XmlAttribute(name = "LEVEL")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String level;
    @XmlAttribute(name = "FIELDTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fieldtype;
    @XmlAttribute(name = "PICTURETEXT")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String picturetext;
    @XmlAttribute(name = "OCCURS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String occurs;
    @XmlAttribute(name = "REDEFINES")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String redefines;
    @XmlAttribute(name = "REFERENCEDTABLE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referencedtable;
    @XmlAttribute(name = "REFERENCEDFIELD")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referencedfield;
    @XmlAttribute(name = "REFERENCEDDBD")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referenceddbd;
    @XmlAttribute(name = "OFFSET")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String offset;
    @XmlAttribute(name = "LENGTH")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String length;
    @XmlAttribute(name = "PHYSICALOFFSET")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String physicaloffset;
    @XmlAttribute(name = "PHYSICALLENGTH")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String physicallength;
    @XmlAttribute(name = "FIELDNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fieldnumber;
    @XmlAttribute(name = "FIELDPROPERTY")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fieldproperty;
    @XmlAttribute(name = "HIDDEN")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String hidden;
    @XmlAttribute(name = "GROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String group;
    @XmlAttribute(name = "SHIFTSTATE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String shiftstate;
    @XmlElement(name = "SOURCEFIELD")
    protected List<SOURCEFIELD> sourcefield;
    @XmlElement(name = "FIELDATTRIBUTE")
    protected List<FIELDATTRIBUTE> fieldattribute;


    
    public SOURCEFIELD() {
		super();
	}
    
    public SOURCEFIELD(String name, String businessname, String description, String datatype, String keytype,
			String precision, String scale, String nullable, String usageflags, String level, String fieldtype,
			String picturetext, String occurs, String length, String physicaloffset, String physicallength,
			String fieldnumber, String fieldproperty, String hidden) {
		super();
		this.name = name;
		this.businessname = businessname;
		this.description = description;
		this.datatype = datatype;
		this.keytype = keytype;
		this.precision = precision;
		this.scale = scale;
		this.nullable = nullable;
		this.usageflags = usageflags;
		this.level = level;
		this.fieldtype = fieldtype;
		this.picturetext = picturetext;
		this.occurs = occurs;
		this.length = length;
		this.physicaloffset = physicaloffset;
		this.physicallength = physicallength;
		this.fieldnumber = fieldnumber;
		this.fieldproperty = fieldproperty;
		this.hidden = hidden;
	}

	public SOURCEFIELD(String name, String businessname, String description, String datatype, String keytype,
			String precision, String scale, String nullable, String usage, String usageflags, String level,
			String fieldtype, String picturetext, String occurs, String redefines, String referencedtable,
			String referencedfield, String referenceddbd, String offset, String length, String physicaloffset,
			String physicallength, String fieldnumber, String fieldproperty, String hidden, String group,
			String shiftstate, List<SOURCEFIELD> sourcefield, List<FIELDATTRIBUTE> fieldattribute) {
		super();
		this.name = name;
		this.businessname = businessname;
		this.description = description;
		this.datatype = datatype;
		this.keytype = keytype;
		this.precision = precision;
		this.scale = scale;
		this.nullable = nullable;
		this.usage = usage;
		this.usageflags = usageflags;
		this.level = level;
		this.fieldtype = fieldtype;
		this.picturetext = picturetext;
		this.occurs = occurs;
		this.redefines = redefines;
		this.referencedtable = referencedtable;
		this.referencedfield = referencedfield;
		this.referenceddbd = referenceddbd;
		this.offset = offset;
		this.length = length;
		this.physicaloffset = physicaloffset;
		this.physicallength = physicallength;
		this.fieldnumber = fieldnumber;
		this.fieldproperty = fieldproperty;
		this.hidden = hidden;
		this.group = group;
		this.shiftstate = shiftstate;
		this.sourcefield = sourcefield;
		this.fieldattribute = fieldattribute;
	}
    
    public SOURCEFIELD(SOURCEFIELD sourcefield) {
		super();
		this.name = sourcefield.name;
		this.businessname = sourcefield.businessname;
		this.description = sourcefield.description;
		this.datatype = sourcefield.datatype;
		this.keytype = sourcefield.keytype;
		this.precision = sourcefield.precision;
		this.scale = sourcefield.scale;
		this.nullable = sourcefield.nullable;
		this.usage = sourcefield.usage;
		this.usageflags = sourcefield.usageflags;
		this.level = sourcefield.level;
		this.fieldtype = sourcefield.fieldtype;
		this.picturetext = sourcefield.picturetext;
		this.occurs = sourcefield.occurs;
		this.redefines = sourcefield.redefines;
		this.referencedtable = sourcefield.referencedtable;
		this.referencedfield = sourcefield.referencedfield;
		this.referenceddbd = sourcefield.referenceddbd;
		this.offset = sourcefield.offset;
		this.length = sourcefield.length;
		this.physicaloffset = sourcefield.physicaloffset;
		this.physicallength = sourcefield.physicallength;
		this.fieldnumber = sourcefield.fieldnumber;
		this.fieldproperty = sourcefield.fieldproperty;
		this.hidden = sourcefield.hidden;
		this.group = sourcefield.group;
		this.shiftstate = sourcefield.shiftstate;
		this.sourcefield = sourcefield.sourcefield;
		this.fieldattribute = sourcefield.fieldattribute;
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
     * Obtiene el valor de la propiedad usage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSAGE() {
        return usage;
    }

    /**
     * Define el valor de la propiedad usage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSAGE(String value) {
        this.usage = value;
    }

    /**
     * Obtiene el valor de la propiedad usageflags.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSAGEFLAGS() {
        return usageflags;
    }

    /**
     * Define el valor de la propiedad usageflags.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSAGEFLAGS(String value) {
        this.usageflags = value;
    }

    /**
     * Obtiene el valor de la propiedad level.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEVEL() {
        return level;
    }

    /**
     * Define el valor de la propiedad level.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEVEL(String value) {
        this.level = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDTYPE() {
        return fieldtype;
    }

    /**
     * Define el valor de la propiedad fieldtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDTYPE(String value) {
        this.fieldtype = value;
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
     * Obtiene el valor de la propiedad occurs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCCURS() {
        return occurs;
    }

    /**
     * Define el valor de la propiedad occurs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCCURS(String value) {
        this.occurs = value;
    }

    /**
     * Obtiene el valor de la propiedad redefines.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREDEFINES() {
        return redefines;
    }

    /**
     * Define el valor de la propiedad redefines.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREDEFINES(String value) {
        this.redefines = value;
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
     * Obtiene el valor de la propiedad referenceddbd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCEDDBD() {
        return referenceddbd;
    }

    /**
     * Define el valor de la propiedad referenceddbd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCEDDBD(String value) {
        this.referenceddbd = value;
    }

    /**
     * Obtiene el valor de la propiedad offset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFSET() {
        return offset;
    }

    /**
     * Define el valor de la propiedad offset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFSET(String value) {
        this.offset = value;
    }

    /**
     * Obtiene el valor de la propiedad length.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLENGTH() {
        return length;
    }

    /**
     * Define el valor de la propiedad length.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLENGTH(String value) {
        this.length = value;
    }

    /**
     * Obtiene el valor de la propiedad physicaloffset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHYSICALOFFSET() {
        return physicaloffset;
    }

    /**
     * Define el valor de la propiedad physicaloffset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHYSICALOFFSET(String value) {
        this.physicaloffset = value;
    }

    /**
     * Obtiene el valor de la propiedad physicallength.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHYSICALLENGTH() {
        return physicallength;
    }

    /**
     * Define el valor de la propiedad physicallength.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHYSICALLENGTH(String value) {
        this.physicallength = value;
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
     * Obtiene el valor de la propiedad fieldproperty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDPROPERTY() {
        return fieldproperty;
    }

    /**
     * Define el valor de la propiedad fieldproperty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDPROPERTY(String value) {
        this.fieldproperty = value;
    }

    /**
     * Obtiene el valor de la propiedad hidden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHIDDEN() {
        return hidden;
    }

    /**
     * Define el valor de la propiedad hidden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHIDDEN(String value) {
        this.hidden = value;
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
     * Obtiene el valor de la propiedad shiftstate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIFTSTATE() {
        return shiftstate;
    }

    /**
     * Define el valor de la propiedad shiftstate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIFTSTATE(String value) {
        this.shiftstate = value;
    }

    /**
     * Gets the value of the sourcefield property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourcefield property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOURCEFIELD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SOURCEFIELD }
     * 
     * 
     */
    public List<SOURCEFIELD> getSOURCEFIELD() {
        if (sourcefield == null) {
            sourcefield = new ArrayList<SOURCEFIELD>();
        }
        return this.sourcefield;
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
    @Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof SOURCEFIELD){
			SOURCEFIELD ptr = (SOURCEFIELD) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getBUSINESSNAME() && !ptr.getBUSINESSNAME().equals(this.businessname)){
				retVal = false;
			}
			if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.description)){
				retVal = false;
			}
			if(null!=ptr.getDATATYPE() && !ptr.getDATATYPE().equals(this.datatype)){
				retVal = false;
			}
			if(null!=ptr.getKEYTYPE() && !ptr.getKEYTYPE().equals(this.keytype)){
				retVal = false;
			}
			if(null!=ptr.getPRECISION() && !ptr.getPRECISION().equals(this.precision)){
				retVal = false;
			}
			if(null!=ptr.getSCALE() && !ptr.getSCALE().equals(this.scale)){
				retVal = false;
			}
			if(null!=ptr.getNULLABLE() && !ptr.getNULLABLE().equals(this.nullable)){
				retVal = false;
			}
			if(null!=ptr.getUSAGEFLAGS() && !ptr.getUSAGEFLAGS().equals(this.usageflags)){
				retVal = false;
			}
			if(null!=ptr.getLEVEL() && !ptr.getLEVEL().equals(this.level)){
				retVal = false;
			}
			if(null!=ptr.getFIELDTYPE() && !ptr.getFIELDTYPE().equals(this.fieldtype)){
				retVal = false;
			}
			if(null!=ptr.getPICTURETEXT() && !ptr.getPICTURETEXT().equals(this.picturetext)){
				retVal = false;
			}
			if(null!=ptr.getOCCURS() && !ptr.getOCCURS().equals(this.occurs)){
				retVal = false;
			}
			if(null!=ptr.getLENGTH() && !ptr.getLENGTH().equals(this.length)){
				retVal = false;
			}
			if(null!=ptr.getPHYSICALOFFSET() && !ptr.getPHYSICALOFFSET().equals(this.physicaloffset)){
				retVal = false;
			}
			if(null!=ptr.getPHYSICALLENGTH() && !ptr.getPHYSICALLENGTH().equals(this.physicallength)){
				retVal = false;
			}
			if(null!=ptr.getFIELDNUMBER() && !ptr.getFIELDNUMBER().equals(this.fieldnumber)){
				retVal = false;
			}
			if(null!=ptr.getFIELDPROPERTY() && !ptr.getFIELDPROPERTY().equals(this.fieldproperty) && !ptr.getFIELDPROPERTY().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getHIDDEN() && !ptr.getHIDDEN().equals(this.hidden)){
				retVal = false;
			}
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,businessname,description,datatype,keytype,precision,scale,nullable,usageflags,level,fieldtype,picturetext,occurs,length,physicaloffset,physicallength,fieldnumber,fieldproperty,hidden);
	}

}
