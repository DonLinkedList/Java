package assignment7B;

public class Timer{
	long start;
	long now;
	
	public Timer() {
		this.start = System.currentTimeMillis();
	}
	
	public void setNow(long now) {
		this.now = now;
	}
	
	public long getTime() {
		now = System.currentTimeMillis();
		return (now - start);
	}
}
