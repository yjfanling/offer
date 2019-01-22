package offer;

import org.junit.Test;

public class Match {
	public boolean match(char[] str, char[] pattern)
    {
		if(str==null||pattern==null)
			return false;
		int patternIndex=0,strIndex=0;
		return matchcore(str,pattern,patternIndex,strIndex);
    }
	private boolean matchcore(char[] str, char[] pattern, int patternIndex, int strIndex) {
		// TODO Auto-generated method stub
		if (strIndex == str.length && patternIndex == pattern.length) {
			  return true;
		}
		if (strIndex != str.length && patternIndex == pattern.length) {
			 return false;
		}
		if(strIndex==str.length&&patternIndex!=pattern.length)
		{
			if(patternIndex<pattern.length-1&&pattern[patternIndex+1]=='*')
				return matchcore(str,pattern,patternIndex+2,strIndex);
			else
				return false;
		}
		if(patternIndex<pattern.length-1&&pattern[patternIndex+1]=='*')
			if(pattern[patternIndex]==str[strIndex]||pattern[patternIndex]=='.'&&strIndex!=str.length){
				return matchcore(str,pattern,patternIndex+2,strIndex)||matchcore(str,pattern,patternIndex+2,strIndex+1)||matchcore(str,pattern,patternIndex,strIndex+1);
			}
			else
				return matchcore(str,pattern,patternIndex+2,strIndex);
		if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
			    return matchcore(str, pattern, patternIndex + 1,strIndex + 1 );
			}
				
		return false;
	}
	@Test
	public void test(){
		char[] str="aaa".toCharArray();
		char[] pattern="ab*a".toCharArray();
		if(match(str, pattern))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
