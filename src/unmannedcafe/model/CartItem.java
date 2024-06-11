package unmannedcafe.model;

<<<<<<< HEAD
import unmannedcafe.model.menu.Dessert;
=======
>>>>>>> refs/remotes/origin/master
import unmannedcafe.model.menu.Drink;

public class CartItem {
	Drink drink;
<<<<<<< HEAD
	Dessert dessert;
=======
>>>>>>> refs/remotes/origin/master
	int menuId;
	int quantity;
<<<<<<< HEAD

	public CartItem(Drink drink) {
		this.drink = drink;
		this.menuId = drink.getID();
=======
	
	public CartItem(Drink drink) {
		this.drink = drink;
		this.menuId = drink.getMenuId();
>>>>>>> refs/remotes/origin/master
		this.quantity = 1;
	}
<<<<<<< HEAD

	public CartItem(Dessert dessert) {
		this.dessert = dessert;
		this.menuId = dessert.getID();
		this.quantity = 1;
=======
	
	public Drink getDrink() {
		return drink;
>>>>>>> refs/remotes/origin/master
	}
<<<<<<< HEAD

	public Drink getDrink() {
		return drink;
=======
	public void setDrink(Drink drink) {
		this.drink = drink;
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
	public String toString(int i) {
		if (drink != null)
			return i + ", " + drink.getName() + ", " + quantity + "잔, " + getPrice() + "원";
		else
			return i + ", " + dessert.getName() + ", " + quantity + "개, " + getPrice() + "원";
=======
	@Override
	public String toString() {
		return drink.getMenuId() + ", " + drink.getName() + ", " + quantity + "잔, " + getPrice() + "원";
>>>>>>> refs/remotes/origin/master
	}

	public int getPrice() {
<<<<<<< HEAD
		if (drink != null)
			return quantity * drink.getPrice();
		else
			return quantity * dessert.getPrice();
=======
		return quantity * drink.getPrice();
>>>>>>> refs/remotes/origin/master
	}

}
