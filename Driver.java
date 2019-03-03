//package a6;
// author: Xiaohui Wang
// ID: 260719359
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {

		// get singleton ordering system and start a new order
		OrderingSystem os = OrderingSystem.getInstance();
		singleOrder theOrder = os.newOrder();
		
		// for the first order
		// alcohol : warning message only printed once though multiple alcohol ordered
		theOrder.add("F","a1","m2","d1"); // fullMeal - discount on dessert
		theOrder.add("r3"); // beer - display warning
		theOrder.add("r4"); // wine
		theOrder.add("I"); // itemOfDay - discount
		
		// look at full order
		theOrder.display();	
		
		// display payment summary - sum of prices
		theOrder.pay();
		
		// close the order
		boolean paid = true;
		theOrder.close(paid);
		
	}
}

