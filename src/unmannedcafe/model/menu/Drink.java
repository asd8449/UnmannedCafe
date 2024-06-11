package unmannedcafe.model.menu;

<<<<<<< HEAD
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
=======
public class Drink {
	private final int tag = 1;
	private int menuId;
	private String name;
	private int ml;//용량
	private int price;
	private boolean ice;
	public Drink(int id, String name, int ml, int price) {
		this.menuId = id;
		this.name = name;
		this.ml = ml;
		this.price = price;
		//this.ice = ice;
	}
	
	@Override
	public String toString() {
		String i = ice ? "차가운" : "뜨거운";
		return menuId + " | " + name + " | " + ml + "ml | " + price + "원 | " + i + "음료";
	}	
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMl() {
		return ml;
	}
	public void setMl(int ml) {
		this.ml = ml;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isIce() {
		return ice;
	}
	public void setIce(boolean ice) {
		this.ice = ice;
>>>>>>> refs/remotes/origin/master
	}
	
}
