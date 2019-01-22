package offer;

import org.junit.Test;

public class Duplicate2 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(length<2)
			return false;
		for(int i=0;i<length;i++)
		{
			while(numbers[i]!=i)
			{
				if(numbers[i]==numbers[numbers[i]])
				{
					duplication[0]=numbers[i];
					return true;
				}
				swap(numbers,i,numbers[i]);
			}
		}
		return false;
	}

	private void swap(int[] numbers, int i, int j) {
		// TODO Auto-generated method stub
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}
	@Test
	public void test(){
		int[] numbers={2,3,1,0,2,5,3};
		int[] duplication=new int[1];
		if(duplicate(numbers, 7, duplication))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
