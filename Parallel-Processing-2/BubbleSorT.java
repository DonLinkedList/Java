package assignment7B;

public class BubbleSorT implements Runnable{
	int[] array;
	
	public BubbleSorT(int[] array) {
		this.array = array;
	}
	
	@Override
	public void run() {
		//threaded bubble sort method
		for(int i = 0; i < array.length - 1; i++) {
			final int tempI = i;
			//new lamba function
			new Thread(() -> {
				for (int j = 0; j < array.length - (tempI + 1); j++) {
					final int tempJ = j;
					//nested lamba function
					new Thread(() -> {
						int temp;
						if (array[tempJ] > array[tempJ + 1]) {
							temp = array[tempJ];
							array[tempJ] = array[tempJ + 1];
							array[tempJ + 1] = temp;
						}
					});
				}
			});
		}
	}
	
	public int[] bubbleSort(int[] anArray) {
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
}
