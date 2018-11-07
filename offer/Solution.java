package offer;

import java.util.ArrayList;

import org.junit.Test;
public class Solution {
	public int MoreThanHalfNum_Solution(int [] array) {
        int max=array[0];
        for(int i=0;i<=array.length-1;i++)
        {
        	if(array[i]>max)
        		max=array[i];
        }
		int[] a=new int[max+1];
		for(int i=0;i<a.length;i++)
		{
			a[i]=0;
		}
		for(int i=0;i<array.length;i++)
		{
			a[array[i]]++;
		}
		max=0;
		int result=0;
		for(int i=0;i<=a.length-1;i++)
        {
        	if(a[i]>max)
        	{
        		max=a[i];
        		result=i;
        	}
        }
		if(max>array.length/2)
			return result;
		return 0;
    }
	
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    sort(input);
    ArrayList<Integer> result=new ArrayList<Integer>();
    for(int i=0;i<k;i++)
    	result.add(input[i]);	
	return result;
    }
private void sort(int[] input) {
	// TODO Auto-generated method stub
	for(int i=0;i<input.length;i++) 
	{
		for(int j=i+1;j<input.length;j++)
		{
			if(input[j]<input[i])
				swap(input,i,j);
		}
	}
}	
private void swap(int[] x,int a,int b)
{
	int t=x[a];
	x[a]=x[b];
	x[b]=t;
}
@Test
public void Test(){
	int[] b={1,2,3,2,2,2,5,4,2};
	ArrayList<Integer> result=GetLeastNumbers_Solution(b,6);
	System.out.println(result.toString());
}
}

