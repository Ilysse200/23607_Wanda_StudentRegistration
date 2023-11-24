package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository <Student, Long> {
}
