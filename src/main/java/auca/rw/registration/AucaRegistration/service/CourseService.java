package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {
        @Autowired
        private CourseRepo courseRepository;
        public String saveCourse(Course course) {
            if (course != null) {
                courseRepository.save(course);
                return "course saved successfully";
            } else {
                return null;
            }
        }
        public List<Course> displayAllCourses() {
            return courseRepository.findAll();

        }

        public String deleteCourse(Long id) {
            if (id != null) {
                courseRepository.deleteById(id);
                return "course deleted successfully";
            } else {
                return "No course available to delete";

            }

        }

        public String updateCourses(Long id) {
            if (id != null) {
                Optional<Course> Courses = courseRepository.findById(id);
                if (Courses.isPresent()) {
                    Course course1 = Courses.get();

                    //Student student = Studentrepository.findById(id).get();
                    course1.getSemester().getSemId();
                    course1.getCourseDefinition().getCourseName();
                    course1.getUnit().getName();
                    course1.getCourseDefinition().getCourseName();
                    courseRepository.save(course1);
                    return "course updated successfully";
                } else {
                    return "No course found with the given ID";
                }

            } else {
                return "invalid ID";
            }
        }

    public List<Course> getCoursesPerUnitAndSemester(AcademicUnit unit, Semester semester) {

        return courseRepository.findCourseByUnitAndSemester(unit,semester);
    }

}

