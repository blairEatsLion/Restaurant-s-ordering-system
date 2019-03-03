//package a6;

public class DessertInCombo extends Item implements Discount{
	
	Item x;	
	DessertInCombo(Item a){
		super(a.getName(), a.getPrice(),a.getLabel());		
		x = a;
	}

	public double getPrice() {
		return super.getPrice() * 0.5; 
	}
	
	public String mkString() {
		return getLabel() + "   half-priced Dessert  " + getName() + "  $ " + getPrice() + "    original: $" + super.getPrice();
	}


}
