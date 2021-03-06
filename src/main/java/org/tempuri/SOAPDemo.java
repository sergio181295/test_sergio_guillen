
package org.tempuri;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SOAPDemo", targetNamespace = "http://tempuri.org", wsdlLocation = "/wsdl/persons.wsdl")
public class SOAPDemo
    extends Service
{

    private final static URL SOAPDEMO_WSDL_LOCATION;
    private final static WebServiceException SOAPDEMO_EXCEPTION;
    private final static QName SOAPDEMO_QNAME = new QName("http://tempuri.org", "SOAPDemo");

    static {
        SOAPDEMO_WSDL_LOCATION = org.tempuri.SOAPDemo.class.getResource("/wsdl/persons.wsdl");
        WebServiceException e = null;
        if (SOAPDEMO_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find '/wsdl/persons.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        SOAPDEMO_EXCEPTION = e;
    }

    public SOAPDemo() {
        super(__getWsdlLocation(), SOAPDEMO_QNAME);
    }

    public SOAPDemo(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPDEMO_QNAME, features);
    }

    public SOAPDemo(URL wsdlLocation) {
        super(wsdlLocation, SOAPDEMO_QNAME);
    }

    public SOAPDemo(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPDEMO_QNAME, features);
    }

    public SOAPDemo(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAPDemo(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOAPDemoSoap
     */
    @WebEndpoint(name = "SOAPDemoSoap")
    public SOAPDemoSoap getSOAPDemoSoap() {
        return super.getPort(new QName("http://tempuri.org", "SOAPDemoSoap"), SOAPDemoSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOAPDemoSoap
     */
    @WebEndpoint(name = "SOAPDemoSoap")
    public SOAPDemoSoap getSOAPDemoSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org", "SOAPDemoSoap"), SOAPDemoSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPDEMO_EXCEPTION!= null) {
            throw SOAPDEMO_EXCEPTION;
        }
        return SOAPDEMO_WSDL_LOCATION;
    }

}
