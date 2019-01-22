package offer;

import org.junit.Test;

public class StrToInt {
	public int strToInt(String str){
		char[] array=str.toCharArray();
		long num=0;
		if(array.length==0)
			return (int)num;
		if(array.length==1&&(array[0]=='\0'||array[0]==0))
		{
			return (int)num;
		}
		int i=0;
		boolean minus=false;
		if(array[i]=='-')
		{
			minus=true;
			i++;
		}
		else if(array[i]=='+')
			i++;
		for(;i<array.length;i++)
		{
			if(array[i]>='0'&&array[i]<='9')
				num=num*10+(array[i]-'0');
			else 
				return 0;
		}
		if((!minus&&num>0x7FFFFFFF)||(minus&&num<0x80000000))
		{
			num=0;
		}
		if(minus)
			num=-1*num;
		return (int)num;
		
	}
	@Test
	public void test(){
		String str="123";
		System.out.println(strToInt(str));
	}
}
