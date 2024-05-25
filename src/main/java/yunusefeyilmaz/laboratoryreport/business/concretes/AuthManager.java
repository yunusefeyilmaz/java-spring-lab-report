package yunusefeyilmaz.laboratoryreport.business.concretes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.AuthService;
import yunusefeyilmaz.laboratoryreport.business.abstracts.LabAssistantService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.LoginLabAssistantRequest;
import yunusefeyilmaz.laboratoryreport.business.response.AuthResponse;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;
import yunusefeyilmaz.laboratoryreport.security.JwtTokenProvider;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

	private AuthenticationManager authenticationManager;
	
	private JwtTokenProvider jwtTokenProvider;
	
	private LabAssistantService labAssistantService;
	
	private PasswordEncoder passwordEncoder;
	
	@Override
	public AuthResponse login(LoginLabAssistantRequest labAssistantRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(labAssistantRequest.getHospitalId(), labAssistantRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		LabAssistant labAssistant = labAssistantService.getOneLabAsistantByLabAssistant(labAssistantRequest.getHospitalId());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Bearer " + jwtToken);
		authResponse.setId(labAssistant.getId());
		return authResponse;
	}

	@Override
	public ResponseEntity<AuthResponse> register(CreateLabAssistantRequest labAssistantRequest) {
		AuthResponse authResponse = new AuthResponse();
		if(labAssistantService.getOneLabAsistantByLabAssistant(labAssistantRequest.getHospitalId()) !=null) {
			authResponse.setMessage("Lab Asistant already exits");
			return new ResponseEntity<>(authResponse,HttpStatus.BAD_REQUEST);
		}
		labAssistantRequest.setPassword(passwordEncoder.encode(labAssistantRequest.getPassword()));
		labAssistantService.add(labAssistantRequest);
		authResponse.setMessage("Lab Assitant created");
		return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
	}

}
