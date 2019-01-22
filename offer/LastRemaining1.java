package offer;

public class LastRemaining1 {
	public int LastRemaining_Solution(int n, int m) {
		if(n<1||m<1)
			return -1;
		int last=0;
		if(n==1)
			last=0;
		else
			last=(LastRemaining_Solution(n-1, m)+m)%n;
		return last;
	}
}
