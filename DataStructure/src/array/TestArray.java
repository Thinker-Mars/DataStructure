package array;

public class TestArray {
	
	public static void main (String[] args) {
		
		MyArray myArray = new MyArray(5);
		myArray.add(5);
		myArray.add(10);
		myArray.add(15);
		myArray.add(20);
		myArray.display();
		System.out.println(myArray.get(2));
		myArray.delete(5);
		myArray.display();
		myArray.modify(10, 1);
		myArray.display();
		
		
		
	}
	
	
	

}
