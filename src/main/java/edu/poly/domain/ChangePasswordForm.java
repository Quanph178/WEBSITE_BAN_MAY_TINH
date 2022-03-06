package edu.poly.domain;

public class ChangePasswordForm {
	private String id;
	private String passwords;
	private String confirmPassword;
	private String currentPassword;

	public ChangePasswordForm() {

	}

	public ChangePasswordForm(String id, String passwords, String confirmPassword, String currentPassword) {
		super();
		this.id = id;
		this.passwords = passwords;
		this.confirmPassword = confirmPassword;
		this.currentPassword = currentPassword;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

}
