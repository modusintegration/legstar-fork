package com.legstar.test.cixs.doublmix;
import java.rmi.server.UID;
import javax.jws.WebService;

import com.legstar.coxb.transform.HostTransformException;
import com.legstar.host.invoke.AbstractServiceAdapter;
import com.legstar.host.invoke.HostInvokerException;
import com.legstar.messaging.LegStarAddress;
import com.legstar.test.coxb.doublmix.Dfhcommarea;

/**
 * JAX-WS Service Adapter implementation.
 * Each method maps to a CICS program. 
 * 
 * This class was generated by LegStar Mainframe Web Service adapter generator.
 */
@WebService(endpointInterface = "com.legstar.test.cixs.doublmix.Doublmix",
            serviceName = "doublmixService",
            portName = "doublmixPort",
            targetNamespace = "http://cixs.test.legstar.com/doublmix")
public class DoublmixImpl extends AbstractServiceAdapter implements Doublmix {

    /** Name of this service adapter implementation. */
    private static final String  SERVICE_ADAPTER_NAME = "doublmix";

    /** Invoker implementation for operation doublmix. */
    private DoublmixProgramInvoker mDoublmixProgramInvoker;

    /** Contructor creates a set of operation invokers. */
    public DoublmixImpl() {
        super(SERVICE_ADAPTER_NAME);
        mDoublmixProgramInvoker = new DoublmixProgramInvoker(getConfigFileName());
    }
    
    /** {@inheritDoc} */
    public Dfhcommarea doublmix(
               final Dfhcommarea request,
               final DoublmixHostHeader hostHeader)
               throws DoublmixFault {
    
        try {
            return getDoublmixProgramInvoker().doublmix(
                    getAddress(hostHeader), getRequestID(hostHeader), request);
        } catch (HostInvokerException e) {
            throw getDoublmixFault(e, "Failed to invoke host program:");
        } catch (HostTransformException e) {
            throw getDoublmixFault(e, "Failed to transform data:");
        }
    }

    /**
     * Formats a fault element to notify client of an exception.
     *
     * @param e the exception which occurred
     * @param text short message describing the context
     * @return the fault exception
     */
    public DoublmixFault getDoublmixFault(
            final Exception e, final String text) {

        DoublmixFaultInfo faultInfo = new DoublmixFaultInfo();
        faultInfo.setMessage(e.getMessage());
        faultInfo.setDetail(getDoublmixProgramInvoker().toString());
        return new DoublmixFault(text + ' ' 
                + faultInfo.getMessage(), faultInfo, e);
    }

        
    /**
     * Extracts header data from SOAP header and create a host address.
     * @param hostHeader the java object mapping the SOAP header element
     * @return the new host address
     */
    public LegStarAddress getAddress(
            final DoublmixHostHeader hostHeader) {
        if (hostHeader == null) {
            return null;
        }
        LegStarAddress address = new LegStarAddress(hostHeader.getHostEndPoint());
        address.setHostCharset(hostHeader.getHostCharset());
        address.setHostUserID(hostHeader.getHostUserID());
        address.setHostPassword(hostHeader.getHostPassword());
        address.setHostTraceMode(hostHeader.getHostTraceMode());
        return address;
    }

    /**
     * Generates a unique ID for a request. This can be passed from the client
     * using the host header.
     * @param hostHeader the java object mapping the SOAP header element
     * @return  a unique request ID
     */
    public String getRequestID(final DoublmixHostHeader hostHeader) {
        if (hostHeader != null && hostHeader.getHostRequestID() != null) {
            return hostHeader.getHostRequestID();
        } else {
            return getServiceAdapterName() + ":" + new UID().toString();
        }
    }

    /**
     * @return the invoker implementation for operation doublmix
     */
    public DoublmixProgramInvoker getDoublmixProgramInvoker() {
        return mDoublmixProgramInvoker;
    }

    /**
     * @param programInvoker the invoker implementation for operation doublmix to set
     */
    public void setDoublmixProgramInvoker(
            final DoublmixProgramInvoker programInvoker) {
        mDoublmixProgramInvoker = programInvoker;
    }
    
}
