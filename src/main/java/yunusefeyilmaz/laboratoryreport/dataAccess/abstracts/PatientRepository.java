package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	 Optional<Patient> findByPatientId(String patientId);
	 List<Patient> findByReportsLabAssistantId(Long labAssistantId);
	 Optional<Patient> findByReportsLabAssistantIdAndId(Long labAssistantId,Long patientId);
}
