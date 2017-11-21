package com.kobook.login.DTO;

public class LoginDTO {

	private String person_email;
	private String person_pwd;
	private boolean use_cookie;
	
	public LoginDTO(){}

	public LoginDTO(String person_email, String person_pwd, boolean use_cookie) {
		super();
		this.person_email = person_email;
		this.person_pwd = person_pwd;
		this.use_cookie = use_cookie;
	}

	public String getPerson_email() {
		return person_email;
	}

	public void setPerson_email(String person_email) {
		this.person_email = person_email;
	}

	public String getPerson_pwd() {
		return person_pwd;
	}

	public void setPerson_pwd(String person_pwd) {
		this.person_pwd = person_pwd;
	}

	public boolean isUse_cookie() {
		return use_cookie;
	}

	public void setUse_cookie(boolean use_cookie) {
		this.use_cookie = use_cookie;
	}

	
}
