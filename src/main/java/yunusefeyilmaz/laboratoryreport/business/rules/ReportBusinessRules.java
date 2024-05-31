package yunusefeyilmaz.laboratoryreport.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.LabAssistantService;
import yunusefeyilmaz.laboratoryreport.business.abstracts.PatientService;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdatePatientRequest;
import yunusefeyilmaz.laboratoryreport.core.utilities.mappers.ModelMapperService;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;
import yunusefeyilmaz.laboratoryreport.entities.Patient;

@AllArgsConstructor
@Service
public class ReportBusinessRules {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private LabAssistantService labAssistantService;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	public Patient checkPatientExists(Patient patient) {
		if(patient!=null) {
			return this.patientService.findOrCreatePatient(patient);
		}
		return patient;
	}
	
	public void updatePatient(Patient patient) {
		this.patientService.update(this.modelMapperService.forRequest().map(patient, UpdatePatientRequest.class));
	}

	public LabAssistant checkLabAssistant() {
		return this.labAssistantService.getOneLabAsistantByLabAssistant(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public boolean checkImageNull(byte[] image) {
		return image == null;
	}

}
