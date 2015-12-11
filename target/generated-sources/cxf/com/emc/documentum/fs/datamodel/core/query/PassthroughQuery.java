
package com.emc.documentum.fs.datamodel.core.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PassthroughQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PassthroughQuery">
 *   &lt;complexContent>
 *     &lt;extension base="{http://query.core.datamodel.fs.documentum.emc.com/}Query">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="queryString" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="typeAlias" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PassthroughQuery")
public class PassthroughQuery
    extends Query
{

    @XmlAttribute(name = "queryString")
    protected String queryString;
    @XmlAttribute(name = "typeAlias")
    protected String typeAlias;

    /**
     * Gets the value of the queryString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Sets the value of the queryString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryString(String value) {
        this.queryString = value;
    }

    /**
     * Gets the value of the typeAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeAlias() {
        return typeAlias;
    }

    /**
     * Sets the value of the typeAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeAlias(String value) {
        this.typeAlias = value;
    }

}