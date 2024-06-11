package unmannedcafe.model.menu;

public class Dessert extends Menu{
	public Dessert(int id, String name, int price) {
		super(id, name, price);
	}
	
	@Override
	public String toString() {
		return getID() + " | " + getName() + " | " + getPrice() + "원 | ";
	}
	
}

