package br.com.in28minutes.soap.webservices.coursemanagement.soap;

import br.com.in28minutes.soap.webservices.coursemanagement.soap.bean.Course;
import br.com.in28minutes.soap.webservices.coursemanagement.soap.service.CourseDetailsService;
import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {
    //method
    //input - request - GetCourseDetailsRequest
    //output - response - GetCourseDetailsResponse

    @Autowired
    CourseDetailsService service;

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetail(@RequestPayload GetCourseDetailsRequest request){
        Course course = service.findById(request.getId());

        return mapCourse(course);
    }

    private GetCourseDetailsResponse mapCourse(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();

        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());

        response.setCourseDetails(courseDetails);

        return response;
    }


}
