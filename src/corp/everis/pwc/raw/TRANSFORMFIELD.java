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
    "transformfieldattr"
})
@XmlRootElement(name = "TRANSFORMFIELD")
public class TRANSFORMFIELD {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "DATATYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "PORTTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String porttype;
    @XmlAttribute(name = "PRECISION", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "SCALE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scale;
    @XmlAttribute(name = "PICTURETEXT")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String picturetext;
    @XmlAttribute(name = "DEFAULTVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String defaultvalue;
    @XmlAttribute(name = "EXPRESSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expression;
    @XmlAttribute(name = "EXPRESSIONTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expressiontype;
    @XmlAttribute(name = "EXPRESSION_DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expressiondescription;
    @XmlAttribute(name = "FIELDNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fieldnumber;
    @XmlAttribute(name = "REF_SOURCE_FIELD")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refsourcefield;
    @XmlAttribute(name = "MAPPLETGROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mappletgroup;
    @XmlAttribute(name = "REF_FIELD")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String reffield;
    @XmlAttribute(name = "REF_TRANSFORMATION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String reftransformation;
    @XmlAttribute(name = "REF_INSTANCETYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refinstancetype;
    @XmlAttribute(name = "SEQUENCE_GENERATOR_VALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sequencegeneratorvalue;
    @XmlAttribute(name = "GROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String group;
    @XmlAttribute(name = "OUTPUTGROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String outputgroup;
    @XmlAttribute(name = "ISSORTKEY")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String issortkey;
    @XmlAttribute(name = "SORTDIRECTION")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String sortdirection;
    @XmlAttribute(name = "IGNORE_NULL_INPUTS")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ignorenullinputs;
    @XmlAttribute(name = "IGNORE_IN_COMPARE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ignoreincompare;
    @XmlElement(name = "TRANSFORMFIELDATTR")
    protected List<TRANSFORMFIELDATTR> transformfieldattr;
    
    public TRANSFORMFIELD(String name, String datatype, String porttype, String precision, String scale) {
		super();
		this.name = name;
		this.datatype = datatype;
		this.porttype = porttype;
		this.precision = precision;
		this.scale = scale;
	}

	public TRANSFORMFIELD(String name, String description, String datatype, String porttype, String precision,
			String scale, String picturetext, String defaultvalue, String expression, String expressiontype,
			String expressiondescription, String fieldnumber, String refsourcefield, String mappletgroup,
			String reffield, String reftransformation, String refinstancetype, String sequencegeneratorvalue,
			String group, String outputgroup, String issortkey, String sortdirection, String ignorenullinputs,
			String ignoreincompare, List<TRANSFORMFIELDATTR> transformfieldattr) {
		super();
		this.name = name;
		this.description = description;
		this.datatype = datatype;
		this.porttype = porttype;
		this.precision = precision;
		this.scale = scale;
		this.picturetext = picturetext;
		this.defaultvalue = defaultvalue;
		this.expression = expression;
		this.expressiontype = expressiontype;
		this.expressiondescription = expressiondescription;
		this.fieldnumber = fieldnumber;
		this.refsourcefield = refsourcefield;
		this.mappletgroup = mappletgroup;
		this.reffield = reffield;
		this.reftransformation = reftransformation;
		this.refinstancetype = refinstancetype;
		this.sequencegeneratorvalue = sequencegeneratorvalue;
		this.group = group;
		this.outputgroup = outputgroup;
		this.issortkey = issortkey;
		this.sortdirection = sortdirection;
		this.ignorenullinputs = ignorenullinputs;
		this.ignoreincompare = ignoreincompare;
		this.transformfieldattr = transformfieldattr;
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
     * Obtiene el valor de la propiedad porttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPORTTYPE() {
        return porttype;
    }

    /**
     * Define el valor de la propiedad porttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPORTTYPE(String value) {
        this.porttype = value;
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
     * Obtiene el valor de la propiedad defaultvalue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEFAULTVALUE() {
        return defaultvalue;
    }

    /**
     * Define el valor de la propiedad defaultvalue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEFAULTVALUE(String value) {
        this.defaultvalue = value;
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

    /**
     * Obtiene el valor de la propiedad expressiontype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPRESSIONTYPE() {
        return expressiontype;
    }

    /**
     * Define el valor de la propiedad expressiontype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPRESSIONTYPE(String value) {
        this.expressiontype = value;
    }

    /**
     * Obtiene el valor de la propiedad expressiondescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPRESSIONDESCRIPTION() {
        return expressiondescription;
    }

    /**
     * Define el valor de la propiedad expressiondescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPRESSIONDESCRIPTION(String value) {
        this.expressiondescription = value;
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
     * Obtiene el valor de la propiedad refsourcefield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFSOURCEFIELD() {
        return refsourcefield;
    }

    /**
     * Define el valor de la propiedad refsourcefield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFSOURCEFIELD(String value) {
        this.refsourcefield = value;
    }

    /**
     * Obtiene el valor de la propiedad mappletgroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAPPLETGROUP() {
        return mappletgroup;
    }

    /**
     * Define el valor de la propiedad mappletgroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAPPLETGROUP(String value) {
        this.mappletgroup = value;
    }

    /**
     * Obtiene el valor de la propiedad reffield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFFIELD() {
        return reffield;
    }

    /**
     * Define el valor de la propiedad reffield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFFIELD(String value) {
        this.reffield = value;
    }

    /**
     * Obtiene el valor de la propiedad reftransformation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFTRANSFORMATION() {
        return reftransformation;
    }

    /**
     * Define el valor de la propiedad reftransformation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFTRANSFORMATION(String value) {
        this.reftransformation = value;
    }

    /**
     * Obtiene el valor de la propiedad refinstancetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFINSTANCETYPE() {
        return refinstancetype;
    }

    /**
     * Define el valor de la propiedad refinstancetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFINSTANCETYPE(String value) {
        this.refinstancetype = value;
    }

    /**
     * Obtiene el valor de la propiedad sequencegeneratorvalue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQUENCEGENERATORVALUE() {
        return sequencegeneratorvalue;
    }

    /**
     * Define el valor de la propiedad sequencegeneratorvalue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQUENCEGENERATORVALUE(String value) {
        this.sequencegeneratorvalue = value;
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
     * Obtiene el valor de la propiedad outputgroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPUTGROUP() {
        return outputgroup;
    }

    /**
     * Define el valor de la propiedad outputgroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPUTGROUP(String value) {
        this.outputgroup = value;
    }

    /**
     * Obtiene el valor de la propiedad issortkey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSORTKEY() {
        return issortkey;
    }

    /**
     * Define el valor de la propiedad issortkey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSORTKEY(String value) {
        this.issortkey = value;
    }

    /**
     * Obtiene el valor de la propiedad sortdirection.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSORTDIRECTION() {
        return sortdirection;
    }

    /**
     * Define el valor de la propiedad sortdirection.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSORTDIRECTION(String value) {
        this.sortdirection = value;
    }

    /**
     * Obtiene el valor de la propiedad ignorenullinputs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIGNORENULLINPUTS() {
        return ignorenullinputs;
    }

    /**
     * Define el valor de la propiedad ignorenullinputs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIGNORENULLINPUTS(String value) {
        this.ignorenullinputs = value;
    }

    /**
     * Obtiene el valor de la propiedad ignoreincompare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIGNOREINCOMPARE() {
        return ignoreincompare;
    }

    /**
     * Define el valor de la propiedad ignoreincompare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIGNOREINCOMPARE(String value) {
        this.ignoreincompare = value;
    }

    /**
     * Gets the value of the transformfieldattr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformfieldattr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANSFORMFIELDATTR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANSFORMFIELDATTR }
     * 
     * 
     */
    public List<TRANSFORMFIELDATTR> getTRANSFORMFIELDATTR() {
        if (transformfieldattr == null) {
            transformfieldattr = new ArrayList<TRANSFORMFIELDATTR>();
        }
        return this.transformfieldattr;
    }

    public TRANSFORMFIELD(TRANSFORMFIELD tfCopy){
    	this.name = tfCopy.name;
    	this.description = tfCopy.description;
    	this.datatype = tfCopy.datatype;
    	this.porttype = tfCopy.porttype;
    	this.precision = tfCopy.precision;
    	this.scale = tfCopy.scale;
    	this.picturetext = tfCopy.picturetext;
    	this.defaultvalue = tfCopy.defaultvalue;
    	this.expression = tfCopy.expression;
    	this.expressiontype = tfCopy.expressiontype;
    	this.expressiondescription = tfCopy.expressiondescription;
    	this.fieldnumber = tfCopy.fieldnumber;
    	this.refsourcefield = tfCopy.refsourcefield;
    	this.mappletgroup = tfCopy.mappletgroup;
    	this.reffield = tfCopy.reffield;
    	this.reftransformation = tfCopy.reftransformation;
    	this.refinstancetype = tfCopy.refinstancetype;
    	this.sequencegeneratorvalue = tfCopy.sequencegeneratorvalue;
    	this.group = tfCopy.group;
    	this.outputgroup = tfCopy.outputgroup;
    	this.issortkey = tfCopy.issortkey;
    	this.sortdirection = tfCopy.sortdirection;
    	this.ignorenullinputs = tfCopy.ignorenullinputs;
    	this.ignoreincompare = tfCopy.ignoreincompare;
    	this.transformfieldattr = tfCopy.transformfieldattr;
    }

	public TRANSFORMFIELD() {
		
	}
    @Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof TRANSFORMFIELD){
			TRANSFORMFIELD ptr = (TRANSFORMFIELD) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.getNAME())){
				retVal = false;
			}
			if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.getDESCRIPTION())){
				retVal = false;
			}
			if(null!=ptr.getDATATYPE() && !ptr.getDATATYPE().equals(this.getDATATYPE())){
				retVal = false;
			}
			if(null!=ptr.getPORTTYPE() && !ptr.getPORTTYPE().equals(this.getPORTTYPE())){
				retVal = false;
			}
			if(null!=ptr.getPRECISION() && !ptr.getPRECISION().equals(this.getPRECISION())){
				retVal = false;
			}
			
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,description,datatype,porttype,precision);
	}
 }
