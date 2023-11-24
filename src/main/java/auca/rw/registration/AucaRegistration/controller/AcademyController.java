package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.service.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/academy", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AcademyController {
    @Autowired
    private AcademicService academicService;
    @PostMapping(value = "/saveacademy")
        public ResponseEntity<?> saveAcademy(@RequestBody AcademicUnit academicUnit) {
            if (academicUnit != null) {

                String message = academicService.saveAcademy(academicUnit);
                if (message != null) {
                    return new ResponseEntity<>(" academy saved successfully", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("academy not saved successfully", HttpStatus.BAD_GATEWAY);
                }

            } else {
                return new ResponseEntity<>("something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }
        @GetMapping(value = "/displayAllacademies")
        public ResponseEntity<?> displayAllacademies() {
            List<AcademicUnit> viewacademy = academicService.displayAllAcademies();

            if (!viewacademy.isEmpty()) {
                return new ResponseEntity<>(viewacademy, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No records of coursedef available", HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping(value = "/deleteAcademies/{id}")
        public ResponseEntity<?> deleteacademies(@PathVariable Long id) {
            if (id != null) {
                String deleteMessage = academicService.deleteAcademic(id);
                if (deleteMessage != null) {
                    return new ResponseEntity<>("academy deleted successfully", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("academy not deleted", HttpStatus.BAD_GATEWAY);
                }
            }
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);

        }
        @PutMapping(value = "/updateacademy/{id}")
        public ResponseEntity<?> updateacademy(@PathVariable Long id){
            if(id !=null){
                String updateMessage = academicService.updateAcademy(id);

                if(updateMessage !=null){
                    return new ResponseEntity<>("academy updated successfully", HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>("academy not updated", HttpStatus.BAD_GATEWAY);
                }
            }
            else {
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }

    }

