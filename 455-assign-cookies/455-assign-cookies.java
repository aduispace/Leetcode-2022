class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int leftG = 0, leftS = 0;
        while (leftG <= g.length - 1 && leftS <= s.length - 1) {
            if (g[leftG] <= s[leftS]) {
                contentChildren++;
                leftG++;
            }
            leftS++;
        }
        
        return contentChildren;
    }
}