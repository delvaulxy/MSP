//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "METADATAEXTENSION")
public class METADATAEXTENSION {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "VENDORNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String vendorname;
    @XmlAttribute(name = "DOMAINNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String domainname;
    @XmlAttribute(name = "DATATYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String datatype;
    @XmlAttribute(name = "VALUE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "MAXLENGTH")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maxlength;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "ISSHAREREAD")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isshareread;
    @XmlAttribute(name = "ISSHAREWRITE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String issharewrite;
    @XmlAttribute(name = "ISCLIENTVISIBLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isclientvisible;
    @XmlAttribute(name = "ISCLIENTEDITABLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isclienteditable;
    @XmlAttribute(name = "ISREUSABLE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isreusable;
    @XmlAttribute(name = "COMPONENTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String componentversion;

    public METADATAEXTENSION(){
    	super();
    }
    
    
    public METADATAEXTENSION(String name, String vendorname, String domainname, String datatype, String value,
			String maxlength, String description, String isshareread, String issharewrite, String isclientvisible,
			String isclienteditable, String isreusable, String componentversion) {
		super();
		this.name = name;
		this.vendorname = vendorname;
		this.domainname = domainname;
		this.datatype = datatype;
		this.value = value;
		this.maxlength = maxlength;
		this.description = description;
		this.isshareread = isshareread;
		this.issharewrite = issharewrite;
		this.isclientvisible = isclientvisible;
		this.isclienteditable = isclienteditable;
		this.isreusable = isreusable;
		this.componentversion = componentversion;
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
     * Obtiene el valor de la propiedad vendorname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVENDORNAME() {
        return vendorname;
    }

    /**
     * Define el valor de la propiedad vendorname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVENDORNAME(String value) {
        this.vendorname = value;
    }

    /**
     * Obtiene el valor de la propiedad domainname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOMAINNAME() {
        return domainname;
    }

    /**
     * Define el valor de la propiedad domainname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOMAINNAME(String value) {
        this.domainname = value;
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
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUE() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUE(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad maxlength.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAXLENGTH() {
        return maxlength;
    }

    /**
     * Define el valor de la propiedad maxlength.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAXLENGTH(String value) {
        this.maxlength = value;
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
     * Obtiene el valor de la propiedad isshareread.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSHAREREAD() {
        return isshareread;
    }

    /**
     * Define el valor de la propiedad isshareread.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSHAREREAD(String value) {
        this.isshareread = value;
    }

    /**
     * Obtiene el valor de la propiedad issharewrite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSHAREWRITE() {
        return issharewrite;
    }

    /**
     * Define el valor de la propiedad issharewrite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSHAREWRITE(String value) {
        this.issharewrite = value;
    }

    /**
     * Obtiene el valor de la propiedad isclientvisible.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISCLIENTVISIBLE() {
        return isclientvisible;
    }

    /**
     * Define el valor de la propiedad isclientvisible.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISCLIENTVISIBLE(String value) {
        this.isclientvisible = value;
    }

    /**
     * Obtiene el valor de la propiedad isclienteditable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISCLIENTEDITABLE() {
        return isclienteditable;
    }

    /**
     * Define el valor de la propiedad isclienteditable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISCLIENTEDITABLE(String value) {
        this.isclienteditable = value;
    }

    /**
     * Obtiene el valor de la propiedad isreusable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISREUSABLE() {
        return isreusable;
    }

    /**
     * Define el valor de la propiedad isreusable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISREUSABLE(String value) {
        this.isreusable = value;
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
    @Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof METADATAEXTENSION){
			METADATAEXTENSION ptr = (METADATAEXTENSION) v;
			retVal = true;
			if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getVENDORNAME() && !ptr.getVENDORNAME().equals(this.vendorname)){
				retVal = false;
			}
			if(null!=ptr.getDOMAINNAME() && !ptr.getDOMAINNAME().equals(this.domainname)){
				retVal = false;
			}
			if(null!=ptr.getDATATYPE() && !ptr.getDATATYPE().equals(this.datatype)){
				retVal = false;
			}
			if(null!=ptr.getVALUE() && !ptr.getVALUE().equals(this.value)){
				retVal = false;
			}
			if(null!=ptr.getMAXLENGTH() && !ptr.getMAXLENGTH().equals(this.maxlength)){
				retVal = false;
			}
			if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.description)){
				retVal = false;
			}
			if(null!=ptr.getISSHAREREAD() && !ptr.getISSHAREREAD().equals(this.isshareread)){
				retVal = false;
			}
			if(null!=ptr.getISSHAREWRITE() && !ptr.getISSHAREWRITE().equals(this.issharewrite)){
				retVal = false;
			}
			if(null!=ptr.getISCLIENTVISIBLE() && !ptr.getISCLIENTVISIBLE().equals(this.isclientvisible)){
				retVal = false;
			}
			if(null!=ptr.getISCLIENTEDITABLE() && !ptr.getISCLIENTEDITABLE().equals(this.isclienteditable)){
				retVal = false;
			}
			if(null!=ptr.getISREUSABLE() && !ptr.getISREUSABLE().equals(this.isreusable)){
				retVal = false;
			}
			if(null!=ptr.getCOMPONENTVERSION() && !ptr.getCOMPONENTVERSION().equals(this.componentversion)){
				retVal = false;
			}
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,vendorname,domainname,datatype,value,maxlength,description,isshareread,issharewrite,isclientvisible,isclienteditable,isreusable,componentversion);
	}
}
