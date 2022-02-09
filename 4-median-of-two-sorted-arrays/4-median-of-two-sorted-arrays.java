class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute force: double pointer -> O(m+n)
        // better: binary search: 
        // 1. 对m+n的整体数组，划分左半边的元素数量为(m+n+1)/2，向上取整，不分奇偶, 奇数时左半部分多一个元素
        // eg: (3+3+1)/2 = 3, (3+2+1)/2 = 3
        // 2.分割线对两个数组需要满足交叉小于等于
        if (nums1.length > nums2.length) {
            // nums1 will be always shorter one
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int leftTotal = (m + n + 1) / 2;
        // search area [0, m)
        int left = 0, right = m; 
        
        while (left < right) {
            // i will be leftmost element on right partition
            // 然而left + (right - left) / 2是向下取整，所以整体要+1
            int i = left + (right - left) / 2 + 1;
            int j = leftTotal - i;
            
            // 满足交叉小于等于: nums1[i - 1] < nums2[j] && nums1[j - 1] < nums1[i]
            if (nums1[i - 1] > nums2[j]) {
                // 说明i-1的元素不满足，因为搜索的是左闭右开[left, right), which is [left, i -1)
                right = i - 1;
            } else {
                // 说明i-1的元素满足，因为搜索的是左闭右开[left, right), 而i-1已经搜索过，所以[i, right)
                left = i;
            }
        }
        // partition1代表nums1 分割位置，向上取整；partition2代表nums2 分割位置，向上取整
        int i = left, j = leftTotal - left;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1]; 
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];  // i != m, i本身就是右半部分最大的
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1]; 
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j]; // j != n, j本身就是右半部分最大的
        double median = 0.0;
        if ((m + n) % 2 == 1) {
            median = (double) Math.max(nums1LeftMax, nums2LeftMax); 
        } else {
            median = (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0; 
        }
        
        return median;
    }
}