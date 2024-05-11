package yunusefeyilmaz.laboratoryreport.business.abstracts;

import java.util.List;

import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllLabAssistantsResponse;

public interface LabAssistantService {
	List<GetAllLabAssistantsResponse> getAll();
	void add(CreateLabAssistantRequest createLabAssistantRequest);
	void update(UpdateLabAssistantRequest updateLabAssistantRequest);
	void delete(Long id);
}
