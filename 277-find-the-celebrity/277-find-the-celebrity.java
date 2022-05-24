/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// boolean knows(int a, int b) return if a knows b

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;
        
        for (int i = 1; i < n; i++) {
            if (knows(cand, i) || !knows(i, cand)) {
                cand = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (knows(cand, i) || !knows(i, cand)) {
                // no celebrity
                return -1;
            }
        }
        
        return cand;
    }
}