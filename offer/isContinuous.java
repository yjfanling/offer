package offer;

import org.junit.Test;

public class isContinuous {
	public boolean iscontinuous(int [] numbers) {
		if(numbers.length<1)
			return false;
		numbers=sort(numbers);
		int countzero=0;
		int i=0;
		while(i<numbers.length&&numbers[i]==0)
		{
			countzero++;
			i++;
		}
		int empty=0;
		for(int j=countzero+1;j<numbers.length;j++)
		{
			if(numbers[j]==numbers[j-1]&&numbers[j]!=0)
				return false;
			empty+=numbers[j]-numbers[j-1]-1;
		}
		if(empty<=countzero)
			return true;
		return false;
    }

	private int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		for(int i=0;i<numbers.length;i++)
		{
			int min=numbers[i];
			for(int j=i+1;j<numbers.length;j++)
				if(min>numbers[j])
				{
					min=numbers[j];
					swap(numbers,i,j);
				}
		}
		return numbers;
	}
	private void swap(int[] numbers, int i, int j) {
		// TODO Auto-generated method stub
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}
	@Test
	public void test(){
		int[] numbers={0,3,5,4,0};
		if(iscontinuous(numbers))
			System.out.println("yes");
	}
}

	
