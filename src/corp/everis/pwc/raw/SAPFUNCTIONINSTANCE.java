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
    "sapfuncinstanceparam",
    "saptableinstanceparam"
})
@XmlRootElement(name = "SAPFUNCTIONINSTANCE")
public class SAPFUNCTIONINSTANCE {

    @XmlAttribute(name = "FUNCTIONNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String functionname;
    @XmlAttribute(name = "DSQINSTNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dsqinstname;
    @XmlElement(name = "SAPFUNCINSTANCEPARAM")
    protected List<SAPFUNCINSTANCEPARAM> sapfuncinstanceparam;
    @XmlElement(name = "SAPTABLEINSTANCEPARAM")
    protected List<SAPTABLEINSTANCEPARAM> saptableinstanceparam;

    /**
     * Obtiene el valor de la propiedad functionname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNCTIONNAME() {
        return functionname;
    }

    /**
     * Define el valor de la propiedad functionname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNCTIONNAME(String value) {
        this.functionname = value;
    }

    /**
     * Obtiene el valor de la propiedad dsqinstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSQINSTNAME() {
        return dsqinstname;
    }

    /**
     * Define el valor de la propiedad dsqinstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSQINSTNAME(String value) {
        this.dsqinstname = value;
    }

    /**
     * Gets the value of the sapfuncinstanceparam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapfuncinstanceparam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPFUNCINSTANCEPARAM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPFUNCINSTANCEPARAM }
     * 
     * 
     */
    public List<SAPFUNCINSTANCEPARAM> getSAPFUNCINSTANCEPARAM() {
        if (sapfuncinstanceparam == null) {
            sapfuncinstanceparam = new ArrayList<SAPFUNCINSTANCEPARAM>();
        }
        return this.sapfuncinstanceparam;
    }

    /**
     * Gets the value of the saptableinstanceparam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saptableinstanceparam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPTABLEINSTANCEPARAM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPTABLEINSTANCEPARAM }
     * 
     * 
     */
    public List<SAPTABLEINSTANCEPARAM> getSAPTABLEINSTANCEPARAM() {
        if (saptableinstanceparam == null) {
            saptableinstanceparam = new ArrayList<SAPTABLEINSTANCEPARAM>();
        }
        return this.saptableinstanceparam;
    }

}
