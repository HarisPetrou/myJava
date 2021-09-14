package gr.hua.dit.spr_hib.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
     private int id;	
    
	 

	 @Column(name = "full_name")
     private String fullName;
	 
	 @Column(name="username")
	 private String username;
	 
	 @Column(name = "password")
	 private String password;
	 
	 @Column(name = "email")
	 private String email;
	 
	 @Column(name = "student_id")
	 private int studentId;
	 
	 @Column(name = "professor_id")
	 private int professorId;

	@Column(name="enabled")
	private String enabled;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", studentId=" + studentId + ", professorId=" + professorId + ", enabled="
				+ enabled + "]";
	}

	
	 
	 

}
