package br.com.in28minutes.soap.webservices.coursemanagement.soap;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Criando a configuração para geração do Wsdl.
//Enable Spring Web Services
@EnableWs
//Spring Configuration
@Configuration
public class WebServiceConfig {
    //MessageDispatcherServlet
        //ApplicationContext
    //url -> /ws/*

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformSchemaLocations(true);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");

        return servletRegistrationBean;
    }

    // /Ws/courses.wsdl
    // course=details.xsd
    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        //PortType - CoursePort
        definition.setPortTypeName("CoursePort");
        //Namespace - http://in28minutes.com/courses
        definition.setTargetNamespace("http://in28minutes.com/courses");
        // ws /
        definition.setLocationUri("http://localhost:8080/ws");
        //schema
        definition.setSchema(coursesSchema);

        return definition;
    }

    @Bean
    public XsdSchema coursesSchema(){
        SimpleXsdSchema simpleXsdSchema = new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
        return simpleXsdSchema;
    }

}

