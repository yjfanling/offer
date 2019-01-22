package offer;

import java.util.ArrayList;

public class MaxInWindows {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(num==null||size>num.length||size<1)
			return list;
		int a[]=new int[size];
		int index=0;
		while(index<num.length-size+1)
		{
			int count=index;
			for(int i=0;i<size;i++)
			{
				a[i]=num[count++];
			}
			list.add(max(a));
			index++;
		}
		return list;
    }

	private Integer max(int[] a) {
		// TODO Auto-generated method stub
		int max=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(max<a[i])
				max=a[i];
		}
		return max;
	}
}
