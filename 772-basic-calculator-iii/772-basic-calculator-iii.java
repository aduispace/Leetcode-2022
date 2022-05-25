class Solution {
    // recursively solve this
    
    public int calculate(String s) {
   Queue<Character> tokens = new ArrayDeque<Character>();

   for(char c : s.toCharArray()){
       if(c != ' ') tokens.offer(c);
   }

   tokens.offer('+');
   return calculate(tokens);
}

private int calculate(Queue<Character> tokens){
     
    // 6-4/2 -> 0  +  6 - 4 / 2
    //.        prev  num 
    // 处理到当前num时只处理prev的计算结果
   char preOp = '+';
   int num = 0, sum = 0, prev = 0;

   while(!tokens.isEmpty()){
        char c = tokens.poll();

        if('0' <= c && c <= '9') {
            num = num * 10 + c - '0';
        }else if(c=='(') {
            num = calculate(tokens);
        }else{
            switch (preOp){
                case '+':
                    sum += prev;
                    prev = num;
                    break;
                case '-':
                    sum += prev;
                    prev = -num;
                    break;
                case '*':
                    prev *= num;
                    break;
                case '/':
                    prev /= num;
                    break;
            }

            if(c == ')')
                break;

            preOp = c;
            num = 0;
        }
   }

   return sum + prev;
}
}