package leetcode100;

import org.junit.Test;

public class DecodeString {
    String src;
    int ptr;
    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    private String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }
        int num = 1;
        String ret = "";
        if (Character.isDigit(src.charAt(ptr))) {
            num = getDigit();
            ptr++;
            String str = getString();
            ptr++;
            while (num-->0) {
                ret +=str;
            }
        }else if (Character.isLetter(src.charAt(ptr))){
            ret += src.charAt(ptr++);
        }
        return ret + getString();
    }

    private int getDigit() {
        int result = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            result = result *10 + (src.charAt(ptr++) - '0');
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
