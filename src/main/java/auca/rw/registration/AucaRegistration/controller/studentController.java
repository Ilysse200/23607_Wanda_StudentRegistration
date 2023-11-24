package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.Student;
import auca.rw.registration.AucaRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/student", produces = {MediaType.APPLICATION_JSON_VALUE})
public class studentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        if (student != null) {

            String message = studentService.saveStudent(student);
            if (message != null) {
                return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not saved successfully", HttpStatus.BAD_GATEWAY);
            }

        } else {
            return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/displayAllStudents")
    public ResponseEntity<?> displayAllStudents() {
        List<Student> viewStudents = studentService.displayAllStudents();

        if (!viewStudents.isEmpty()) {
            return new ResponseEntity<>(viewStudents, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No records of students available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        if (id != null) {
            String deleteMessage = studentService.deleteStudent(id);
            if (deleteMessage != null) {
                return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not deleted", HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

    }
    @PutMapping(value = "/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id){
        if(id !=null){
            String updateMessage = studentService.updateStudent(id);
            if(updateMessage !=null){
                return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Student not updated", HttpStatus.BAD_GATEWAY);
            }
        }
        else {
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }
}




