package yunusefeyilmaz.laboratoryreport.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.ReportService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllReportsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetReportResponse;
import yunusefeyilmaz.laboratoryreport.core.utilities.mappers.ModelMapperService;
import yunusefeyilmaz.laboratoryreport.dataAccess.abstracts.ReportRepository;
import yunusefeyilmaz.laboratoryreport.entities.Report;

@Service
@AllArgsConstructor
public class ReportManager implements ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllReportsResponse> getAll() {
		List<Report> reports = this.reportRepository.findAll();
		List<GetAllReportsResponse> reportsResponse = reports.stream()
				.map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsResponse.class))
				.collect(Collectors.toList());
		return reportsResponse;
	}

	@Override
	public void add(CreateReportRequest createReportRequest) {
		Report report = this.modelMapperService.forRequest().map(createReportRequest, Report.class);
		this.reportRepository.save(report);
	}

	@Override
	public void update(UpdateReportRequest updateReportRequest) {
		Report report = this.modelMapperService.forRequest().map(updateReportRequest, Report.class);
		this.reportRepository.save(report);
	}

	@Override
	public void delete(Long id) {
		this.reportRepository.deleteById(id);
	}

	@Override
	public GetReportResponse getReport(Long id) {
		Optional<Report> report = this.reportRepository.findById(id);
		GetReportResponse reportResponse = report.map(r -> this.modelMapperService.forResponse().map(r, GetReportResponse.class)).orElse(null);
		return reportResponse;
	}

}
