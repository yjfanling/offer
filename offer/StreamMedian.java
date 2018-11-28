package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;
public class StreamMedian {
	private  PriorityQueue<Integer> max=new PriorityQueue<Integer>(new Comparator<Integer>(){

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
	});
	private  PriorityQueue<Integer> min=new PriorityQueue<Integer>(new Comparator<Integer>(){

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		
	});
	public  void Insert(Integer num){
		if(((min.size()+max.size())&1)==0)
		{
			if(min.size()==0)
				min.add(num);
			else
			{
				if(num>=min.peek())
					min.add(num);
				else 
				{
					max.add(num);
					min.add(max.poll());
				}
			}
		}
		else
		{
			if(max.size()==0)
				max.add(num);
			else
			{
				if(num<=max.peek())
					max.add(num);
				else
				{
					min.add(num);
					max.add(min.poll());
				}
			}
		}
	}
	public  Double GetMedian(){
		if(max.size()+min.size()==0)
			return 0.0;
		Double median=0.0;
		Double size=(double) (max.size()+min.size());
		if(((max.size()+min.size())&1)==0)
			median=((double)(min.peek()+max.peek()))/2;
		else
			median=(double)min.peek();
		return median;
	}
}
