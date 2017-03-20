//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.02.12 a las 12:05:52 PM CET 
//


package corp.everis.pwc.raw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "SHORTCUT")
public class SHORTCUT {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "DBDNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dbdname;
    @XmlAttribute(name = "REPOSITORYNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String repositoryname;
    @XmlAttribute(name = "REFOBJECTNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refobjectname;
    @XmlAttribute(name = "REFERENCEDDBD")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referenceddbd;
    @XmlAttribute(name = "REFERENCETYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String referencetype;
    @XmlAttribute(name = "OBJECTTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String objecttype;
    @XmlAttribute(name = "OBJECTSUBTYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String objectsubtype;
    @XmlAttribute(name = "FOLDERNAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foldername;
    @XmlAttribute(name = "FOLDERVERSIONNAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String folderversionname;
    @XmlAttribute(name = "COMMENTS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String comments;
    @XmlAttribute(name = "VERSIONNUMBER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versionnumber;
    @XmlAttribute(name = "TEMPLATEID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String templateid;

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
     * Obtiene el valor de la propiedad dbdname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBDNAME() {
        return dbdname;
    }

    /**
     * Define el valor de la propiedad dbdname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBDNAME(String value) {
        this.dbdname = value;
    }

    /**
     * Obtiene el valor de la propiedad repositoryname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPOSITORYNAME() {
        return repositoryname;
    }

    /**
     * Define el valor de la propiedad repositoryname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPOSITORYNAME(String value) {
        this.repositoryname = value;
    }

    /**
     * Obtiene el valor de la propiedad refobjectname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFOBJECTNAME() {
        return refobjectname;
    }

    /**
     * Define el valor de la propiedad refobjectname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFOBJECTNAME(String value) {
        this.refobjectname = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceddbd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCEDDBD() {
        return referenceddbd;
    }

    /**
     * Define el valor de la propiedad referenceddbd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCEDDBD(String value) {
        this.referenceddbd = value;
    }

    /**
     * Obtiene el valor de la propiedad referencetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCETYPE() {
        return referencetype;
    }

    /**
     * Define el valor de la propiedad referencetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCETYPE(String value) {
        this.referencetype = value;
    }

    /**
     * Obtiene el valor de la propiedad objecttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTTYPE() {
        return objecttype;
    }

    /**
     * Define el valor de la propiedad objecttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTTYPE(String value) {
        this.objecttype = value;
    }

    /**
     * Obtiene el valor de la propiedad objectsubtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTSUBTYPE() {
        return objectsubtype;
    }

    /**
     * Define el valor de la propiedad objectsubtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTSUBTYPE(String value) {
        this.objectsubtype = value;
    }

    /**
     * Obtiene el valor de la propiedad foldername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOLDERNAME() {
        return foldername;
    }

    /**
     * Define el valor de la propiedad foldername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOLDERNAME(String value) {
        this.foldername = value;
    }

    /**
     * Obtiene el valor de la propiedad folderversionname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOLDERVERSIONNAME() {
        return folderversionname;
    }

    /**
     * Define el valor de la propiedad folderversionname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOLDERVERSIONNAME(String value) {
        this.folderversionname = value;
    }

    /**
     * Obtiene el valor de la propiedad comments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMENTS() {
        return comments;
    }

    /**
     * Define el valor de la propiedad comments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMENTS(String value) {
        this.comments = value;
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
     * Obtiene el valor de la propiedad templateid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEMPLATEID() {
        return templateid;
    }

    /**
     * Define el valor de la propiedad templateid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEMPLATEID(String value) {
        this.templateid = value;
    }

}
