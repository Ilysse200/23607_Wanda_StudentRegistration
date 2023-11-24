package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SemesterService {
    @Autowired
    private SemesterRepository semesterRepository;
    public String saveSemester(Semester semester) {
        if (semester != null) {
            semesterRepository.save(semester);
            return "semester saved successfully";
        } else {
            return null;
        }
    }
    public List<Semester> displayAllSemesters() {
        return semesterRepository.findAll();

    }
    public boolean semesterExists(Long id){
        return semesterRepository.existsById(id);
    }

    public Semester getSemesterById(Long id){
        return semesterRepository.findById((id)).orElse(null);
    }

    public String deleteSemester(Long id) {
        if (id != null) {
            semesterRepository.deleteById(id);
            return "Semester deleted successfully";
        } else {
            return "No semesters available to delete";

        }

    }

    public String updateSemester(Long id) {
        if (id != null) {
            Optional<Semester> semester = semesterRepository.findById(id);
            if (semester.isPresent()) {
                Semester semester1 = semester.get();

                //Student student = Studentrepository.findById(id).get();
                semester1.setName("Sem3");
                semester1.setStartDate(LocalDate.parse("/01/01/2001"));
                semester1.setEndDate(LocalDate.parse("03/05/2001"));
                semesterRepository.save(semester1);
                return "Student updated successfully";
            } else {
                return "No student found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }
}

