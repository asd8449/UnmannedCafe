package unmannedcafe.model;

import unmannedcafe.model.menu.Dessert;
import unmannedcafe.model.menu.Drink;

public class CartItem {
	Drink drink;
	Dessert dessert;
	int menuId;
	int quantity;


	
	public CartItem(Drink drink) {
		this.drink = drink;
		this.menuId = drink.getID();
		this.quantity = 1;
	}


	public CartItem(Dessert dessert) {
		this.dessert = dessert;
		this.menuId = dessert.getID();
		this.quantity = 1;
	}


	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
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

	public String toString(int i) {
		if (drink != null)
			return i + ", " + drink.getName() + ", " + quantity + "잔, " + getPrice() + "원";
		else
			return i + ", " + dessert.getName() + ", " + quantity + "개, " + getPrice() + "원";
	}

	public int getPrice() {

		if (drink != null)
			return quantity * drink.getPrice();
		else
			return quantity * dessert.getPrice();

	}

}
