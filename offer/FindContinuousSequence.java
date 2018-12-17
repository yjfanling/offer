package offer;

import java.util.ArrayList;

import org.junit.Test;
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer> > listsequence=new ArrayList<ArrayList<Integer> >();
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	if(sum<3)
    		return listsequence;
    	int small=1;
    	int big=2;
    	int result=small+big;
    	
    	while(small<(sum+1)/2)
    	{
    		if(result==sum)
    		{
    			list=addlist(small,big);
    			listsequence.add(list);	
    			big++;
    			result+=big;
    		}
    		else if(result<sum)
    		{
    			big++;
    			result+=big;
    		}
    		else
    		{
    			result-=small;
    			small++;
    		}
    	}
    	return listsequence;
    }

	private ArrayList<Integer> addlist(int small, int big) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=small;i<=big;i++)
			list.add(i);
		return list;
	}
	@Test
	public void test(){
		ArrayList<ArrayList<Integer> > listsequence=findContinuousSequence(15);
		System.out.println(listsequence.toString());
		
	}
}