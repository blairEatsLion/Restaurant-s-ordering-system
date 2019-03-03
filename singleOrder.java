//package a6;
//author: Xiaohui Wang
import java.util.ArrayList;

public class singleOrder {
	
	ArrayList <Item> orderList = new ArrayList<Item>();  // list of ordered items
	
	OrderingSystem os = OrderingSystem.getInstance();  // calling functions in OrderingSystem
	
	public void display() {
		String a = os.display(orderList);
		System.out.println(a);
	}	
	
	public void add(String label) {
		os.add(orderList, label);
	}
	
	
	public void add(String label0,String label1,String label2,String label3) {
		os.add(orderList, label0, label1, label2, label3);
	}
	
	public void fullMealSelected(Appetizer a, MainCourse m, Dessert d) {
		os.fullMealSelected(orderList, a, m, d);
	}
	
	public void pay() {
		String a = os.pay(orderList);
		System.out.println(a);
	}
	
	public void close(boolean paid) {
		os.close(paid);
	}
	
}
