package com.nkxgen.spring.orm.model;

public class User {

	public User() {
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_ludate() {
		return user_ludate;
	}

	public void setUser_ludate(String user_ludate) {
		this.user_ludate = user_ludate;
	}

	public User(int user_id, String user_displayname, String user_password, String user_cdate, String user_empl_id,
			String user_status, short user_role, String user_ludate) {
		this.user_id = user_id;
		this.user_displayname = user_displayname;
		this.user_password = user_password;
		this.user_cdate = user_cdate;
		this.user_empl_id = user_empl_id;
		this.user_status = user_status;
		this.user_role = user_role;
		this.user_ludate = user_ludate;
	}

	public String getUser_displayname() {
		return user_displayname;
	}

	public void setUser_displayname(String user_displayname) {
		this.user_displayname = user_displayname;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_cdate() {
		return user_cdate;
	}

	public void setUser_cdate(String user_cdate) {
		this.user_cdate = user_cdate;
	}

	public String getUser_empl_id() {
		return user_empl_id;
	}

	public void setUser_empl_id(String user_empl_id) {
		this.user_empl_id = user_empl_id;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public short getUser_role() {
		return user_role;
	}

	public void setUser_role(short role) {
		this.user_role = role;
	}

	private int user_id;
	private String user_displayname;
	private String user_password;
	private String user_cdate;
	private String user_empl_id;
	private String user_status;
	private short user_role;
	private String user_ludate;

	@Override
	public String toString() {
		return "User{" + "user_id=" + user_id + ", user_displayname='" + user_displayname + '\'' + ", user_password='"
				+ user_password + '\'' + ", user_cdate='" + user_cdate + '\'' + ", user_empl_id='" + user_empl_id + '\''
				+ ", user_status='" + user_status + '\'' + ", user_role=" + user_role + ", user_ludate='" + user_ludate
				+ '\'' + '}';
	}

}
