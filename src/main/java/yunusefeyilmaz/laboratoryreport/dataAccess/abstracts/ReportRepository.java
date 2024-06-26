package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	List<Report> findByPatient_Id(Long patientId);
	List<Report> findByLabAssistantId(Long labId);
	Optional<Report> findByLabAssistantIdAndId(Long labAssistantId, Long reportId);
}
