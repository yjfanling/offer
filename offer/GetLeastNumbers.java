package offer;

import java.util.ArrayList;

public class GetLeastNumbers {
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
}
