package org.laboratory.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int user_id;

	private String account;

	private String password;

	private String user_name;

	private String email;


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(){

	}

	public User(int user_id, String account, String password, String user_name, String email) {
		this.user_id = user_id;
		this.account = account;
		this.password = password;
		this.user_name = user_name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", user_name='" + user_name + '\'' +
				", email='" + email + '\'' +
				'}';
	}



}
