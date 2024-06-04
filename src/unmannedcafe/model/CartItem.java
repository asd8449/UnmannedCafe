package unmannedcafe.model;

import unmannedcafe.model.menu.Drink;

public class CartItem {
	Drink drink;
	int menuId;
	int quantity;
	
	public CartItem(Drink drink) {
		this.drink = drink;
		this.menuId = drink.getMenuId();
		this.quantity = 1;
	}
	
	public Drink getDrink() {
		return drink;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
		
	}

	@Override
	public String toString() {
		return drink.getMenuId() + ", " + drink.getName() + ", " + quantity + "잔, " + getPrice() + "원";
	}

	public int getPrice() {
		return quantity * drink.getPrice();
	}
	
	
}
