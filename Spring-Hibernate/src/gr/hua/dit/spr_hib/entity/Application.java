package gr.hua.dit.spr_hib.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Application")

public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "thesis_name")
    private String thesisName;
	
	@Column(name = "application_date")
    private Date applicationDate;

	
	@Column (name ="id_professor")
	private int idProfessor;
	
	@Column (name = "id_student")
	private int idStudent;
	
	@Column (name = "state")
	private String state;
	
	
	public String getThesisName() {
		return thesisName;
	}

	public void setThesisName(String thesisName) {
		this.thesisName = thesisName;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", thesisName=" + thesisName + ", applicationDate=" + applicationDate
				+ ", idProfessor=" + idProfessor + ", idStudent=" + idStudent + ", state=" + state + "]";
	}

	
	
	
}
