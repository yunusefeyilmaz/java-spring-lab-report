package yunusefeyilmaz.laboratoryreport.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientRequest {
	private Long id;
	private String name;
	private String surname;
	private String patientID;
}
