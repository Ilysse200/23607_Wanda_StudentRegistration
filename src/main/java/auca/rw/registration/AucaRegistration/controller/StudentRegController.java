package auca.rw.registration.AucaRegistration.controller;


import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.domain.StudentCourse;
import auca.rw.registration.AucaRegistration.domain.StudentReg;
import auca.rw.registration.AucaRegistration.repository.AcademicRepository;
import auca.rw.registration.AucaRegistration.repository.SemesterRepository;
import auca.rw.registration.AucaRegistration.service.AcademicService;
import auca.rw.registration.AucaRegistration.service.SemesterService;
import auca.rw.registration.AucaRegistration.service.StudentRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/studentreg", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentRegController {
    @Autowired
    private StudentRegService studentRegService;
    @Autowired
    private AcademicRepository academicRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @PostMapping(value = "/savestudentreg")
    public ResponseEntity<?> saveStudentCourse(@RequestBody StudentReg studentReg) {
        if (studentReg != null) {
//            StudentCourse studentCourse = new StudentCourse();
//            studentCourse.setStudentRegistration(studentReg);
//            studentReg.getStudentCourses().add(studentCourse);
            String message = studentRegService.saveRegistration(studentReg);

            if (message != null) {
                return new ResponseEntity<>("Student's registration saved successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student's registration not saved successfully", HttpStatus.BAD_GATEWAY);
            }

        } else {
            return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }


    @GetMapping(value = "/displayAllStudentRegistration")
    public ResponseEntity<?> displayAllStudentRegistration() {
        List<StudentReg> viewStudentRegistration = studentRegService.displayAllRegistrations();

        if (!viewStudentRegistration.isEmpty()) {
            return new ResponseEntity<>(viewStudentRegistration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Student's registration of students available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteStudentRegistration/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        if (id != null) {
            String deleteMessage = studentRegService.deleteregistration(id);
            if (deleteMessage != null) {
                return new ResponseEntity<>("Student's registration deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student's registration not deleted", HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

    }
    @PutMapping(value = "/updateStudentRegistration/{id}")
    public ResponseEntity<?> updateStudentCourse(@PathVariable Long id){
        if(id !=null){
            String updateMessage = studentRegService.updateRegistration(id);
            if(updateMessage !=null){
                return new ResponseEntity<>("Student's registration updated successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Student's registration not updated", HttpStatus.BAD_GATEWAY);
            }
        }
        else {
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }

//    @GetMapping("/listByDepartmentAndSemester/{departmentCode}/{semesterId}")
//    public ResponseEntity<List<StudentReg>> listRegistrationsByDepartmentAndSemester(
//            @PathVariable Long departmentCode,
//            @PathVariable Long semesterId) {
//
//        AcademicUnit academicUnit = academicService.getAcademyByCode(departmentCode);
//        Semester semester = semesterService.getSemesterById(semesterId);
//
//        if (academicUnit != null && semester != null) {
//            List<StudentReg> registrations = studentRegService.findByAcademyandSem(academicUnit, semester);
//            return new ResponseEntity<>(registrations, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping(value = "/getStudentsbyDepartmentAndSemester/{department_id}/{semester_id}")
    public ResponseEntity<List<StudentReg>> getStudentsByDepartmentAndSemester(@PathVariable Long department_id, @PathVariable Long semester_id) {
        Semester sem = semesterRepository.findById(semester_id).orElse(null);
        AcademicUnit dep = academicRepository.findById(department_id).orElse(null);

        List<StudentReg> studentsPerDepAndSem = studentRegService.getStudentsByDepartmentAndSemester(dep,sem);
        if (studentsPerDepAndSem != null && !studentsPerDepAndSem.isEmpty()) {
            return new ResponseEntity<>(studentsPerDepAndSem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getStudentsbySemester/{semester_id}")
    public ResponseEntity<List<StudentReg>> getStudentsBySemester(@PathVariable Long semester_id) {
        Semester sem = semesterRepository.findById(semester_id).orElse(null);

        List<StudentReg> studentsPerSemester = studentRegService.getStudentsBySemester(sem);
        if (studentsPerSemester != null && !studentsPerSemester.isEmpty()) {
            return new ResponseEntity<>(studentsPerSemester, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
