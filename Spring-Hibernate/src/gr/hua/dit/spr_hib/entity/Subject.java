package gr.hua.dit.spr_hib.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject {
	
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", prerequisites=" + prerequisites + ", studiesLevel="
				+ studiesLevel + ", numberOfStudents=" + numberOfStudents + ", supervisorId=" + supervisorId + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "prerequisites")
    private String prerequisites;
	
	@Column(name = "Studies_level")
    private String studiesLevel;
	
	@Column(name = "number_Of_students")
    private int numberOfStudents;
	
	@Column(name = "supervisor_id")
    private int supervisorId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getStudiesLevel() {
		return studiesLevel;
	}

	public void setStudiesLevel(String studiesLevel) {
		this.studiesLevel = studiesLevel;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
	
	
}

