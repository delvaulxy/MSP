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
    "sebljoin",
    "sebllink",
    "seblmvlink",
    "seblmvlinkrel"
})
@XmlRootElement(name = "SEBLSRCINFO")
public class SEBLSRCINFO {

    @XmlElement(name = "SEBLJOIN")
    protected List<SEBLJOIN> sebljoin;
    @XmlElement(name = "SEBLLINK")
    protected List<SEBLLINK> sebllink;
    @XmlElement(name = "SEBLMVLINK")
    protected List<SEBLMVLINK> seblmvlink;
    @XmlElement(name = "SEBLMVLINKREL")
    protected List<SEBLMVLINKREL> seblmvlinkrel;

    /**
     * Gets the value of the sebljoin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sebljoin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSEBLJOIN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SEBLJOIN }
     * 
     * 
     */
    public List<SEBLJOIN> getSEBLJOIN() {
        if (sebljoin == null) {
            sebljoin = new ArrayList<SEBLJOIN>();
        }
        return this.sebljoin;
    }

    /**
     * Gets the value of the sebllink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sebllink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSEBLLINK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SEBLLINK }
     * 
     * 
     */
    public List<SEBLLINK> getSEBLLINK() {
        if (sebllink == null) {
            sebllink = new ArrayList<SEBLLINK>();
        }
        return this.sebllink;
    }

    /**
     * Gets the value of the seblmvlink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seblmvlink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSEBLMVLINK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SEBLMVLINK }
     * 
     * 
     */
    public List<SEBLMVLINK> getSEBLMVLINK() {
        if (seblmvlink == null) {
            seblmvlink = new ArrayList<SEBLMVLINK>();
        }
        return this.seblmvlink;
    }

    /**
     * Gets the value of the seblmvlinkrel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seblmvlinkrel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSEBLMVLINKREL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SEBLMVLINKREL }
     * 
     * 
     */
    public List<SEBLMVLINKREL> getSEBLMVLINKREL() {
        if (seblmvlinkrel == null) {
            seblmvlinkrel = new ArrayList<SEBLMVLINKREL>();
        }
        return this.seblmvlinkrel;
    }

}
