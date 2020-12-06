package lab5B_StacksandQueues;

public class CustomStack {
	int cap = 20;
	int top;
	Clothing[] anArray = new Clothing[cap];
	
	public CustomStack() {
		top = -1;
	}
	
	@Override
	public String toString() {
		String fin = "";
		for (int i = 0; i < top; i++) {
			fin = fin + (anArray[i] + "\n");
		}
		return fin;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void push(Clothing c) {
		if (top >= (cap - 1)) {
			return;
		}
		else {
			anArray[++top] = c;
		}
	}
	
	public Clothing pop() {
		if (top < 0) {
			return null;
		}
		else {
			Clothing x = anArray[top--];
			return x;
		}
	}
	
	public Clothing peek() {
		return anArray[top];
	}
	
	public int getColour(String colour) {
		int sum = 0;
		for (int i = 0; i < top; i++) {
			if (anArray[i].colour.equals(colour)) {
				sum++;
			}
		}
		return sum;
	}
	
	public int getHighTemp() {
		int sum = 0;
		if (isEmpty()) {
			return 0;
		}
		else {
			for (int i = 0; i < top; i++) {
				if (anArray[i].highTemp) {
					sum++;
				}
			}
			return sum;
		}
	}
}
class Clothing {
	final String name;
	final String colour;
	final boolean highTemp;
	
	public Clothing(String name, String colour, boolean highTemp) {
		this.name = name;
		this.colour = colour;
		this.highTemp = highTemp;
	}

	@Override
	public String toString() {
		return "Clothing [name= " + name + ", colour= " + colour + ", highTemp= " + highTemp + "]";
	}
}