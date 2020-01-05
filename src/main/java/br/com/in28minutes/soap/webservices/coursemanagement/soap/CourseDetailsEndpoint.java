package br.com.in28minutes.soap.webservices.coursemanagement.soap;

import br.com.in28minutes.soap.webservices.coursemanagement.soap.bean.Course;
import br.com.in28minutes.soap.webservices.coursemanagement.soap.service.CourseDetailsService;
import com.in28minutes.courses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {
    //method
    //input - request - GetCourseDetailsRequest
    //output - response - GetCourseDetailsResponse

    @Autowired
    CourseDetailsService courseService;

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailRequest(@RequestPayload GetCourseDetailsRequest request){
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();

        Course course = courseService.findById(request.getId());
        if(course == null)
            throw  new CourseNotFoundExeption("Invalid Course Id "+request.getId());
        response.setCourseDetails(mapCourse(course));

        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailRequest(){
        List<Course> courses = courseService.findAll();

        return mapAllCoursesDetails(courses);
    }

    private GetAllCourseDetailsResponse mapAllCoursesDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        for (Course course : courses) {
            CourseDetails courseDetails = mapCourse(course);
            response.getCourseDetails().add(courseDetails);
        }
        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse deleteCourseDetailRequest(@RequestPayload DeleteCourseDetailsRequest request){
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();

        Status status = courseService.deleteById(request.getId());
        response.setStatus(status);
        return response;
    }

    private CourseDetails mapCourse(Course course) {

        CourseDetails courseDetails = new CourseDetails();

        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());


        return courseDetails;
    }


}
