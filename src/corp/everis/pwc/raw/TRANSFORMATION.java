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
		"group",
		"sourcefield",
		"transformfield",
		"tableattribute",
		"initprop",
		"metadataextension",
		"transformfieldattrdef",
		"fielddependency",
		"flatfile",
		"exprmacrodependency"
})
@XmlRootElement(name = "TRANSFORMATION")
public class TRANSFORMATION {
	@XmlAttribute(name = "NAME", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String name;
	@XmlAttribute(name = "DESCRIPTION")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String description;
	@XmlAttribute(name = "TYPE", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String type;
	@XmlAttribute(name = "OBJECTVERSION")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String objectversion;
	@XmlAttribute(name = "REUSABLE")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String reusable;
	@XmlAttribute(name = "ISVSAM_NORMALIZER")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String isvsamnormalizer;
	@XmlAttribute(name = "REF_SOURCE_NAME")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String refsourcename;
	@XmlAttribute(name = "REF_DBD_NAME")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String refdbdname;
	@XmlAttribute(name = "TEMPLATEID")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String templateid;
	@XmlAttribute(name = "TEMPLATENAME")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String templatename;
	@XmlAttribute(name = "PARENT")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String parent;
	@XmlAttribute(name = "PARENT_TYPE")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String parenttype;
	@XmlAttribute(name = "VERSIONNUMBER")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String versionnumber;
	@XmlAttribute(name = "COMPONENTVERSION")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String componentversion;
	@XmlAttribute(name = "CRCVALUE")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String crcvalue;
	@XmlElement(name = "GROUP")
	protected List<GROUP> group;
	@XmlElement(name = "SOURCEFIELD")
	protected List<SOURCEFIELD> sourcefield;
	@XmlElement(name = "TRANSFORMFIELD")
	protected List<TRANSFORMFIELD> transformfield;
	@XmlElement(name = "TABLEATTRIBUTE")
	protected List<TABLEATTRIBUTE> tableattribute;
	@XmlElement(name = "INITPROP")
	protected List<INITPROP> initprop;
	@XmlElement(name = "METADATAEXTENSION")
	protected List<METADATAEXTENSION> metadataextension;
	@XmlElement(name = "TRANSFORMFIELDATTRDEF")
	protected List<TRANSFORMFIELDATTRDEF> transformfieldattrdef;
	@XmlElement(name = "FIELDDEPENDENCY")
	protected List<FIELDDEPENDENCY> fielddependency;
	@XmlElement(name = "FLATFILE")
	protected FLATFILE flatfile;
	@XmlElement(name = "EXPRMACRODEPENDENCY")
	protected List<EXPRMACRODEPENDENCY> exprmacrodependency;

	public TRANSFORMATION(){
		super();
	}
	public TRANSFORMATION(String name, String type, String objectversion, String reusable, String versionnumber) {
		super();
		this.name = name;
		this.type = type;
		this.objectversion = objectversion;
		this.reusable = reusable;
		this.versionnumber = versionnumber;
	}

	public TRANSFORMATION(String name, String description, String type, String objectversion, String reusable,
			String isvsamnormalizer, String refsourcename, String refdbdname, String templateid, String templatename,
			String parent, String parenttype, String versionnumber, String componentversion, String crcvalue,
			List<GROUP> group, List<SOURCEFIELD> sourcefield, List<TRANSFORMFIELD> transformfield,
			List<TABLEATTRIBUTE> tableattribute, List<INITPROP> initprop, List<METADATAEXTENSION> metadataextension,
			List<TRANSFORMFIELDATTRDEF> transformfieldattrdef, List<FIELDDEPENDENCY> fielddependency, FLATFILE flatfile,
			List<EXPRMACRODEPENDENCY> exprmacrodependency) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.objectversion = objectversion;
		this.reusable = reusable;
		this.isvsamnormalizer = isvsamnormalizer;
		this.refsourcename = refsourcename;
		this.refdbdname = refdbdname;
		this.templateid = templateid;
		this.templatename = templatename;
		this.parent = parent;
		this.parenttype = parenttype;
		this.versionnumber = versionnumber;
		this.componentversion = componentversion;
		this.crcvalue = crcvalue;
		this.group = group;
		this.sourcefield = sourcefield;
		this.transformfield = transformfield;
		this.tableattribute = tableattribute;
		this.initprop = initprop;
		this.metadataextension = metadataextension;
		this.transformfieldattrdef = transformfieldattrdef;
		this.fielddependency = fielddependency;
		this.flatfile = flatfile;
		this.exprmacrodependency = exprmacrodependency;
	}
	public TRANSFORMATION(TRANSFORMATION transformation) {
		super();
		this.name = transformation.name;
		this.description = transformation.description;
		this.type = transformation.type;
		this.objectversion = transformation.objectversion;
		this.reusable = transformation.reusable;
		this.isvsamnormalizer = transformation.isvsamnormalizer;
		this.refsourcename = transformation.refsourcename;
		this.refdbdname = transformation.refdbdname;
		this.templateid = transformation.templateid;
		this.templatename = transformation.templatename;
		this.parent = transformation.parent;
		this.parenttype = transformation.parenttype;
		this.versionnumber = transformation.versionnumber;
		this.componentversion = transformation.componentversion;
		this.crcvalue = transformation.crcvalue;
		this.group = transformation.group;
		this.sourcefield = transformation.sourcefield;
		this.transformfield = transformation.transformfield;
		this.tableattribute = transformation.tableattribute;
		this.initprop = transformation.initprop;
		this.metadataextension = transformation.metadataextension;
		this.transformfieldattrdef = transformation.transformfieldattrdef;
		this.fielddependency = transformation.fielddependency;
		this.flatfile = transformation.flatfile;
		this.exprmacrodependency = transformation.exprmacrodependency;
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
	 * Obtiene el valor de la propiedad isvsamnormalizer.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getISVSAMNORMALIZER() {
		return isvsamnormalizer;
	}

	/**
	 * Define el valor de la propiedad isvsamnormalizer.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setISVSAMNORMALIZER(String value) {
		this.isvsamnormalizer = value;
	}

	/**
	 * Obtiene el valor de la propiedad refsourcename.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getREFSOURCENAME() {
		return refsourcename;
	}

	/**
	 * Define el valor de la propiedad refsourcename.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setREFSOURCENAME(String value) {
		this.refsourcename = value;
	}

	/**
	 * Obtiene el valor de la propiedad refdbdname.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getREFDBDNAME() {
		return refdbdname;
	}

	/**
	 * Define el valor de la propiedad refdbdname.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setREFDBDNAME(String value) {
		this.refdbdname = value;
	}

	/**
	 * Obtiene el valor de la propiedad templateid.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTEMPLATEID() {
		return templateid;
	}

	/**
	 * Define el valor de la propiedad templateid.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTEMPLATEID(String value) {
		this.templateid = value;
	}

	/**
	 * Obtiene el valor de la propiedad templatename.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTEMPLATENAME() {
		return templatename;
	}

	/**
	 * Define el valor de la propiedad templatename.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTEMPLATENAME(String value) {
		this.templatename = value;
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
	 * Gets the value of the transformfield property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the transformfield property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getTRANSFORMFIELD().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link TRANSFORMFIELD }
	 * 
	 * 
	 */
	public List<TRANSFORMFIELD> getTRANSFORMFIELD() {
		if (transformfield == null) {
			transformfield = new ArrayList<TRANSFORMFIELD>();
		}
		return this.transformfield;
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
	 * Gets the value of the initprop property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the initprop property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getINITPROP().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link INITPROP }
	 * 
	 * 
	 */
	public List<INITPROP> getINITPROP() {
		if (initprop == null) {
			initprop = new ArrayList<INITPROP>();
		}
		return this.initprop;
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

	/**
	 * Gets the value of the transformfieldattrdef property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the transformfieldattrdef property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getTRANSFORMFIELDATTRDEF().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link TRANSFORMFIELDATTRDEF }
	 * 
	 * 
	 */
	public List<TRANSFORMFIELDATTRDEF> getTRANSFORMFIELDATTRDEF() {
		if (transformfieldattrdef == null) {
			transformfieldattrdef = new ArrayList<TRANSFORMFIELDATTRDEF>();
		}
		return this.transformfieldattrdef;
	}

	/**
	 * Gets the value of the fielddependency property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the fielddependency property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getFIELDDEPENDENCY().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link FIELDDEPENDENCY }
	 * 
	 * 
	 */
	public List<FIELDDEPENDENCY> getFIELDDEPENDENCY() {
		if (fielddependency == null) {
			fielddependency = new ArrayList<FIELDDEPENDENCY>();
		}
		return this.fielddependency;
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

	@Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof TRANSFORMATION){
			TRANSFORMATION ptr = (TRANSFORMATION) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.description)){
				retVal = false;
			}
			if(null!=ptr.getTYPE() && !ptr.getTYPE().equals(this.type)){
				retVal = false;
			}
			if(null!=ptr.getOBJECTVERSION() && !ptr.getOBJECTVERSION().equals(this.objectversion)){
				retVal = false;
			}
			if(null!=ptr.getREUSABLE() && !ptr.getREUSABLE().equals(this.reusable)){
				retVal = false;
			}
			if(null!=ptr.getISVSAMNORMALIZER() && !ptr.getISVSAMNORMALIZER().equals(this.isvsamnormalizer)){
				retVal = false;
			}
			if(null!=ptr.getREFSOURCENAME() && !ptr.getREFSOURCENAME().equals(this.refsourcename)){
				retVal = false;
			}
			if(null!=ptr.getREFDBDNAME() && !ptr.getREFDBDNAME().equals(this.refdbdname)){
				retVal = false;
			}
			if(null!=ptr.getTEMPLATEID() && !ptr.getTEMPLATEID().equals(this.templateid)){
				retVal = false;
			}
			if(null!=ptr.getTEMPLATENAME() && !ptr.getTEMPLATENAME().equals(this.templatename)){
				retVal = false;
			}
			if(null!=ptr.getPARENT() && !ptr.getPARENT().equals(this.parent)){
				retVal = false;
			}
			if(null!=ptr.getPARENTTYPE() && !ptr.getPARENTTYPE().equals(this.parenttype)){
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
			if(null!=ptr.getGROUP() && !ptr.getGROUP().equals(this.group) && !ptr.getGROUP().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getSOURCEFIELD() && !ptr.getSOURCEFIELD().equals(this.sourcefield) && !ptr.getSOURCEFIELD().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getTRANSFORMFIELD() && !ptr.getTRANSFORMFIELD().equals(this.transformfield) && !ptr.getTRANSFORMFIELD().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getTABLEATTRIBUTE() && !ptr.getTABLEATTRIBUTE().equals(this.tableattribute) && !ptr.getTABLEATTRIBUTE().isEmpty()){
				retVal = false;
			}
			/*if(null!=ptr.getINITPROP() && !ptr.getINITPROP().equals(this.initprop)&& !ptr.getINITPROP().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getMETADATAEXTENSION() && !ptr.getMETADATAEXTENSION().equals(this.metadataextension) && !ptr.getMETADATAEXTENSION().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getTRANSFORMFIELDATTRDEF() && !ptr.getTRANSFORMFIELDATTRDEF().equals(this.transformfieldattrdef) && !ptr.getTRANSFORMFIELDATTRDEF().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getFIELDDEPENDENCY() && !ptr.getFIELDDEPENDENCY().equals(this.fielddependency) && !ptr.getFIELDDEPENDENCY().isEmpty()){
				retVal = false;
			}
			if(null!=ptr.getFLATFILE() && !ptr.getFLATFILE().equals(this.flatfile)){
				retVal = false;
			}
			if(null!=ptr.getEXPRMACRODEPENDENCY() && !ptr.getEXPRMACRODEPENDENCY().equals(this.exprmacrodependency) && !ptr.getEXPRMACRODEPENDENCY().isEmpty()){
				retVal = false;
			}
*/
		}

		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, description, type, objectversion, reusable, isvsamnormalizer, refsourcename, refdbdname, templateid,templatename, parent, parenttype, versionnumber, componentversion, crcvalue, group,sourcefield, transformfield, tableattribute );
		/*return Objects.hash(name, description, type, objectversion, reusable, isvsamnormalizer, refsourcename, refdbdname, templateid, 
				templatename, parent, parenttype, versionnumber, componentversion, crcvalue, group, sourcefield, transformfield, tableattribute, 
				initprop, metadataextension, transformfieldattrdef, fielddependency, flatfile, exprmacrodependency);*/
	}
}
