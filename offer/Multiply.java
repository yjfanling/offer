package offer;

import org.junit.Test;

public class Multiply {
	public int[] multiply(int[] A) {
		if(A.length<0)
			return null;
		int[] B=new int[A.length];
		B[0]=1;
		for(int i=1;i<A.length;i++)
		{
			B[i]=B[i-1]*A[i-1];
		}
		int temp=1;
		for(int i=A.length-2;i>=0;--i)
		{
			temp*=A[i+1];
			B[i]*=temp;
		}
		return B;
    }
	@Test
	public void test(){
		int[] A={2,3,1,1,2,5,3};
		int[] B=multiply(A);
		for(int i=0;i<B.length;i++)
			System.out.println(B[i]);
	}
}
