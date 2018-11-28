package offer;

import org.junit.Test;

public class FindGreatestSumOfSubArray {
	public int findGreatestSumOfSubArray(int[] array) {
		if(array.length==0)
			return 0;
		int cursum=array[0];
		int greatestsum=array[0];
		for(int i=1;i<array.length;i++)
		{
			if(cursum<0)
				cursum=array[i];
			else
				cursum=cursum+array[i];			
			if(greatestsum<cursum)
				greatestsum=cursum;
		}
		return greatestsum;
    }
	@Test
	public void test(){
		int[] array={1,-2,3,10,-4,7,2,-5};
		int n=findGreatestSumOfSubArray(array);
		System.out.println(n);
	}
}
