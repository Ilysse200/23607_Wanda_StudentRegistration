package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.CourseDefinition;
import auca.rw.registration.AucaRegistration.repository.CourseDefinitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseDefinitionService {
    @Autowired
    private CourseDefinitionRepo courseDefinitionRepo;
    public String saveCourseDef(CourseDefinition courseDefinition) {
        if (courseDefinition != null) {
            courseDefinitionRepo.save(courseDefinition);
            return "coursedefinition saved successfully";
        } else {
            return null;
        }
    }
    public List<CourseDefinition> displayAllCoursesDef() {
        return courseDefinitionRepo.findAll();

    }

    public String deleteCourseDef(Long id) {
        if (id != null) {
            courseDefinitionRepo.deleteById(id);
            return "coursedefinition deleted successfully";
        } else {
            return "No coursedefinition available to delete";

        }

    }

    public String updateCourseDef(Long id) {
        if (id != null) {
            Optional<CourseDefinition> CourseDef = courseDefinitionRepo.findById(id);
            if (CourseDef.isPresent()) {
                CourseDefinition courseDefinition = CourseDef.get();

                //Student student = Studentrepository.findById(id).get();
                courseDefinition.setCourseCode("COS334");
                courseDefinition.setCourseName("Arts");
                courseDefinition.setCourseDescription("Paintings of the advanced level");
                return "coursedefinition updated successfully";
            } else {
                return "No coursedefinition found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }

}
