package yunusefeyilmaz.laboratoryreport.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="lab_assistants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LabAssistant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="hospital_id", unique = true)
	private String hospitalID;
	
	@OneToMany(mappedBy = "labAssistant")
	private List<Report> reports;
	
}
