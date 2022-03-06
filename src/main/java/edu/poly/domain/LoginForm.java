package edu.poly.domain;

public class LoginForm {
	private String id,passwords;
	private boolean remember;
	
	
	public LoginForm() {
		super();
	}
	public LoginForm(String id, String passwords, boolean remember) {
		super();
		this.id = id;
		this.passwords = passwords;
		this.remember = remember;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	
	
	
}
