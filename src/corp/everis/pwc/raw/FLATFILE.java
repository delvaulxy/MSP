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
@XmlRootElement(name = "FLATFILE")
public class FLATFILE {

    @XmlAttribute(name = "FILENAME")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String filename;
    @XmlAttribute(name = "FILETYPE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String filetype;
    @XmlAttribute(name = "DELIMITED")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String delimited;
    @XmlAttribute(name = "DELIMITERS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String delimiters;
    @XmlAttribute(name = "ROWDELIMITER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rowdelimiter;
    @XmlAttribute(name = "DELIMITERS_IN_BINARY")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String delimitersinbinary;
    @XmlAttribute(name = "QUOTE_CHARACTER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String quotecharacter;
    @XmlAttribute(name = "NULL_CHARACTER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String nullcharacter;
    @XmlAttribute(name = "NULLCHARTYPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nullchartype;
    @XmlAttribute(name = "STAGEFILEREINIT")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String stagefilereinit;
    @XmlAttribute(name = "STAGEFILEPERSIST")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String stagefilepersist;
    @XmlAttribute(name = "REPEATABLE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String repeatable;
    @XmlAttribute(name = "CONSECDELIMITERSASONE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String consecdelimitersasone;
    @XmlAttribute(name = "MULTIDELIMITERSASAND")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String multidelimitersasand;
    @XmlAttribute(name = "STRIPTRAILINGBLANKS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String striptrailingblanks;
    @XmlAttribute(name = "PADBYTES")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String padbytes;
    @XmlAttribute(name = "SKIPLEADINGBYTES")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String skipleadingbytes;
    @XmlAttribute(name = "SKIPTRAILINGBYTES")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String skiptrailingbytes;
    @XmlAttribute(name = "LINESEQUENTIAL")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String linesequential;
    @XmlAttribute(name = "KEEPESCAPECHAR")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String keepescapechar;
    @XmlAttribute(name = "SHIFTSENSITIVEDATA")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String shiftsensitivedata;
    @XmlAttribute(name = "ESCAPE_CHARACTER")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String escapecharacter;
    @XmlAttribute(name = "SKIPROWS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String skiprows;
    @XmlAttribute(name = "CODEPAGE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String codepage;

    public FLATFILE() {
		super();
	}
    public FLATFILE(String filename, String filetype, String delimited, String delimiters, String rowdelimiter,
			String delimitersinbinary, String quotecharacter, String nullcharacter, String nullchartype,
			String stagefilereinit, String stagefilepersist, String repeatable, String consecdelimitersasone,
			String multidelimitersasand, String striptrailingblanks, String padbytes, String skipleadingbytes,
			String skiptrailingbytes, String linesequential, String keepescapechar, String shiftsensitivedata,
			String escapecharacter, String skiprows, String codepage) {
		super();
		this.filename = filename;
		this.filetype = filetype;
		this.delimited = delimited;
		this.delimiters = delimiters;
		this.rowdelimiter = rowdelimiter;
		this.delimitersinbinary = delimitersinbinary;
		this.quotecharacter = quotecharacter;
		this.nullcharacter = nullcharacter;
		this.nullchartype = nullchartype;
		this.stagefilereinit = stagefilereinit;
		this.stagefilepersist = stagefilepersist;
		this.repeatable = repeatable;
		this.consecdelimitersasone = consecdelimitersasone;
		this.multidelimitersasand = multidelimitersasand;
		this.striptrailingblanks = striptrailingblanks;
		this.padbytes = padbytes;
		this.skipleadingbytes = skipleadingbytes;
		this.skiptrailingbytes = skiptrailingbytes;
		this.linesequential = linesequential;
		this.keepescapechar = keepescapechar;
		this.shiftsensitivedata = shiftsensitivedata;
		this.escapecharacter = escapecharacter;
		this.skiprows = skiprows;
		this.codepage = codepage;
	}
    public FLATFILE(FLATFILE flatfile) {
		super();
		this.filename = flatfile.filename;
		this.filetype = flatfile.filetype;
		this.delimited = flatfile.delimited;
		this.delimiters = flatfile.delimiters;
		this.rowdelimiter = flatfile.rowdelimiter;
		this.delimitersinbinary = flatfile.delimitersinbinary;
		this.quotecharacter = flatfile.quotecharacter;
		this.nullcharacter = flatfile.nullcharacter;
		this.nullchartype = flatfile.nullchartype;
		this.stagefilereinit = flatfile.stagefilereinit;
		this.stagefilepersist = flatfile.stagefilepersist;
		this.repeatable = flatfile.repeatable;
		this.consecdelimitersasone = flatfile.consecdelimitersasone;
		this.multidelimitersasand = flatfile.multidelimitersasand;
		this.striptrailingblanks = flatfile.striptrailingblanks;
		this.padbytes = flatfile.padbytes;
		this.skipleadingbytes = flatfile.skipleadingbytes;
		this.skiptrailingbytes = flatfile.skiptrailingbytes;
		this.linesequential = flatfile.linesequential;
		this.keepescapechar = flatfile.keepescapechar;
		this.shiftsensitivedata = flatfile.shiftsensitivedata;
		this.escapecharacter = flatfile.escapecharacter;
		this.skiprows = flatfile.skiprows;
		this.codepage = flatfile.codepage;
	}

	/**
     * Obtiene el valor de la propiedad filename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILENAME() {
        return filename;
    }

    /**
     * Define el valor de la propiedad filename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILENAME(String value) {
        this.filename = value;
    }

    /**
     * Obtiene el valor de la propiedad filetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILETYPE() {
        return filetype;
    }

    /**
     * Define el valor de la propiedad filetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILETYPE(String value) {
        this.filetype = value;
    }

    /**
     * Obtiene el valor de la propiedad delimited.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIMITED() {
        return delimited;
    }

    /**
     * Define el valor de la propiedad delimited.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIMITED(String value) {
        this.delimited = value;
    }

    /**
     * Obtiene el valor de la propiedad delimiters.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIMITERS() {
        return delimiters;
    }

    /**
     * Define el valor de la propiedad delimiters.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIMITERS(String value) {
        this.delimiters = value;
    }

    /**
     * Obtiene el valor de la propiedad rowdelimiter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROWDELIMITER() {
        return rowdelimiter;
    }

    /**
     * Define el valor de la propiedad rowdelimiter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROWDELIMITER(String value) {
        this.rowdelimiter = value;
    }

    /**
     * Obtiene el valor de la propiedad delimitersinbinary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIMITERSINBINARY() {
        return delimitersinbinary;
    }

    /**
     * Define el valor de la propiedad delimitersinbinary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIMITERSINBINARY(String value) {
        this.delimitersinbinary = value;
    }

    /**
     * Obtiene el valor de la propiedad quotecharacter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQUOTECHARACTER() {
        return quotecharacter;
    }

    /**
     * Define el valor de la propiedad quotecharacter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQUOTECHARACTER(String value) {
        this.quotecharacter = value;
    }

    /**
     * Obtiene el valor de la propiedad nullcharacter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNULLCHARACTER() {
        return nullcharacter;
    }

    /**
     * Define el valor de la propiedad nullcharacter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNULLCHARACTER(String value) {
        this.nullcharacter = value;
    }

    /**
     * Obtiene el valor de la propiedad nullchartype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNULLCHARTYPE() {
        return nullchartype;
    }

    /**
     * Define el valor de la propiedad nullchartype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNULLCHARTYPE(String value) {
        this.nullchartype = value;
    }

    /**
     * Obtiene el valor de la propiedad stagefilereinit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTAGEFILEREINIT() {
        return stagefilereinit;
    }

    /**
     * Define el valor de la propiedad stagefilereinit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTAGEFILEREINIT(String value) {
        this.stagefilereinit = value;
    }

    /**
     * Obtiene el valor de la propiedad stagefilepersist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTAGEFILEPERSIST() {
        return stagefilepersist;
    }

    /**
     * Define el valor de la propiedad stagefilepersist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTAGEFILEPERSIST(String value) {
        this.stagefilepersist = value;
    }

    /**
     * Obtiene el valor de la propiedad repeatable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPEATABLE() {
        return repeatable;
    }

    /**
     * Define el valor de la propiedad repeatable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPEATABLE(String value) {
        this.repeatable = value;
    }

    /**
     * Obtiene el valor de la propiedad consecdelimitersasone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONSECDELIMITERSASONE() {
        return consecdelimitersasone;
    }

    /**
     * Define el valor de la propiedad consecdelimitersasone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONSECDELIMITERSASONE(String value) {
        this.consecdelimitersasone = value;
    }

    /**
     * Obtiene el valor de la propiedad multidelimitersasand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMULTIDELIMITERSASAND() {
        return multidelimitersasand;
    }

    /**
     * Define el valor de la propiedad multidelimitersasand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMULTIDELIMITERSASAND(String value) {
        this.multidelimitersasand = value;
    }

    /**
     * Obtiene el valor de la propiedad striptrailingblanks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTRIPTRAILINGBLANKS() {
        return striptrailingblanks;
    }

    /**
     * Define el valor de la propiedad striptrailingblanks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTRIPTRAILINGBLANKS(String value) {
        this.striptrailingblanks = value;
    }

    /**
     * Obtiene el valor de la propiedad padbytes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPADBYTES() {
        return padbytes;
    }

    /**
     * Define el valor de la propiedad padbytes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPADBYTES(String value) {
        this.padbytes = value;
    }

    /**
     * Obtiene el valor de la propiedad skipleadingbytes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSKIPLEADINGBYTES() {
        return skipleadingbytes;
    }

    /**
     * Define el valor de la propiedad skipleadingbytes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSKIPLEADINGBYTES(String value) {
        this.skipleadingbytes = value;
    }

    /**
     * Obtiene el valor de la propiedad skiptrailingbytes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSKIPTRAILINGBYTES() {
        return skiptrailingbytes;
    }

    /**
     * Define el valor de la propiedad skiptrailingbytes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSKIPTRAILINGBYTES(String value) {
        this.skiptrailingbytes = value;
    }

    /**
     * Obtiene el valor de la propiedad linesequential.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINESEQUENTIAL() {
        return linesequential;
    }

    /**
     * Define el valor de la propiedad linesequential.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINESEQUENTIAL(String value) {
        this.linesequential = value;
    }

    /**
     * Obtiene el valor de la propiedad keepescapechar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKEEPESCAPECHAR() {
        return keepescapechar;
    }

    /**
     * Define el valor de la propiedad keepescapechar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKEEPESCAPECHAR(String value) {
        this.keepescapechar = value;
    }

    /**
     * Obtiene el valor de la propiedad shiftsensitivedata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIFTSENSITIVEDATA() {
        return shiftsensitivedata;
    }

    /**
     * Define el valor de la propiedad shiftsensitivedata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIFTSENSITIVEDATA(String value) {
        this.shiftsensitivedata = value;
    }

    /**
     * Obtiene el valor de la propiedad escapecharacter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESCAPECHARACTER() {
        return escapecharacter;
    }

    /**
     * Define el valor de la propiedad escapecharacter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESCAPECHARACTER(String value) {
        this.escapecharacter = value;
    }

    /**
     * Obtiene el valor de la propiedad skiprows.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSKIPROWS() {
        return skiprows;
    }

    /**
     * Define el valor de la propiedad skiprows.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSKIPROWS(String value) {
        this.skiprows = value;
    }

    /**
     * Obtiene el valor de la propiedad codepage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODEPAGE() {
        return codepage;
    }

    /**
     * Define el valor de la propiedad codepage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODEPAGE(String value) {
        this.codepage = value;
    }

}
