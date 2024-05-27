package yunusefeyilmaz.laboratoryreport.business.abstracts;

import java.util.List;

import yunusefeyilmaz.laboratoryreport.business.requests.CreatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllPatientsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetPatientResponse;
import yunusefeyilmaz.laboratoryreport.entities.Patient;

public interface PatientService {
	List<GetAllPatientsResponse> getAll();
	Patient add(CreatePatientRequest createPatientRequest);
	void update(UpdatePatientRequest updatePatientRequest);
	void delete(Long id);
	GetPatientResponse getPatient(Long id);
	GetPatientResponse findOneByPatientId(String patientID);
	Patient findOrCreatePatient(Patient patient);
	Patient findById(Long id);
}
