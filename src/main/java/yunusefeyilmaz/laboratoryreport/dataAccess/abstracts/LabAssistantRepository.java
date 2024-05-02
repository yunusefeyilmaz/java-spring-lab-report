package yunusefeyilmaz.laboratoryreport.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yunusefeyilmaz.laboratoryreport.entities.LabAssistant;

@Repository
public interface LabAssistantRepository extends JpaRepository<LabAssistant, Integer> {

}
