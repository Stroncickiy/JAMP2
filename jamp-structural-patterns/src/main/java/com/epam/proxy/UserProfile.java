package com.epam.proxy;

public class UserProfile {
	private String name;
	private String password;
	private int money;

	public UserProfile(String name, String password, int money) {
		super();
		this.name = name;
		this.password = password;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getMoney() {
		return money;
	}

	public void decreaseMoney(int amount) {
		money -= amount;
	}

}
