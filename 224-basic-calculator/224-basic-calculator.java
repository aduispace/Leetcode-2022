class Solution {
//     int i = 0;
//     public int calculate(String s) {

//         // 1 + 1 -> +1 +1
//         // recursion: find "(" and start recursion, find ")" stop recursion and result
//         return helper("(" + s + ")");
//     }
    
//     private int helper(String s) {
//         int sign = 1;
//         int res = 0;
//         int num = 0;
//         while (i < s.length()) {
//             char ch = s.charAt(i);
//             if (Character.isDigit(ch)) {
//                 // how to get num char by char
//                 num = num * 10 + (ch - '0');
//                 i++;
//             } else if (ch == '+' || ch == '-') {
//                 res += sign * num;
//                 sign = ch == '+' ? 1 : -1;
//                 num = 0;
//                 i++;
//             } else if (ch == '(') {
//                 i++;
//                 // 
//                 res += sign * helper(s);
//             } else if (ch == ')') {
//                 res += sign * num;
//                 i++;
//                 return res;
//             } else {
//                 i++;
//             }
//         }
        
//         return res;
//  }    
    
    int i;

    public int calculate(String s) {

        int operand = 0;
        int result = 0; // For the on-going result
        int nextOperandSign = 1;  // 1 means positive, -1 means negative

        while(i < s.length()) {

            char ch = s.charAt(i++);

            if (ch == ' ' || Character.isDigit(ch)) {
                operand = (ch == ' ') ? operand : 10 * operand + (ch - '0');
                
            } else if (ch == '(') {
                operand = calculate(s);
                
            } else if (ch == ')') {
                return result + nextOperandSign * operand; // Sub-expression we were evaluating has ended. Exit now...
                
            } else { 
                // If we're here, we just read the operator for the next operand/expression.
                // Evaluate the existing expression already read, reset operand, set sign for next incoming operand.
                result += nextOperandSign * operand;
                nextOperandSign = ch == '+' ? 1 : -1;
                operand = 0;
            }
        }

        return result + (nextOperandSign * operand);
    }
}