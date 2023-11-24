package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface AcademicRepository extends JpaRepository<AcademicUnit, Long> {
}
