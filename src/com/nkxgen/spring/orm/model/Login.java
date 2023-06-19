package com.nkxgen.spring.orm.model;

public class Login {

	public Login() {
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public Login(String uname, String password, String email) {
		this.uname = uname;
		this.password = password;
		this.email = email;
	}

	private String uname;
	private String password;
	private String email;

}
