package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.EAcademicUnit;
import auca.rw.registration.AucaRegistration.repository.AcademicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicService {
    @Autowired
        private AcademicRepository academicRepository;
        public String saveAcademy(AcademicUnit academicUnit) {
            if (academicUnit != null) {
                academicRepository.save(academicUnit);
                return "academy saved successfully";
            } else {
                return null;
            }
        }
        public List<AcademicUnit> displayAllAcademies() {
            return academicRepository.findAll();

        }
        public boolean isAcadExists(Long code) {
        return academicRepository.existsById(code);
    }

        public String deleteAcademic(Long id) {
            if (id != null) {
                academicRepository.deleteById(id);
                return "academy deleted successfully";
            } else {
                return "No academy available to delete";

            }

        }

        public String updateAcademy(Long id) {
            if (id != null) {
                Optional<AcademicUnit> academicUnit = academicRepository.findById(id);
                if (academicUnit.isPresent()) {
                    AcademicUnit academY = academicUnit.get();

                    //Student student = Studentrepository.findById(id).get();
                    academY.setName("IT");
                    academY.setE_unit(EAcademicUnit.DEPARTMENT);
                    academY.setCodeNumb("001");
//                    academY.getCourses();
                    academicRepository.save(academY);
                    return "Academy updated successfully";
                } else {
                    return "No Academy found with the given ID";
                }

            } else {
                return "invalid ID";
            }
        }
        public AcademicUnit getAcademyByCode(Long AcCode){
            return academicRepository.findById(AcCode).orElse(null);
        }
    }
