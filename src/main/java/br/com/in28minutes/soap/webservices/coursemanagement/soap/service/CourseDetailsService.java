package br.com.in28minutes.soap.webservices.coursemanagement.soap.service;

import br.com.in28minutes.soap.webservices.coursemanagement.soap.bean.Course;
import com.in28minutes.courses.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1,"Spring","10 Steps");
        Course course2 = new Course(2,"Spring MVC","10 Examples");
        Course course3 = new Course(3,"Spring Boot","6k Students");
        Course course4 = new Course(4,"Maven","10 Steps");
        Course course5 = new Course(5,"Spring","Most popular mavem course");
        courses.addAll(Arrays.asList(course1,course2,course3,course4,course5));
    }

    // course - 1
    // Course findById(int id)
    public Course findById(int id){
        for (Course course: courses){
            if(course.getId() == id){
                return course;
            }
        }
        return null;
    }

    //courses
    // List<Course> findAll()
    public List<Course> findAll(){
        return courses;
    }

    //deleteCourse findById(int id)
    public Status deleteById(int id){
        Iterator<Course> interator = courses.iterator();
        while (interator.hasNext()){
            Course course = interator.next();
            if(course.getId() == id){
                interator.remove();
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    //updating course & new course

}
