package yunusefeyilmaz.laboratoryreport.business.abstracts;

import java.util.List;

import yunusefeyilmaz.laboratoryreport.business.requests.CreateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllReportsResponse;

public interface ReportService {
	List<GetAllReportsResponse> getAll();
	void add(CreateReportRequest createReportRequest);
	void update(UpdateReportRequest updateReportRequest);
	void delete(int id);
}
