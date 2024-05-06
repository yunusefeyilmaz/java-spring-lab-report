package yunusefeyilmaz.laboratoryreport.business.requests;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;
import yunusefeyilmaz.laboratoryreport.entities.Patient;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportRequest {
	private Patient patient;
	private LabAssistant labAssistant;
    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date reportDate;
    private String imagePath;
}
