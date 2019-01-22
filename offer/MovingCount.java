package offer;

import org.junit.Test;

public class MovingCount {
	public int movingCount(int threshold, int rows, int cols)
    {
		if(threshold<0||rows<1||cols<1)
			return 0;
		boolean[] visited=new boolean[rows*cols];
		for(int i=0;i<rows*cols;i++)
		{
			visited[i]=false;
		}
		int count=movingCountCore(threshold, rows, cols, 0, 0,visited);
		return count;
    }
	private int movingCountCore(int threshold, int rows, int cols, int r, int c, boolean[] visited) {
		// TODO Auto-generated method stub
		int count=0;
		if (check(threshold,rows,cols,r,c,visited)){
			visited[r*cols+c]=true;
			count=1+movingCountCore(threshold, rows, cols, r-1, c, visited)+movingCountCore(threshold, rows, cols, r, c-1, visited)+movingCountCore(threshold, rows, cols, r+1, c, visited)+movingCountCore(threshold, rows, cols, r, c+1, visited);
		}
		return count;
	}
	private boolean check(int threshold, int rows, int cols, int r, int c, boolean[] visited) {
		// TODO Auto-generated method stub
		if(r>=0&&c>=0&&r<rows&&c<cols&&!visited[r*cols+c]&&getSum(r)+getSum(c)<=threshold)
			return true;
		return false;
	}
	private int getSum(int num) {
		// TODO Auto-generated method stub
		int sum=0;
		while(num>0)
		{
			sum+=num%10;
			num/=10;
		}
		return sum;
	}
	@Test
	public void test(){
		System.out.println(movingCount(3, 4, 4));
	}
}
