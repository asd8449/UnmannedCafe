package unmannedcafe;

import java.io.IOException;

import unmannedcafe.controller.UnmannedCafeController;
import unmannedcafe.model.menu.DessertStorage;
import unmannedcafe.model.menu.DrinkStorage;
import unmannedcafe.model.Cart;
import unmannedcafe.view.ConsoleView;

public class UnmannedCafe {

	public static void main(String[] args) throws IOException {
		// model 생성
		DrinkStorage drinkStorage = new DrinkStorage();
		DessertStorage dessertStorage = new DessertStorage();
		Cart cart = new Cart();
		
		// view 생성
		ConsoleView view = new ConsoleView();
		
		// controller 생성 (model, view)
		UnmannedCafeController controller = new UnmannedCafeController(drinkStorage, dessertStorage, cart, view);
		controller.start();
		
		
	}

}