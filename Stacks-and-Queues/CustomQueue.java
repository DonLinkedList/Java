package lab5B_StacksandQueues;

import java.util.Arrays;

public class CustomQueue {
	private int front, back, size, count;
	Food[] anArray;
	
	CustomQueue(int size) {
		anArray = new Food[size];
		this.size = size;
		front = 0;
		back = -1;
		count = 0;
	}
	
	boolean isEmpty() {
		return (count == 0);
	}
	
	boolean isFull() {
		return (count == size);
	}
	
	void enqueue(Food food) {
		if (isFull()) {
			System.exit(1);
		}
		else {
			System.out.println("Inserting " + food);
			back = (back + 1) % size;
			anArray[back] = food;
			count++;
		}
	}
	
	void dequeue(Food food) {
		if (isEmpty()) {
			System.exit(1);
		}
		else {
			System.out.println("Removing " + food);
			front = (front + 1) % size;
			count--;
		}
	}
	
	Food peek() {
		if (isEmpty()) {
			System.exit(1);
		}
		else {
			return anArray[front];
		}
		return null;
	}
	
	int avg() {
		int average = 0;
		for (int i = front; i < back; i++) {
			average += anArray[i].calPerSer;
		}
		return ((int)(average / count));
	}
	
	Food high() {
		int index = 0;
		int max = 0;
		int total = 0;
		for (int i = front; i < back; i++) {
			total = anArray[i].calPerSer * anArray[i].serPerCon;
			if (total > max) {
				index = i;
			}
		}
		return anArray[index];
	}

	@Override
	public String toString() {
		String fin = "";
		for (int i = front; i < back; i++) {
			fin = fin + (anArray[i] + "\n");
		}
		return fin;
	}
	
}
class Food {
	final String name;
	final int calPerSer;
	final int serPerCon;
	
	Food (String name, int calPerSer, int serPerCon) {
		this.name = name;
		this.calPerSer = calPerSer;
		this.serPerCon = serPerCon;
	}

	@Override
	public String toString() {
		return "Food [name= " + name + ", calPerSer= " + calPerSer + ", serPerCon= " + serPerCon + "]";
	}
}
