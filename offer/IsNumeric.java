package offer;

import org.junit.Test;

public class IsNumeric {
	private int index=0;
	public boolean isNumeric(char[] str) {
        if(str==null)
        	return false;
        boolean numeric=scanInteger(str);
        if(index<str.length&&str[index]=='.')
        {
        	index++;
        	numeric=unsignscanInteger(str)||numeric;
        }
        if(index<str.length&&(str[index]=='e'||str[index]=='E'))
        {
        	index++;
        	numeric=numeric&&scanInteger(str);
        }
	return index==str.length&&numeric;
    }
	private boolean scanInteger(char[] str) {
		// TODO Auto-generated method stub
		if(index<str.length&&(str[index]=='-'||str[index]=='+'))
			index++;
		return unsignscanInteger(str);
	}
	private boolean unsignscanInteger(char[] str) {
		// TODO Auto-generated method stub
		int flag=index;
		while(index<str.length&&str[index]!='\0'&&str[index]>='0'&&str[index]<='9')
			index++;
		return index>flag;
	}
	@Test
	public void test(){
		if(isNumeric("12e".toCharArray()))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
