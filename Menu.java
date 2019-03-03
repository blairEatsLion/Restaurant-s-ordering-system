//package a6;
//author: Xiaohui Wang
import java.util.ArrayList;
import java.util.Iterator;

// To set ItemOfDay, simply change the label of that item to "I", 
// then in helpItemOfDay() decorator will process the selected item(s) 
public class Menu {

	// singleton
	private ArrayList <Item> menu;
	
	private static Menu Instance = new Menu();
	public static Menu getInstance() {
		return Instance;
	}
	
	private Menu(){
		menu = new ArrayList <Item>();
		
		menu.add(new Appetizer("Salmon Tartare",6.4,"a1"));
		menu.add(new Appetizer("Garden Salad",6.0,"a2"));
		
		menu.add(new MainCourse("Glazed Pork Ribs",12.8,"m1"));
		menu.add(new MainCourse("Tuna Rice",12.0,"m2"));
		menu.add(new MainCourse("Miso Ramen",10.0,"m3"));
		
		menu.add(new Dessert("Choco Brownie",4.0,"d1"));
		menu.add(new Dessert("Matcha Cake",4.4,"d2"));
		
		menu.add(new Side("Fried Chicken",6.0,"s1"));
		menu.add(new Side("Eel Skewers",4.0,"s2"));
		menu.add(new Side("Lobster Soup",6.0,"I"));
		
		menu.add(new Drink("Sparkling water",2.0,"r1"));
		menu.add(new Drink("Orange juice",4.0,"r2"));
		
		menu.add(new Alcohol("Beer",4.0,"r3"));
		menu.add(new Alcohol("Wine",8.0,"r4"));
	
		// decorator helper function
		helpItemOfDay();

	}
	
	// decorator to add ItemOfDay features to the original item
	public void helpItemOfDay() {
		Iterator<Item> iterator = menu.listIterator();
		int index = 0;
		while(iterator.hasNext()){
			index++;
			Item cur = iterator.next();
			if(cur.getLabel().equals("I")) {
				ItemOfDay i = new ItemOfDay(cur);  // decorator
				menu.set(index-1, i);
			}			
		}	
	}
	
	// iterator to print menu
	public String printMenu() {
		String theMenu = "Menu \nFullMeal(F), Item-Of-Day(I), appetizer(a), main(m), dessert(d), side(s), drink(r) \n";
		theMenu += "F  fullMeal Combo! \n";
		Iterator<Item> iterator = menu.listIterator();
		while(iterator.hasNext()){
			Item cur = iterator.next();
			theMenu += cur.mkString() + "\n";
		}	
		return theMenu;
	}
	
	// check whether user input is a valid label on menu
	public boolean findItem(String label) {
		boolean a = false;
		Iterator<Item> iterator = menu.listIterator();
		while(iterator.hasNext()){
			Item cur = iterator.next();
			if(cur.getLabel().equals(label)) {
				a = true;
			}			
		}	
		return a;
	}
	
	// iterator to retrieve the desired item by label
	public Item selectItem(String label) {
		Item a = null;
		Iterator<Item> iterator = menu.listIterator();
		while(iterator.hasNext()){
			Item cur = iterator.next();
			if(cur.getLabel().equals(label)) {
				a = cur;
			}
		}	
		return a;
	}

}
