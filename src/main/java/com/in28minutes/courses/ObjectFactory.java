//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.01.02 às 04:13:53 PM BRT 
//


package com.in28minutes.courses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.in28minutes.courses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllCourseDetailsRequest_QNAME = new QName("http://in28minutes.com/courses", "GetAllCourseDetailsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.in28minutes.courses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllCourseDetailsResponse }
     * 
     */
    public GetAllCourseDetailsResponse createGetAllCourseDetailsResponse() {
        return new GetAllCourseDetailsResponse();
    }

    /**
     * Create an instance of {@link CourseDetails }
     * 
     */
    public CourseDetails createCourseDetails() {
        return new CourseDetails();
    }

    /**
     * Create an instance of {@link GetCourseDetailsRequest }
     * 
     */
    public GetCourseDetailsRequest createGetCourseDetailsRequest() {
        return new GetCourseDetailsRequest();
    }

    /**
     * Create an instance of {@link GetCourseDetailsResponse }
     * 
     */
    public GetCourseDetailsResponse createGetCourseDetailsResponse() {
        return new GetCourseDetailsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://in28minutes.com/courses", name = "GetAllCourseDetailsRequest")
    public JAXBElement<Object> createGetAllCourseDetailsRequest(Object value) {
        return new JAXBElement<Object>(_GetAllCourseDetailsRequest_QNAME, Object.class, null, value);
    }

}
