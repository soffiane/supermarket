package com.bnp.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.bnp.exceptions.CartException;
import com.bnp.item.Item;

public class Cart {

	private static Map<String, Integer> cartContent = new HashMap<>();
	protected static Map<String, Item> offerList = new HashMap<>();
	protected static Map<String, Double> itemList = new HashMap<>();

	static {
		itemList.put("Apple", 0.20);
		itemList.put("Orange", 0.50);
		itemList.put("Watermelon", 0.80);
		offerList.put("Apple", new Item("Apple", 2, 0.20));
		offerList.put("Watermelon", new Item("Watermelon", 3, 1.60));
	}

	// Method to add item to the existing cart
	public static void addItem(String item, Integer quantity) throws CartException {
		// IF we try to add an item we don't sell
		if (itemList.containsKey(item)) {
			// If the item does not exist in the cart then add it
			if (!getCartContent().containsKey(item)) {
				getCartContent().put(item, quantity);
			} else {
				// if the cart already contains the item then just update
				// the amount by adding the new quantity to old one
				getCartContent().put(item, quantity + getCartContent().get(item));
			}
		} else {
			throw new CartException("This item is not available");
		}
	}

	// Method to remove items along with their quantities from the existing cart
	public static void removeItem(String item, Integer quantity) throws CartException {
		// If the item is not in the cart then throw exception
		if (!getCartContent().containsKey(item)) {
			throw new CartException("No such item in your cart");
		}

		// If the item's quantity to be removed is equal to the existing quantity
		// of the item then remove the item from the cart or else update the quantity
		// of the item in the cart. If the quantity to be removed is more than what's
		// existing in the cart then throw exception as well.
		if (quantity.equals(getCartContent().get(item))) {
			getCartContent().remove(item);
		} else if (getCartContent().get(item) > quantity) {
			getCartContent().put(item, getCartContent().get(item) - quantity);
		} else {
			throw new CartException("Quantity for the provided item is more than the quantity in the cart");
		}
	}

	// Method to preview the content of the cart and all items in it
	public static void reviewCart() throws CartException {
		if (getCartContent().isEmpty()) {
			throw new CartException("Your cart is empty");
		}

		// Iterate through the cart and display the items with their quantities
		Set<String> allItemsInCart = getCartContent().keySet();
		System.out.println("------------------------------------------------------------------");
		for (Iterator<String> i = allItemsInCart.iterator(); i.hasNext();) {
			String item = i.next();
			Integer quantity = getCartContent().get(item);
			System.out.println("Item: " + item + "           Quantity: " + quantity);
		}
		System.out.println("------------------------------------------------------------------");
	}

	// Method to empty the cart
	public static void emptyCart() {
		getCartContent().clear();
	}

	// Method to calculate all total price based on the contents of the cart
	public static double calculateTotalPrice(Map<String, Integer> itemsListMap) {
		Double total = 0.0;

		// Iterate through the cart and calculate the total value of each item and then
		// add the total
		Set<String> keys = itemsListMap.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext();) {
			String item = i.next();
			Integer quantity = itemsListMap.get(item);

			// If there is an offer on this item then process the price accordingly
			if (offerList.containsKey(item)) {
				Item thisOffer = offerList.get(item);

				// If the quantity of the item in the cart is more than offer quantity
				// then process the items and their price accordingly
				if (thisOffer.getQuantity() < quantity) {
					total += (quantity / thisOffer.getQuantity()) * thisOffer.getPrice()
							+ (quantity % thisOffer.getQuantity()) *itemList.get(item);
				} else if (quantity.equals(thisOffer.getQuantity())) {
					total += thisOffer.getPrice();
				} else {
					total += (quantity) * thisOffer.getPrice();
				}
				// If there is no offer on the item then just fetch the price from the price map and calculate the total
			} else {
				Double itemPrice = itemList.get(item);
				total += quantity * itemPrice;
			}
		}

		return total;
	}

	public static Map<String, Integer> getCartContent() {
		return cartContent;
	}

}
