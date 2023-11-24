package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.domain.StudentCourse;
import auca.rw.registration.AucaRegistration.domain.StudentReg;
import auca.rw.registration.AucaRegistration.repository.SemesterRepository;
import auca.rw.registration.AucaRegistration.repository.StudentRegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentRegService {
        @Autowired
        private StudentRegRepo studentRegRepo;

        public String saveRegistration(StudentReg reg) {
            if (reg != null) {
                reg.getAcademicUnit().getCodeNumb();
                studentRegRepo.save(reg);
//                StudentCourse studentCourse = new StudentCourse();
//                studentCourse.setStudentRegistration(reg);
                return "registration saved successfully";
            } else {
                return null;
            }
        }
        public List<StudentReg> displayAllRegistrations() {
            return studentRegRepo.findAll();

        }

        public String deleteregistration(Long id) {
            if (id != null) {
                studentRegRepo.deleteById(id);
                return "registration deleted successfully";
            } else {
                return "No registration available to delete";

            }

        }

        public String updateRegistration(Long id) {
            if (id != null) {
                Optional<StudentReg> studentReg = studentRegRepo.findById(id);
                if (studentReg.isPresent()) {
                    StudentReg studentReg1 = studentReg.get();
                    List<StudentCourse> courses = new ArrayList<>();

                    //Student student = Studentrepository.findById(id).get();
                    studentReg1.setRegDate(LocalDate.parse("01/02/2020"));
                    studentReg1.getStudent().getStudentId();
                    studentReg1.getSemester().getSemId();
                    studentReg1.getAcademicUnit().getName();
//                    studentReg1.getStudentCourses();
//                    semester1.setEndDate(LocalDate.parse("03/05/2001"));
//                    semesterRepository.save(semester1);
                    return "registration updated successfully";
                } else {
                    return "No registration found with the given ID";
                }

            } else {
                return "invalid ID";
            }
        }


    public List<StudentReg> getStudentsBySemester(Semester semester) {

        return studentRegRepo.findBySemester(semester);
    }
    public List<StudentReg> getStudentsByDepartmentAndSemester(AcademicUnit academicUnit, Semester semester) {

        return studentRegRepo.findByAcademicUnitAndSemester( academicUnit, semester);
    }


}
