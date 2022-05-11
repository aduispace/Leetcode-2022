class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // given that each boat can only take 2 people maximum, use two pointers!!!
        Arrays.sort(people);
        int res = 0;
        int start = 0, end = people.length - 1;
        
        while (start < end) {
            if (people[start] + people[end] > limit) {
                end--;
            } else {
                start++;
                end--;
                res++;
            }
        }
        
        return res + (people.length - 2 * start);
    }
    
    // [1, 5, 4, 2] 6
    // [1, 2, 4, 5] 2
    
    
    // [2, 3, 4, 5] 5
    
    // [3, 3, 4, 5] 5
}