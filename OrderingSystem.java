//package a6;
//author: Xiaohui Wang

import java.util.ArrayList;
import java.util.Iterator;

// functionalities: start a new order, list all items, add an item to the
// order, create a full meal, finalize and pay the order
public class OrderingSystem {
	
	// singleton 
	private static OrderingSystem Instance = new OrderingSystem();
	public static OrderingSystem getInstance() {
		return Instance;
	}	
	
	Menu myMenu = Menu.getInstance(); 
	
	// start a new order, display singleton Menu contents
    public singleOrder newOrder() {
		System.out.println(myMenu.printMenu());	
		System.out.println("Add item to the order with label (eg: a2 for Garden Salad)\n");
		singleOrder theOrder = new singleOrder(); 
    	return theOrder;
    }

	// iterator to display order
	// give warning if order contains alcohol
	public String display(ArrayList <Item> orderList) {
		Iterator<Item> iter = orderList.listIterator();
		String ordered = "Please confirm your order\n";
		String warning = "Warning: Your order contains alcohol, customer must be at least 18yrs old! \n";
		boolean hasAlcohol = false;
		while(iter.hasNext()){
			Item cur = iter.next();
			if(cur instanceof Alcohol) {
				hasAlcohol = true;
			}	
			ordered += cur.mkString() + "\n";
		}	
		if(hasAlcohol == true) {
			ordered += "\n" + warning;
		}
		return ordered;
	}
	
	// add to order
	public void add(ArrayList <Item> orderList,String label) {
		if (myMenu.findItem(label)==true) {			
			orderList.add(myMenu.selectItem(label));
		}
		
	}
	
	// add to order - fullMeal items
	public void add(ArrayList <Item> orderList,String label0,String label1,String label2,String label3) {
		if(label0.equals("F")) {
			fullMealSelected(orderList,(Appetizer)myMenu.selectItem(label1),
					(MainCourse)myMenu.selectItem(label2),(Dessert)myMenu.selectItem(label3));
		}
	}
	
	// create full meal
	public void fullMealSelected(ArrayList <Item> orderList,Appetizer a, MainCourse m, Dessert d) {
		 fullMeal f = new fullMeal(a,m,d);
		 orderList.add(f);		
	}
	
	// composite 
	public String pay(ArrayList <Item> orderList) {
		String a = "total price for your current order:  $";
		double sum = 0;
		for(Item item: orderList) {
			sum += item.getPrice();
		}						
		return a + sum;
	}
	
	// order paid and finalized
	public void close(boolean paid) {
		if(paid) {
			System.out.println("\nOrder finalized and paid, Thank you!\n");
		}else {
			System.out.println("\nYou may modify your order before confirmed.\n");
		}
	}
	
}
