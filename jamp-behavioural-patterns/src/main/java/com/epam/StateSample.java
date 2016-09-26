package com.epam;

import com.epam.state.VendingMachine;

public class StateSample {
	private static final String SNEAKERS = "Sneakers"; // costs 20 | count = 2
	private static final String LAYS = "Lays"; // costs 30 | count = 1 
	private static final String TWIX = "Twix"; // costs 40 | count = 4  
	private static final String M_MS = "M&Ms"; // no such goods in machine att all

	public static void exec() {
		VendingMachine vendingMachine = new VendingMachine();
		
		vendingMachine.buyGoods(TWIX, 400); // no money to give rest		
		
		vendingMachine.buyGoods(SNEAKERS, 10); // not enough money received from customer
		vendingMachine.buyGoods(SNEAKERS, 25); // goods given to customer with rest
		
		vendingMachine.buyGoods(LAYS, 30); // goods given to customer  without rest 
		vendingMachine.buyGoods(LAYS, 30); // there is no more such  products
		
		vendingMachine.buyGoods(M_MS, 50); // there is no such goods at all

	}
}
