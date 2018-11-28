package offer;

import org.junit.Test;

public class FindGreatestSumOfSubArray1 {
	public int findGreatestSumOfSubArray(int[] array){
		int sum=0;
		int temsum=0;
		for(int i=0;i<array.length;i++)
		{
			temsum=(temsum<0)?array[i]:temsum+array[i];
			sum=(sum<temsum)?temsum:sum;
		}
		return sum;
	}
}
