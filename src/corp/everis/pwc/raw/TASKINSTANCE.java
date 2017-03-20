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
    "attribute",
    "workflowvariable",
    "valuepair",
    "configreference",
    "sessioncomponent",
    "sessionextension",
    "resourcereference",
    "transformresourceref"
})
@XmlRootElement(name = "TASKINSTANCE")
public class TASKINSTANCE {
	public TASKINSTANCE(String name, String description, String tasktype, String taskname, String isenabled,
			String reusable, String treatinputlinkasand, String failparentifinstancefails,
			String failparentifinstancedidnotrun, String serveroverride, List<ATTRIBUTE> attribute,
			List<WORKFLOWVARIABLE> workflowvariable, List<VALUEPAIR> valuepair, CONFIGREFERENCE configreference,
			List<SESSIONCOMPONENT> sessioncomponent, List<SESSIONEXTENSION> sessionextension,
			List<RESOURCEREFERENCE> resourcereference, List<TRANSFORMRESOURCEREF> transformresourceref) {
		super();
		this.name = name;
		this.description = description;
		this.tasktype = tasktype;
		this.taskname = taskname;
		this.isenabled = isenabled;
		this.reusable = reusable;
		this.treatinputlinkasand = treatinputlinkasand;
		this.failparentifinstancefails = failparentifinstancefails;
		this.failparentifinstancedidnotrun = failparentifinstancedidnotrun;
		this.serveroverride = serveroverride;
		this.attribute = attribute;
		this.workflowvariable = workflowvariable;
		this.valuepair = valuepair;
		this.configreference = configreference;
		this.sessioncomponent = sessioncomponent;
		this.sessionextension = sessionextension;
		this.resourcereference = resourcereference;
		this.transformresourceref = transformresourceref;
	}
	
	public TASKINSTANCE(TASKINSTANCE taskinstance) {
		super();
		this.name = taskinstance.name;
		this.description = taskinstance.description;
		this.tasktype = taskinstance.tasktype;
		this.taskname = taskinstance.taskname;
		this.isenabled = taskinstance.isenabled;
		this.reusable = taskinstance.reusable;
		this.treatinputlinkasand = taskinstance.treatinputlinkasand;
		this.failparentifinstancefails = taskinstance.failparentifinstancefails;
		this.failparentifinstancedidnotrun = taskinstance.failparentifinstancedidnotrun;
		this.serveroverride = taskinstance.serveroverride;
		this.attribute = taskinstance.attribute;
		this.workflowvariable = taskinstance.workflowvariable;
		this.valuepair = taskinstance.valuepair;
		this.configreference = taskinstance.configreference;
		this.sessioncomponent = taskinstance.sessioncomponent;
		this.sessionextension = taskinstance.sessionextension;
		this.resourcereference = taskinstance.resourcereference;
		this.transformresourceref = taskinstance.transformresourceref;
	}

	public TASKINSTANCE(){}
	
    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "TASKTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tasktype;
    @XmlAttribute(name = "TASKNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String taskname;
    @XmlAttribute(name = "ISENABLED")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isenabled;
    @XmlAttribute(name = "REUSABLE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reusable;
    @XmlAttribute(name = "TREAT_INPUTLINK_AS_AND")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String treatinputlinkasand;
    @XmlAttribute(name = "FAIL_PARENT_IF_INSTANCE_FAILS")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String failparentifinstancefails;
    @XmlAttribute(name = "FAIL_PARENT_IF_INSTANCE_DID_NOT_RUN")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String failparentifinstancedidnotrun;
    @XmlAttribute(name = "SERVER_OVERRIDE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String serveroverride;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;
    @XmlElement(name = "WORKFLOWVARIABLE")
    protected List<WORKFLOWVARIABLE> workflowvariable;
    @XmlElement(name = "VALUEPAIR")
    protected List<VALUEPAIR> valuepair;
    @XmlElement(name = "CONFIGREFERENCE")
    protected CONFIGREFERENCE configreference;
    @XmlElement(name = "SESSIONCOMPONENT")
    protected List<SESSIONCOMPONENT> sessioncomponent;
    @XmlElement(name = "SESSIONEXTENSION")
    protected List<SESSIONEXTENSION> sessionextension;
    @XmlElement(name = "RESOURCEREFERENCE")
    protected List<RESOURCEREFERENCE> resourcereference;
    @XmlElement(name = "TRANSFORMRESOURCEREF")
    protected List<TRANSFORMRESOURCEREF> transformresourceref;

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
     * Obtiene el valor de la propiedad tasktype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTASKTYPE() {
        return tasktype;
    }

    /**
     * Define el valor de la propiedad tasktype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTASKTYPE(String value) {
        this.tasktype = value;
    }

    /**
     * Obtiene el valor de la propiedad taskname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTASKNAME() {
        return taskname;
    }

    /**
     * Define el valor de la propiedad taskname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTASKNAME(String value) {
        this.taskname = value;
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
     * Obtiene el valor de la propiedad treatinputlinkasand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTREATINPUTLINKASAND() {
        return treatinputlinkasand;
    }

    /**
     * Define el valor de la propiedad treatinputlinkasand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTREATINPUTLINKASAND(String value) {
        this.treatinputlinkasand = value;
    }

    /**
     * Obtiene el valor de la propiedad failparentifinstancefails.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAILPARENTIFINSTANCEFAILS() {
        return failparentifinstancefails;
    }

    /**
     * Define el valor de la propiedad failparentifinstancefails.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAILPARENTIFINSTANCEFAILS(String value) {
        this.failparentifinstancefails = value;
    }

    /**
     * Obtiene el valor de la propiedad failparentifinstancedidnotrun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAILPARENTIFINSTANCEDIDNOTRUN() {
        return failparentifinstancedidnotrun;
    }

    /**
     * Define el valor de la propiedad failparentifinstancedidnotrun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAILPARENTIFINSTANCEDIDNOTRUN(String value) {
        this.failparentifinstancedidnotrun = value;
    }

    /**
     * Obtiene el valor de la propiedad serveroverride.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVEROVERRIDE() {
        return serveroverride;
    }

    /**
     * Define el valor de la propiedad serveroverride.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVEROVERRIDE(String value) {
        this.serveroverride = value;
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
     * Gets the value of the valuepair property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valuepair property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVALUEPAIR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VALUEPAIR }
     * 
     * 
     */
    public List<VALUEPAIR> getVALUEPAIR() {
        if (valuepair == null) {
            valuepair = new ArrayList<VALUEPAIR>();
        }
        return this.valuepair;
    }

    /**
     * Obtiene el valor de la propiedad configreference.
     * 
     * @return
     *     possible object is
     *     {@link CONFIGREFERENCE }
     *     
     */
    public CONFIGREFERENCE getCONFIGREFERENCE() {
        return configreference;
    }

    /**
     * Define el valor de la propiedad configreference.
     * 
     * @param value
     *     allowed object is
     *     {@link CONFIGREFERENCE }
     *     
     */
    public void setCONFIGREFERENCE(CONFIGREFERENCE value) {
        this.configreference = value;
    }

    /**
     * Gets the value of the sessioncomponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sessioncomponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSIONCOMPONENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSIONCOMPONENT }
     * 
     * 
     */
    public List<SESSIONCOMPONENT> getSESSIONCOMPONENT() {
        if (sessioncomponent == null) {
            sessioncomponent = new ArrayList<SESSIONCOMPONENT>();
        }
        return this.sessioncomponent;
    }

    /**
     * Gets the value of the sessionextension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sessionextension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSIONEXTENSION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSIONEXTENSION }
     * 
     * 
     */
    public List<SESSIONEXTENSION> getSESSIONEXTENSION() {
        if (sessionextension == null) {
            sessionextension = new ArrayList<SESSIONEXTENSION>();
        }
        return this.sessionextension;
    }

    /**
     * Gets the value of the resourcereference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourcereference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRESOURCEREFERENCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RESOURCEREFERENCE }
     * 
     * 
     */
    public List<RESOURCEREFERENCE> getRESOURCEREFERENCE() {
        if (resourcereference == null) {
            resourcereference = new ArrayList<RESOURCEREFERENCE>();
        }
        return this.resourcereference;
    }

    /**
     * Gets the value of the transformresourceref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformresourceref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANSFORMRESOURCEREF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANSFORMRESOURCEREF }
     * 
     * 
     */
    public List<TRANSFORMRESOURCEREF> getTRANSFORMRESOURCEREF() {
        if (transformresourceref == null) {
            transformresourceref = new ArrayList<TRANSFORMRESOURCEREF>();
        }
        return this.transformresourceref;
    }

}
