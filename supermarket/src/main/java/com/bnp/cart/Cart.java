package com.bnp.cart;

import java.util.HashMap;
import java.util.Map;

import com.bnp.item.Item;

public class Cart {

	private static Map<Item, Double> instance;

	/** Point d'accès pour l'instance unique du singleton */
	public static Map<Item, Double> getInstance() {
		if (instance == null) {
			instance = new HashMap<>();
		}
		return instance;
	}

	public void addToCart(Item item, Double quantity) {
		instance.put(item, quantity);
	}

}
