package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
