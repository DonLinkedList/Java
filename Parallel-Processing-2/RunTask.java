package assignment7B;

public class RunTask implements Runnable{
	int[] anArray;
	long start;
	long now;
	double runtime;
	public RunTask(int[] anArray) {
		this.anArray = anArray;
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
	
	public void setRuntime(long rt) {
		this.runtime = rt;
	}
	
	@Override
	public void run() {
		Runnable bs = new BubbleSorT(anArray);
		Thread t2 = new Thread(bs);
		start = System.currentTimeMillis();
		Timer ti2 = new Timer();
		t2.run();
		runtime = (double)(ti2.getTime());
		System.out.println("Thread: Done in " + runtime);		
	}
}
