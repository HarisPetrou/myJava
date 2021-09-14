package gr.hua.dit.spr_hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
	 private int id;
	 
	 @Column(name="student_id")
	 private int studentId;
	 
	 @Column(name = "Semester")
     private int semester;
	 
	 public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "Average")
     private double average;

     @Column(name = "Studies_level")
     private String studiesLevel;

     @Column(name = "Number_Of_Owed_Courses")
     private int owedCoursesNumber;
     
     @Column(name = "Owed_Courses")
     private String owedCourses;
     
   
     
     public Student() {
         
     }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getStudiesLevel() {
		return studiesLevel;
	}

	public void setStudiesLevel(String studiesLevel) {
		this.studiesLevel = studiesLevel;
	}

	public int getOwedCoursesNumber() {
		return owedCoursesNumber;
	}

	public void setOwedCoursesNumber(int owedCoursesNumber) {
		this.owedCoursesNumber = owedCoursesNumber;
	}

	public String getOwedCourses() {
		return owedCourses;
	}

	public void setOwedCourses(String owedCourses) {
		this.owedCourses = owedCourses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", semester=" + semester + ", average=" + average
				+ ", studiesLevel=" + studiesLevel + ", owedCoursesNumber=" + owedCoursesNumber + ", owedCourses="
				+ owedCourses + "]";
	}

	




     
     

}
