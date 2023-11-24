package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.*;
import auca.rw.registration.AucaRegistration.repository.CourseRepo;
import auca.rw.registration.AucaRegistration.repository.SemesterRepository;
import auca.rw.registration.AucaRegistration.repository.StudentRegRepo;
import auca.rw.registration.AucaRegistration.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/sCourse", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private StudentRegRepo studentRegRepo;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private CourseRepo courseRepo;
    @PostMapping(value = "/studCourse")
    public ResponseEntity<?> saveStudentCourse(@RequestBody StudentCourse studentCourse) {
        if (studentCourse != null) {

            String message = studentCourseService.savestudentCourseService(studentCourse);
            if (message != null) {
                return new ResponseEntity<>("Student's course saved successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student's course not saved successfully", HttpStatus.BAD_GATEWAY);
            }

        } else {
            return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/displayAllStudentCourse")
    public ResponseEntity<?> displayAllStudentCourse() {
        List<StudentCourse> viewStudentCourse = studentCourseService.displayAllStudentCourse();

        if (!viewStudentCourse.isEmpty()) {
            return new ResponseEntity<>(viewStudentCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Student's course of students available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        if (id != null) {
            String deleteMessage = studentCourseService.deleteStudentCourse(id);
            if (deleteMessage != null) {
                return new ResponseEntity<>("Student's course deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student's course not deleted", HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

    }
    @PutMapping(value = "/updateStudentCourse/{id}")
    public ResponseEntity<?> updateStudentCourse(@PathVariable Long id){
        if(id !=null){
            String updateMessage = studentCourseService.updateStudentcourse(id);
            if(updateMessage !=null){
                return new ResponseEntity<>("Student's course updated successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Student's course not updated", HttpStatus.BAD_GATEWAY);
            }
        }
        else {
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/getCoursesPerStudent/{studentReg_id}")
    public ResponseEntity<List<StudentCourse>> getStudentCourses(@PathVariable Long studentReg_id) {

        StudentReg studentRegistration = studentRegRepo.findById(studentReg_id).orElse(null);
        List<StudentCourse> studentCourses = studentCourseService.getAllCoursesPerStudent(studentRegistration);
        if (studentCourses != null && !studentCourses.isEmpty()) {
            return new ResponseEntity<>(studentCourses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getStudentsPerCourseAndSemester/{course_id}/{semester_id}")
    public ResponseEntity<List<StudentCourse>> getStudentPerCoursesAndSemester(@PathVariable Long course_id, @PathVariable Long semester_id) {

        Course course = courseRepo.findById(course_id).orElse(null);
        Semester sem = semesterRepository.findById(semester_id).orElse(null);
        List<StudentCourse> studentCourses = studentCourseService.getStudentByCourseAndSemester(course,sem);
        if (studentCourses != null && !studentCourses.isEmpty()) {
            return new ResponseEntity<>(studentCourses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
