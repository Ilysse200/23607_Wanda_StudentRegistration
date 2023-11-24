package auca.rw.registration.AucaRegistration.controller;


import auca.rw.registration.AucaRegistration.domain.CourseDefinition;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.repository.CourseDefinitionRepo;
import auca.rw.registration.AucaRegistration.service.CourseDefinitionService;
import auca.rw.registration.AucaRegistration.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/coursedefinition", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CourseDefinitionController {
    @Autowired
    private CourseDefinitionService courseDefinitionService;
    @PostMapping(value = "/savecoursedefinition")
    public ResponseEntity<?> saveCourseDef(@RequestBody CourseDefinition courseDefinition) {
        if (courseDefinition != null) {

            String message = courseDefinitionService.saveCourseDef(courseDefinition);
            if (message != null) {
                return new ResponseEntity<>(" coursedef saved successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("coursedef not saved successfully", HttpStatus.BAD_GATEWAY);
            }

        } else {
            return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping(value = "/displayAllcourses")
    public ResponseEntity<?> displayAllcourses() {
        List<CourseDefinition> viewCourses = courseDefinitionService.displayAllCoursesDef();

        if (!viewCourses.isEmpty()) {
            return new ResponseEntity<>(viewCourses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No records of coursedef available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteCourses/{id}")
    public ResponseEntity<?> deletecourses(@PathVariable Long id) {
        if (id != null) {
            String deleteMessage = courseDefinitionService.deleteCourseDef(id);
            if (deleteMessage != null) {
                return new ResponseEntity<>("coursedef deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("coursedef not deleted", HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

    }
    @PutMapping(value = "/updateCourse/{id}")
        public ResponseEntity<?> updatecourses(@PathVariable Long id){
        if(id !=null){
            String updateMessage = courseDefinitionService.updateCourseDef(id);

            if(updateMessage !=null){
                return new ResponseEntity<>("coursedef updated successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("coursedef not updated", HttpStatus.BAD_GATEWAY);
            }
        }
        else {
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }
    }

}
