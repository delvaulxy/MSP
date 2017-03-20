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
    "flatfile",
    "xmlinfo",
    "erpsrcinfo",
    "group",
    "tableattribute",
    "sourcefield",
    "metadataextension"
})
@XmlRootElement(name = "SOURCE")
public class SOURCE {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DBDNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dbdname;
    @XmlAttribute(name = "BUSINESSNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String businessname;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "OBJECTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String objectversion;
    @XmlAttribute(name = "OWNERNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ownername;
    @XmlAttribute(name = "IBMCOMP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ibmcomp;
    @XmlAttribute(name = "DATABASETYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String databasetype;
    @XmlAttribute(name = "DATABASE_SUBTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String databasesubtype;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlAttribute(name = "COMPONENTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String componentversion;
    @XmlAttribute(name = "CRCVALUE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String crcvalue;
    @XmlElement(name = "FLATFILE")
    protected FLATFILE flatfile;
    @XmlElement(name = "XMLINFO")
    protected XMLINFO xmlinfo;
    @XmlElement(name = "ERPSRCINFO")
    protected ERPSRCINFO erpsrcinfo;
    @XmlElement(name = "GROUP")
    protected List<GROUP> group;
    @XmlElement(name = "TABLEATTRIBUTE")
    protected List<TABLEATTRIBUTE> tableattribute;
    @XmlElement(name = "SOURCEFIELD")
    protected List<SOURCEFIELD> sourcefield;
    @XmlElement(name = "METADATAEXTENSION")
    protected List<METADATAEXTENSION> metadataextension;

    public SOURCE() {
		super();
	}
    
    
    public SOURCE(String name, String dbdname, String businessname, String description, String objectversion,
			String ownername, String databasetype, String versionnumber, List<SOURCEFIELD> sourcefield) {
		super();
		this.name = name;
		this.dbdname = dbdname;
		this.businessname = businessname;
		this.description = description;
		this.objectversion = objectversion;
		this.ownername = ownername;
		this.databasetype = databasetype;
		this.versionnumber = versionnumber;
		this.sourcefield = sourcefield;
	}
  
    public SOURCE(String name, String dbdname, String businessname, String description, String objectversion,
			String ownername, String databasetype, String versionnumber) {
		super();
		this.name = name;
		this.dbdname = dbdname;
		this.businessname = businessname;
		this.description = description;
		this.objectversion = objectversion;
		this.ownername = ownername;
		this.databasetype = databasetype;
		this.versionnumber = versionnumber;
	}

    public SOURCE(String name, String dbdname, String businessname, String description, String objectversion,
			String ownername, String ibmcomp, String databasetype, String databasesubtype, String versionnumber,
			String componentversion, String crcvalue, FLATFILE flatfile, XMLINFO xmlinfo, ERPSRCINFO erpsrcinfo,
			List<GROUP> group, List<TABLEATTRIBUTE> tableattribute, List<SOURCEFIELD> sourcefield,
			List<METADATAEXTENSION> metadataextension) {
		super();
		this.name = name;
		this.dbdname = dbdname;
		this.businessname = businessname;
		this.description = description;
		this.objectversion = objectversion;
		this.ownername = ownername;
		this.ibmcomp = ibmcomp;
		this.databasetype = databasetype;
		this.databasesubtype = databasesubtype;
		this.versionnumber = versionnumber;
		this.componentversion = componentversion;
		this.crcvalue = crcvalue;
		this.flatfile = flatfile;
		this.xmlinfo = xmlinfo;
		this.erpsrcinfo = erpsrcinfo;
		this.group = group;
		this.tableattribute = tableattribute;
		this.sourcefield = sourcefield;
		this.metadataextension = metadataextension;
	}
    
    public SOURCE(SOURCE source) {
		super();
		this.name = source.name;
		this.dbdname = source.dbdname;
		this.businessname = source.businessname;
		this.description = source.description;
		this.objectversion = source.objectversion;
		this.ownername = source.ownername;
		this.ibmcomp = source.ibmcomp;
		this.databasetype = source.databasetype;
		this.databasesubtype = source.databasesubtype;
		this.versionnumber = source.versionnumber;
		this.componentversion = source.componentversion;
		this.crcvalue = source.crcvalue;
		this.flatfile = source.flatfile;
		this.xmlinfo = source.xmlinfo;
		this.erpsrcinfo = source.erpsrcinfo;
		this.group = source.group;
		this.tableattribute = source.tableattribute;
		this.sourcefield = source.sourcefield;
		this.metadataextension = source.metadataextension;
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
     * Obtiene el valor de la propiedad dbdname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBDNAME() {
        return dbdname;
    }

    /**
     * Define el valor de la propiedad dbdname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBDNAME(String value) {
        this.dbdname = value;
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
     * Obtiene el valor de la propiedad ownername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOWNERNAME() {
        return ownername;
    }

    /**
     * Define el valor de la propiedad ownername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOWNERNAME(String value) {
        this.ownername = value;
    }

    /**
     * Obtiene el valor de la propiedad ibmcomp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBMCOMP() {
        return ibmcomp;
    }

    /**
     * Define el valor de la propiedad ibmcomp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBMCOMP(String value) {
        this.ibmcomp = value;
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
     * Obtiene el valor de la propiedad databasesubtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATABASESUBTYPE() {
        return databasesubtype;
    }

    /**
     * Define el valor de la propiedad databasesubtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATABASESUBTYPE(String value) {
        this.databasesubtype = value;
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
     * Obtiene el valor de la propiedad erpsrcinfo.
     * 
     * @return
     *     possible object is
     *     {@link ERPSRCINFO }
     *     
     */
    public ERPSRCINFO getERPSRCINFO() {
        return erpsrcinfo;
    }

    /**
     * Define el valor de la propiedad erpsrcinfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ERPSRCINFO }
     *     
     */
    public void setERPSRCINFO(ERPSRCINFO value) {
        this.erpsrcinfo = value;
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

		if (v instanceof SOURCE){
			SOURCE ptr = (SOURCE) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getDBDNAME() && !ptr.getDBDNAME().equals(this.dbdname)){
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
			if(null!=ptr.getOWNERNAME() && !ptr.getOWNERNAME().equals(this.ownername)){
				retVal = false;
			}
			if(null!=ptr.getIBMCOMP() && !ptr.getIBMCOMP().equals(this.ibmcomp)){
				retVal = false;
			}
			if(null!=ptr.getDATABASETYPE() && !ptr.getDATABASETYPE().equals(this.databasetype)){
				retVal = false;
			}
			if(null!=ptr.getDATABASESUBTYPE() && !ptr.getDATABASESUBTYPE().equals(this.databasesubtype)){
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
			if(null!=ptr.getFLATFILE() && !ptr.getFLATFILE().equals(this.flatfile)){
				retVal = false;
			}
			if(null!=ptr.getXMLINFO() && !ptr.getXMLINFO().equals(this.xmlinfo)){
				retVal = false;
			}
			if(null!=ptr.getERPSRCINFO() && !ptr.getERPSRCINFO().equals(this.erpsrcinfo)){
				retVal = false;
			}
			if(null!=ptr.getTABLEATTRIBUTE() && !ptr.getTABLEATTRIBUTE().equals(this.tableattribute) && !ptr.getTABLEATTRIBUTE().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getSOURCEFIELD() && !ptr.getSOURCEFIELD().equals(this.sourcefield) && !ptr.getSOURCEFIELD().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getMETADATAEXTENSION() && !ptr.getMETADATAEXTENSION().equals(this.metadataextension) && !ptr.getMETADATAEXTENSION().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getGROUP() && !ptr.getGROUP().equals(this.group) && !ptr.getGROUP().isEmpty()){
				retVal = false;
			}
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,dbdname,businessname,description,objectversion,ownername,ibmcomp,databasetype,databasesubtype,versionnumber,componentversion,crcvalue,flatfile,xmlinfo,erpsrcinfo,group,tableattribute,sourcefield,metadataextension);
	}

}
