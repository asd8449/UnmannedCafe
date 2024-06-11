package unmannedcafe.model;

import java.util.ArrayList;

<<<<<<< HEAD
import unmannedcafe.model.menu.Dessert;
=======
>>>>>>> refs/remotes/origin/master
import unmannedcafe.model.menu.Drink;

public class Cart {
	// private CartItem[] itemList = new CartItem[64];
	private ArrayList<CartItem> itemList = new ArrayList<>();
	Drink drink;
	Dessert dessert;
	// private int numItems = 0;

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
<<<<<<< HEAD

=======
		
>>>>>>> refs/remotes/origin/master
		CartItem item = getCartItem(drink);
		if (item == null) {
			itemList.add(new CartItem(drink));
<<<<<<< HEAD
		} else {
=======
		}
		else {
>>>>>>> refs/remotes/origin/master
			item.addQuantity(1);
		}
	}
<<<<<<< HEAD

	public void addItem(Dessert dessert) {

		CartItem item = getCartItem(dessert);
		if (item == null) {
			itemList.add(new CartItem(dessert));
		} else {
			item.addQuantity(1);
=======
	
	private CartItem getCartItem(Drink drink) {
		
		for (CartItem item : itemList) {
			if (item.getDrink() == drink) return item;
>>>>>>> refs/remotes/origin/master
		}
	}

	private CartItem getCartItem(Drink drink) {

		for (CartItem item : itemList) {
			if (item.getDrink() == drink)
				return item;
		}

		return null;
	}
<<<<<<< HEAD

	private CartItem getCartItem(Dessert dessert) {

=======
	
	private CartItem getCartItem(int id) {
>>>>>>> refs/remotes/origin/master
		for (CartItem item : itemList) {
<<<<<<< HEAD
			if (item.getDessert() == dessert)
				return item;
		}

		return null;
	}

	private CartItem getCartItem(int id) {
		for (CartItem item : itemList) {
			if (item.menuId == id)
				return item;
=======
			if (item.menuId == id) return item;
>>>>>>> refs/remotes/origin/master
		}
		return null;
	}

	public void resetCart() {
		itemList.clear();
	}

	public boolean isValidItem(int id) {
		for (CartItem item : itemList) {
<<<<<<< HEAD
			if (item.menuId == id)
				return true;
=======
			if (item.menuId == id) return true;
>>>>>>> refs/remotes/origin/master
		}
		return false;
	}

<<<<<<< HEAD
	public boolean checkCartItem(int num) {
		if (itemList.size() >= num)
			return true;
		return false;
=======
	public void deleteItem(int id) {
		CartItem item = getCartItem(id);
		itemList.remove(item);
>>>>>>> refs/remotes/origin/master
	}

<<<<<<< HEAD
	public void deleteItem(int num) {
		itemList.remove(num);
	}

	public void updateQuantity(int id, int quantity) {

=======
	public void updateQuantity(int id, int quantity) {
		
>>>>>>> refs/remotes/origin/master
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
