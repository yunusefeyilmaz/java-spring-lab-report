package yunusefeyilmaz.laboratoryreport.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.Getter;
import lombok.Setter;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;

@Getter
@Setter
public class JwtLabAssistantDetails implements UserDetails{
	
	public Long id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	private JwtLabAssistantDetails(Long id,String username,String password,Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static JwtLabAssistantDetails create(LabAssistant labAssistant) {
		List<GrantedAuthority> authoritiesList = new ArrayList<>();
		authoritiesList.add(new SimpleGrantedAuthority("labassistant"));
		return new JwtLabAssistantDetails(labAssistant.getId(),labAssistant.getHospitalId(),labAssistant.getPassword(),authoritiesList);
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
