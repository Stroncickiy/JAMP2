package com.epam.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyBankAccount implements BankAccount {

	private BankAccount realAccount;
	private Map<String, String> userPasswords;

	public ProxyBankAccount(BankAccount realAccount) {
		this.userPasswords = new HashMap<>();
		this.realAccount = realAccount;

		userPasswords.put("Bob", "qweqwe");
	}

	@Override
	public int getMoney(UserProfile userProfile, int amount) {
		if (userPasswords.containsKey(userProfile.getName())) {
			if (userPasswords.get(userProfile.getName()).equals(userProfile.getPassword())) {
				return realAccount.getMoney(userProfile, amount);
			} else {
				System.out.println(" Wrong password for user " + userProfile.getName());
			}

		} else {
			System.out.println(" User does not exists " + userProfile.getName());
		}
		return -1;
	}

}
