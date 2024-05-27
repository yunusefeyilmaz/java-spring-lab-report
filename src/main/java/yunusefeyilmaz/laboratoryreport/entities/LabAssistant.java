package yunusefeyilmaz.laboratoryreport.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="hospital_id", unique = true)
	@NotBlank
	private String hospitalId;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "labAssistant", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JsonIgnore
	private List<Report> reports;
	
}
