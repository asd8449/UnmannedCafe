package unmannedcafe.model.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DessertStorage {
	ArrayList<Dessert> DessertList = new ArrayList<>();
	private String fileName = "dessertlist.txt";
	private int lastId;
	public boolean isSaved;
	public DessertStorage() throws IOException {
		loadDessertListFromFile();
		generatedLastId();
		isSaved = true;
	}

	private void generatedLastId() {
		lastId = 0;
		for(Dessert dessert : DessertList) {
			int id = dessert.getID();
			if(id>lastId)
				lastId = id;
		}
		
	}

	private void loadDessertListFromFile()throws IOException {
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String idStr;
			while((idStr = br.readLine()) != null && !idStr.equals("")) {
				int id = Integer.parseInt(idStr);
				String name = br.readLine();
				int price = Integer.parseInt(br.readLine());
				DessertList.add(new Dessert(id, name, price));
			}
			fr.close();
			br.close();
		}catch(FileNotFoundException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public int getNumDesserts() {
		return DessertList.size();
	}
	
	public String getDessertInfo(int i) {
		return DessertList.get(i).toString();
	}
	
	public boolean isValidDessert(int id) {
		for(Dessert dessert : DessertList) {
			if(dessert.getID() == id)
				return true;
		}
		return false;
	}
	
	public Dessert getDessertById(int id) {
		for(Dessert dessert : DessertList) {
			if(dessert.getID() == id)
				return dessert;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return DessertList.size() == 0;
	}
	
	public void deleteItem(int id) {
		DessertList.remove(getDessertById(id));
		isSaved = false;
	}
	
	public void addDessert(String name, int price) {
		Dessert dessert = new Dessert(++lastId, name, price);
		isSaved = false;
	}
	
	public void saveDessert2File() {
		try {
			FileWriter fw = new FileWriter(fileName);
			for(Dessert dessert : DessertList) {
				fw.write(dessert.getID() + "\n");
				fw.write(dessert.getName() + "\n");
				fw.write(dessert.getPrice() + "\n");
			}
			isSaved = true;
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
