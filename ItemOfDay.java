//package a6;

// decorator
public class ItemOfDay extends Item implements Discount{
	
	Item x;	
	ItemOfDay(Item a){
		super(a.getName(), a.getPrice(),a.getLabel());		
		x = a;
	}

	public double getPrice() {
		return super.getPrice() * 0.5;  // hard-coded discount percentage
	}
	
	public String mkString() {
		return getLabel() + "   Item-Of-Day  " + getName() + "  $ " + getPrice() + "    original: $" + super.getPrice();
	}


}
