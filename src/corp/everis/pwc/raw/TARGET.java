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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "keyword",
    "flatfile",
    "xmlinfo",
    "group",
    "targetfield",
    "targetindex",
    "tableattribute",
    "metadataextension"
})
@XmlRootElement(name = "TARGET")
public class TARGET {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "BUSINESSNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String businessname;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "OBJECTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String objectversion;
    @XmlAttribute(name = "CONSTRAINT")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String constraint;
    @XmlAttribute(name = "TABLEOPTIONS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tableoptions;
    @XmlAttribute(name = "TABLETYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tabletype;
    @XmlAttribute(name = "DATABASETYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String databasetype;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlAttribute(name = "COMPONENTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String componentversion;
    @XmlAttribute(name = "CRCVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String crcvalue;
    @XmlElement(name = "KEYWORD")
    protected List<KEYWORD> keyword;
    @XmlElement(name = "FLATFILE")
    protected FLATFILE flatfile;
    @XmlElement(name = "XMLINFO")
    protected XMLINFO xmlinfo;
    @XmlElement(name = "GROUP")
    protected List<GROUP> group;
    @XmlElement(name = "TARGETFIELD")
    protected List<TARGETFIELD> targetfield;
    @XmlElement(name = "TARGETINDEX")
    protected List<TARGETINDEX> targetindex;
    @XmlElement(name = "TABLEATTRIBUTE")
    protected List<TABLEATTRIBUTE> tableattribute;
    @XmlElement(name = "METADATAEXTENSION")
    protected List<METADATAEXTENSION> metadataextension;


    
    public TARGET(){}
    public TARGET(String name, String objectversion, String databasetype, String versionnumber) {
		super();
		this.name = name;
		this.objectversion = objectversion;
		this.databasetype = databasetype;
		this.versionnumber = versionnumber;
	}
    public TARGET(String name, String objectversion, String databasetype, String versionnumber,
			List<TARGETFIELD> targetfield) {
		super();
		this.name = name;
		this.objectversion = objectversion;
		this.databasetype = databasetype;
		this.versionnumber = versionnumber;
		this.targetfield = targetfield;
	}

    public TARGET(String name, String businessname, String description, String objectversion, String constraint,
			String tableoptions, String tabletype, String databasetype, String versionnumber, String componentversion,
			String crcvalue, List<KEYWORD> keyword, FLATFILE flatfile, XMLINFO xmlinfo, List<GROUP> group,
			List<TARGETFIELD> targetfield, List<TARGETINDEX> targetindex, List<TABLEATTRIBUTE> tableattribute,
			List<METADATAEXTENSION> metadataextension) {
		super();
		this.name = name;
		this.businessname = businessname;
		this.description = description;
		this.objectversion = objectversion;
		this.constraint = constraint;
		this.tableoptions = tableoptions;
		this.tabletype = tabletype;
		this.databasetype = databasetype;
		this.versionnumber = versionnumber;
		this.componentversion = componentversion;
		this.crcvalue = crcvalue;
		this.keyword = keyword;
		this.flatfile = flatfile;
		this.xmlinfo = xmlinfo;
		this.group = group;
		this.targetfield = targetfield;
		this.targetindex = targetindex;
		this.tableattribute = tableattribute;
		this.metadataextension = metadataextension;
	}
    public TARGET(TARGET target) {
		super();
		this.name = target.name;
		this.businessname = target.businessname;
		this.description = target.description;
		this.objectversion = target.objectversion;
		this.constraint = target.constraint;
		this.tableoptions = target.tableoptions;
		this.tabletype = target.tabletype;
		this.databasetype = target.databasetype;
		this.versionnumber = target.versionnumber;
		this.componentversion = target.componentversion;
		this.crcvalue = target.crcvalue;
		this.keyword = target.keyword;
		this.flatfile = target.flatfile;
		this.xmlinfo = target.xmlinfo;
		this.group = target.group;
		this.targetfield = target.targetfield;
		this.targetindex = target.targetindex;
		this.tableattribute = target.tableattribute;
		this.metadataextension = target.metadataextension;
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
     * Obtiene el valor de la propiedad objectversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTVERSION() {
        return objectversion;
    }

    /**
     * Define el valor de la propiedad objectversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTVERSION(String value) {
        this.objectversion = value;
    }

    /**
     * Obtiene el valor de la propiedad constraint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONSTRAINT() {
        return constraint;
    }

    /**
     * Define el valor de la propiedad constraint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONSTRAINT(String value) {
        this.constraint = value;
    }

    /**
     * Obtiene el valor de la propiedad tableoptions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTABLEOPTIONS() {
        return tableoptions;
    }

    /**
     * Define el valor de la propiedad tableoptions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTABLEOPTIONS(String value) {
        this.tableoptions = value;
    }

    /**
     * Obtiene el valor de la propiedad tabletype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTABLETYPE() {
        return tabletype;
    }

    /**
     * Define el valor de la propiedad tabletype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTABLETYPE(String value) {
        this.tabletype = value;
    }

    /**
     * Obtiene el valor de la propiedad databasetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATABASETYPE() {
        return databasetype;
    }

    /**
     * Define el valor de la propiedad databasetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATABASETYPE(String value) {
        this.databasetype = value;
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
     * Obtiene el valor de la propiedad componentversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPONENTVERSION() {
        return componentversion;
    }

    /**
     * Define el valor de la propiedad componentversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPONENTVERSION(String value) {
        this.componentversion = value;
    }

    /**
     * Obtiene el valor de la propiedad crcvalue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRCVALUE() {
        return crcvalue;
    }

    /**
     * Define el valor de la propiedad crcvalue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRCVALUE(String value) {
        this.crcvalue = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKEYWORD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KEYWORD }
     * 
     * 
     */
    public List<KEYWORD> getKEYWORD() {
        if (keyword == null) {
            keyword = new ArrayList<KEYWORD>();
        }
        return this.keyword;
    }

    /**
     * Obtiene el valor de la propiedad flatfile.
     * 
     * @return
     *     possible object is
     *     {@link FLATFILE }
     *     
     */
    public FLATFILE getFLATFILE() {
        return flatfile;
    }

    /**
     * Define el valor de la propiedad flatfile.
     * 
     * @param value
     *     allowed object is
     *     {@link FLATFILE }
     *     
     */
    public void setFLATFILE(FLATFILE value) {
        this.flatfile = value;
    }

    /**
     * Obtiene el valor de la propiedad xmlinfo.
     * 
     * @return
     *     possible object is
     *     {@link XMLINFO }
     *     
     */
    public XMLINFO getXMLINFO() {
        return xmlinfo;
    }

    /**
     * Define el valor de la propiedad xmlinfo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLINFO }
     *     
     */
    public void setXMLINFO(XMLINFO value) {
        this.xmlinfo = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGROUP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GROUP }
     * 
     * 
     */
    public List<GROUP> getGROUP() {
        if (group == null) {
            group = new ArrayList<GROUP>();
        }
        return this.group;
    }

    /**
     * Gets the value of the targetfield property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetfield property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTARGETFIELD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TARGETFIELD }
     * 
     * 
     */
    public List<TARGETFIELD> getTARGETFIELD() {
        if (targetfield == null) {
            targetfield = new ArrayList<TARGETFIELD>();
        }
        return this.targetfield;
    }

    /**
     * Gets the value of the targetindex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetindex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTARGETINDEX().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TARGETINDEX }
     * 
     * 
     */
    public List<TARGETINDEX> getTARGETINDEX() {
        if (targetindex == null) {
            targetindex = new ArrayList<TARGETINDEX>();
        }
        return this.targetindex;
    }

    /**
     * Gets the value of the tableattribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableattribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTABLEATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TABLEATTRIBUTE }
     * 
     * 
     */
    public List<TABLEATTRIBUTE> getTABLEATTRIBUTE() {
        if (tableattribute == null) {
            tableattribute = new ArrayList<TABLEATTRIBUTE>();
        }
        return this.tableattribute;
    }

    /**
     * Gets the value of the metadataextension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadataextension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMETADATAEXTENSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link METADATAEXTENSION }
     * 
     * 
     */
    public List<METADATAEXTENSION> getMETADATAEXTENSION() {
        if (metadataextension == null) {
            metadataextension = new ArrayList<METADATAEXTENSION>();
        }
        return this.metadataextension;
    }
	@Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof TARGET){
			TARGET ptr = (TARGET) v;
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
			if(null!=ptr.getOBJECTVERSION() && !ptr.getOBJECTVERSION().equals(this.objectversion)){
				retVal = false;
			}
			if(null!=ptr.getCONSTRAINT() && !ptr.getCONSTRAINT().equals(this.constraint)){
				retVal = false;
			}
			if(null!=ptr.getTABLEOPTIONS() && !ptr.getTABLEOPTIONS().equals(this.tableoptions)){
				retVal = false;
			}
			if(null!=ptr.getTABLETYPE() && !ptr.getTABLETYPE().equals(this.tabletype)){
				retVal = false;
			}
			if(null!=ptr.getDATABASETYPE() && !ptr.getDATABASETYPE().equals(this.databasetype)){
				retVal = false;
			}
			if(null!=ptr.getVERSIONNUMBER() && !ptr.getVERSIONNUMBER().equals(this.versionnumber)){
				retVal = false;
			}
			if(null!=ptr.getCOMPONENTVERSION() && !ptr.getCOMPONENTVERSION().equals(this.componentversion)){
				retVal = false;
			}
			if(null!=ptr.getCRCVALUE() && !ptr.getCRCVALUE().equals(this.crcvalue)){
				retVal = false;
			}
			if(null!=ptr.getKEYWORD() && !ptr.getKEYWORD().equals(this.keyword) && !ptr.getKEYWORD().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getFLATFILE() && !ptr.getFLATFILE().equals(this.flatfile)){
				retVal = false;
			}
			if(null!=ptr.getXMLINFO() && !ptr.getXMLINFO().equals(this.xmlinfo)){
				retVal = false;
			}
			if(null!=ptr.getGROUP() && !ptr.getGROUP().equals(this.group)){
				retVal = false;
			}
			if(null!=ptr.getTARGETFIELD() && !ptr.getTARGETFIELD().equals(this.targetfield) && !ptr.getTARGETFIELD().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getTARGETINDEX() && !ptr.getTARGETINDEX().equals(this.targetindex) && !ptr.getTARGETINDEX().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getTABLEATTRIBUTE() && !ptr.getTABLEATTRIBUTE().equals(this.tableattribute) && !ptr.getTABLEATTRIBUTE().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getMETADATAEXTENSION() && !ptr.getMETADATAEXTENSION().equals(this.metadataextension) && !ptr.getMETADATAEXTENSION().isEmpty()){
				retVal = false;
			}
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, businessname, description, objectversion, constraint, tableoptions, tabletype, databasetype, versionnumber, componentversion, crcvalue, keyword, flatfile, xmlinfo, group, targetfield, targetindex, tableattribute, metadataextension);
	}
}
