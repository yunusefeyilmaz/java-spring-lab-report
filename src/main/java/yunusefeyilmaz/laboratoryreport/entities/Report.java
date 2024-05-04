package yunusefeyilmaz.laboratoryreport.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="reports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
	
	@ManyToOne
    @JoinColumn(name = "lab_assistant_id", nullable = false)
    private LabAssistant labAssistant;
	
	@Column(name = "file_number")
    private String fileNumber;
	
	@Column(name = "diagnosis_title")
    private String diagnosisTitle;
	
	@Column(name = "diagnosis_details", length = 2048)
    private String diagnosisDetails;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "report_date")
    private Date reportDate;
	
	@Column(name = "image_path")
    private String imagePath;
	
}
