package offer;

public class Duplicate1 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(length<2)
			return false;
		int[] array=new int[length];
		for(int i=0;i<length;i++)
		{
			array[numbers[i]]+=1;
			if(array[numbers[i]]>1)
			{
				duplication[0]=numbers[i];
				return true;
			}
		}
		return false;
	}
}
