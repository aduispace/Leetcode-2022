class Solution {
    public int evalRPN(String[] tokens) {
        // number一定比operator多一个
        Deque<Integer> numberStack = new ArrayDeque<>();
        int result = 0;
        for (String i : tokens) {
            if (isOperator(i)) {
                int a = numberStack.pop();
                int b = numberStack.pop();
                result = calculate(a, b, i);
                numberStack.push(result);
            } else {
                numberStack.push(Integer.parseInt(i));
            }
        }
        
        return numberStack.pop();
    }
    
    private boolean isOperator (String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }
    
    private int calculate(int a, int b, String str) {
        if (str.equals("+")) {
            return a + b;
        } else if (str.equals("-")){
            return b - a;
        } else if (str.equals("*")) {
            return a * b;
        } else {
            return b / a;
        }
    }
}

// class Solution {
//     public int evalRPN(String[] tokens) {
//         if (tokens == null || tokens.length == 0) {
//             return -1;
//         }

//         int first;
//         int second;
//         final Deque<Integer> stack = new ArrayDeque<>();

//         for (String token : tokens) {
//             switch (token) {
//                 case "+":
//                     stack.push(stack.pop() + stack.pop());
//                     break;

//                 case "-":
//                     first = stack.pop();
//                     second = stack.pop();

//                     stack.push(second - first);
//                     break;

//                 case "*":
//                     stack.push(stack.pop() * stack.pop());
//                     break;

//                 case "/":
//                     first = stack.pop();
//                     second = stack.pop();

//                     stack.push(second / first);
//                     break;

//                 default:
//                     stack.push(Integer.parseInt(token));
//                     break;
//             }
//         }

//         return stack.pop();
//     }
// }