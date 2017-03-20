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
    "repository"
})
@XmlRootElement(name = "POWERMART")
public class POWERMART {

    @XmlAttribute(name = "CREATION_DATE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String creationdate;
    @XmlAttribute(name = "REPOSITORY_VERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String repositoryversion;
    @XmlElement(name = "REPOSITORY")
    protected List<REPOSITORY> repository;
    
    
    public POWERMART(){}
    public POWERMART(String creationdate, String repositoryversion) {
		super();
		this.creationdate = creationdate;
		this.repositoryversion = repositoryversion;
	}

	/**
     * Obtiene el valor de la propiedad creationdate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATIONDATE() {
        return creationdate;
    }

    /**
     * Define el valor de la propiedad creationdate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATIONDATE(String value) {
        this.creationdate = value;
    }

    /**
     * Obtiene el valor de la propiedad repositoryversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPOSITORYVERSION() {
        return repositoryversion;
    }

    /**
     * Define el valor de la propiedad repositoryversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPOSITORYVERSION(String value) {
        this.repositoryversion = value;
    }

    /**
     * Gets the value of the repository property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the repository property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREPOSITORY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link REPOSITORY }
     * 
     * 
     */
    public List<REPOSITORY> getREPOSITORY() {
        if (repository == null) {
            repository = new ArrayList<REPOSITORY>();
        }
        return this.repository;
    }

    @Override
    public boolean equals(Object v) {
    	boolean retVal = false;

    	if (v instanceof POWERMART){
    		POWERMART ptr = (POWERMART) v;
    		retVal = true;

    		if(null!=ptr.getCREATIONDATE() && !ptr.getCREATIONDATE().equals(this.getCREATIONDATE())){
    			retVal = false;
    		}
    		if(null!=ptr.getREPOSITORY() && !ptr.getREPOSITORY().equals(this.getREPOSITORY())){
    			retVal = false;
    		}
    		if(null!=ptr.getREPOSITORYVERSION() && !ptr.getREPOSITORYVERSION().equals(this.getREPOSITORYVERSION())){
    			retVal = false;
    		}
    	}
    	return retVal;
    }
    @Override
    public int hashCode() {
    	return Objects.hash(creationdate,repositoryversion,repository);
    }
}
