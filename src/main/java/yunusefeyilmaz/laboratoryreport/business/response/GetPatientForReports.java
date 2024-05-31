package yunusefeyilmaz.laboratoryreport.business.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPatientForReports {
	private Long id;
	private String name;
	private String surname;
	private String patientId;
}
