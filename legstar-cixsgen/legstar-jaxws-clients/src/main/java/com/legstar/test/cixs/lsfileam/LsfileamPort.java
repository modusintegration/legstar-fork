
package com.legstar.test.cixs.lsfileam;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "lsfileamPort", targetNamespace = "http://cixs.test.legstar.com/lsfileam")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.legstar.test.coxb.lsfileac.ObjectFactory.class,
    com.legstar.test.cixs.lsfileam.ObjectFactory.class
})
public interface LsfileamPort {


    /**
     * 
     * @param hostHeader
     * @param parameters
     * @return
     *     returns com.legstar.test.cixs.lsfileam.LsfileamResponse
     * @throws LsfileamFault
     */
    @WebMethod(action = "urn:lsfileam")
    @WebResult(name = "LsfileamResponse", targetNamespace = "http://cixs.test.legstar.com/lsfileam", partName = "result")
    public LsfileamResponse lsfileam(
        @WebParam(name = "LsfileamRequest", targetNamespace = "http://cixs.test.legstar.com/lsfileam", partName = "parameters")
        LsfileamRequest parameters,
        @WebParam(name = "LsfileamHostHeader", targetNamespace = "http://cixs.test.legstar.com/lsfileam", header = true, partName = "hostHeader")
        LsfileamHostHeader hostHeader)
        throws LsfileamFault
    ;

}
