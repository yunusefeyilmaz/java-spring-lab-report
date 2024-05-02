package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

}
