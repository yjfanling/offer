package leetcode100;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(len, nums);
        for (int i = nums.length-1; i >nums.length-k+1; i--) {
            swap(nums,i,0);
            len--;
            maxHeapify(len,0,nums);
        }
        return nums[0];
    }

    private void buildMaxHeap(int len, int[] nums) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(len, i ,nums);
        }
    }

    private void maxHeapify(int len, int i, int[] nums) {
        int largest = i;
        int l = largest*2 +1;
        int r = largest*2 +2;
        if (nums[l] > nums[largest]) {
            largest = l;
        }
        if (nums[r] > nums[largest]) {
            largest = r;
        }
        swap(nums,largest, i);
    }

    private void swap(int[] nums, int largest, int i) {
        int tmp = nums[largest];
        nums[largest] = nums[i];
        nums[i] = tmp;
    }
}
