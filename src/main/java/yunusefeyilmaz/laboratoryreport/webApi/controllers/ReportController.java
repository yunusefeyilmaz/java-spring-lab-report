package yunusefeyilmaz.laboratoryreport.webApi.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import yunusefeyilmaz.laboratoryreport.business.abstracts.ReportService;
import yunusefeyilmaz.laboratoryreport.business.requests.CreateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.requests.UpdateReportRequest;
import yunusefeyilmaz.laboratoryreport.business.response.GetAllReportsResponse;
import yunusefeyilmaz.laboratoryreport.business.response.GetReportResponse;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping
	public List<GetAllReportsResponse> getAll(){
		return this.reportService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateReportRequest createReportRequest) {
		this.reportService.add(createReportRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateReportRequest updateReportRequest) {
		this.reportService.update(updateReportRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.reportService.delete(id);
	}
	
	@GetMapping("/{id}")
	public GetReportResponse getReport(@PathVariable Long id) {
		return this.reportService.getReport(id);
	}
	
}
