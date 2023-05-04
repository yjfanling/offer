package offer;

import org.junit.Test;

public class Add {
	public int add(int num1,int num2)
	{
		int sum,carry;
		do{
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		while(num2!=0);
		return sum;	
	}
	@Test
	public void test(){
		int num1=12;
		int num2=34;
		System.out.println(add(num1, num2));
	}
	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length ==0) {
			return 0;
		}
		int size = nums.length;
		int left = 0;
		int right = size - 1;
		while (left < right) {
			while(left < right && nums[left] != val) {
				left++;
			}
			while(right > left && nums[right] == val) {
				right--;
			}
			nums[left] = nums[right];
		}
		return left;
	}
}
