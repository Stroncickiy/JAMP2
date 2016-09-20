package com.epam.proxy;

public class ConcreteBankAccount implements BankAccount {

	@Override
	public int getMoney(UserProfile userProfile, int amount) {
		if (userProfile.getMoney() >= amount) {
			userProfile.decreaseMoney(amount);
			return amount;
		} else {
			return -1;
		}
	}

}
