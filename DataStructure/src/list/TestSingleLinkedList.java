package list;

public class TestSingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addHead("D");
		singleLinkedList.addHead("66666");
		singleLinkedList.addHead("This is Mine.");
		singleLinkedList.addHead("Halo");
		singleLinkedList.display();
		//System.out.println(singleLinkedList.search("7"));
		singleLinkedList.delete("Halo");
		singleLinkedList.display();

	}

}
