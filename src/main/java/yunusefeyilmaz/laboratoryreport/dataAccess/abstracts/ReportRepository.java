package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	List<Report> findByPatient_Id(Long patientId);
    List<Report> findAllByOrderByReportDateDesc();
}
