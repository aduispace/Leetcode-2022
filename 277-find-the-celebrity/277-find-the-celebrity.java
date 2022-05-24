/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// boolean knows(int a, int b) return if a knows b

// O(N)

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;
        
        for (int i = 1; i < n; i++) {
            // cand cannot know i, i must know cand, if false, switch the candidate
            if (knows(cand, i) || !knows(i, cand)) {
                cand = i;
            }
        }
        
        // final check
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
/***
int findCelebrity(int n) {
    // 先假设 cand 是名人
    int cand = 0;
    for (int other = 1; other < n; other++) {
        if (!knows(other, cand) || knows(cand, other)) {
            // cand 不可能是名人，排除
            // 假设 other 是名人
            cand = other;
        } else {
            // other 不可能是名人，排除
            // 什么都不用做，继续假设 cand 是名人
        }
    }

    // 现在的 cand 是排除的最后结果，但不能保证一定是名人
    for (int other = 0; other < n; other++) {
        if (cand == other) continue;
        // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
        if (!knows(other, cand) || knows(cand, other)) {
            return -1;
        }
    }

    return cand;
}

**/