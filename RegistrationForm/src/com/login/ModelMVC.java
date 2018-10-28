package com.login;

public class ModelMVC 
{
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String ans;
	private String sques;
	private String mobile;
	
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getAns() {
		return ans;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSques() {
		return sques;
	}
	public void setSques(String sques) {
		this.sques = sques;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}