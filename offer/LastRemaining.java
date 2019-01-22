package offer;

import org.junit.Test;

public class LastRemaining {
	public int LastRemaining_Solution(int n, int m) {
        if(n<0||m<0)
        	return -1;
		int result=-1;
        int count=n;
        int step=0;
        int[] array=new int[n];
        while(count>0)
        {
        	result++;
        	if(result>=n)
        		result=0;
        	if(array[result]==-1)
        		continue;
        	step++;
        	if(step==m)
        	{
        		step=0;
        		array[result]=-1;
        		count--;
        	}
        }
		return result;
    }
	@Test
	public void test(){
		System.out.println(LastRemaining_Solution(5, 3));
	}
}
