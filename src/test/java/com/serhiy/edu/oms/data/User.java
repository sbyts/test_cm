package com.serhiy.edu.oms.data;

interface ILoginName {
	IPassword setLoginName(String loginName);
}

interface IPassword {
	IBuild setPassword(String password);
}

interface IBuild {
	IUser build();
}

public class User implements  ILoginName, IPassword,
		 IBuild, IUser {
	private String loginName;
	private String password;
	private User() {
	}

	private User(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public static ILoginName get() {
		return new User();
	}

	public IPassword setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	public IBuild setPassword(String password) {
		this.password = password;
		return this;
	}

	public IUser build() {
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}


	// - - - - - - - - - - - - - - - - - - - -
}
