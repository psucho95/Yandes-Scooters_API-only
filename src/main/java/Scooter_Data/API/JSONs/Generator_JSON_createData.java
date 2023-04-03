package Scooter_Data.API.JSONs;

import java.util.Random;

public class Generator_JSON_createData {
	String login;
	String password;
	String name;
	String registerJSON;

	public Generator_JSON_createData() {
		Random random = new Random();
		login = String.format("someLogin%d", random.nextInt(100, 9999));
		password = String.format("somePWD%d", random.nextInt(100, 9999));
		name = String.format("someName%d", random.nextInt(100, 9999));
	}


	public String JSON_Register(int isLogin, int isPassword, int isName) {

		String finalData = Integer.toString(isLogin) + Integer.toString(isPassword) + Integer.toString(isName);

		switch (finalData) {
			case "111": {
				registerJSON = String.format("{\"login\": \"%s\",\"password\": \"%s\",\"firstName\": \"%s\"}", login, password, name);
				return registerJSON;
			}
			case "011": {
				registerJSON = String.format("{\"login\": \"\",\"password\": \"%s\",\"firstName\": \"%s\"}", password, name);
				return registerJSON;
			}
			case "001": {
				registerJSON = String.format("{\"login\": \"\",\"password\": \"\",\"firstName\": \"%s\"}", name);
				return registerJSON;
			}
			case "101": {
				registerJSON = String.format("{\"login\": \"%s\",\"password\": \"\",\"firstName\": \"%s\"}", login, name);
				return registerJSON;
			}
			case "100": {
				registerJSON = String.format("{\"login\": \"%s\",\"password\": \"\",\"firstName\": \"\"}", login);
				return registerJSON;
			}
			case "110": {
				registerJSON = String.format("{\"login\": \"%s\",\"password\": \"%s\",\"firstName\": \"\"}", login, password);
				return registerJSON;
			}
			case "010": {
				registerJSON = String.format("{\"login\": \"\",\"password\": \"%s\",\"firstName\": \"\"}", password);
				return registerJSON;
			}

			default: {
				registerJSON = "{\"login\": \"defLogin\",\"password\": \"defPWD\",\"firstName\": \"defName\"}";
				return registerJSON;
			}
		}
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getRegisterJSON() {
		return registerJSON;
	}

}
