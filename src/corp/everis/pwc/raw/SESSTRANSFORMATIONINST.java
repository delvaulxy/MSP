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
    "sesstransformationgroup",
    "partition",
    "hashkey",
    "flatfile",
    "attribute"
})
@XmlRootElement(name = "SESSTRANSFORMATIONINST")
public class SESSTRANSFORMATIONINST {

    @XmlAttribute(name = "SINSTANCENAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sinstancename;
    @XmlAttribute(name = "TRANSFORMATIONNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String transformationname;
    @XmlAttribute(name = "TRANSFORMATIONTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String transformationtype;
    @XmlAttribute(name = "PARTITIONTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String partitiontype;
    @XmlAttribute(name = "ISREPARTITIONPOINT")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isrepartitionpoint;
    @XmlAttribute(name = "STAGE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String stage;
    @XmlAttribute(name = "PIPELINE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String pipeline;
    @XmlElement(name = "SESSTRANSFORMATIONGROUP")
    protected List<SESSTRANSFORMATIONGROUP> sesstransformationgroup;
    @XmlElement(name = "PARTITION")
    protected List<PARTITION> partition;
    @XmlElement(name = "HASHKEY")
    protected List<HASHKEY> hashkey;
    @XmlElement(name = "FLATFILE")
    protected List<FLATFILE> flatfile;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;

    public SESSTRANSFORMATIONINST(){}
    
    public SESSTRANSFORMATIONINST(String sinstancename, String transformationname, String transformationtype,
			String isrepartitionpoint, String stage, String pipeline) {
		super();
		this.sinstancename = sinstancename;
		this.transformationname = transformationname;
		this.transformationtype = transformationtype;
		this.isrepartitionpoint = isrepartitionpoint;
		this.stage = stage;
		this.pipeline = pipeline;
	}

	public SESSTRANSFORMATIONINST(String sinstancename, String transformationname, String transformationtype,
			String partitiontype, String isrepartitionpoint, String stage, String pipeline,
			List<SESSTRANSFORMATIONGROUP> sesstransformationgroup, List<PARTITION> partition, List<HASHKEY> hashkey,
			List<FLATFILE> flatfile, List<ATTRIBUTE> attribute) {
		super();
		this.sinstancename = sinstancename;
		this.transformationname = transformationname;
		this.transformationtype = transformationtype;
		this.partitiontype = partitiontype;
		this.isrepartitionpoint = isrepartitionpoint;
		this.stage = stage;
		this.pipeline = pipeline;
		this.sesstransformationgroup = sesstransformationgroup;
		this.partition = partition;
		this.hashkey = hashkey;
		this.flatfile = flatfile;
		this.attribute = attribute;
	}	
	public SESSTRANSFORMATIONINST(SESSTRANSFORMATIONINST sesstransformationinst) {
		super();
		this.sinstancename = sesstransformationinst.sinstancename;
		this.transformationname = sesstransformationinst.transformationname;
		this.transformationtype = sesstransformationinst.transformationtype;
		this.partitiontype = sesstransformationinst.partitiontype;
		this.isrepartitionpoint = sesstransformationinst.isrepartitionpoint;
		this.stage = sesstransformationinst.stage;
		this.pipeline = sesstransformationinst.pipeline;
		this.sesstransformationgroup = sesstransformationinst.sesstransformationgroup;
		this.partition = sesstransformationinst.partition;
		this.hashkey = sesstransformationinst.hashkey;
		this.flatfile = sesstransformationinst.flatfile;
		this.attribute = sesstransformationinst.attribute;
	}

	/**
     * Obtiene el valor de la propiedad sinstancename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSINSTANCENAME() {
        return sinstancename;
    }

    /**
     * Define el valor de la propiedad sinstancename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSINSTANCENAME(String value) {
        this.sinstancename = value;
    }

    /**
     * Obtiene el valor de la propiedad transformationname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSFORMATIONNAME() {
        return transformationname;
    }

    /**
     * Define el valor de la propiedad transformationname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSFORMATIONNAME(String value) {
        this.transformationname = value;
    }

    /**
     * Obtiene el valor de la propiedad transformationtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSFORMATIONTYPE() {
        return transformationtype;
    }

    /**
     * Define el valor de la propiedad transformationtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSFORMATIONTYPE(String value) {
        this.transformationtype = value;
    }

    /**
     * Obtiene el valor de la propiedad partitiontype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTITIONTYPE() {
        return partitiontype;
    }

    /**
     * Define el valor de la propiedad partitiontype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTITIONTYPE(String value) {
        this.partitiontype = value;
    }

    /**
     * Obtiene el valor de la propiedad isrepartitionpoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISREPARTITIONPOINT() {
        return isrepartitionpoint;
    }

    /**
     * Define el valor de la propiedad isrepartitionpoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISREPARTITIONPOINT(String value) {
        this.isrepartitionpoint = value;
    }

    /**
     * Obtiene el valor de la propiedad stage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTAGE() {
        return stage;
    }

    /**
     * Define el valor de la propiedad stage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTAGE(String value) {
        this.stage = value;
    }

    /**
     * Obtiene el valor de la propiedad pipeline.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIPELINE() {
        return pipeline;
    }

    /**
     * Define el valor de la propiedad pipeline.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIPELINE(String value) {
        this.pipeline = value;
    }

    /**
     * Gets the value of the sesstransformationgroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sesstransformationgroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSESSTRANSFORMATIONGROUP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SESSTRANSFORMATIONGROUP }
     * 
     * 
     */
    public List<SESSTRANSFORMATIONGROUP> getSESSTRANSFORMATIONGROUP() {
        if (sesstransformationgroup == null) {
            sesstransformationgroup = new ArrayList<SESSTRANSFORMATIONGROUP>();
        }
        return this.sesstransformationgroup;
    }

    /**
     * Gets the value of the partition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPARTITION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PARTITION }
     * 
     * 
     */
    public List<PARTITION> getPARTITION() {
        if (partition == null) {
            partition = new ArrayList<PARTITION>();
        }
        return this.partition;
    }

    /**
     * Gets the value of the hashkey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hashkey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHASHKEY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HASHKEY }
     * 
     * 
     */
    public List<HASHKEY> getHASHKEY() {
        if (hashkey == null) {
            hashkey = new ArrayList<HASHKEY>();
        }
        return this.hashkey;
    }

    /**
     * Gets the value of the flatfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flatfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFLATFILE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FLATFILE }
     * 
     * 
     */
    public List<FLATFILE> getFLATFILE() {
        if (flatfile == null) {
            flatfile = new ArrayList<FLATFILE>();
        }
        return this.flatfile;
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

}
