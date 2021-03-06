package com.legstar.test.cixs.arraygrp;
import java.rmi.server.UID;
import javax.jws.WebService;

import com.legstar.coxb.transform.HostTransformException;
import com.legstar.host.invoke.AbstractServiceAdapter;
import com.legstar.host.invoke.HostInvokerException;
import com.legstar.messaging.LegStarAddress;
import com.legstar.test.coxb.arraygrp.Dfhcommarea;

/**
 * JAX-WS Service Adapter implementation.
 * Each method maps to a CICS program. 
 * 
 * This class was generated by LegStar Mainframe Web Service adapter generator.
 */
@WebService(endpointInterface = "com.legstar.test.cixs.arraygrp.Arraygrp",
            serviceName = "arraygrpService",
            portName = "arraygrpPort",
            targetNamespace = "http://cixs.test.legstar.com/arraygrp")
public class ArraygrpImpl extends AbstractServiceAdapter implements Arraygrp {

    /** Name of this service adapter implementation. */
    private static final String  SERVICE_ADAPTER_NAME = "arraygrp";

    /** Invoker implementation for operation arraygrp. */
    private ArraygrpProgramInvoker mArraygrpProgramInvoker;

    /** Contructor creates a set of operation invokers. */
    public ArraygrpImpl() {
        super(SERVICE_ADAPTER_NAME);
        mArraygrpProgramInvoker = new ArraygrpProgramInvoker(getConfigFileName());
    }
    
    /** {@inheritDoc} */
    public Dfhcommarea arraygrp(
               final Dfhcommarea request,
               final ArraygrpHostHeader hostHeader)
               throws ArraygrpFault {
    
        try {
            return getArraygrpProgramInvoker().arraygrp(
                    getAddress(hostHeader), getRequestID(hostHeader), request);
        } catch (HostInvokerException e) {
            throw getArraygrpFault(e, "Failed to invoke host program:");
        } catch (HostTransformException e) {
            throw getArraygrpFault(e, "Failed to transform data:");
        }
    }

    /**
     * Formats a fault element to notify client of an exception.
     *
     * @param e the exception which occurred
     * @param text short message describing the context
     * @return the fault exception
     */
    public ArraygrpFault getArraygrpFault(
            final Exception e, final String text) {

        ArraygrpFaultInfo faultInfo = new ArraygrpFaultInfo();
        faultInfo.setMessage(e.getMessage());
        faultInfo.setDetail(getArraygrpProgramInvoker().toString());
        return new ArraygrpFault(text + ' ' 
                + faultInfo.getMessage(), faultInfo, e);
    }

        
    /**
     * Extracts header data from SOAP header and create a host address.
     * @param hostHeader the java object mapping the SOAP header element
     * @return the new host address
     */
    public LegStarAddress getAddress(
            final ArraygrpHostHeader hostHeader) {
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
    public String getRequestID(final ArraygrpHostHeader hostHeader) {
        if (hostHeader != null && hostHeader.getHostRequestID() != null) {
            return hostHeader.getHostRequestID();
        } else {
            return getServiceAdapterName() + ":" + new UID().toString();
        }
    }

    /**
     * @return the invoker implementation for operation arraygrp
     */
    public ArraygrpProgramInvoker getArraygrpProgramInvoker() {
        return mArraygrpProgramInvoker;
    }

    /**
     * @param programInvoker the invoker implementation for operation arraygrp to set
     */
    public void setArraygrpProgramInvoker(
            final ArraygrpProgramInvoker programInvoker) {
        mArraygrpProgramInvoker = programInvoker;
    }
    
}
