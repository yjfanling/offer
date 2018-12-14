package offer;

public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2)
        {
        	return;
        }
        int result=0;
		for(int i=0;i<array.length;i++)
        {
        	result^=array[i];
        }
		int index=FindFirstBitIs1(result);
		for(int i=0;i<array.length;i++)
		{
			if(isBit(array[i], index))
				num1[0]^=array[i];
			else
				num2[0]^=array[i];
		}
    }
	public int FindFirstBitIs1(int num)
	{
		int indexBit=0;
		while(((num&1)==0)&&(indexBit<8*4))
		{
			num=num>>1;
			indexBit++;
		}
		return indexBit;
	}
	public boolean isBit(int num,int indexBit){
		num=num>>indexBit;
		return (num&1)==1;
	}
}
