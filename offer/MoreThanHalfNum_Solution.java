package offer;

public class MoreThanHalfNum_Solution {
	public int MoreThanHalfNum_Solution1(int [] array) {
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
}
