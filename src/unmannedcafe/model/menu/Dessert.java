<<<<<<< HEAD
package unmannedcafe.model.menu;

public class Dessert extends Menu{
	private final int tag = 2;
	public Dessert(int id, String name, int price) {
		super(id, name, price);
	}
	
	@Override
	public String toString() {
		return getID() + " | " + getName() + " | " + getPrice() + "원 | ";
	}
	
}
=======
package unmannedcafe.model.menu;

public class Dessert {
	private final int tag = 2;
	private int menuId;
	private String name;
	private int price;
	
}
>>>>>>> refs/remotes/origin/master
