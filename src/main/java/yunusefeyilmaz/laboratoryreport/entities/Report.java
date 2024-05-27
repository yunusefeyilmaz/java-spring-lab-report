package yunusefeyilmaz.laboratoryreport.entities;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
	@JsonIgnore
    private Patient patient;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "lab_assistant_id", nullable = false)
	@JsonIgnore
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
	
	@Lob
	@Column(name = "image")
    private byte[] image;
	
}
