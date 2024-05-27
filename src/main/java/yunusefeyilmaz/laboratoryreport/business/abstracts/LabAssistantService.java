package yunusefeyilmaz.laboratoryreport.business.abstracts;

import java.util.List;

import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllLabAssistantsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetLabAssistantResponse;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;

public interface LabAssistantService {
	List<GetAllLabAssistantsResponse> getAll();
	void add(CreateLabAssistantRequest createLabAssistantRequest);
	void update(UpdateLabAssistantRequest updateLabAssistantRequest);
	void delete(Long id);
	LabAssistant getOneLabAsistantByLabAssistant(String hospitalId);
	LabAssistant findById(Long id);
	GetLabAssistantResponse getOne(Long id);
}
