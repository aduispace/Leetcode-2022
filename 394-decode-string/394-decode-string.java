// Approach 1: Divide and Conquer, DFS

// class Solution {
//     // Time: O(K*N)
//     // use a pointer from beginning
//     int i = 0;
    
//     public String decodeString(String s) {
//         return build(s);
//     }
    
//     private String build(String s) {
//         StringBuilder sb = new StringBuilder();
//         int num = 0;
//         while (i < s.length()) {
//             char ch = s.charAt(i);
//             i++;
//             if (Character.isDigit(ch)) {
//                 num = num * 10 + (ch - '0');
//             } else if (ch == '[') {
//                 // use recursion build(s), append that k times
//                 String cur = build(s);
                
//                 // O(K), append k times 
//                 for (int j = 0; j < num; j++) {
//                     sb.append(cur);
//                 }
//                 // reset num to 0
//                 num = 0;
//             } else if (Character.isAlphabetic(ch)) {
//                 sb.append(ch);
//             } else if (ch == ']') {
//                 break;
//             }
//         }
        
//         return sb.toString();
//     }
// }

// Approach 2: Using stack: 

class Solution {
    // Time: O(K*N)

    public String decodeString(String s) {
        // two stacks, one for strings, one for ints
        Deque<String> strs = new ArrayDeque<>();
        Deque<Integer> ints = new ArrayDeque<>();
        
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(arr[i])) {
                while (Character.isDigit(arr[i])) {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
            } else if (arr[i] == '[') {
                // meet '[', push both num and temp string to stack, reset num and temp string
                ints.push(num);
                num = 0;
                strs.push(sb.toString());
                sb = new StringBuilder();
                i++;
            } else if (arr[i] == ']') {
                // pop both top inter
                int topNum = ints.pop();
                String topStr = strs.pop();
                
                String temp = "";
                // 重复的是当前res剩下的string
                String curRes = sb.toString();
                for (int j = 0; j < topNum; j++) {
                    temp += curRes;
                }
                // 最后res为str stack里top的加上刚才重复的 比如a2[c] -> acc
                temp = topStr + temp;
                
                sb = new StringBuilder(temp);
                i++;
            } else {
                sb.append(arr[i]);
                i++;
            }
        }
        
        return sb.toString();
    } 
    
}



//     public String decodeString(String s) {
//         Queue<Character> queue = new LinkedList<>();
//         for (char i : s.toCharArray()) {
//             queue.offer(i);
//         }
//         return build(queue);
//     }
    
//     private String build(Queue<Character> queue) {
//         StringBuilder sb = new StringBuilder();
//         int num = 0;
//         while (!queue.isEmpty()) {
//             char ch = queue.poll();
//             if (Character.isDigit(ch)) {
//                 num = num * 10 + (ch - '0');
//             } else if (ch == '[') {
//                 String cur = build(queue);
//                 for (int j = 0; j < num; j++) {
//                     sb.append(cur);
//                 }
//                 num = 0;
//             } else if (Character.isAlphabetic(ch)) {
//                 sb.append(ch);
//             } else if (ch == ']') {
//                 break;
//             }
//         }
        
//         return sb.toString();
//     }