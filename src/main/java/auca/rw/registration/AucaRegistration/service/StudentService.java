package auca.rw.registration.AucaRegistration.service;


import auca.rw.registration.AucaRegistration.domain.Student;
import  auca.rw.registration.AucaRegistration.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private studentRepository Studentrepository;

    public String saveStudent(Student student) {
        if (student != null) {
            Studentrepository.save(student);
            return "Student saved successfully";

        } else {
            return null;
        }

    }

    public List<Student> displayAllStudents() {
        return Studentrepository.findAll();

    }

    public String deleteStudent(Long id) {
        if (id != null) {
            Studentrepository.deleteById(id);
            return "Student deleted successfully";
        } else {
            return "No student available to delete";

        }

    }

    public String updateStudent(Long id) {
        if (id != null) {
            Optional<Student> student = Studentrepository.findById(id);
            if (student.isPresent()) {
                Student student1 = student.get();

                //Student student = Studentrepository.findById(id).get();
           student1.setStudentName("Santos");
           student1.setDateOfBirth("/01/01/1999");
                Studentrepository.save(student1);
                return "Student updated successfully";
            } else {
                return "No student found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }
}



