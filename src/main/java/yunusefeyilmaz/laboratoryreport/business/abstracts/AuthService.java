package yunusefeyilmaz.laboratoryreport.business.abstracts;


import org.springframework.http.ResponseEntity;

import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.LoginLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.AuthResponse;

public interface AuthService {
	AuthResponse login(LoginLabAssistantRequest labAssistantRequest);
	ResponseEntity<AuthResponse> register(CreateLabAssistantRequest labAssistantRequest);
}
