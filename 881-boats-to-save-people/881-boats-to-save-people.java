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
        
        // res是能装两个的船个数，剩下的(people.length - 2 * start)为装一个的船的个数
        return res + (people.length - 2 * start);
    }

}