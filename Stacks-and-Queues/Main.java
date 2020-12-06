package lab5B_StacksandQueues;

public class Main {
	public static void main(String[] args) {
		CustomStack stack = new CustomStack();
		Clothing c1 = new Clothing("Shirt", "Green", true);
		
		for (int i = 0; i <= 4; i++) {
			stack.push(c1);
		}
		
		System.out.println("Added 5 new green shirts; are washable in hot water");
		
		for (int i = 0; i <= 7; i++) {
			stack.push(new Clothing("Pants", "Blue", false));
		}
		
		System.out.println("Added 7 new blue pants; none are washable in hot water\n");
		
		System.out.println(stack);
		
		System.out.println("Clothes that are blue in the stack " + stack.getColour("Blue"));
		System.out.println("Amount of clothes that can be washed in high temp " + stack.getHighTemp() + "\n");
		
		CustomQueue q = new CustomQueue(20);
		
		for (int i = 0; i < 5; i++) {
			q.enqueue(new Food("Bluebarries", 100, 5));
		}
		
		for (int i = 0; i < 4; i++) {
			q.enqueue(new Food("Pizza", 180, 8));
		}
		
		System.out.println();
		System.out.println("Food with the most calories" + q.high());
		System.out.println("Average calories in list = " + q.avg() + "\n");
		
		
		System.out.println(q);
	}
}
