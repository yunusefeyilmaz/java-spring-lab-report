package yunusefeyilmaz.laboratoryreport.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLabAssistantRequest {
	private int id;
	private String name;
	private String surname;
	private String hospitalID;
}
