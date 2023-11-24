package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.domain.Student;
import auca.rw.registration.AucaRegistration.service.SemesterService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( value = "/semester", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @PostMapping(value = "/saveSemester")
    public ResponseEntity<?> saveStudent(@RequestBody Semester semester) {
        if (semester != null) {

            String message = semesterService.saveSemester(semester);
            if (message != null) {
                return new ResponseEntity<>("Semester saved successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Semester not saved successfully", HttpStatus.BAD_GATEWAY);
            }

        } else {
            return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping(value = "/displayAllSemesters")
    public ResponseEntity<?> displayAllSemesters() {
        List<Semester> viewSemester = semesterService.displayAllSemesters();

        if (!viewSemester.isEmpty()) {
            return new ResponseEntity<>(viewSemester, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No records of students available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteSemester/{id}")
    public ResponseEntity<?> deleteSemester(@PathVariable Long id) {
        if (id != null) {
            String deleteMessage = semesterService.deleteSemester(id);
            if (deleteMessage != null) {
                return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student not deleted", HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

    }
    @PutMapping(value = "/updateSemester/{id}")
    public ResponseEntity<?> updateSemester(@PathVariable Long id){
        if(id !=null){
            String updateMessage = semesterService.updateSemester(id);
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
