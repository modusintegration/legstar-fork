
package com.legstar.test.cixs.redopera;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "RedoperaFaultInfo", targetNamespace = "http://cixs.test.legstar.com/redopera")
public class RedoperaFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RedoperaFaultInfo faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public RedoperaFault(String message, RedoperaFaultInfo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public RedoperaFault(String message, RedoperaFaultInfo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.legstar.test.cixs.redopera.RedoperaFaultInfo
     */
    public RedoperaFaultInfo getFaultInfo() {
        return faultInfo;
    }

}
