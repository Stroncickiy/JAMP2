package com.epam.state;

public interface VendingMachineState {
	boolean giveGoodsToCustomer(Goods goods,int rest);
}
