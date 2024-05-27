package yunusefeyilmaz.laboratoryreport.business.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yunusefeyilmaz.laboratoryreport.entities.Report;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLabAssistantResponse {
	private String name;
	private String surname;
	private String hospitalId;
	private List<Report> reports;
}
