package offer;

public class FirstAppearingOnce{
	private int[] cur=new int[256];
	private int index=0;
	public FirstAppearingOnce()
	{
		for(int i=0;i<cur.length;i++)
		{
			cur[i]=-1;
		}
	}
	public void Insert(char ch)
    {
        if(cur[ch]==-1)
        	cur[ch]=index;
        else if(cur[ch]>0)
        	cur[ch]=-2;
        index++;
    }
  //return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
    	char ch='\0';
    	int min=Integer.MAX_VALUE;
    	for(int i=0;i<cur.length;i++)
    	{
    		if(cur[i]>0&&cur[i]<min)
    		{
    			min=cur[i];
    			ch=(char)i;
    		}
    	}
    	if(ch=='\0')
    		return '#';
    	else
    		return ch;
    }
}
