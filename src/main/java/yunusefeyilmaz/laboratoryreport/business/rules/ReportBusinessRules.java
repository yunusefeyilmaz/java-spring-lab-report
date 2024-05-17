package yunusefeyilmaz.laboratoryreport.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.PatientService;
import yunusefeyilmaz.laboratoryreport.entities.Patient;

@AllArgsConstructor
@Service
public class ReportBusinessRules {
	
	
	@Autowired
	private PatientService patientService;
	
	public Patient checkPatientExists(Patient patient) {
		return this.patientService.findOrCreatePatient(patient);
	}

}
