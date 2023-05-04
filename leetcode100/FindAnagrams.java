package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s , String p) {
        int sLen = s.length();
        int pLen = p.length();
        int all = p.length();
        if (sLen<pLen) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] array = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++array[p.charAt(i)-'a'];
        }
        int l = 0;
        int r = 0;
        for (; l < sLen-pLen+1; l++) {
            while (r<sLen&&array[s.charAt(r)-'a'] >0) {
                all--;
                array[s.charAt(r++)-'a']--;
            }
            if (all == 0) {
                result.add(l);
            }
            array[s.charAt(l)-'a']++;
            all++;
        }
        return result;
    }
}
/**
 * 滑动窗口
 * 记录P的总字符个数，一步一步右移，个数刚好相等即为解
 * 记录的值偿还完了即缩减左边界，继续右移
 */
