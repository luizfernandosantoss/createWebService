package br.com.in28minutes.soap.webservices.coursemanagement.soap;

import br.com.in28minutes.soap.webservices.coursemanagement.soap.bean.Course;
import br.com.in28minutes.soap.webservices.coursemanagement.soap.service.CourseDetailsService;
import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetAllCourseDetailsResponse;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;
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

    private CourseDetails mapCourse(Course course) {

        CourseDetails courseDetails = new CourseDetails();

        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());


        return courseDetails;
    }


}
