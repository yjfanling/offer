package offer;

public class ReverseSentence {
	public String reverseSentence(String str){
		char[] string=str.toCharArray();
		string=reverse(string, 0, string.length-1);
		for(int i=0;i<string.length;i++)
		{
			int start=i;
			int j=i;
			while(j<string.length&&string[j]!=' ')
			{
				j++;
			}
			int end=j-1;
			string=reverse(string, start, end);
			i=j;
		}
		String strresult=new String(string);
		return strresult;
	}
	private char[] reverse(char[] string,int start,int end) {
		// TODO Auto-generated method stub
		int median=(end+1-start)/2+start;
		if(string.length<1)
			return string;
		for(int i=start;i<median;i++)
			swap(string,i,end-i+start);
		return string;
	}
	private void swap(char[] string ,int a, int b)
	{
		char temp=string[b];
		string[b]=string[a];
		string[a]=temp;
	}
}
