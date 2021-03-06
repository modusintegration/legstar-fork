
package com.legstar.test.cixs.binnatsi;

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
@WebService(name = "binnatsiPort", targetNamespace = "http://cixs.test.legstar.com/binnatsi")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.legstar.test.cixs.binnatsi.ObjectFactory.class,
    com.legstar.test.coxb.binnatsi.ObjectFactory.class
})
public interface BinnatsiPort {


    /**
     * 
     * @param hostHeader
     * @param parameters
     * @return
     *     returns com.legstar.test.cixs.binnatsi.BinnatsiResponse
     * @throws BinnatsiFault
     */
    @WebMethod(action = "urn:binnatsi")
    @WebResult(name = "BinnatsiResponse", targetNamespace = "http://cixs.test.legstar.com/binnatsi", partName = "result")
    public BinnatsiResponse binnatsi(
        @WebParam(name = "BinnatsiRequest", targetNamespace = "http://cixs.test.legstar.com/binnatsi", partName = "parameters")
        BinnatsiRequest parameters,
        @WebParam(name = "BinnatsiHostHeader", targetNamespace = "http://cixs.test.legstar.com/binnatsi", header = true, partName = "hostHeader")
        BinnatsiHostHeader hostHeader)
        throws BinnatsiFault
    ;

}
