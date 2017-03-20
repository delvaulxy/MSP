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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sapfunction",
    "sapstructure",
    "sapprogram",
    "sapoutputport",
    "sapvariable",
    "sapprogramflowobject"
})
@XmlRootElement(name = "ERPINFO")
public class ERPINFO {

    @XmlElement(name = "SAPFUNCTION")
    protected List<SAPFUNCTION> sapfunction;
    @XmlElement(name = "SAPSTRUCTURE")
    protected List<SAPSTRUCTURE> sapstructure;
    @XmlElement(name = "SAPPROGRAM")
    protected List<SAPPROGRAM> sapprogram;
    @XmlElement(name = "SAPOUTPUTPORT")
    protected List<SAPOUTPUTPORT> sapoutputport;
    @XmlElement(name = "SAPVARIABLE")
    protected List<SAPVARIABLE> sapvariable;
    @XmlElement(name = "SAPPROGRAMFLOWOBJECT")
    protected List<SAPPROGRAMFLOWOBJECT> sapprogramflowobject;

    /**
     * Gets the value of the sapfunction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapfunction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPFUNCTION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPFUNCTION }
     * 
     * 
     */
    public List<SAPFUNCTION> getSAPFUNCTION() {
        if (sapfunction == null) {
            sapfunction = new ArrayList<SAPFUNCTION>();
        }
        return this.sapfunction;
    }

    /**
     * Gets the value of the sapstructure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapstructure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPSTRUCTURE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPSTRUCTURE }
     * 
     * 
     */
    public List<SAPSTRUCTURE> getSAPSTRUCTURE() {
        if (sapstructure == null) {
            sapstructure = new ArrayList<SAPSTRUCTURE>();
        }
        return this.sapstructure;
    }

    /**
     * Gets the value of the sapprogram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapprogram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPPROGRAM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPPROGRAM }
     * 
     * 
     */
    public List<SAPPROGRAM> getSAPPROGRAM() {
        if (sapprogram == null) {
            sapprogram = new ArrayList<SAPPROGRAM>();
        }
        return this.sapprogram;
    }

    /**
     * Gets the value of the sapoutputport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapoutputport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPOUTPUTPORT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPOUTPUTPORT }
     * 
     * 
     */
    public List<SAPOUTPUTPORT> getSAPOUTPUTPORT() {
        if (sapoutputport == null) {
            sapoutputport = new ArrayList<SAPOUTPUTPORT>();
        }
        return this.sapoutputport;
    }

    /**
     * Gets the value of the sapvariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapvariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPVARIABLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPVARIABLE }
     * 
     * 
     */
    public List<SAPVARIABLE> getSAPVARIABLE() {
        if (sapvariable == null) {
            sapvariable = new ArrayList<SAPVARIABLE>();
        }
        return this.sapvariable;
    }

    /**
     * Gets the value of the sapprogramflowobject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sapprogramflowobject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSAPPROGRAMFLOWOBJECT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SAPPROGRAMFLOWOBJECT }
     * 
     * 
     */
    public List<SAPPROGRAMFLOWOBJECT> getSAPPROGRAMFLOWOBJECT() {
        if (sapprogramflowobject == null) {
            sapprogramflowobject = new ArrayList<SAPPROGRAMFLOWOBJECT>();
        }
        return this.sapprogramflowobject;
    }

}
