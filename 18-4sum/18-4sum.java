class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
                
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // List<Integer> temp = new ArrayList<>();
                    // temp.add(nums[left]);
                    // temp.add(nums[right]);
                    // result.add(temp);
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[left], nums[right])));
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // because we check left and left+1, right and right-1, need to move one more spot
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            // !!!!recursion: 
            // kSum -> (k-1)Sum
            for (int i = start; i < nums.length - (k - 1); i++) {
                
                // 加的都是i，跟start没关系
                List<List<Integer>> temp = kSum(nums, target - nums[i], i + 1, k - 1);          
                for (List<Integer> cur : temp) {
                    cur.add(nums[i]);
                }
                // every list in temp got nums[start] now, then addAll to result (list of list)
                result.addAll(temp);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        
        return result;
    }
}