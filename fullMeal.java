//package a6;

import java.util.ArrayList;

public class fullMeal extends Item implements Discount{

	ArrayList <Item> mealSet = new ArrayList<Item>();
	
	// constructor
	fullMeal(Appetizer a, MainCourse m, Dessert d) {
		super(a.getName(), a.getPrice(),a.getLabel());	 // super constructor
		mealSet.add(a);
		mealSet.add(m);
		DessertInCombo i = new DessertInCombo(d);  // decorator: dessert half-priced
		mealSet.add(i);	
	}
	
	// composite
	public double getPrice() {
		double price = 0;
		for(Item item: mealSet) {
			price += item.getPrice();					
		}		
		return price;
	}
	
	// composite
	public String mkString() {
		String s1 = "F FullMeal Selection\n";
		String s2 = "";;
		for(Item item: mealSet) {
			s2 += "   -" + item.mkString() + "\n";					
		}
		String s3 = "   fullMeal total is " + getPrice();
		return s1 + s2 + s3;
	}
}
