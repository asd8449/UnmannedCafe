package unmannedcafe.model.menu;

public class Drink extends Menu{
	private final int tag = 1;
	private int ml;//용량
	public Drink(int id, String name, int ml, int price) {
		super(id, name, price);
		this.ml = ml;
	}
	
	@Override
	public String toString() {
		return getID() + " | " + getName() + " | " + ml + "ml | " + getPrice() + "원";
	}	
	
	public int getMl() {
		return ml;
	}
	public void setMl(int ml) {
		this.ml = ml;
	}
	
}
