package com.att.lemonade.test.data.objects;

public class LoginDetails {
	public String username;
	public String password;
	public String successMessage;
	public String runmode;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getRunmode() {
		return runmode;
	}
	public void setRunmode(String runmode) {
		this.runmode = runmode;
	}
	@Override
	public String toString() {
		return "LoginDetails [username=" + username + ", password=" + password + ", successMessage=" + successMessage
				+ ", runmode=" + runmode + "]";
	}
	
}
