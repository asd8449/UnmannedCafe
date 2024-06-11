package unmannedcafe.view;

import java.util.Scanner;

import unmannedcafe.model.Cart;
import unmannedcafe.model.User;
import unmannedcafe.model.menu.DessertStorage;
import unmannedcafe.model.menu.DrinkStorage;

public class ConsoleView {

	// 환영 인사 출력
	public void displayWelcome() {
		String welcome = "24시 무인 카페에 오신걸 환영합니다.";
		System.out.println(welcome);	
	}

	// 메뉴 번호 입력 받기
	public int selectMenu(String[] menuList) {
		
		displayMenu(menuList);
		
		int menu;
		do {
			System.out.print(">> 메뉴 선택 : ");
			menu = readNumber();	
			if (menu < 0 || menu >= menuList.length)
				System.out.println("0부터 " + (menuList.length-1) + "까지의 숫자를 입력하세요.");
		} while (menu < 0 || menu >= menuList.length);
		return menu;
	}

	// 메뉴 출력
	private void displayMenu(String[] menuList) {
		System.out.println("=========================================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("=========================================");
	}

	// 음료 목록 보여주기
	public void displayDrinkInfo(DrinkStorage drinkStorage) {
		for (int i = 0; i < drinkStorage.getNumDrinks(); i++) {
			String drinkInfo = drinkStorage.getDrinkInfo(i);
			System.out.println(drinkInfo);
		}
	}
	// 디저트 목록 보여주기
	public void displayDessertInfo(DessertStorage dessertStorage) {
		for (int i = 0; i < dessertStorage.getNumDesserts(); i++) {
			String dessertInfo = dessertStorage.getDessertInfo(i);
			System.out.println(dessertInfo);
		}
	}

	// 장바구니 보여주기
	public void displayCart(Cart cart) {
		if (cart.isEmpty()) {
			System.out.println(">> 장바구니가 비어 있습니다.");
			return;
		}
			
		for (int i = 0; i < cart.getNumItems(); i++) {
			System.out.println(cart.getItemInfo(i));	
		}
		System.out.println("총 금액 : " + cart.getTotalPrice() + "원");
	}

	// 입력받은 매개변수에 따라 같은 이름의 다른 메서드 실행(오버로딩) 
	public int selectMenuId(DrinkStorage drinkStorage) {
	
		int id;
		boolean result;
		do {
			System.out.print("장바구니에 추가할 음료의 ID를 입력하세요 : ");
			id = readNumber();
			result = drinkStorage.isValidDrink(id);
			if (!result)
				System.out.print("잘못된 ID입니다.");
		} while (!result);
		
		return id;
	}
	
	public int selectMenuId(DessertStorage dessertStorage) {
		
		int id;
		boolean result;
		do {
			System.out.print("장바구니에 추가할 디저트의 ID를 입력하세요 : ");
			id = readNumber();
			result = dessertStorage.isValidDessert(id);
			if (!result)
				System.out.print("잘못된 ID입니다.");
		} while (!result);
		
		return id;
	}
	// 장바구니에 있는 메뉴의 번호를 입력 받기
	public int selectMenuNum(Cart cart) {
		int num;
		boolean result;
		do {
			System.out.print("메뉴 번호 입력 : ");
			num = readNumber();
			result = cart.checkCartItem(num);
			if (!result)
				System.out.print("잘못된 입력입니다.\n");
		} while (!result);
		return num;
	}

	// 메뉴 수량 입력 받기
	public int inputQuantity() {
		int number;
		do {
			System.out.print(">> 수량 입력 (" + 0 + "이상 입력) : ");
			number = readNumber();
			if (number < 0)
				System.out.println("잘못된 수량입니다.");
		} while (number < 0);
		
		return number;
	}

	// 고객 정보 입력 받기
	public void inputCustomerInfo(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("회원명과 적립번호(전화번호)를 입력해주세요.");
		System.out.print(">> 회원명 : ");
		user.setName(input.nextLine());
		System.out.print(">> 전화번호 : ");
		user.setPhone(input.nextLine());
	}

	// 배송 정보 입력 받기 - 주소와 이메일주소가 없는 경우
//	public void inputDeliveryInfo(Customer customer) {
//		if (customer.getEmail() == null) {
//			Scanner input = new Scanner(System.in);
//			System.out.println("배송을 위하여 이메일 주소와 배송받을 곳의 주소를 입력받습니다.");
//			System.out.print(">> 이메일 : ");
//			customer.setEmail(input.nextLine());
//			System.out.print(">> 주소 : ");
//			customer.setAddress(input.nextLine());
//		}
//	}
	
	public void displayOrder(Cart cart, User user) {
		
		System.out.println();
		// 장바구니 보여주기
		System.out.println("***** 주문 정보 ******");
		displayCart(cart);
		
		// 주문 정보 보여주기 - 회원명, 전화번호(적립번호)
		System.out.println("***** 적립 확인 ******");
		System.out.println(">> 회원명 : " + user.getName());
		System.out.println(">> 전화번호 : " + user.getPhone());
		System.out.println();

	}
	
	/////////////////////  공용 모듈 ////////////////////////
	
	// 입력된 문자열을 입력했을 때만 true를 반환하는 confirm용
	public boolean askConfirm(String message, String yes) {
		
		System.out.print(message);
		
		Scanner input = new Scanner(System.in);
		if (input.nextLine().equals(yes)) return true;
		return false;
		
	}
	
	// 숫자 입력 받기 (숫자가 아닌 문자를 넣으면 예외 처리하고 다시 입력받기)
	public int readNumber() {
		Scanner input = new Scanner(System.in);
		try {
			int number = input.nextInt();
			return number;
		} catch (Exception e) {
			System.out.print("숫자를 입력하세요 :");
			return readNumber();
		}
	}
	
	public int readNumber(String message) {
		Scanner input = new Scanner(System.in);
		showMessage(message);
		try {
			int number = input.nextInt();
			return number;
		} catch (Exception e) {
			System.out.print("숫자를 입력하세요 :");
			return readNumber();
		}
	}
	
	// 입력된 문자열 출력
	public void showMessage(String message) {
		System.out.println(message);
		
	}

	public String inputString(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		return sc.nextLine();
	}


	
}
