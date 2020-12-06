package assignment7B;

public class Main {
	public static int[] bubbleSort(int[] anArray) {
		int n = anArray.length;
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - (i + 1); j++) {
				if (anArray[j] > anArray[j + 1]) {
					temp = anArray[j];
					anArray[j] = anArray[j + 1];
					anArray[j + 1] = temp;
				}
			}
		}
		return anArray;
	}
	
	public static void print(int[] anArray) {
		System.out.print(anArray[0]);
		for (int i = 1; i < 100; i++) {
			System.out.print(", " + anArray[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums = new int[10000];
		int[] nums2 = new int[10000];
		Runnable RunTask = new RunTask(nums);
		Thread thread1 = new Thread(RunTask);
		double runtime;
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = ((int)(Math.random() * 201 - 101));
			nums2[i] = nums[i];
		}
		
		Timer t1 = new Timer();
		bubbleSort(nums2);
		runtime = (double)(t1.getTime());
		System.out.println("BubbleSort: Done in " + runtime);
		
		thread1.run();
	}
}
