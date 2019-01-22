package offer;

import java.util.ArrayList;

import org.junit.Test;

public class Duplicate {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    if(length<2)
	    	return false;
	    ArrayList<Integer> list=new ArrayList<Integer>();
	    for(int i=0;i<length;i++)
	    {
	    	if(!list.contains(numbers[i]))
	    		list.add(numbers[i]);
	    	else
	    	{
	    		duplication[0]=numbers[i];
	    		return true;
	    	}
	    		
	    }
		return false;
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
