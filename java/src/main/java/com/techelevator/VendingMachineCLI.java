package com.techelevator;

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

		String choice = (String) menu.getChoiceFromOptions(purchaseMenuOptions);

		// TODO: DEAL WITH THIS
		System.out.println("\nCurrent Money Provided: $" + vendingMachine.getAmountFed());

		switch(choice) {
			case PURCHASE_MENU_OPTION_FEED_MONEY:
				feedMoney();
			case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
				//TODO
				//selectProduct();
			case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
				//TODO
				//finishTransaction();
		}
	}

	private void feedMoney() {
		boolean shouldContinue = true;
		Scanner scanner = new Scanner(System.in);
		while (shouldContinue) {
			System.out.println("How much money would you like to pay? Whole dollar amounts only");
			try {
				Integer moneyInput = Integer.parseInt(scanner.nextLine());
				vendingMachine.addMoney(new BigDecimal(moneyInput));

			} catch (IllegalArgumentException e) {
				System.out.println("Please enter a valid, whole dollar amount.");
			}
			System.out.println("\nCurrent Money Provided: $" + vendingMachine.getAmountFed());
			boolean askAgain = true;
			while(askAgain) {
				System.out.println("Would you like to add more money? Y/N");
				String response = scanner.nextLine();

				if (response.toUpperCase().equals("Y") || response.toUpperCase().equals("N")) {
					askAgain = false;
				}
				else{
					System.out.println("Invalid option. Enter Y or N");
				}

				if (response.toUpperCase().equals("N")) {
					shouldContinue = false;
				}
			}
		}
	}






	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
