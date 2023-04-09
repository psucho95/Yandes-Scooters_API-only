package Scooter_Data.API.JSONs;

public  class Generator_JSON_loginData {
	String login;
	String password;
	String loginJSON;

	public Generator_JSON_loginData(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String JSON_Login()
	{
		loginJSON = String.format("{\"login\": \"%s\",\"password\": \"%s\"}", login, password);
		return loginJSON;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getLoginJSON() {
		return loginJSON;
	}
}
