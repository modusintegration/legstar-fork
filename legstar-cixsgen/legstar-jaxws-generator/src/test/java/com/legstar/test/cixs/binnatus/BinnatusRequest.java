package com.legstar.test.cixs.binnatus;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.legstar.test.coxb.binnatus.Dfhcommarea;

/**
 * LegStar/Jaxws Operation Request Wrapper.
 * A wrapper class for the Request.
 * 
 * This class was generated by LegStar Mainframe Web Service adapter generator.
 */

@XmlRootElement(name = "BinnatusRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinnatusRequest",
         namespace = "http://cixs.test.legstar.com/binnatus",
         propOrder = {
    "request"
})
public class BinnatusRequest {
    
    /** Inner JAXB-bound object. */
    @XmlElement(name = "Dfhcommarea",
                namespace = "http://legstar.com/test/coxb/binnatus",
                required = true)
    private Dfhcommarea request;

    /**
    * Get the inner JAXB-bound object.
    * 
    * @return JAXB-bound object
    */
    public Dfhcommarea getRequest() {
        return request;
    }

  /**
   * Set the inner JAXB-bound object.
   * 
   * @param value JAXB-bound object
   */
    public void setRequest(
            final Dfhcommarea value) {
        request = value;
    }

}
