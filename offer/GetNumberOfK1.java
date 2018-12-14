package offer;

import org.junit.Test;

public class GetNumberOfK1 {
	public int getNumberOfK(int [] array , int k) {
		if(array.length==0)
			return 0;
		int firstk=getFirstK(array, k, 0,array.length-1);
		int lastk=getLastK(array, k, 0, array.length-1);
		if(firstk!=-1&&lastk!=-1)
			return lastk-firstk+1;
		return 0;
	}
	private int getFirstK(int[] array,int k,int start,int end){
		if(end<start)
			return -1;
		int middleindex=(end+start)/2;
		int middledate=array[middleindex];
		if(middledate==k)
		{
			if((middleindex>0&&array[middleindex-1]!=k)||middleindex==0)
				return middleindex;
			else
				end=middleindex-1;
			
		}
		else if(middledate>k)
			end=middleindex-1;
		else 
			start=middleindex+1;
		return getFirstK(array, k, start, end);
	}
	private int getLastK(int[] array,int k,int start,int end){
		if(end<start)
			return -1;
		int middleindex=(end+start)/2;
		int middledate=array[middleindex];
		if(middledate==k)
		{
			if(((middleindex<array.length-1)&&(array[middleindex+1]!=k))||middleindex==array.length-1)
				return middleindex;
			else
				start=middleindex+1;
			
		}
		else if(middledate>k)
			end=middleindex-1;
		else 
			start=middleindex+1;
		return getLastK(array, k, start, end);
	}
	@Test
	public void test(){
		int[] array={1,2,3,3,3,3};
		System.out.println(getNumberOfK(array, 3));
	}
}
