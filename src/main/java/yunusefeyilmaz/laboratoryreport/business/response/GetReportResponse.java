package yunusefeyilmaz.laboratoryreport.business.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReportResponse {
	private Long id;
	private GetPatientForReports patient;
	private GetLabAssistantForReports labAssistant;
    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date reportDate;
    private byte[] image;
}
