package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.CourseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseDefinitionRepo extends JpaRepository<CourseDefinition, Long> {
}
