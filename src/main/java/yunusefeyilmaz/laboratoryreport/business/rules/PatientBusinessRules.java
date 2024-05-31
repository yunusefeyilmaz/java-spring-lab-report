package yunusefeyilmaz.laboratoryreport.business.rules;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.LabAssistantService;
import yunusefeyilmaz.laboratoryreport.business.response.GetPatientResponse;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;

@AllArgsConstructor
@Service
public class PatientBusinessRules {
	
	@Autowired
	private LabAssistantService labAssistantService;
	
	
	public boolean checkIfPatientNull(GetPatientResponse patient) {
		if(patient == null) {
			return true;
		}
		return false;
	}
	public LabAssistant checkLabAssistant() {
		return this.labAssistantService.getOneLabAsistantByLabAssistant(SecurityContextHolder.getContext().getAuthentication().getName());
	}
}	
