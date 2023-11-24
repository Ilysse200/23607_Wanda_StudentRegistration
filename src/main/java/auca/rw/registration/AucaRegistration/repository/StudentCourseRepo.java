package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.domain.StudentCourse;
import auca.rw.registration.AucaRegistration.domain.StudentReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse, Long> {

    List<StudentCourse> findCoursesByStudentRegistration(StudentReg studentRegistration);
    List<StudentCourse> findByCourseAndStudentRegistration(Course course, StudentReg studentRegistration);


}
