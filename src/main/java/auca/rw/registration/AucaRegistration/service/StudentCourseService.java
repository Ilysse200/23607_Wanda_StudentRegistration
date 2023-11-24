package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.domain.StudentCourse;
import auca.rw.registration.AucaRegistration.domain.StudentReg;
import auca.rw.registration.AucaRegistration.repository.StudentCourseRepo;
import auca.rw.registration.AucaRegistration.repository.StudentRegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseRepo studentCourseRepo;
    @Autowired
    private StudentRegRepo studentRegRepo;

    public String savestudentCourseService(StudentCourse studentCourse) {
        if (studentCourse != null) {
            studentCourseRepo.save(studentCourse);
            return "Student's course saved successfully";

        } else {
            return null;
        }

    }

    public List<StudentCourse> displayAllStudentCourse() {
        return studentCourseRepo.findAll();

    }

        public String deleteStudentCourse(Long id) {
        if (id != null) {
            studentCourseRepo.deleteById(id);
            return "Student's course deleted successfully";
        } else {
            return "No Student's course available to delete";

        }

    }

    public String updateStudentcourse(Long id) {
        if (id != null) {
            Optional<StudentCourse> student = studentCourseRepo.findById(id);
            if (student.isPresent()) {
                StudentCourse student1 = student.get();

                //Student student = Studentrepository.findById(id).get();
                student1.getSemester().getName();
                student1.getStudentRegistration().getStudent().getStudentName();
                student1.getCourseDefinition().getCourseName();
                studentCourseRepo.save(student1);
                return "Student's course updated successfully";
            } else {
                return "No Student's course found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }
//    public String findCourses(Long id){
//        studentCourseRepo.findBy(StudentReg r)
//        StudentCourse studentCourse = new StudentCourse();
//
//
//    }

    public List<StudentCourse> getAllCoursesPerStudent(StudentReg studentRegistration) {

        return studentCourseRepo.findCoursesByStudentRegistration(studentRegistration);
    }

    public List<StudentCourse> getStudentByCourseAndSemester(Course course, Semester semester) {
        List<StudentReg> students = studentRegRepo.findBySemester(semester);
        List<StudentCourse> studentsFound = new ArrayList<>();
        for (StudentReg student : students) {
            List<StudentCourse> courses = studentCourseRepo.findByCourseAndStudentRegistration(course, student);
            studentsFound.addAll(courses);
        }
        return studentsFound;
    }

}
