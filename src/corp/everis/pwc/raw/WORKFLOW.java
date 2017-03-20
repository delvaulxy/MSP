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
    "scheduler",
    "task",
    "session",
    "worklet",
    "taskinstance",
    "workflowlink",
    "workflowvariable",
    "workflowevent",
    "attribute",
    "metadataextension",
    "conwfruninfo"
})
@XmlRootElement(name = "WORKFLOW")
public class WORKFLOW {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "SERVERNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String servername;
    @XmlAttribute(name = "SERVER_DOMAINNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String serverdomainname;
    @XmlAttribute(name = "SUSPENSION_EMAIL")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String suspensionemail;
    @XmlAttribute(name = "SCHEDULERNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String schedulername;
    @XmlAttribute(name = "REUSABLE_SCHEDULER")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusablescheduler;
    @XmlAttribute(name = "ISVALID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isvalid;
    @XmlAttribute(name = "ISENABLED")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isenabled;
    @XmlAttribute(name = "SUSPEND_ON_ERROR")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String suspendonerror;
    @XmlAttribute(name = "TASKS_MUST_RUN_ON_SERVER")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tasksmustrunonserver;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlAttribute(name = "ISSERVICE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isservice;
    @XmlAttribute(name = "ISRUNNABLESERVICE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isrunnableservice;
    @XmlAttribute(name = "SERVICELEVELNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String servicelevelname;
    @XmlElement(name = "SCHEDULER")
    protected SCHEDULER scheduler;
    @XmlElement(name = "TASK")
    protected List<TASK> task;
    @XmlElement(name = "SESSION")
    protected List<SESSION> session;
    @XmlElement(name = "WORKLET")
    protected List<WORKLET> worklet;
    @XmlElement(name = "TASKINSTANCE")
    protected List<TASKINSTANCE> taskinstance;
    @XmlElement(name = "WORKFLOWLINK")
    protected List<WORKFLOWLINK> workflowlink;
    @XmlElement(name = "WORKFLOWVARIABLE")
    protected List<WORKFLOWVARIABLE> workflowvariable;
    @XmlElement(name = "WORKFLOWEVENT")
    protected List<WORKFLOWEVENT> workflowevent;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;
    @XmlElement(name = "METADATAEXTENSION")
    protected List<METADATAEXTENSION> metadataextension;
    @XmlElement(name = "CONWFRUNINFO")
    protected List<CONWFRUNINFO> conwfruninfo;

	public WORKFLOW(){}
    
    public WORKFLOW(String name, String description, String servername, String serverdomainname, String schedulername,
			String reusablescheduler, String isenabled, String suspendonerror, String tasksmustrunonserver,
			String versionnumber, String isservice, String isrunnableservice) {
		super();
		this.name = name;
		this.description = description;
		this.servername = servername;
		this.serverdomainname = serverdomainname;
		this.schedulername = schedulername;
		this.reusablescheduler = reusablescheduler;
		this.isenabled = isenabled;
		this.suspendonerror = suspendonerror;
		this.tasksmustrunonserver = tasksmustrunonserver;
		this.versionnumber = versionnumber;
		this.isservice = isservice;
		this.isrunnableservice = isrunnableservice;
	}

	public WORKFLOW(String name, String description, String servername, String serverdomainname, String suspensionemail,
			String schedulername, String reusablescheduler, String isvalid, String isenabled, String suspendonerror,
			String tasksmustrunonserver, String versionnumber, String isservice, String isrunnableservice,
			String servicelevelname, SCHEDULER scheduler, List<TASK> task, List<SESSION> session, List<WORKLET> worklet,
			List<TASKINSTANCE> taskinstance, List<WORKFLOWLINK> workflowlink, List<WORKFLOWVARIABLE> workflowvariable,
			List<WORKFLOWEVENT> workflowevent, List<ATTRIBUTE> attribute, List<METADATAEXTENSION> metadataextension,
			List<CONWFRUNINFO> conwfruninfo) {
		super();
		this.name = name;
		this.description = description;
		this.servername = servername;
		this.serverdomainname = serverdomainname;
		this.suspensionemail = suspensionemail;
		this.schedulername = schedulername;
		this.reusablescheduler = reusablescheduler;
		this.isvalid = isvalid;
		this.isenabled = isenabled;
		this.suspendonerror = suspendonerror;
		this.tasksmustrunonserver = tasksmustrunonserver;
		this.versionnumber = versionnumber;
		this.isservice = isservice;
		this.isrunnableservice = isrunnableservice;
		this.servicelevelname = servicelevelname;
		this.scheduler = scheduler;
		this.task = task;
		this.session = session;
		this.worklet = worklet;
		this.taskinstance = taskinstance;
		this.workflowlink = workflowlink;
		this.workflowvariable = workflowvariable;
		this.workflowevent = workflowevent;
		this.attribute = attribute;
		this.metadataextension = metadataextension;
		this.conwfruninfo = conwfruninfo;
	}
	public WORKFLOW(WORKFLOW workflow) {
		super();
		this.name = workflow.name;
		this.description = workflow.description;
		this.servername = workflow.servername;
		this.serverdomainname = workflow.serverdomainname;
		this.suspensionemail = workflow.suspensionemail;
		this.schedulername = workflow.schedulername;
		this.reusablescheduler = workflow.reusablescheduler;
		this.isvalid = workflow.isvalid;
		this.isenabled = workflow.isenabled;
		this.suspendonerror = workflow.suspendonerror;
		this.tasksmustrunonserver = workflow.tasksmustrunonserver;
		this.versionnumber = workflow.versionnumber;
		this.isservice = workflow.isservice;
		this.isrunnableservice = workflow.isrunnableservice;
		this.servicelevelname = workflow.servicelevelname;
		this.scheduler = workflow.scheduler;
		this.task = workflow.task;
		this.session = workflow.session;
		this.worklet = workflow.worklet;
		this.taskinstance = workflow.taskinstance;
		this.workflowlink = workflow.workflowlink;
		this.workflowvariable = workflow.workflowvariable;
		this.workflowevent = workflow.workflowevent;
		this.attribute = workflow.attribute;
		this.metadataextension = workflow.metadataextension;
		this.conwfruninfo = workflow.conwfruninfo;
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
     * Obtiene el valor de la propiedad servername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVERNAME() {
        return servername;
    }

    /**
     * Define el valor de la propiedad servername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVERNAME(String value) {
        this.servername = value;
    }

    /**
     * Obtiene el valor de la propiedad serverdomainname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVERDOMAINNAME() {
        return serverdomainname;
    }

    /**
     * Define el valor de la propiedad serverdomainname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVERDOMAINNAME(String value) {
        this.serverdomainname = value;
    }

    /**
     * Obtiene el valor de la propiedad suspensionemail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUSPENSIONEMAIL() {
        return suspensionemail;
    }

    /**
     * Define el valor de la propiedad suspensionemail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUSPENSIONEMAIL(String value) {
        this.suspensionemail = value;
    }

    /**
     * Obtiene el valor de la propiedad schedulername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCHEDULERNAME() {
        return schedulername;
    }

    /**
     * Define el valor de la propiedad schedulername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCHEDULERNAME(String value) {
        this.schedulername = value;
    }

    /**
     * Obtiene el valor de la propiedad reusablescheduler.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREUSABLESCHEDULER() {
        return reusablescheduler;
    }

    /**
     * Define el valor de la propiedad reusablescheduler.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREUSABLESCHEDULER(String value) {
        this.reusablescheduler = value;
    }

    /**
     * Obtiene el valor de la propiedad isvalid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISVALID() {
        return isvalid;
    }

    /**
     * Define el valor de la propiedad isvalid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISVALID(String value) {
        this.isvalid = value;
    }

    /**
     * Obtiene el valor de la propiedad isenabled.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISENABLED() {
        return isenabled;
    }

    /**
     * Define el valor de la propiedad isenabled.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISENABLED(String value) {
        this.isenabled = value;
    }

    /**
     * Obtiene el valor de la propiedad suspendonerror.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUSPENDONERROR() {
        return suspendonerror;
    }

    /**
     * Define el valor de la propiedad suspendonerror.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUSPENDONERROR(String value) {
        this.suspendonerror = value;
    }

    /**
     * Obtiene el valor de la propiedad tasksmustrunonserver.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTASKSMUSTRUNONSERVER() {
        return tasksmustrunonserver;
    }

    /**
     * Define el valor de la propiedad tasksmustrunonserver.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTASKSMUSTRUNONSERVER(String value) {
        this.tasksmustrunonserver = value;
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
     * Obtiene el valor de la propiedad isservice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSERVICE() {
        return isservice;
    }

    /**
     * Define el valor de la propiedad isservice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSERVICE(String value) {
        this.isservice = value;
    }

    /**
     * Obtiene el valor de la propiedad isrunnableservice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISRUNNABLESERVICE() {
        return isrunnableservice;
    }

    /**
     * Define el valor de la propiedad isrunnableservice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISRUNNABLESERVICE(String value) {
        this.isrunnableservice = value;
    }

    /**
     * Obtiene el valor de la propiedad servicelevelname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICELEVELNAME() {
        return servicelevelname;
    }

    /**
     * Define el valor de la propiedad servicelevelname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICELEVELNAME(String value) {
        this.servicelevelname = value;
    }

    /**
     * Obtiene el valor de la propiedad scheduler.
     * 
     * @return
     *     possible object is
     *     {@link SCHEDULER }
     *     
     */
    public SCHEDULER getSCHEDULER() {
        return scheduler;
    }

    /**
     * Define el valor de la propiedad scheduler.
     * 
     * @param value
     *     allowed object is
     *     {@link SCHEDULER }
     *     
     */
    public void setSCHEDULER(SCHEDULER value) {
        this.scheduler = value;
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
     * Gets the value of the taskinstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskinstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTASKINSTANCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TASKINSTANCE }
     * 
     * 
     */
    public List<TASKINSTANCE> getTASKINSTANCE() {
        if (taskinstance == null) {
            taskinstance = new ArrayList<TASKINSTANCE>();
        }
        return this.taskinstance;
    }

    /**
     * Gets the value of the workflowlink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowlink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOWLINK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOWLINK }
     * 
     * 
     */
    public List<WORKFLOWLINK> getWORKFLOWLINK() {
        if (workflowlink == null) {
            workflowlink = new ArrayList<WORKFLOWLINK>();
        }
        return this.workflowlink;
    }

    /**
     * Gets the value of the workflowvariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowvariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOWVARIABLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOWVARIABLE }
     * 
     * 
     */
    public List<WORKFLOWVARIABLE> getWORKFLOWVARIABLE() {
        if (workflowvariable == null) {
            workflowvariable = new ArrayList<WORKFLOWVARIABLE>();
        }
        return this.workflowvariable;
    }

    /**
     * Gets the value of the workflowevent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowevent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWORKFLOWEVENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WORKFLOWEVENT }
     * 
     * 
     */
    public List<WORKFLOWEVENT> getWORKFLOWEVENT() {
        if (workflowevent == null) {
            workflowevent = new ArrayList<WORKFLOWEVENT>();
        }
        return this.workflowevent;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ATTRIBUTE }
     * 
     * 
     */
    public List<ATTRIBUTE> getATTRIBUTE() {
        if (attribute == null) {
            attribute = new ArrayList<ATTRIBUTE>();
        }
        return this.attribute;
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
     * Gets the value of the conwfruninfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conwfruninfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONWFRUNINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CONWFRUNINFO }
     * 
     * 
     */
    public List<CONWFRUNINFO> getCONWFRUNINFO() {
        if (conwfruninfo == null) {
            conwfruninfo = new ArrayList<CONWFRUNINFO>();
        }
        return this.conwfruninfo;
    }

}
