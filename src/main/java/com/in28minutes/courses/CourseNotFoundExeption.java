package com.in28minutes.courses;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://in28minutes.com/courses}001_COURSE_NOT_FOUND_EXEPTION")
public class CourseNotFoundExeption extends RuntimeException {
    private static final  long serialVersionUID = 3518170101751491969L;

    public CourseNotFoundExeption(String message) {
        super(message);
    }
}
