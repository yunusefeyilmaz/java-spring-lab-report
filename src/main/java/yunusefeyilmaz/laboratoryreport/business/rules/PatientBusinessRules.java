package yunusefeyilmaz.laboratoryreport.business.rules;


import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.response.GetPatientResponse;

@AllArgsConstructor
@Service
public class PatientBusinessRules {
	
	public boolean checkIfPatientNull(GetPatientResponse patient) {
		if(patient == null) {
			return true;
		}
		return false;
	}
	
}	
