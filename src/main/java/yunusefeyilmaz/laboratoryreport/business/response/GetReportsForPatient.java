package yunusefeyilmaz.laboratoryreport.business.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReportsForPatient {
	private Long id;
    private String fileNumber;	
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date reportDate;
    private boolean isImageEmpty;
}
