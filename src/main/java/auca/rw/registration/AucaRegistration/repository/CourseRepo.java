package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

//    public List<Course> getCoursesByDepartmentAndSemester(AcademicUnit department, Semester semester) {
//        return crsRepo.findByDepartmentAndSemester(department, semester);
//    }
List<Course> findCourseByUnitAndSemester(AcademicUnit academicUnit, Semester semester);

}
