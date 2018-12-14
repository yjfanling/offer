package offer;

import org.junit.Test;

public class GetNumberOfK {
	public int getNumberOfK(int [] array , int k) {
		int i=0;
		int count=0;
		while(i<array.length&&array[i]!=k)
			i++;
		while(i<array.length&&array[i]==k)
		{
			count++;
			i++;
		}
		return count;
    }
	@Test
	public void test(){
		int[] array={1,2,3,3,3,3};
		System.out.println(getNumberOfK(array, 3));
		
	}
}
