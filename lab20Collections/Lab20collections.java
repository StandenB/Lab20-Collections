package lab20Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab20collections {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		String cont = "no";
		
		// Create map for pricing with item name the key and price the value
		Map<String, Double> prices = new HashMap<>();
		int items = 0;  // how many items are going into the shopping cart
		int itemsSold = 0; // how many matches to array
		double saleTotal = 0.0, avgPrice = 0.0;
		
		// Setting up parallel arrays to hold items purchase with associated price
		ArrayList<String> shoppingCart = new ArrayList<>();
		ArrayList<Double> salePrice = new ArrayList<>();
		
		// Filling map
		prices.put("oranges", .89);
		prices.put("grapes", 1.29);
		prices.put("apples", 1.69);
		prices.put("bananas", 1.49);
		prices.put("mango", 1.19);
		prices.put("melon", 1.29);
		prices.put("kiwi", .99);
		prices.put("avacado", 1.09);
		
		System.out.println("Welcome to Guenther's Market!\n");
		
		// Do loop for each item added to shopping cart
		do {
		
			System.out.println("Item\t\t Price");
			System.out.println("=============================");
		
			// Fancy enhanced loop for printing out all values pairs in map
			for (Map.Entry<String, Double> entry : prices.entrySet()) {
				System.out.println(entry.getKey() + "\t\t$" + entry.getValue());
			}
			boolean validOrder = false;
			do {
				System.out.print("What item would you like to order?");
				String purchase = scnr.next();
				
				if (prices.containsKey(purchase) == true) {
					// Populating our parallel ArrayLists with purchase data
					shoppingCart.add(purchase);
					salePrice.add(prices.get(purchase));
					System.out.println("Adding " + purchase + " to cart at $" + prices.get(purchase));
					validOrder = true;
					
					// Collecting data for future use
					items = items + 1;
					saleTotal = saleTotal + prices.get(purchase);
				}
				else {
					System.out.println("Sorry, we don't have those. Please try again.");
				}
			}
			while (validOrder = false);
			
			System.out.println("Would you like to order anything else (y/n)");
			cont = scnr.next();
			cont = cont.toLowerCase();
		}
		while (cont.equals("y"));
		
		System.out.println("\nThanks for your order!");
		System.out.println("Here's what you got:");
		
		for (int count = 0; count < items; count++) {
			System.out.println(shoppingCart.get(count) + "\t$" + salePrice.get(count));
		}
		System.out.println("\t======");
		System.out.printf("Total: \t$" + saleTotal);
		avgPrice = getAvgPrice(items, saleTotal);
		System.out.printf("\nAverage price per item in order was $%,.2f%n", avgPrice);
		
		
		
/*		int indexOfHighest = getIndexHigh();
		System.out.println("The highest priced item was at index " + indexOfHighest);
				
		int indexOfLowest = getIndexLow();
		System.out.println("The lowest priced item was at index " + indexOfLowest);
		
		//System.out.println("Press any key to continue.");
*/				
		scnr.close();
		
	}

public static double getAvgPrice(int items, double value) {
	double avgPrice = (value/items);
			return avgPrice;
}
	
/*
public static int getIndexHigh(int index, double price) {
	
	for (int i = 0; i < index; i++) {
		if (price > topPrice) {
		double topPrice = price;
		}
		
	}
}

public static int getIndexLow(int index, double price) {
	
}
*/
}
