package com.epam.state;

public class StateRejectOfferDueToAbscenceOfMoneyForRest implements VendingMachineState {

	@Override
	public boolean giveGoodsToCustomer(Goods goods, int money) {
		System.out.println(
				" goods " + goods.getName() + " was  not given to customer because there is no money to give rest");
		return false;
	}

}
