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
import yunusefeyilmaz.laboratoryreport.business.abstracts.LabAssistantService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllLabAssistantsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetLabAssistantResponse;

@RestController
@RequestMapping("/api/labassistants")
@AllArgsConstructor
public class LabAssistantController {

	@Autowired
	private LabAssistantService labAssistantService;
	
	@GetMapping
	public List<GetAllLabAssistantsResponse> getAll(){
		return this.labAssistantService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateLabAssistantRequest createLabAssistantRequest) {
		this.labAssistantService.add(createLabAssistantRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateLabAssistantRequest updateLabAssistantRequest) {
		this.labAssistantService.update(updateLabAssistantRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.labAssistantService.delete(id);
	}
	
	@GetMapping("/{id}")
	public GetLabAssistantResponse getOne(@PathVariable Long id){
		return this.labAssistantService.getOne(id);
	}
}
