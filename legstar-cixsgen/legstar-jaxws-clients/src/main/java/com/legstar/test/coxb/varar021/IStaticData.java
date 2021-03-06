
package com.legstar.test.coxb.varar021;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LkupInfo" type="{http://legstar.com/test/coxb/varar021}LkupInfo39" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IStaticData", propOrder = {
    "lkupInfo"
})
public class IStaticData {

    @XmlElement(name = "LkupInfo", required = true)
    protected List<LkupInfo39> lkupInfo;

    /**
     * Gets the value of the lkupInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lkupInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLkupInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LkupInfo39 }
     * 
     * 
     */
    public List<LkupInfo39> getLkupInfo() {
        if (lkupInfo == null) {
            lkupInfo = new ArrayList<LkupInfo39>();
        }
        return this.lkupInfo;
    }

}
