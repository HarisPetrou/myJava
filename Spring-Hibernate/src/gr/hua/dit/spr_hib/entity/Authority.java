package gr.hua.dit.spr_hib.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authorities")

public class Authority {
	
  @Id
  @Column(name = "username")
  private String username;

  
  @Column(name = "authority")
  private String authority;
  
  
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getAuthority() {
	return authority;
}

public void setAuthority(String authority) {
	this.authority = authority;
}

@Override
public String toString() {
	return "Authority [username=" + username + ", authority=" + authority + "]";
}
  
  
}