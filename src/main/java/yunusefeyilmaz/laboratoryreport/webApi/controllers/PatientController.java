package yunusefeyilmaz.laboratoryreport.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.PatientService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdatePatientRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllPatientsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetPatientResponse;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public List<GetAllPatientsResponse> getAll(){
		return this.patientService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreatePatientRequest createPatientRequest) {
		this.patientService.add(createPatientRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdatePatientRequest updatePatientRequest ) {
		this.patientService.update(updatePatientRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.patientService.delete(id);
	}
	
	@GetMapping("/{id}")
	public GetPatientResponse getPatient(@PathVariable Long id) {
		return this.patientService.getPatient(id);
	}
}
