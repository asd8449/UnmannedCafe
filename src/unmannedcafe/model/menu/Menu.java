package unmannedcafe.model.menu;

public class Menu {
	private int ID;
	private String name;
	private int price;
	
	public Menu(int id, String name, int price) {
		this.ID = id;
		this.name = name;
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
