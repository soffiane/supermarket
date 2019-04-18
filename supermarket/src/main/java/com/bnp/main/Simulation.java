package com.bnp.main;

import com.bnp.cart.Cart;
import com.bnp.exceptions.CartException;

public class Simulation {

	public static void main(String[] args) {

		// When the cart is empty check the contents
		// This should throw an exception because the cart is empty
		try {
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}

		// Add 4 apples and then print the total price and also review the cart
		try {
			Cart.addItem("Apple", 4);
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		double totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);

		// Add 3 oranges and then print the total price and also review the cart
		try {
			Cart.addItem("Orange", 3);
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);

		//Add 5 watermelons and then print the total price and also review the cart
		try {
			Cart.addItem("Watermelon", 5);
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);

		// Remove 2 apples and then print the total price and also review the cart
		try {
			Cart.removeItem("Apple", 2);
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		try {
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);

		// Remove an Orange from the cart and then print the total price and also review the cart
		try {
			Cart.removeItem("Orange", 1);
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Cart.removeItem("Watermelon", 2);
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		try {
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);

		// Here you empty your cart and then review
		// the total price and content of the cart
		Cart.emptyCart();
		try {
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);

		// Add 4 apples A again and review the price and content of the cart
		try {
			Cart.addItem("Apple", 4);
			Cart.reviewCart();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		totalPrice = Cart.calculateTotalPrice(Cart.getCartContent());
		System.out.println("Total Price: " + totalPrice);
	}

}
