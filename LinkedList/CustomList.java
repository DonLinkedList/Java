package assignment5_LinkedList;

public class CustomList {
	Node head;
	static class Node {
		String name;
		int data;
		Node next;
		
		Node (String name, int data) {
			this.name = name;
			this.data = data;
			next = null;
		}
	}
	public void getReport() {
		Node temp = head;
	}
	
	public int getCount(String name) {
		Node temp = head;
		if (head == null) {
			return 0;
		}
		else {
			while (temp.next != null) {
				if (temp.next.name == name) {
					return temp.next.data;
				}
				else {
					temp = temp.next;
				}
			}
			return 0;
		}
	}
		
	public void add(String name) {
		Node newNode = new Node(name, 1);
		Node last = head;
		
		if (head == null) {
			head = newNode;
			newNode.next = null;
			System.out.println("Added \"" + newNode.name + "\" there is now " + newNode.data + " of them");
		}
		else if (head != null) {
			if (head.name.equals(name)) {
				
			}
		}
//		System.out.println("Added \"" + last.name + "\" there is now " + last.data + " of them");
		
	}
}
