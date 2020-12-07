package com.cg.loginmodule.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Entity class
 * @author MANASA KAITHA
 */
@Entity
@Table(name="LoginData")
public class LoginData {
private String userId;
private String password;
private String userType;
@Id
public String getUserId() { 
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
@Column(name = "Password", nullable = false)
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Column(name = "type", nullable = false)
public String getType() {
	return userType;
}
public void setType(String type) {
	this.userType = type;
}
@Override
public String toString() {
	return "LoginData [userId=" + userId + ", password=" + password + ", type=" + userType + "]";
}
public LoginData() {
	super();

}


}
