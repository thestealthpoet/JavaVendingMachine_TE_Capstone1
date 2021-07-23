package com.techelevator;

import com.techelevator.exceptions.InvalidChoiceException;
import com.techelevator.exceptions.OutOfStockException;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE ,MAIN_MENU_OPTION_EXIT};
	private VendingMachine vendingMachine;
	private Scanner scanner = new Scanner(System.in);
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				displayPurchaseItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchasingProcessMenu();
			}
			else if(choice.equals(MAIN_MENU_OPTION_EXIT))
				//TODO Add logger later
				System.exit(0);
		}
	}

	public void displayPurchaseItems(){
		VendingMachineItem[] items = vendingMachine.getInventory().toArray(new VendingMachineItem[0]);
		for(int i = 0;i<items.length;i++ ){
			System.out.println(items[i].getId() +" "+items[i].getName() +" QTY: "+(items[i].isSoldOut()?"SOLD OUT":items[i].getStock()));
		}
	}

	public void purchasingProcessMenu() {
		final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
		final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
		final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

		String[] purchaseMenuOptions = {PURCHASE_MENU_OPTION_FEED_MONEY,
										PURCHASE_MENU_OPTION_SELECT_PRODUCT,
										PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

		boolean shouldDisplay = true;
		while(shouldDisplay) {
		String choice = (String) menu.getChoiceFromOptions(purchaseMenuOptions);

		// TODO: DEAL WITH THIS
		System.out.println("\nCurrent Money Provided: $" + vendingMachine.getAmountFed());


			switch (choice) {
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					feedMoney();
					break;
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					try {
						selectProduct();
					} catch (InvalidChoiceException | OutOfStockException e) {
						System.out.println(e.getMessage());
					}
					break;
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					//TODO
					//finishTransaction();
					shouldDisplay = false;
			}
		}
	}

	private void feedMoney() {
		boolean shouldContinue = true;

		//FIXME - get out of this loop somehow
		while (shouldContinue) {
			System.out.println("How much money would you like to pay? Whole dollar amounts only");
			String[] validAmounts = {"$1", "$5", "$10", "$20"};
			boolean askAgain = true;

			while (askAgain) {
				String choice = (String) menu.getChoiceFromOptions(validAmounts);
				choice = choice.substring(1);
				BigDecimal moneyInput = new BigDecimal(choice);
				vendingMachine.addMoney(moneyInput);
				System.out.println("\nCurrent Money Provided: $" + vendingMachine.getAmountFed());

				System.out.println("Would you like to add more money?");
				String[] options = {"Yes", "No"};
				String response = (String) menu.getChoiceFromOptions(options);

				if (response.equals("No")) {
					askAgain = false;
				}
			}
	}

	}
	private void selectProduct() throws OutOfStockException, InvalidChoiceException {
		System.out.println("What item would you like to purchase?");
		displayPurchaseItems();
		String idChoice = scanner.nextLine();
		VendingMachineItem itemToVend = null;
		List<VendingMachineItem> allItems = vendingMachine.getInventory();
		for (VendingMachineItem item: allItems) {
			if (idChoice.equals(item.getId())) {
				itemToVend = item;
				break;
			} 
		}
		// If valid product has not been chosen, tell user
		if(itemToVend == null) {
			throw new InvalidChoiceException();
		}

		// If item is out of stock, inform user
		if(itemToVend.isSoldOut()) {
			throw new OutOfStockException();
		}

		// If valid item is chosen, dispense it to customer
		dispenseProduct(itemToVend);
	}

	public void dispenseProduct(VendingMachineItem itemToVend) {

	}






	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
