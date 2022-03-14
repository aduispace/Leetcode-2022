class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();
        int a = 0, total = 0;
        for (char ch : secretArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < secretArr.length; i++) {
            if (secretArr[i] == guessArr[i]) {
                a++;
            }
            if (map.containsKey(guessArr[i]) && map.get(guessArr[i]) > 0) {
                total++;
                map.put(guessArr[i], map.get(guessArr[i]) - 1);
            }
        }
        
        return String.valueOf(a) + "A" + String.valueOf(total - a) + "B";
        
    }
}