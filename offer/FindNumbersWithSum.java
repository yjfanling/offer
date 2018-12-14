package offer;

import java.util.ArrayList;

import org.junit.Test;

public class FindNumbersWithSum {
	public ArrayList<Integer> findNumbersWithSum(int[] array,int sum){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(array.length<1)
			return list;
		int min=0;
		int start=0,end=array.length-1;
		while(start<end)
		{
			int sum1=array[start]+array[end];
			if(sum1==sum)
			{	
				if(min==0)
				{
					list.add(array[start]);
					list.add(array[end]);
					min=array[start]*array[end];
				}
				else if(min>(array[start]*array[end]))
				{
					list.clear();
					list.add(array[start]);
					list.add(array[end]);
				}
				end--;
			}
			else if(sum1<sum){
				start++;
			}
			else
				end--;
//			if((array[start]+array[end])<sum)
//				start++;
//			else if((array[start]+array[end])>sum)
//				end--;
//			else
//			{
//				if(min==0)
//				{
//					list.add(array[start]);
//					list.add(array[end]);
//					min=array[start]*array[end]; 
//					end--;
//				}
//				else if(min>(array[start]*array[end]))
//				{
//					min=array[start]*array[end];
//					list.clear();
//					list.add(array[start]);
//					list.add(array[end]);
//				}
//			}
		}
		return list;
	}
	@Test
	public void test(){
		int[] array={1,2,4,7,11,15};
		System.out.println(findNumbersWithSum(array, 15).toString());
	}
}
