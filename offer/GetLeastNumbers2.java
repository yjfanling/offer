package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={4,5,1,6,2,7,3,8};
		ArrayList<Integer> result=GetLeastNumbers_Solution(input,4);
		System.out.println(result.toString());
	}
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
		if(input.length==0||k<=0||k>input.length)
			return result;
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k,new Comparator<Integer>(){
			public int compare(Integer a1,Integer a2){
				return a2.compareTo(a1);
			}
		});
		int i=0;
		for(i=0;i<k;i++)
			queue.add(input[i]);
		for(i=k;i<input.length;i++)
		{
			if(input[i]<queue.peek())
			{
				queue.poll();
				queue.add(input[i]);
			}
		}
		for(int j=0;j<k;j++)
			result.add(queue.poll());
		return result;
    }
}
