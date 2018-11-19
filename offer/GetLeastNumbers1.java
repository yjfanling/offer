package offer;
import java.util.ArrayList;
public class GetLeastNumbers1 {
	public static void main(String[] args){
		int[] input={4,5,1,6,2,7,3,8};
		ArrayList<Integer> result=GetLeastNumbers_Solution(input,8);
		System.out.println(result.toString());
	}
	public static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(input.length == 0 || k > input.length || k <= 0)
            return result;
		int lo=0;
		int hi=input.length-1;
		int index=partition(input, lo, hi);
		while(index!=k-1)
		{
			if(index>k-1)
			{
				hi=index-1;
				index=partition(input, lo, hi);
			}
			else
			{
				lo=index+1;
				if(lo<hi)
					index=partition(input, lo, hi);
				else
					index=k-1;
			}
		}
		for(int i=0;i<k;i++)
			result.add(input[i]);
		return result;
	}
	private static  int partition(int[] input,int lo,int hi){
		int i=lo,j=hi+1;
		int v=input[lo];
		while(true)
		{
			while(input[++i]<v)
				if(i==hi)
					break;
			while(v<input[--j])
				if(j==lo)
					break;
			if(i>=j)
				break;
			exch(input,i,j);
		}
		exch(input,j,lo);
		return j;
	}
	private static  void exch(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
//	@Test
//	public void test(){
//		int[] input={4,5,1,6,2,7,3,8};
//		ArrayList<Integer> result=GetLeastNumbers_Solution(input,10);
//		System.out.println(result.toString());
//	}
//	@Test
//	public void test1(){
//		int[] input={4,5,1,6,2,7,3,8};
//		int v=partition(input,7, 7);
////		v=partition(input, 4, 7);
////		v=partition(input, 5, 7);
////		v=partition(input, 6, 7);
////		v=partition(input, 7, 7);
//		System.out.println(v);
////		for(int i=0;i<8;i++)
////			System.out.println(input[i]);
//	}
}
