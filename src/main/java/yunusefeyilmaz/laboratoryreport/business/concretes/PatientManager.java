package yunusefeyilmaz.laboratoryreport.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.PatientService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllPatientsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetPatientResponse;
import yunusefeyilmaz.laboratoryreport.business.rules.PatientBusinessRules;
import yunusefeyilmaz.laboratoryreport.core.utilities.mappers.ModelMapperService;
import yunusefeyilmaz.laboratoryreport.dataAccess.abstracts.PatientRepository;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;
import yunusefeyilmaz.laboratoryreport.entities.Patient;

@Service
@AllArgsConstructor
public class PatientManager implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ModelMapperService modelMapperService;
	
	private PatientBusinessRules patientBusinessRules;

	@Transactional
	@Override
	public List<GetAllPatientsResponse> getAll() {
		List<Patient> patients = this.patientRepository.findByReportsLabAssistantId(this.patientBusinessRules.checkLabAssistant().getId());
		List<GetAllPatientsResponse> patientsResponse = patients.stream().
				map(patient -> this.modelMapperService.forResponse().map(patient, GetAllPatientsResponse.class)).collect(Collectors.toList());
		return patientsResponse;
	}

	@Override
	public Patient add(CreatePatientRequest createPatientRequest) {
		Patient patient = this.modelMapperService.forRequest().map(createPatientRequest, Patient.class);
		return this.patientRepository.save(patient);
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

	@Transactional
	@Override
	public GetPatientResponse getPatient(Long id) {
		Optional<Patient> patient = this.patientRepository.findByReportsLabAssistantIdAndId(this.patientBusinessRules.checkLabAssistant().getId(),id);
		GetPatientResponse patientResponse = patient.map(p -> this.modelMapperService.forResponse().map(p, GetPatientResponse.class)).orElse(null);
		return patientResponse;
	}

	@Transactional
	@Override
	public GetPatientResponse findOneByPatientId(String patientID) {
		Optional<Patient> patient = this.patientRepository.findByPatientId(patientID);
		GetPatientResponse patientResponse = patient.map(p -> this.modelMapperService.forResponse().map(p, GetPatientResponse.class)).orElse(null);
		return patientResponse;
	}
	@Transactional
	@Override
	public Patient findById(Long id) {
		Optional<Patient> patient = this.patientRepository.findById(id);
		Patient patientResponse = patient.map(p -> this.modelMapperService.forResponse().map(p, Patient.class)).orElse(null);
		patientResponse.setId(id);
		return patientResponse;
	}

	@Override
	public Patient findOrCreatePatient(Patient patient) {
		GetPatientResponse patientResponse = this.findOneByPatientId(patient.getPatientId());
		if(this.patientBusinessRules.checkIfPatientNull(patientResponse)) {
			CreatePatientRequest patientRequest = this.modelMapperService.forRequest().map(patient, CreatePatientRequest.class);
			return this.add(patientRequest);
		}
		patient.setId(patientResponse.getId());
		return patient;
	}

}
