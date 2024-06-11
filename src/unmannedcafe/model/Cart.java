package unmannedcafe.model;

import java.util.ArrayList;
import unmannedcafe.model.menu.Dessert;
import unmannedcafe.model.menu.Drink;

public class Cart {
	private ArrayList<CartItem> itemList = new ArrayList<>();
	Drink drink;
	Dessert dessert;

	public boolean isEmpty() {
		return itemList.isEmpty();
	}

	public ArrayList<CartItem> getItemList() {
		return itemList;
	}

	public int getNumItems() {
		return itemList.size();
	}

	public String getItemInfo(int index) {
		return itemList.get(index).toString(index + 1);
	}

	public void addItem(Drink drink) {

		CartItem item = getCartItem(drink);
		if (item == null) {
			itemList.add(new CartItem(drink));

		} else {

			item.addQuantity(1);
		}
	}

	public void addItem(Dessert dessert) {

		CartItem item = getCartItem(dessert);
		if (item == null) {
			itemList.add(new CartItem(dessert));
		} else {
			item.addQuantity(1);
		}
	}

	private CartItem getCartItem(Drink drink) {

		for (CartItem item : itemList) {
			if (item.getDrink() == drink)
				return item;
		}
		return null;
	}

	private CartItem getCartItem(Dessert dessert) {

		for (CartItem item : itemList) {

			if (item.getDessert() == dessert)
				return item;
		}

		return null;
	}

	private CartItem getCartItem2Num(int num) {
		if (num <= itemList.size())
			return itemList.get(num - 1);
		return null;
	}

	public void resetCart() {
		itemList.clear();
	}

	public boolean checkCartItem(int num) {
		if (itemList.size() >= num)
			return true;
		return false;
	}

	public void deleteItem(int num) {
		itemList.remove(num);
	}

	public void updateQuantity(int num, int quantity) {

		if (quantity == 0)
			deleteItem(num);
		else {
			CartItem item = getCartItem2Num(num);
			item.setQuantity(quantity);
		}

	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for (CartItem item : itemList) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

}
