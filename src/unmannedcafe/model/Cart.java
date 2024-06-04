package unmannedcafe.model;

import java.util.ArrayList;

import unmannedcafe.model.menu.Drink;

public class Cart {
	//private CartItem[] itemList = new CartItem[64];
	private ArrayList<CartItem> itemList = new ArrayList<>();
	//private int numItems = 0;

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
		return itemList.get(index).toString();
	}

	public void addItem(Drink drink) {
		
		CartItem item = getCartItem(drink);
		if (item == null) {
			itemList.add(new CartItem(drink));
		}
		else {
			item.addQuantity(1);
		}
	}
	
	private CartItem getCartItem(Drink drink) {
		
		for (CartItem item : itemList) {
			if (item.getDrink() == drink) return item;
		}
		
		return null;
	}
	
	private CartItem getCartItem(int id) {
		for (CartItem item : itemList) {
			if (item.menuId == id) return item;
		}
		return null;
	}
	

	public void resetCart() {
		itemList.clear();
	}

	public boolean isValidItem(int id) {
		for (CartItem item : itemList) {
			if (item.menuId == id) return true;
		}
		return false;
	}

	public void deleteItem(int id) {
		CartItem item = getCartItem(id);
		itemList.remove(item);
	}

	public void updateQuantity(int id, int quantity) {
		
		if (quantity == 0)
			deleteItem(id);
		else {
			CartItem item = getCartItem(id);
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


