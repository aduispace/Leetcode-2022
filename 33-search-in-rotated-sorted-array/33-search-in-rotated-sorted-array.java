class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}




// class Solution {
//     public int search(int[] nums, int target) {
//         int left = 0, right = nums.length - 1;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             if (nums[mid] == target) {
//                 return mid;
//             } else if (nums[mid] > target && nums[mid] > nums[0]) {
//                 if (target > nums[0]) {
//                     right = mid - 1;
//                 } else if (target < nums[0]) {
//                     left = mid + 1;
//                 }
//             } else if (nums[mid] < target && nums[mid] > nums[0]) {
//                 left = mid + 1;
//             } else if (nums[mid] > target && nums[mid] < nums[0]) {
//                 right = mid - 1;
//             } else if (nums[mid] < target && nums[mid] < nums[0]) {
//                 if (target > nums[0]) {
//                     right = mid - 1;
//                 } else if (target < nums[0]) {
//                     left = mid + 1;
//                 }
//             }
//         }
        
//         return nums[0] == target ? 0 : -1;
//     }
// }

