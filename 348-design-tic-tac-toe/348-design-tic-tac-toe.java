class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int anti = 0;
    
    // win needs every single spot in that col/row/diagonal/antiDigonal to be taken

    int n = 0;
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int winCondition = player == 1 ? -player * n : player * n;
        int addOnNum = player == 1? -player : player;
        if (row == col) {
            diagonal += addOnNum;
        } 
        if (row + col == n - 1) {
            anti += addOnNum;
        }
        rows[row] += addOnNum;
        cols[col] += addOnNum;
        
        if (diagonal == winCondition || anti == winCondition || rows[row] == winCondition || cols[col] == winCondition) {
            return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */