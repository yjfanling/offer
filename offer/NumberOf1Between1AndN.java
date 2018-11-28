package offer;

import org.junit.Test;

public class NumberOf1Between1AndN {
	public int NumberOf1Between1AndN_Solution(int n) {
		int s=1;
		int c=0;
		for(int i=0;i<=n;i++)
		{
			c+=sum(i);
		}
		return c;
	}

	private int sum(int i) {
		// TODO Auto-generated method stub
		int c=0;
		while(i!=0)
		{
			if(i%10==1)
				c++;
			i=i/10;
		}
		return c;
	}
	@Test
	public void test()
	{
		System.out.println(NumberOf1Between1AndN_Solution(13));
	}
}
