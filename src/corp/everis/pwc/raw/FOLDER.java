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
    "folderversion",
    "config",
    "scheduler",
    "task",
    "session",
    "worklet",
    "workflow",
    "source",
    "target",
    "transformation",
    "mapplet",
    "mapping",
    "shortcut",
    "exprmacro"
})
@XmlRootElement(name = "FOLDER")
public class FOLDER {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "SHARED")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String shared;
    @XmlAttribute(name = "OWNER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String owner;
    @XmlAttribute(name = "GROUP")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String group;
    @XmlAttribute(name = "PERMISSIONS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String permissions;
    @XmlAttribute(name = "UUID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uuid;
    @XmlElement(name = "FOLDERVERSION")
    protected List<FOLDERVERSION> folderversion;
    @XmlElement(name = "CONFIG")
    protected List<CONFIG> config;
    @XmlElement(name = "SCHEDULER")
    protected List<SCHEDULER> scheduler;
    @XmlElement(name = "TASK")
    protected List<TASK> task;
    @XmlElement(name = "SESSION")
    protected List<SESSION> session;
    @XmlElement(name = "WORKLET")
    protected List<WORKLET> worklet;
    @XmlElement(name = "WORKFLOW")
    protected List<WORKFLOW> workflow;
    @XmlElement(name = "SOURCE")
    protected List<SOURCE> source;
    @XmlElement(name = "TARGET")
    protected List<TARGET> target;
    @XmlElement(name = "TRANSFORMATION")
    protected List<TRANSFORMATION> transformation;
    @XmlElement(name = "MAPPLET")
    protected List<MAPPLET> mapplet;
    @XmlElement(name = "MAPPING")
    protected List<MAPPING> mapping;
    @XmlElement(name = "SHORTCUT")
    protected List<SHORTCUT> shortcut;
    @XmlElement(name = "EXPRMACRO")
    protected List<EXPRMACRO> exprmacro;

    
    public FOLDER(){}
    
    public FOLDER(String name, String description, String shared, String owner, String group, String permissions,
			String uuid) {
		super();
		this.name = name;
		this.description = description;
		this.shared = shared;
		this.owner = owner;
		this.group = group;
		this.permissions = permissions;
		this.uuid = uuid;
	}

	public FOLDER(String name, String description, String shared, String owner, String group, String permissions,
			String uuid, List<FOLDERVERSION> folderversion, List<CONFIG> config, List<SCHEDULER> scheduler,
			List<TASK> task, List<SESSION> session, List<WORKLET> worklet, List<WORKFLOW> workflow, List<SOURCE> source,
			List<TARGET> target, List<TRANSFORMATION> transformation, List<MAPPLET> mapplet, List<MAPPING> mapping,
			List<SHORTCUT> shortcut, List<EXPRMACRO> exprmacro) {
		super();
		this.name = name;
		this.description = description;
		this.shared = shared;
		this.owner = owner;
		this.group = group;
		this.permissions = permissions;
		this.uuid = uuid;
		this.folderversion = folderversion;
		this.config = config;
		this.scheduler = scheduler;
		this.task = task;
		this.session = session;
		this.worklet = worklet;
		this.workflow = workflow;
		this.source = source;
		this.target = target;
		this.transformation = transformation;
		this.mapplet = mapplet;
		this.mapping = mapping;
		this.shortcut = shortcut;
		this.exprmacro = exprmacro;
	}
	
	public FOLDER(FOLDER f) {
		super();
		this.name = f.name;
		this.description = f.description;
		this.shared = f.shared;
		this.owner = f.owner;
		this.group = f.group;
		this.permissions = f.permissions;
		this.uuid = f.uuid;
		this.folderversion = f.folderversion;
		this.config = f.config;
		this.scheduler = f.scheduler;
		this.task = f.task;
		this.session = f.session;
		this.worklet = f.worklet;
		this.workflow = f.workflow;
		this.source = f.source;
		this.target = f.target;
		this.transformation = f.transformation;
		this.mapplet = f.mapplet;
		this.mapping = f.mapping;
		this.shortcut = f.shortcut;
		this.exprmacro = f.exprmacro;
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
     * Obtiene el valor de la propiedad shared.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHARED() {
        return shared;
    }

    /**
     * Define el valor de la propiedad shared.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHARED(String value) {
        this.shared = value;
    }

    /**
     * Obtiene el valor de la propiedad owner.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOWNER() {
        return owner;
    }

    /**
     * Define el valor de la propiedad owner.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOWNER(String value) {
        this.owner = value;
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
     * Obtiene el valor de la propiedad permissions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERMISSIONS() {
        return permissions;
    }

    /**
     * Define el valor de la propiedad permissions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERMISSIONS(String value) {
        this.permissions = value;
    }

    /**
     * Obtiene el valor de la propiedad uuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the folderversion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the folderversion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFOLDERVERSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FOLDERVERSION }
     * 
     * 
     */
    public List<FOLDERVERSION> getFOLDERVERSION() {
        if (folderversion == null) {
            folderversion = new ArrayList<FOLDERVERSION>();
        }
        return this.folderversion;
    }

    /**
     * Gets the value of the config property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the config property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONFIG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CONFIG }
     * 
     * 
     */
    public List<CONFIG> getCONFIG() {
        if (config == null) {
            config = new ArrayList<CONFIG>();
        }
        return this.config;
    }

    /**
     * Gets the value of the scheduler property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scheduler property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSCHEDULER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SCHEDULER }
     * 
     * 
     */
    public List<SCHEDULER> getSCHEDULER() {
        if (scheduler == null) {
            scheduler = new ArrayList<SCHEDULER>();
        }
        return this.scheduler;
    }

    /**
     * Gets the value of the task property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the task property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTASK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TASK }
     * 
     * 
     */
    public List<TASK> getTASK() {
        if (task == null) {
            task = new ArrayList<TASK>();
        }
        return this.task;
    }

    /**
     * Gets the value of the session property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the session property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSION }
     * 
     * 
     */
    public List<SESSION> getSESSION() {
        if (session == null) {
            session = new ArrayList<SESSION>();
        }
        return this.session;
    }

    /**
     * Gets the value of the worklet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the worklet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKLET().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKLET }
     * 
     * 
     */
    public List<WORKLET> getWORKLET() {
        if (worklet == null) {
            worklet = new ArrayList<WORKLET>();
        }
        return this.worklet;
    }

    /**
     * Gets the value of the workflow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOW().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOW }
     * 
     * 
     */
    public List<WORKFLOW> getWORKFLOW() {
        if (workflow == null) {
            workflow = new ArrayList<WORKFLOW>();
        }
        return this.workflow;
    }

    /**
     * Gets the value of the source property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the source property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOURCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SOURCE }
     * 
     * 
     */
    public List<SOURCE> getSOURCE() {
        if (source == null) {
            source = new ArrayList<SOURCE>();
        }
        return this.source;
    }

    /**
     * Gets the value of the target property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the target property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTARGET().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TARGET }
     * 
     * 
     */
    public List<TARGET> getTARGET() {
        if (target == null) {
            target = new ArrayList<TARGET>();
        }
        return this.target;
    }

    /**
     * Gets the value of the transformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANSFORMATION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANSFORMATION }
     * 
     * 
     */
    public List<TRANSFORMATION> getTRANSFORMATION() {
        if (transformation == null) {
            transformation = new ArrayList<TRANSFORMATION>();
        }
        return this.transformation;
    }

    /**
     * Gets the value of the mapplet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapplet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMAPPLET().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MAPPLET }
     * 
     * 
     */
    public List<MAPPLET> getMAPPLET() {
        if (mapplet == null) {
            mapplet = new ArrayList<MAPPLET>();
        }
        return this.mapplet;
    }

    /**
     * Gets the value of the mapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMAPPING().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MAPPING }
     * 
     * 
     */
    public List<MAPPING> getMAPPING() {
        if (mapping == null) {
            mapping = new ArrayList<MAPPING>();
        }
        return this.mapping;
    }

    /**
     * Gets the value of the shortcut property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shortcut property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSHORTCUT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SHORTCUT }
     * 
     * 
     */
    public List<SHORTCUT> getSHORTCUT() {
        if (shortcut == null) {
            shortcut = new ArrayList<SHORTCUT>();
        }
        return this.shortcut;
    }

    /**
     * Gets the value of the exprmacro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exprmacro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEXPRMACRO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EXPRMACRO }
     * 
     * 
     */
    public List<EXPRMACRO> getEXPRMACRO() {
        if (exprmacro == null) {
            exprmacro = new ArrayList<EXPRMACRO>();
        }
        return this.exprmacro;
    }
    
    
    public void getCopy(FOLDER folder){
    	FOLDER f = new FOLDER(folder);
    	this.getEXPRMACRO().addAll(f.getEXPRMACRO());
    	this.getMAPPING().addAll(f.getMAPPING());
    	this.getMAPPLET().addAll(f.getMAPPLET());
    	this.getSESSION().addAll(f.getSESSION());
    	this.getSHORTCUT().addAll(f.getSHORTCUT());
    	this.getSOURCE().addAll(f.getSOURCE());
    	this.getTARGET().addAll(f.getTARGET());
    	this.getTASK().addAll(f.getTASK());
    	this.getTRANSFORMATION().addAll(f.getTRANSFORMATION());
    	this.getWORKFLOW().addAll(f.getWORKFLOW());
    	this.getWORKLET().addAll(f.getWORKLET());
    }
    @Override
    public boolean equals(Object v) {
    	boolean retVal = false;

    	if (v instanceof FOLDER){
    		FOLDER ptr = (FOLDER) v;
    		retVal = true;
    		
    		if(null!=ptr.getNAME() && !ptr.getNAME().equals(this.getNAME())){
    			retVal = false;
    		}
    		if(null!=ptr.getDESCRIPTION() && !ptr.getDESCRIPTION().equals(this.getDESCRIPTION())){
    			retVal = false;
    		}
    		if(null!=ptr.getSHARED() && !ptr.getSHARED().equals(this.getSHARED())){
    			retVal = false;
    		}
    		if(null!=ptr.getOWNER() && !ptr.getOWNER().equals(this.getOWNER())){
    			retVal = false;
    		}
    		if(null!=ptr.getMAPPING() && !ptr.getMAPPING().equals(this.getMAPPING())){
    			retVal = false;
    		}
    		if(null!=ptr.getSOURCE() && !ptr.getSOURCE().equals(this.getSOURCE())){
    			retVal = false;
    		}
    		if(null!=ptr.getTARGET() && !ptr.getTARGET().equals(this.getTARGET())){
    			retVal = false;
    		}
    	}
    	return retVal;
    }
    @Override
    public int hashCode() {
    	return Objects.hash(name, description, shared, owner, mapping,source,target);
    }
}
