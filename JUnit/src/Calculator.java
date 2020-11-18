
public class Calculator {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public double avg(int[] arr) {
		if(arr.length == 0) return 0;
		double s = 0;
		for(int i: arr) s += i;
		return s / arr.length;
	}
	
	public int min(int[] arr) {
		if(arr.length == 0) return 0;
		int res = Integer.MAX_VALUE;
		for(int i: arr) res = Math.min(res, i);
		return res;
	}
	
	public int max(int[] arr) {
		if(arr.length == 0) return 0;
		int res = Integer.MIN_VALUE;
		for(int i: arr) res = Math.max(res, i);
		return res;
	}
}
