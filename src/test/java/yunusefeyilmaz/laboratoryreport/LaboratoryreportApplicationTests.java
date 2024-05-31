package yunusefeyilmaz.laboratoryreport;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
	    "DB_URL=jdbc:postgresql://localhost:5432/db_lab_report",
	    "DB_USERNAME=postgres",
	    "DB_PASSWORD=123456789"
	})
class LaboratoryreportApplicationTests {

	@Test
	void contextLoads() {
	}

}
