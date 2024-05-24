package yunusefeyilmaz.laboratoryreport.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.dataAccess.abstracts.LabAssistantRepository;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;
import yunusefeyilmaz.laboratoryreport.security.JwtLabAssistantDetails;

@Service
@AllArgsConstructor
public class LabAssistantDetailsService implements UserDetailsService {

	@Autowired
    private LabAssistantRepository labAssistantRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LabAssistant labAssistant = labAssistantRepository.findByHospitalId(username);
        if (labAssistant == null) {
            throw new UsernameNotFoundException("Lab Assistant not found with hospitalID: " + username);
        }
        return JwtLabAssistantDetails.create(labAssistant);
	}
	
	public UserDetails loadUserById(Long id) {
		LabAssistant labAssistant = labAssistantRepository.findById(id).get();
		return JwtLabAssistantDetails.create(labAssistant);
	}

}
