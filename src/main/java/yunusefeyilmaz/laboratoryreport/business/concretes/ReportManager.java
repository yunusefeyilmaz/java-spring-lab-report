package yunusefeyilmaz.laboratoryreport.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.ReportService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllReportsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetReportResponse;
import yunusefeyilmaz.laboratoryreport.business.rules.ReportBusinessRules;
import yunusefeyilmaz.laboratoryreport.core.utilities.mappers.ModelMapperService;
import yunusefeyilmaz.laboratoryreport.dataAccess.abstracts.ReportRepository;
import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;
import yunusefeyilmaz.laboratoryreport.entities.Patient;
import yunusefeyilmaz.laboratoryreport.entities.Report;

@Service
@AllArgsConstructor
public class ReportManager implements ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private ModelMapperService modelMapperService;
	
	private ReportBusinessRules reportBusinessRules;

	@Transactional
	@Override
	public List<GetAllReportsResponse> getAll() {
		List<Report> reports = this.reportRepository.findAll();
		List<GetAllReportsResponse> reportsResponse = reports.stream()
				.map(report -> this.modelMapperService.forResponse().map(report, GetAllReportsResponse.class))
				.collect(Collectors.toList());
		return reportsResponse;
	}

	@Transactional
	@Override
	public void add(CreateReportRequest createReportRequest) {
		Report report = this.modelMapperService.forRequest().map(createReportRequest, Report.class);
		if(report.getPatient()!=null) {
			Patient patient = this.reportBusinessRules.checkPatientExists(report.getPatient());
			report.setPatient(patient);
		}
		String labAssistantHospitalID = SecurityContextHolder.getContext().getAuthentication().getName();
		LabAssistant labAssistant = this.reportBusinessRules.checkLabAssistant(labAssistantHospitalID);
		report.setLabAssistant(labAssistant);
		this.reportRepository.save(report);
	}

	@Transactional
	@Override
	public void update(UpdateReportRequest updateReportRequest) {
		Report report = this.modelMapperService.forRequest().map(updateReportRequest, Report.class);
		Patient patient = report.getPatient();
		this.reportRepository.save(report);
		this.reportBusinessRules.updatePatient(patient);
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
