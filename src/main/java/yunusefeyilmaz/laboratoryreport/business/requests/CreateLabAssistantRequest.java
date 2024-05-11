package yunusefeyilmaz.laboratoryreport.business.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yunusefeyilmaz.laboratoryreport.entities.Report;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLabAssistantRequest {
	private String name;
	private String surname;
	private String hospitalID;
	private String password;
	private List<Report> reports;
}
