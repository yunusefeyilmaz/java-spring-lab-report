package yunusefeyilmaz.laboratoryreport.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.PatientService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllPatientsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetPatientResponse;
import yunusefeyilmaz.laboratoryreport.core.utilities.mappers.ModelMapperService;
import yunusefeyilmaz.laboratoryreport.dataAccess.abstracts.PatientRepository;
import yunusefeyilmaz.laboratoryreport.entities.Patient;

@Service
@AllArgsConstructor
public class PatientManager implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllPatientsResponse> getAll() {
		List<Patient> patients = this.patientRepository.findAll();
		List<GetAllPatientsResponse> patientsResponse = patients.stream().
				map(patient -> this.modelMapperService.forResponse().map(patient, GetAllPatientsResponse.class)).collect(Collectors.toList());
		return patientsResponse;
	}

	@Override
	public void add(CreatePatientRequest createPatientRequest) {
		Patient patient = this.modelMapperService.forRequest().map(createPatientRequest, Patient.class);
		this.patientRepository.save(patient);
	}

	@Override
	public void update(UpdatePatientRequest updatePatientRequest) {
		Patient patient = this.modelMapperService.forRequest().map(updatePatientRequest, Patient.class);
		this.patientRepository.save(patient);
	}

	@Override
	public void delete(Long id) {
		this.patientRepository.deleteById(id);
	}

	@Override
	public GetPatientResponse getPatient(Long id) {
		Optional<Patient> patient = this.patientRepository.findById(id);
		GetPatientResponse patientResponse = patient.map(p -> this.modelMapperService.forResponse().map(p, GetPatientResponse.class)).orElse(null);
		return patientResponse;
	}

}
