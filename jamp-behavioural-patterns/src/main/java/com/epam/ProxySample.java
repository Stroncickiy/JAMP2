package com.epam;

import com.epam.proxy.BankAccount;
import com.epam.proxy.ConcreteBankAccount;
import com.epam.proxy.ProxySecuredBankAccount;
import com.epam.proxy.UserProfile;

public class ProxySample {
	public static void exec() {

		BankAccount realAccount = new ConcreteBankAccount();
		BankAccount account = new ProxySecuredBankAccount(realAccount);

		UserProfile userProfile = new UserProfile("Bob", "qweqwe", 100);
		UserProfile userProfileWrongPass = new UserProfile("Bob", "qweqwe1", 100);
		
		UserProfile userProfileNotExists = new UserProfile("John", "qweqwe", 100);

		int money = account.getMoney(userProfile, 10);
		if (money > 0) {
			System.out.println(" we just taken " + money + " dollars from user " + userProfile.getName() + " account");
		}

		account.getMoney(userProfileWrongPass, 10);
		account.getMoney(userProfileNotExists, 10);

	}
}
