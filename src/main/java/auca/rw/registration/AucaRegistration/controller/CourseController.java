package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.repository.AcademicRepository;
import auca.rw.registration.AucaRegistration.repository.SemesterRepository;
import auca.rw.registration.AucaRegistration.service.CourseService;
import auca.rw.registration.AucaRegistration.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/course",produces ={MediaType.APPLICATION_JSON_VALUE})
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private AcademicRepository academicUnitRepository;
    @PostMapping(value = "/saveCourse")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {

        System.err.println("error"+ course.getCourseDefinition() + course.getSemester()+ course.toString());
        //Long semId = "1";
        //course.getSemester().setId();
        Semester semester = new Semester();
        semester.setId(Long.valueOf("1"));
        course.setSemester(semester);
        if (course != null) {


            String message = courseService.saveCourse(course);

            if (message != null) {

                return new ResponseEntity<>("course saved successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("course not saved successfully", HttpStatus.BAD_GATEWAY);
            }

        } else {
            return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping(value = "/displayAllCourses")
    public ResponseEntity<?> displayAllCourses() {
        List<Course> viewCourse = courseService.displayAllCourses();

        if (!viewCourse.isEmpty()) {
            return new ResponseEntity<>(viewCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No records of courses available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        if (id != null) {
            String deleteMessage = courseService.deleteCourse(id);
            if (deleteMessage != null) {
                return new ResponseEntity<>("courses deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("course not deleted", HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

    }
    @PutMapping(value = "/updateCourses/{id}")
    public ResponseEntity<?> updateCourses(@PathVariable Long id){
        if(id !=null){
            String updateMessage = courseService.updateCourses(id);
            if(updateMessage !=null){
                return new ResponseEntity<>("course updated successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("course not updated", HttpStatus.BAD_GATEWAY);
            }
        }
        else {
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/getCoursesPerUnitAndSemester/{department_id}/{semester_id}")
    public ResponseEntity<?> getCoursesPerUnitAndSemester(@PathVariable Long department_id, @PathVariable Long semester_id) {

        Semester sem = semesterRepository.findById(semester_id).orElse(null);
        AcademicUnit dep = academicUnitRepository.findById(department_id).orElse(null);
        List<Course> Courses = courseService.getCoursesPerUnitAndSemester(dep,sem);
        if (Courses != null && !Courses.isEmpty()) {
            return new ResponseEntity<>(Courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
