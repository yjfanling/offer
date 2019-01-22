package offer;

import org.junit.Test;

public class Sum {
public int Sum_Solution(int n) {
        int sum=n;
        boolean flag=(n>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }
@Test
public void test(){
	System.out.println(Sum_Solution(3));
}
}
