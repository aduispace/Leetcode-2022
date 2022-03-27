class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // [7, 9, 10, 0, 0, 0] [3, 5, 6]
        // time: O(M+N) 
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0) {
                break;
            }
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
                continue;
            }
            if (nums2[j] >= nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
        }
    }
}