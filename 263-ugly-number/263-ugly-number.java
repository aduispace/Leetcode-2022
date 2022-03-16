class Solution {
    public boolean isUgly(int n) {
//         int[] primes = new int[]{2, 3, 5};
//         for (int i = 0; n > 1 && i < 3; i++) {
//             if (n % primes[i] == 0) {
//                 n /= primes[i];
//                 i--;
//             }
//         }
        
//         return n == 1;
        if (n == 0) return false;
	    while(n % 2 == 0) n /= 2;
	    while(n % 3 == 0) n /= 3;
	    while(n % 5 == 0) n /= 5;
        return n == 1;
    }
}