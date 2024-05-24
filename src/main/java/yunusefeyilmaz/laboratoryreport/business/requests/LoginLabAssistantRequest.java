package yunusefeyilmaz.laboratoryreport.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLabAssistantRequest {
	private String hospitalId;
	private String password;
}
