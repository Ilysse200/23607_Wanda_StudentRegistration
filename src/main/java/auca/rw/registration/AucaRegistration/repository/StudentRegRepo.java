package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.domain.StudentReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRegRepo extends JpaRepository<StudentReg, Long> {
    List<StudentReg> findBySemester(Semester semester);
    List<StudentReg> findByAcademicUnitAndSemester(AcademicUnit academicUnit, Semester semester);



}
