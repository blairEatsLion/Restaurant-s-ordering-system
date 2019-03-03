//package a6;

// abstract class that implements an interface
abstract class Item implements Discount{
	
	private String name;
	private double price;
	private String label; 
	
	// constructor
	public Item(String name, double price, String label) {
		this.label = label;
		this.name = name;
		this.price = price;
	}

	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String mkString() {
		return getLabel() + "  " + getName() + "   $ " + getPrice();
	}

}
