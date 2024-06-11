package unmannedcafe.controller;

import unmannedcafe.model.Cart;
import unmannedcafe.model.menu.DessertStorage;
import unmannedcafe.model.menu.DrinkStorage;
import unmannedcafe.model.User;
import unmannedcafe.view.ConsoleView;

public class UnmannedCafeController {

	ConsoleView view;
	DrinkStorage drinkStorage;
	DessertStorage dessertStorage;
	Cart mCart;
	User mUser;
	
	String[] categoryList = {
			"0. 뒤로가기",
			"1. 음료",
			"2. 디저트"
	};
	
	String[] menuList = {
			"0. 종료",
			"1. 음료 메뉴 보기",
			"2. 디저트 메뉴 보기",
			"3. 장바구니 보기",
			"4. 메뉴 담기",
			"5. 장바구니 메뉴 삭제",
			"6. 장바구니 메뉴 수량 변경",
			"7. 장바구니 비우기",
			"8. 주문하기",
			"9. 관리자 모드"
	};
	
	public UnmannedCafeController(DrinkStorage drinkStorage, DessertStorage dessertStorage, Cart cart, ConsoleView view) {
		this.view = view;
		this.drinkStorage = drinkStorage;
		this.dessertStorage = dessertStorage;
		this.mCart = cart;
	}

	public void start() {
		welcome();
		
		int menu;
		
		do {
			menu = view.selectMenu(menuList);
			
			switch (menu) {
			case 1 -> viewDrinkInfo();
			case 2 -> viewDessertInfo();
			case 3 -> viewCart();
			case 4 -> addMenu2Cart();
			case 5 -> deleteMenuInCart();
			case 6 -> updateMenuInCart();
			case 7 -> resetCart();
			case 8 -> order();
			case 9 -> adminMode();
			case 0 -> end();
			default -> view.showMessage("잘못된 메뉴 번호입니다.");
			}
		} while (menu != 0);	
	}

	private void adminMode() {
		authenticateAdmin();
		
	}

	private void authenticateAdmin() {
		view.showMessage("관리자 모드 진입을 위한 인증");
		String id = view.inputString("id 입력 : ");
		String pw = view.inputString("password 입력 : ");
		
	}

	// 환영 인사
	private void welcome() {
		view.displayWelcome();
	}
	
	// 고객 정보 등록
	private void registerUserInfo() {
		mUser = new User();
		view.inputCustomerInfo(mUser);
	}

	// 도서 정보 보기
	private void viewDrinkInfo() {
		view.displayDrinkInfo(drinkStorage);
	}
	
	private void viewDessertInfo() {
		view.displayDessertInfo(dessertStorage);
	}
	
	// 장바구니 보기
	private void viewCart() {
		view.displayCart(mCart);
	}

	// 장바구니에 도서 추가
	private void addMenu2Cart() {
		int category;
		do {
			category = view.selectMenu(categoryList);
			
			switch (category) {
			case 1 -> selectDrink(category);
			case 2 -> selectDessert(category);
			case 0 -> cancel();
			default -> view.showMessage("존재하지 않는 카테고리입니다.");
			}
		} while (category != 0);

	}
	
	private void selectDrink(int categ) {
		view.displayDrinkInfo(drinkStorage);
		int id = view.selectMenuId(drinkStorage);
		mCart.addItem(drinkStorage.getDrinkById(id));
		view.showMessage(">>장바구니에 메뉴를 추가하였습니다.");	
	}

	private void selectDessert(int categ) {
		view.displayDessertInfo(dessertStorage);
		int id = view.selectMenuId(dessertStorage);
		mCart.addItem(dessertStorage.getDessertById(id));
		view.showMessage(">>장바구니에 메뉴를 추가하였습니다.");	
	}

	private void cancel() {
		System.out.println("메인메뉴로 돌아갑니다.");
	}

	// 장바구니 도서 삭제
	private void deleteMenuInCart() {
		// 장바구니 보여주기
		view.displayCart(mCart);
		if (!mCart.isEmpty()) {
			// 장바구니 번호 입력
			int cartListNum = view.selectMenuNum(mCart);
			if (view.askConfirm(">> 해당 메뉴를 삭제하려면 y를 입력하세요 : ", "y")) {
				// 해당 도서 ID의 cartItem 삭제
				mCart.deleteItem(cartListNum - 1);
				view.showMessage(">> 삭제완료");
			}else {
				System.out.println("취소되었습니다.");
			}
		}
	}
	
	// 장바구니 도서 수량 변경
	private void updateMenuInCart() {
		// 장바구니 보여주기
		view.displayCart(mCart);
		if (!mCart.isEmpty()) {
			// 도서 ID 입력 받기
			int num = view.selectMenuNum(mCart);
			// 수량 입력 받기
			int quantity = view.inputQuantity();
			// 도서 ID에 해당하는 cartItem 가져와서 cartItem quantity set 수량
			mCart.updateQuantity(num, quantity);
		}
	}

	// 장바구니 비우기
	private void resetCart() {
		view.displayCart(mCart);
		
		if (!mCart.isEmpty()) {
			if (view.askConfirm(">> 장바구니를 비우려면 yes를 입력하세요 : ", "yes")) {
				mCart.resetCart();
				view.showMessage(">> 장바구니를 비웠습니다.");
			}
		}
		
	}
	
	// 주문
	private void order() {
		// 배송 정보 추가
		getDeliveryInfo();
		// 구매 정보 보기 : 장바구니 내역, 배송 정보
		viewOrderInfo();
		// 진짜 주문할거니?
		if (view.askConfirm("진짜 주문하려면 yes를 입력하세요 : ", "yes") ) {
			registerUserInfo();
			// 주문 처리 -> 장바구니 초기화
			mCart.resetCart();
		}
	}
	
	private void getDeliveryInfo() {
		//view.inputDeliveryInfo(mUser);	
	}

	private void viewOrderInfo() {
		view.displayOrder(mCart, mUser);
	}
	
	// 종료
	private void end() {
		view.showMessage(">>방문해주셔서 감사합니다.");
	}













}
