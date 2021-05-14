package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@Column(name="TenDN")
	private String tenDN;
	@Column(name="Pass")
	private String pass;
	
	
	public Admin() {
		super();
	}
	public Admin(String tenDN, String pass) {
		super();
		this.tenDN = tenDN;
		this.pass = pass;
	}
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
