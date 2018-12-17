package offer;

import org.junit.Test;

public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        char[] string=str.toCharArray();
        string=reverse(string,0,string.length-1);
        string=reverse(string,0,string.length-1-n);
        string=reverse(string,string.length-n,string.length-1);
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
	@Test
	public void test(){
		String string="abcdefg";
		char[] String=string.toCharArray();
		String str=new String(reverse(String,5,6));
		String strresult=leftRotateString(string, 2);
		System.out.println(strresult);
	}
}