package offer;

import org.junit.Test;

public class InversePairs {	
	public int inversePairs(int [] array) {
        if(array.length<=0)
        	return 0;
        int[] copy=new int[array.length];
        for(int i=0;i<array.length;i++)
        {
        	copy[i]=array[i];
        }
        int count=InversePairsCore(array,copy,0,array.length-1);
        return count;
    }

	private int InversePairsCore(int[] array, int[] copy, int start, int end) {
		// TODO Auto-generated method stub
		if(start==end){
			return 0;
		}
		int length=(end+start)/2;
		int left=InversePairsCore(array, copy, start, length)%1000000007;
		int right=InversePairsCore(array, copy, length+1, end)%1000000007;
		int i=length;
		int j=end;
		int indexCopy=end;
		int count=0;
		while(i>=start&&j>=length+1)
		{
			if(array[i]>array[j])
			{
				count+=j-length;
				copy[indexCopy--]=array[i--];
				if(count>=1000000007)
					count%=1000000007;
			}
			else
			{
				copy[indexCopy--]=array[j--];
			}
		}
		for(;i>=start;i--)
			copy[indexCopy--]=array[i];
		for(;j>length;j--)
			copy[indexCopy--]=array[j];
		for(int s=start;s<=end;s++)
		{
			array[s]=copy[s];
		}
		return (left+right+count)%1000000007;
	}
	@Test
	public void test(){
		int[] array={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
		System.out.println(inversePairs(array));
	}
}
