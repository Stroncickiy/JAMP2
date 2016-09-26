package com.epam.state;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
	// available Goods
	private static final Goods sneakers = new Goods("Sneakers", 20);
	private static final Goods lays = new Goods("Lays", 30);
	private static final Goods twix = new Goods("Twix", 40);
	// states 
	private static final VendingMachineState STATE_REJECT_NOT_ENOUGH_MONEY = new StateRejectOfferDueToNotEnoughMoneyRecieved();
	private static final VendingMachineState STATE_NO_SUCH_PRODUCT = new StateRejectOfferDueToAbsenceOfGoods();
	private static final VendingMachineState STATE_NOT_ENOUGH_MONEY_TO_GIVE_REST = new StateRejectOfferDueToAbscenceOfMoneyForRest();
	private static final VendingMachineState STATE_GIVE_GOODS_AND_REST = new StateGiveGoodsWithRest();
	private static final VendingMachineState STATE_GIVE_GOODS_WITHOUT_REST = new StateGiveGoodsWithoutRest();
	
	private VendingMachineState machineState;
	private Map<Goods, Integer> goods;
	private Integer bank;

	public VendingMachine() {
		goods = new HashMap<>();
		bank = 10; // original amount of money in machine 
		goods.put(sneakers, 2);
		goods.put(lays, 1);
		goods.put(twix, 4);
	}

	public Goods buyGoods(String goodsIdentifier, int money) {
		Goods goodsByIdentifier = getGoodsByIdentifier(goodsIdentifier);
		if (goodsByIdentifier == null) {
			System.out.println("no such goods " + goodsIdentifier);
			return null;
		}

		int cost = goodsByIdentifier.getCost();
		Integer countOfGoods = goods.get(goodsByIdentifier);

		if (money < cost) {
			machineState = STATE_REJECT_NOT_ENOUGH_MONEY;
			machineState.giveGoodsToCustomer(goodsByIdentifier, -1);
			return null;
		}

		if (countOfGoods < 1) {
			machineState = STATE_NO_SUCH_PRODUCT;
			machineState.giveGoodsToCustomer(goodsByIdentifier, -1);
			return null;
		}

		if (money > cost) {
			int rest = money - cost;
			if (rest > bank) {
				machineState = STATE_NOT_ENOUGH_MONEY_TO_GIVE_REST;
				machineState.giveGoodsToCustomer(goodsByIdentifier, rest);
				return null;
			} else {
				machineState = STATE_GIVE_GOODS_AND_REST;
				machineState.giveGoodsToCustomer(goodsByIdentifier, rest);
				decreaseGoodsCount(goodsByIdentifier);
				bank += money;
				bank -= rest;
				return goodsByIdentifier;
			}
		} else {
			machineState = STATE_GIVE_GOODS_WITHOUT_REST;
			machineState.giveGoodsToCustomer(goodsByIdentifier, -1);
			decreaseGoodsCount(goodsByIdentifier);
			bank += money;
			return goodsByIdentifier;
		}
	}

	private void decreaseGoodsCount(Goods goodsIdentifier) {
		Integer oldCount = goods.get(goodsIdentifier);
		goods.remove(goodsIdentifier);
		goods.put(goodsIdentifier, oldCount - 1);

	}

	private Goods getGoodsByIdentifier(String goodsIdentifier) {
		if (twix.getName().equalsIgnoreCase(goodsIdentifier)) {
			return twix;
		} else if (sneakers.getName().equalsIgnoreCase(goodsIdentifier)) {
			return sneakers;
		} else if (lays.getName().equalsIgnoreCase(goodsIdentifier)) {
			return lays;
		}
		return null;
	}
}
