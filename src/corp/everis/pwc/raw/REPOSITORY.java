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
    "folder"
})
@XmlRootElement(name = "REPOSITORY")
public class REPOSITORY {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DATABASETYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String databasetype;
    @XmlAttribute(name = "CODEPAGE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String codepage;
    @XmlAttribute(name = "VERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String version;
    @XmlAttribute(name = "PARENTREPOSITORY")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parentrepository;
    @XmlElement(name = "FOLDER")
    protected List<FOLDER> folder;

    
    
    public REPOSITORY() {
		super();
	}

    
    
	public REPOSITORY(String name, String databasetype, String codepage, String version, String parentrepository,
			List<FOLDER> folder) {
		super();
		this.name = name;
		this.databasetype = databasetype;
		this.codepage = codepage;
		this.version = version;
		this.parentrepository = parentrepository;
		this.folder = folder;
	}
	
	public REPOSITORY(String name, String databasetype, String codepage, String version,List<FOLDER> folder) {
		super();
		this.name = name;
		this.databasetype = databasetype;
		this.codepage = codepage;
		this.version = version;
		this.folder = folder;
	}

	public REPOSITORY(String name, String databasetype, String codepage, String version) {
		super();
		this.name = name;
		this.databasetype = databasetype;
		this.codepage = codepage;
		this.version = version;
	}
	public REPOSITORY(REPOSITORY repository) {
		super();
		this.name = repository.name;
		this.databasetype = repository.databasetype;
		this.codepage = repository.codepage;
		this.version = repository.version;
		this.parentrepository = repository.parentrepository;
		this.folder = repository.folder;
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
     * Obtiene el valor de la propiedad codepage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODEPAGE() {
        return codepage;
    }

    /**
     * Define el valor de la propiedad codepage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODEPAGE(String value) {
        this.codepage = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERSION() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERSION(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad parentrepository.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENTREPOSITORY() {
        return parentrepository;
    }

    /**
     * Define el valor de la propiedad parentrepository.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENTREPOSITORY(String value) {
        this.parentrepository = value;
    }

    /**
     * Gets the value of the folder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the folder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFOLDER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FOLDER }
     * 
     * 
     */
    public List<FOLDER> getFOLDER() {
        if (folder == null) {
            folder = new ArrayList<FOLDER>();
        }
        return this.folder;
    }
    @Override
    public boolean equals(Object v) {
    	boolean retVal = false;

    	if (v instanceof REPOSITORY){
    		REPOSITORY ptr = (REPOSITORY) v;
    		retVal = true;

    		if(null!=ptr.getCODEPAGE() && !ptr.getCODEPAGE().equals(this.getCODEPAGE())){
    			retVal = false;
    		}
    		if(null!=ptr.getDATABASETYPE() && !ptr.getDATABASETYPE().equals(this.getDATABASETYPE())){
    			retVal = false;
    		}
    		if(null!=ptr.getFOLDER() && !ptr.getFOLDER().equals(this.getFOLDER())){
    			retVal = false;
    		}
    		if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.getNAME())){
    			retVal = false;
    		}
    		if(null!=ptr.getPARENTREPOSITORY() && !ptr.getPARENTREPOSITORY().equals(this.getPARENTREPOSITORY())){
    			retVal = false;
    		}
    		if(null!=ptr.getVERSION() && !ptr.getVERSION().equals(this.getVERSION())){
    			retVal = false;
    		}
    	}
    	return retVal;
    }
    @Override
    public int hashCode() {
    	return Objects.hash(codepage,databasetype,folder,name, parentrepository,version);
    }

}
