package offer;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
	public ArrayList<String> Permutation1(String str) {
        ArrayList<String> result=new ArrayList<String>();
       if(str==null)
           return result;
	Permutation1(str.toCharArray(),0,result);
	Collections.sort(result);
       return result;
    }

	/**
	 * @param chars
	 * @param i
	 * @param result
	 */
	private void Permutation1(char[] chars, int i, ArrayList<String> result) {
		// TODO Auto-generated method stub
		if(i==chars.length-1&&!result.contains(String.valueOf(chars)))
			result.add(String.valueOf(chars));
		else
		{
			for(int j=i;j<chars.length;++j)
			{
				swap(chars,i,j);
				Permutation1(chars, i+1, result);
				swap(chars,i,j);
			}
		}
			
	}
	private void swap(char[] x,int a,int b)
	{
		char t=x[a];
		x[a]=x[b];
		x[b]=t;
	}
}
