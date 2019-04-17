package com.bnp.main;

import java.util.Map;
import java.util.Scanner;

import com.bnp.cart.Cart;
import com.bnp.item.Item;

public class Simulation {
	
	public static void main(String[] args) {
		System.out.println("Welcome to your favorite supermarket");
		System.out.println("Item				Price");
		Map<Item, Double> cart = Cart.getInstance();
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int quantity = in.nextInt();
		} finally {
			in.close();
		}
		
	}

}
