package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	 Optional<Patient> findByPatientID(String patientID);
	 Optional<Patient> findById(Long id);
}
