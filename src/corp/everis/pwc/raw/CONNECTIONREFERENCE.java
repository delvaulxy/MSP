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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "attribute"
})
@XmlRootElement(name = "CONNECTIONREFERENCE")
public class CONNECTIONREFERENCE {

    @XmlAttribute(name = "CNXREFNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String cnxrefname;
    @XmlAttribute(name = "CONNECTIONTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String connectiontype;
    @XmlAttribute(name = "CONNECTIONSUBTYPE", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String connectionsubtype;
    @XmlAttribute(name = "CONNECTIONNUMBER", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String connectionnumber;
    @XmlAttribute(name = "CONNECTIONNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String connectionname;
    @XmlAttribute(name = "PARTITIONNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String partitionname;
    @XmlAttribute(name = "VARIABLE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String variable;
    @XmlAttribute(name = "COMPONENTVERSION")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String componentversion;
    @XmlElement(name = "ATTRIBUTE")
    protected List<ATTRIBUTE> attribute;

    /**
     * Obtiene el valor de la propiedad cnxrefname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNXREFNAME() {
        return cnxrefname;
    }

    /**
     * Define el valor de la propiedad cnxrefname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNXREFNAME(String value) {
        this.cnxrefname = value;
    }

    /**
     * Obtiene el valor de la propiedad connectiontype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONNECTIONTYPE() {
        return connectiontype;
    }

    /**
     * Define el valor de la propiedad connectiontype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONNECTIONTYPE(String value) {
        this.connectiontype = value;
    }

    /**
     * Obtiene el valor de la propiedad connectionsubtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONNECTIONSUBTYPE() {
        return connectionsubtype;
    }

    /**
     * Define el valor de la propiedad connectionsubtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONNECTIONSUBTYPE(String value) {
        this.connectionsubtype = value;
    }

    /**
     * Obtiene el valor de la propiedad connectionnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONNECTIONNUMBER() {
        return connectionnumber;
    }

    /**
     * Define el valor de la propiedad connectionnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONNECTIONNUMBER(String value) {
        this.connectionnumber = value;
    }

    /**
     * Obtiene el valor de la propiedad connectionname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONNECTIONNAME() {
        return connectionname;
    }

    /**
     * Define el valor de la propiedad connectionname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONNECTIONNAME(String value) {
        this.connectionname = value;
    }

    /**
     * Obtiene el valor de la propiedad partitionname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTITIONNAME() {
        return partitionname;
    }

    /**
     * Define el valor de la propiedad partitionname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTITIONNAME(String value) {
        this.partitionname = value;
    }

    /**
     * Obtiene el valor de la propiedad variable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVARIABLE() {
        return variable;
    }

    /**
     * Define el valor de la propiedad variable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVARIABLE(String value) {
        this.variable = value;
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
