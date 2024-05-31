package yunusefeyilmaz.laboratoryreport.business.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yunusefeyilmaz.laboratoryreport.entities.Report;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPatientResponse {
	private Long id;
	private String name;
	private String surname;
	private String patientId;
	private List<Report> reports;
}
