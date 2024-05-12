package yunusefeyilmaz.laboratoryreport.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.LabAssistantService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllLabAssistantsResponse;
import yunusefeyilmaz.laboratoryreport.core.utilities.mappers.ModelMapperService;
import yunusefeyilmaz.laboratoryreport.dataAccess.abstracts.LabAssistantRepository;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;

@Service
@AllArgsConstructor
public class LabAssistantManager implements LabAssistantService {
	
	@Autowired
	private LabAssistantRepository labAssistantRepository;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllLabAssistantsResponse> getAll() {
		List<LabAssistant> labAssistants = this.labAssistantRepository.findAll();
		List<GetAllLabAssistantsResponse> labAssistantsResponse = labAssistants.stream()
				.map(labAssistant -> this.modelMapperService.forResponse().map(labAssistant, GetAllLabAssistantsResponse.class))
					.collect(Collectors.toList());
		return labAssistantsResponse;
	}
	
	@Override
	public void add(CreateLabAssistantRequest createLabAssistantRequest) {
		LabAssistant labAssistant = this.modelMapperService.forRequest().map(createLabAssistantRequest, LabAssistant.class);
		this.labAssistantRepository.save(labAssistant);
	}
	
	@Override
	public void update(UpdateLabAssistantRequest updateLabAssistantRequest) {
		LabAssistant labAssistant = this.modelMapperService.forRequest().map(updateLabAssistantRequest, LabAssistant.class);
		this.labAssistantRepository.save(labAssistant);
	}
	
	@Override
	public void delete(Long id) {
		this.labAssistantRepository.deleteById(id);;
	}

}
