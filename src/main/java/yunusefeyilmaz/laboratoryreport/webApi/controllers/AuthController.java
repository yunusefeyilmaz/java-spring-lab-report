package yunusefeyilmaz.laboratoryreport.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.AuthService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.LoginLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.AuthResponse;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginLabAssistantRequest labAssistantRequest) {
		return this.authService.login(labAssistantRequest);
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody CreateLabAssistantRequest labAssistantRequest) {
		return this.authService.register(labAssistantRequest);
	}
}
