class Solution {
    public boolean buddyStrings(String s, String goal) {
        String A = s;
        String B = goal;
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> set = new HashSet<Character>();
            for (char c : A.toCharArray()) set.add(c);
            return set.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
    
}