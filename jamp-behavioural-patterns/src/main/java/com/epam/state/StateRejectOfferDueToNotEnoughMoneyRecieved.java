package com.epam.state;

public class StateRejectOfferDueToNotEnoughMoneyRecieved implements VendingMachineState {
	@Override
	public boolean giveGoodsToCustomer(Goods goods, int money) {
		System.out.println(" goods " + goods.getName() + " was not given because customer does not given enough money");
		return false;
	}
}
