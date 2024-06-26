package unmannedcafe.model.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DrinkStorage {
	ArrayList<Drink> DrinkList = new ArrayList<>();
	private String fileName = "drinklist.txt";
	private int lastId;
	public boolean isSaved;

	public DrinkStorage() throws IOException {
		loadDrinkListFromFile();
		generatedLastId();
		isSaved = true;
	}

	private void generatedLastId() {
		lastId = 0;
		for (Drink drink : DrinkList) {
			int id = drink.getID();
			if (id > lastId)
				lastId = id;
		}

	}

	private void loadDrinkListFromFile() throws IOException {
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String idStr;
			while ((idStr = br.readLine()) != null && !idStr.equals("")) {
				int id = Integer.parseInt(idStr);
				String name = br.readLine();
				int ml = Integer.parseInt(br.readLine());
				int price = Integer.parseInt(br.readLine());
				DrinkList.add(new Drink(id, name, ml, price));
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

	public int getNumDrinks() {
		return DrinkList.size();
	}

	public String getDrinkInfo(int i) {
		return DrinkList.get(i).toString();
	}

	public boolean isValidDrink(int id) {
		for (Drink drink : DrinkList) {
			if (drink.getID() == id)
				return true;
		}
		return false;
	}

	public Drink getDrinkById(int id) {
		for (Drink drink : DrinkList) {
			if (drink.getID() == id)
				return drink;
		}
		return null;
	}

	public boolean isEmpty() {
		return DrinkList.size() == 0;
	}

	public void deleteItem(int id) {
		DrinkList.remove(getDrinkById(id));
		isSaved = false;
	}

	public void addDrink(String name, int ml, int price) {
		Drink drink = new Drink(++lastId, name, ml, price);
		isSaved = false;
	}

	public void saveDrink2File() {
		try {
			FileWriter fw = new FileWriter(fileName);
			for (Drink drink : DrinkList) {
				fw.write(drink.getID() + "\n");
				int id = drink.getID();
				if (id > lastId)
					lastId = id;
			}
			isSaved = true;
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
